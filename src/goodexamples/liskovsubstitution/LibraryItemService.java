package goodexamples.liskovsubstitution;

import dtos.BookMetadata;

/*
* Abstraction that lets the services below follow the Liskov Substitution Principle (LSP).
* It only promises what every kind of library item can actually do.
*/
public interface LibraryItemService {

    // Tell a member where they can find this item.
    String getLocation(BookMetadata metadata);

}
