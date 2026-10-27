package services;

import dtos.AudioBookDTO;

import java.time.Instant;
import java.util.UUID;

public class AudioBookService {

    public String generateStreamingUrl(AudioBookDTO audioBookDto, String memberId) {
        // 1. Business Logic Validation
        if (audioBookDto == null || memberId == null) {
            throw new IllegalArgumentException("Invalid book data or member identification.");
        }

        // 2. Mocking a secure digital sign-off (Simulating CDN logic)
        String secureToken = UUID.randomUUID().toString();
        long expirationTimestamp = Instant.now().getEpochSecond() + 7200; // Link expires in 2 hours

        // 3. Building the streaming payload link
        String streamingUrl = String.format(
                "https://library.com/stream/%s?codec=%s&token=%s&expires=%d",
                audioBookDto.getBookMetadata().getIsbn(),
                audioBookDto.getAudioCodec().toLowerCase(),
                secureToken,
                expirationTimestamp
        );

        System.out.println("LOG [AudioBookService]: Generated secure stream for " + audioBookDto.getBookMetadata().getTitle());
        return streamingUrl;
    }
}
