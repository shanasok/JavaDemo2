package models;

import enums.AudienceAgeEnum;

/*
* Domain model for an audiobook.
* Takes plain fields rather than an AudioBookDTO so the model never depends on the dtos package.
*/
public class AudioBook extends LibraryItem {

    private static final int LOAN_PERIOD_DAYS = 14;

    private final String narrator;
    private final int duration; // in minutes
    private final String audioCodec;

    public AudioBook(String isbn, String title, String author, AudienceAgeEnum audienceAge,
                     String narrator, int duration, String audioCodec) {
        super(isbn, title, author, audienceAge);
        this.narrator = narrator;
        this.duration = duration;
        this.audioCodec = audioCodec;
    }

    @Override
    protected int getLoanPeriodDays() {
        return LOAN_PERIOD_DAYS;
    }

    // Getters

    public String getNarrator() {
        return narrator;
    }

    public int getDuration() {
        return duration;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

}
