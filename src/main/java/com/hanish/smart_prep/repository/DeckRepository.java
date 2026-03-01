package com.hanish.smart_prep.repository;

import com.hanish.smart_prep.entity.StudyDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeckRepository extends JpaRepository<StudyDeck, Long> {

    List<StudyDeck> findByUserId(Long userId);

}
