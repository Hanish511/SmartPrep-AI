package com.hanish.smart_prep.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    String question;

    @Column(columnDefinition = "TEXT")
    String answer;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    @JsonIgnore
    StudyDeck deck;

}
