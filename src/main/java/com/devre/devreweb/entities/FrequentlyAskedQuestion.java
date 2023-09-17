package com.devre.devreweb.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "frequently_asked_question")
public class FrequentlyAskedQuestion extends BaseEntity{
    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int questionId;

    @Column(name = "question",length = 500)
    private String question;

    @Column(name = "answer",length = 5000)
    private String answer;
}
