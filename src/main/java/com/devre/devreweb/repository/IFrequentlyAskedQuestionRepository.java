package com.devre.devreweb.repository;

import com.devre.devreweb.entities.FrequentlyAskedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFrequentlyAskedQuestionRepository extends JpaRepository<FrequentlyAskedQuestion, Integer> {
}
