package com.devre.devreweb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_type")
public class UserType extends  BaseEntity{
    @Id
    @Column(name = "user_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "short_code")
    private String shortCode;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userType", fetch =FetchType.EAGER)
    @JsonBackReference
    private List<User> userList;
}
