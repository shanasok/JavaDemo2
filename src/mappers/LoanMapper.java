package mappers;

import dtos.LoanDTO;
import models.LibraryItem;

/*
* Builds a LoanDTO from any LibraryItem.
* Works for books and audiobooks alike because it only uses fields that LibraryItem provides.
*/
public class LoanMapper {

    public LoanDTO toLoanDTO(LibraryItem item) {
        return new LoanDTO(item.getIsbn(), item.getTitle(), item.getBorrowedBy(), item.getDueDate());
    }

}
