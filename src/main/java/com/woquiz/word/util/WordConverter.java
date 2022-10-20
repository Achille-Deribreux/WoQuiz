package com.woquiz.word.util;

import java.util.List;
import java.util.stream.Collectors;

import com.woquiz.word.dto.WordBody;
import com.woquiz.word.dto.WordDto;
import com.woquiz.word.model.Word;

public class WordConverter {

    private WordConverter() {
    }

    public static WordDto convertToWordDto(Word word){
        return new WordDto()
                .id(word.getId())
                .basicWord(word.getBasicWord())
                .translation(word.getTranslation())
                .level(word.getLevel())
                .wordStatus(word.getStatus());
    }

    public static Word convertToWord(WordBody wordBody){
        return new Word()
            .id(wordBody.getId())
            .basicWord(wordBody.getBasicWord())
            .translation(wordBody.getTranslation())
            .level(wordBody.getLevel())
            .wordStatus(wordBody.getStatus());
    }

    public static List<WordDto> convertToWordDto(List<Word> wordList){
        return wordList.stream().map(WordConverter::convertToWordDto).collect(Collectors.toList());
    }
}
