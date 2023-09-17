package com.devre.devreweb.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity{
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id", nullable = true)
    private Integer parentId;

    @Column(name = "slug")
    private String slug;

    @Column(name = "is_actv")
    private int isActv;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> postList;



}
