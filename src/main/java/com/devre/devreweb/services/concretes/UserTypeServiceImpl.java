package com.devre.devreweb.services.concretes;

import com.devre.devreweb.entities.UserType;
import com.devre.devreweb.repository.IUserTypeRepository;
import com.devre.devreweb.services.abstracts.IUserTypeService;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements IUserTypeService {
    private IUserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(IUserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserType getUserTypeById(Integer userTypeId) {
        return this.userTypeRepository.findById(userTypeId).orElse(null);
    }
}
