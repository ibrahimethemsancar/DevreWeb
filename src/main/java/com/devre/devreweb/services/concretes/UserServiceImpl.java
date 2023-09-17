package com.devre.devreweb.services.concretes;

import com.devre.devreweb.entities.User;
import com.devre.devreweb.entities.UserType;
import com.devre.devreweb.repository.IUserRepository;
import com.devre.devreweb.services.abstracts.IUserService;
import com.devre.devreweb.services.abstracts.IUserTypeService;
import com.devre.devreweb.services.requests.CreateUserRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private IUserRepository userRepository;
    private IUserTypeService userTypeService;

    public UserServiceImpl(IUserRepository userRepository, IUserTypeService userTypeService) {
        this.userRepository = userRepository;
        this.userTypeService = userTypeService;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(CreateUserRequest request) throws Exception {
            UserType userType = this.userTypeService.getUserTypeById(request.getUserTypeId());
            if(userType != null){
                if(request.getEmail() != null && request.getPassword() != null){
                    User newUser = new User();
                    newUser.setUserName(request.getUserName());
                    newUser.setUserType(new UserType());
                    newUser.setEmail(request.getEmail());
                    newUser.setMobile(request.getMobile());
                    newUser.setFirstName(request.getFirstName());
                    newUser.setLastName(request.getLastName());
                    newUser.setPassword(request.getPassword());
                    newUser.setIsActv(1);
                    newUser.setUserType(userType);
                    userRepository.save(newUser);
                }
            }
            else throw new  Exception("UserType is not found!");


    }

    @Override
    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
