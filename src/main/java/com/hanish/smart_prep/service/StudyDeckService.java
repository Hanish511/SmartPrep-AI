package com.hanish.smart_prep.service;

import com.hanish.smart_prep.dto.FlashcardResponse;
import com.hanish.smart_prep.entity.Flashcard;
import com.hanish.smart_prep.entity.StudyDeck;
import com.hanish.smart_prep.entity.User;
import com.hanish.smart_prep.repository.DeckRepository;
import com.hanish.smart_prep.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyDeckService {

    private final DeckRepository deckRepository;
    private final UserRepository userRepository;
    private final AiGenerationService aiGenerationService;

    public StudyDeckService(DeckRepository deckRepository, UserRepository userRepository, AiGenerationService aiGenerationService){
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
        this.aiGenerationService = aiGenerationService;
    }

    @Transactional
    public StudyDeck generateAndSaveDeck(Long userId, String title, String text, int numberOfCards){
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found!"));

        FlashcardResponse aiResponse = aiGenerationService.generateFlashcards(text, numberOfCards);

        StudyDeck deck = new StudyDeck();
        deck.setTitle(title);
        deck.setUser(user);

        List<Flashcard> flashcardsEntities = new ArrayList<>();

        aiResponse.flashcards().forEach(dto -> {
            Flashcard card = new Flashcard();
            card.setQuestion(dto.question());
            card.setAnswer(dto.answer());
            card.setDeck(deck);
            flashcardsEntities.add(card);
        });

        deck.setFlashcards(flashcardsEntities);

        return deckRepository.save(deck);
    }

    public List<StudyDeck> getUserDecks(Long userId){
        return deckRepository.findByUserId(userId);
    }

}
