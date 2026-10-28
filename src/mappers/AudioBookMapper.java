package mappers;

import dtos.AudioBookDTO;
import dtos.BookMetadata;
import models.AudioBook;

/*
* The only class that knows about both the AudioBook model and the audiobook-related DTOs.
* If a DTO changes shape, only this class needs to change.
*/
public class AudioBookMapper {

    public AudioBook toModel(AudioBookDTO dto) {
        BookMetadata metadata = dto.getBookMetadata();
        return new AudioBook(
                metadata.getIsbn(),
                metadata.getTitle(),
                metadata.getAuthor(),
                metadata.getAudienceAge(),
                dto.getNarrator(),
                dto.getDuration(),
                dto.getAudioCodec()
        );
    }

    public AudioBookDTO toDTO(AudioBook audioBook) {
        BookMetadata metadata = new BookMetadata(audioBook.getIsbn(), audioBook.getTitle(), audioBook.getAuthor(), audioBook.getAudienceAge());
        return new AudioBookDTO(metadata, audioBook.getNarrator(), audioBook.getDuration(), audioBook.getAudioCodec());
    }

}
