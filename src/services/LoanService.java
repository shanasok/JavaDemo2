package services;

import dtos.AudioBookDTO;
import dtos.BookDTO;
import dtos.LoanDTO;
import mappers.AudioBookMapper;
import mappers.BookMapper;
import mappers.LoanMapper;
import models.LibraryItem;

import java.time.LocalDate;

public class LoanService {

    private final BookMapper bookMapper = new BookMapper();
    private final AudioBookMapper audioBookMapper = new AudioBookMapper();
    private final LoanMapper loanMapper = new LoanMapper();

    public LoanDTO borrowBook(BookDTO bookDto, String memberId) {
        if (bookDto == null || bookDto.getMetadata() == null) {
            throw new IllegalArgumentException("Invalid book data.");
        }
        return borrow(bookMapper.toModel(bookDto), memberId);
    }

    public LoanDTO borrowAudioBook(AudioBookDTO audioBookDto, String memberId) {
        if (audioBookDto == null || audioBookDto.getBookMetadata() == null) {
            throw new IllegalArgumentException("Invalid audiobook data.");
        }
        return borrow(audioBookMapper.toModel(audioBookDto), memberId);
    }

    // Shared steps for every kind of LibraryItem; the public methods above only map their DTO to a model.
    private LoanDTO borrow(LibraryItem item, String memberId) {
        // 1. Validate the member
        if (memberId == null) {
            throw new IllegalArgumentException("Invalid member identification.");
        }

        // 2. Business logic: the item (as a Borrowable) enforces availability and sets the due date
        item.borrow(memberId, LocalDate.now());

        // 3. Convert the result back into a DTO for the caller
        System.out.println("LOG [LoanService]: " + memberId + " borrowed " + item.getTitle() + ", due " + item.getDueDate());
        return loanMapper.toLoanDTO(item);
    }

}
