package dtos;

import java.util.Objects;

public class AudioBookDTO {

    private BookMetadata bookMetadata;
    private String narrator;
    private int duration; // in minutes
    private String audioCodec; // e.g., "MP3", "AAC"

    public AudioBookDTO() {
        super();
    }

    public AudioBookDTO(BookMetadata bookMetadata, String narrator, int duration, String audioCodec) {
        this.bookMetadata = bookMetadata;
        this.narrator = narrator;
        this.duration = duration;
        this.audioCodec = audioCodec;
    }

    // equals and hashCode methods for comparing AudioBookDTO objects based on bookMetadata, narrator, duration, and audioCodec

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AudioBookDTO that = (AudioBookDTO) o;
        return duration == that.duration && Objects.equals(bookMetadata, that.bookMetadata) && Objects.equals(narrator, that.narrator) && Objects.equals(audioCodec, that.audioCodec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookMetadata, narrator, duration, audioCodec);
    }

    @Override
    public String toString() {
        return "AudioBookDTO{" +
                "bookMetadata=" + bookMetadata +
                ", narrator='" + narrator + '\'' +
                ", duration=" + duration +
                ", audioCodec='" + audioCodec + '\'' +
                '}';
    }

    // Getters and Setters

    public BookMetadata getBookMetadata() {
        return bookMetadata;
    }

    public void setBookMetadata(BookMetadata bookMetadata) {
        this.bookMetadata = bookMetadata;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(String audioCodec) {
        this.audioCodec = audioCodec;
    }
}
