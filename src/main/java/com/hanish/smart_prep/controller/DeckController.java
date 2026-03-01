package com.hanish.smart_prep.controller;

import com.hanish.smart_prep.dto.DeckRequest;
import com.hanish.smart_prep.entity.StudyDeck;
import com.hanish.smart_prep.service.StudyDeckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

    private final StudyDeckService studyDeckService;

    public DeckController(StudyDeckService studyDeckService){
        this.studyDeckService = studyDeckService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateDeck(@RequestBody DeckRequest request){
        StudyDeck newDeck = studyDeckService.generateAndSaveDeck(
                request.userId(),
                request.title(),
                request.text(),
                request.numberOfCards()
        );

        return ResponseEntity.ok("Success! Deck '" + newDeck.getTitle() + "' generated with " + newDeck.getFlashcards().size() + " cards. Deck ID: "+ newDeck.getId());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<StudyDeck>> getUserDecks(@PathVariable Long userId){
        List<StudyDeck> decks = studyDeckService.getUserDecks(userId);
        return ResponseEntity.ok(decks);
    }
}
