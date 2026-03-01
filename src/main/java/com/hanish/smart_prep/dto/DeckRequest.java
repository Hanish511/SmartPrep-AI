package com.hanish.smart_prep.dto;

public record DeckRequest(
        Long userId,
        String title,
        String text,
        int numberOfCards
) {
}
