package com.devre.devreweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "post_keyword")
public class PostKeyword extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "post_keyword_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "postKeywordId")
    @JsonIgnore
    private List<PostPostKeyword> postList = new ArrayList<>();
}
