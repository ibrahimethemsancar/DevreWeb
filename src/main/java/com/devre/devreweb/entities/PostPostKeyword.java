package com.devre.devreweb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post_post_keyword")
public class PostPostKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post postId;

    @ManyToOne()
    @JoinColumn(name = "post_keyword_id")
    private PostKeyword postKeywordId;
}
