package com.example.japanesetranslations;

public class Word {

    private String defaultWord;
    private String japaneseWord;
    private Integer imageResourceId;
    private Integer audioResourceId;

    public Word(String defaultWord, String japaneseWord) {
        this.defaultWord = defaultWord;
        this.japaneseWord = japaneseWord;
    }

    public Word(String defaultWord, String japaneseWord, Integer imageResourceId) {
        this.defaultWord = defaultWord;
        this.japaneseWord = japaneseWord;
        this.imageResourceId = imageResourceId;
    }

    public Word(String defaultWord, String japaneseWord, Integer imageResourceId, Integer audioResourceId) {
        this.defaultWord = defaultWord;
        this.japaneseWord = japaneseWord;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }

    public Integer getAudioResourceId() {
        return audioResourceId;
    }

    public void setAudioResourceId(Integer audioResourceId) {
        this.audioResourceId = audioResourceId;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public void setDefaultWord(String defaultWord) {
        this.defaultWord = defaultWord;
    }

    public String getJapaneseWord() {
        return japaneseWord;
    }

    public void setJapaneseWord(String japaneseWord) {
        this.japaneseWord = japaneseWord;
    }

    public Integer getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
