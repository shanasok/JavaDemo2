package models;

import java.time.LocalDate;

/*
* Capability shared by library items that can be lent out to a member.
* Lives on model classes (not DTOs) because it describes behaviour, not data.
*/
public interface Borrowable {

    boolean isAvailable();

    void borrow(String memberId, LocalDate borrowDate);

    LocalDate getDueDate();

}
