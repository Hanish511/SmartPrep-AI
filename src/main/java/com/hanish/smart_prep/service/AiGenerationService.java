package com.hanish.smart_prep.service;

import com.hanish.smart_prep.dto.FlashcardResponse;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.stereotype.Service;

@Service
public class AiGenerationService {

    private final ChatModel chatModel;

    public AiGenerationService(ChatModel chatModel){
        this.chatModel = chatModel;
    }

    public FlashcardResponse generateFlashcards(String text, int numberOfCards){
        BeanOutputConverter<FlashcardResponse> converter = new BeanOutputConverter<>(FlashcardResponse.class);
        String promptText = "You are an expert tutor. Create exactly "+ numberOfCards +" flashcards from the following text.\n"+
                "Text : "+ text +"\n\n"+
                converter.getFormat();

        String aiResponseText = chatModel.call(promptText);

        return converter.convert(aiResponseText);
    }
}
