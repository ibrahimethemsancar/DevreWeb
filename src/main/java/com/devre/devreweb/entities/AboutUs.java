package com.devre.devreweb.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "about_us")
public class AboutUs extends  BaseEntity {
    @Id
    @Column(name = "about_us_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aboutUsId;

    @Lob
    @Column(name = "content",columnDefinition = "text")
    private String content;

    @Column(name = "is_actv")
    private int isActv;
}
