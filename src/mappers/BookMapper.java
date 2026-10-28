package mappers;

import dtos.BookDTO;
import dtos.BookMetadata;
import models.Book;

/*
* The only class that knows about both the Book model and the book-related DTOs.
* If a DTO changes shape, only this class needs to change.
*/
public class BookMapper {

    public Book toModel(BookDTO dto) {
        BookMetadata metadata = dto.getMetadata();
        return new Book(
                metadata.getIsbn(),
                metadata.getTitle(),
                metadata.getAuthor(),
                metadata.getAudienceAge(),
                dto.getShippingWeightPounds()
        );
    }

    public BookDTO toDTO(Book book) {
        BookMetadata metadata = new BookMetadata(book.getIsbn(), book.getTitle(), book.getAuthor(), book.getAudienceAge());
        return new BookDTO(metadata, book.getShippingWeightPounds());
    }

}
