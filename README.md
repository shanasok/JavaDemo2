# Repo to teach SOLID principles

SOLID is five design principles that make object-oriented code easier to change, test and understand. This repo uses a small library system (books, audiobooks, late fees and notifications) to show each principle twice: once broken, and once fixed.

| Letter | Principle | In one sentence |
|---|---|---|
| S | Single Responsibility | A class should have only one reason to change. |
| O | Open/Closed | Classes should be open for extension but closed for modification. |
| L | Liskov Substitution | A subclass should be usable anywhere its parent class is expected. |
| I | Interface Segregation | Clients should not be forced to depend on methods they do not use. |
| D | Dependency Inversion | High-level code and low-level details should both depend on abstractions. |

### How the repo is organized

```
src/
├── Main.java          Runs every bad example next to its good example
├── badexamples/       Code that breaks a principle, one package per principle
├── goodexamples/      The same problem solved properly, mirroring badexamples
├── dtos/              Shared data classes (BookDTO, AudioBookDTO, BookMetadata)
├── enums/             Shared enums (AudienceAgeEnum)
└── services/          Library services (BookService, AudioBookService), not yet used by the examples
```

Each principle has a matching pair of packages, for example `badexamples/openclosed` and `goodexamples/openclosed`. Read the bad version first, then the good one. Every good class starts with a "Compare with ..." comment pointing to the bad class it fixes, and comments marked ❌ and ✅ point out exactly where the principle is broken or followed.

### How to run it

Open the project in IntelliJ IDEA and run `src/Main.java`, or from the project root:

```
javac -d out $(find src -name "*.java")
java -cp out Main
```

The output walks through the principles in order, showing what the bad version does (often crashing) and what the good version does instead.

### Spotting violations

| Principle | Smell in the bad code | Fix in the good code |
|---|---|---|
| Single Responsibility | A data class that also saves itself to the database | Move persistence into a DAO |
| Open/Closed | An `if`/`else` or `instanceof` chain that grows with every new type | An interface with one implementation per type |
| Liskov Substitution | A subclass that overrides a method just to throw an exception | Only inherit promises the subclass can keep |
| Interface Segregation | Classes implementing methods that throw `UnsupportedOperationException` | Split the big interface into small, focused ones |
| Dependency Inversion | `new SomeConcreteClass()` inside high-level business logic | Depend on an interface and pass the implementation in |

## Single Responsibility Principle

Look at the class badexamples/singleresponsibility/BadBook.java. It has two responsibilities: 1) holding a book's data (isbn, title, author, and getBookSummary()) and 2) saving itself to the database with saveToDatabase(). This violates the Single Responsibility Principle, which says a class should have only one reason to change. If we need to change how books are stored, such as a new table structure or a different database, we would have to modify BadBook, which could introduce bugs in the book data code. A better design keeps the book data in a class like BookDTO and moves the persistence logic into a separate data access object (DAO), such as a BookDAO.

Look at the class goodexamples/singleresponsibility/BookDAO.java for the fixed version. Its only job is saving books to the database, using the save() method. The book data lives in dtos/BookDTO, which knows nothing about databases. Now a change to how books are stored only touches BookDAO, and a change to the book's fields only touches BookDTO.

## Open/Closed Principle

Look at the class badexamples/openclosed/BadFeeCalculator.java. Its calculateLateFee() method uses an if/else chain of instanceof checks to work out the late fee for each item type (BookDTO, AudioBookDTO). This violates the Open/Closed Principle, which says classes should be open for extension but closed for modification. If the library starts lending a new item type, such as e-books, we would have to modify calculateLateFee() and add another branch, which risks breaking the fee logic for items that already work. A better design defines a LateFeePolicy interface with one implementation per item type, so supporting a new item type means adding a new class without changing existing code.

Look at the class goodexamples/openclosed/FeeCalculator.java for the fixed version. Its calculateLateFee() method takes a LateFeePolicy and delegates to it, so it never needs to know which item type it is working with. BookLateFeePolicy and AudioBookLateFeePolicy each hold the fee logic for one item type. To support e-books, we would add an EBookLateFeePolicy class, and FeeCalculator stays closed for modification.

## Liskov Substitution Principle

Look at the class badexamples/liskovsubstitution/BadAudioBookService.java. It extends badexamples/liskovsubstitution/BadBookService.java. This violates the Liskov Substitution Principle, which says a subclass should be usable anywhere its parent class is expected. BadBookService promises a method called getShelfLocation(). Because an audiobook is digital, BadAudioBookService cannot fulfill this promise and throws an UnsupportedOperationException. badexamples/liskovsubstitution/BadLocationPrinter.java is client code written against BadBookService: it works when given a BadBookService, but crashes when given a BadAudioBookService, breaking substitution.

Look at goodexamples/liskovsubstitution/LibraryItemService.java for the fixed version. Instead of the audiobook inheriting a promise it cannot keep, both services implement an interface that only promises what every library item can do: getLocation(), which tells a member where to find the item. goodexamples/liskovsubstitution/BookLocationService.java returns a shelf, and goodexamples/liskovsubstitution/AudioBookLocationService.java returns an online link. goodexamples/liskovsubstitution/LocationPrinter.java works with any LibraryItemService, so either service can be substituted without anything crashing.

## Interface Segregation Principle

Look at the interface badexamples/interfacesegregation/BadLibraryItem.java. It is one "fat" interface that mixes physical and digital capabilities: getShelfLocation(), getShippingWeightPounds() and generateStreamingUrl(). This violates the Interface Segregation Principle, which says clients should not be forced to depend on methods they do not use. badexamples/interfacesegregation/BadAudioBook.java has to implement all three, even though an audiobook has no shelf and is never shipped, so it is stuck with methods that just throw an UnsupportedOperationException. (Those throwing methods also set up the Liskov Substitution problem described above.)

Look at goodexamples/interfacesegregation/Shelvable.java, goodexamples/interfacesegregation/Shippable.java and goodexamples/interfacesegregation/Streamable.java for the fixed version. The fat interface is split into small, focused interfaces, and each class only implements the ones it can actually fulfil. goodexamples/interfacesegregation/LibraryBook.java implements Shelvable and Shippable, and goodexamples/interfacesegregation/LibraryAudioBook.java implements only Streamable. Code that just needs to stream something can ask for a Streamable and never sees shelf or shipping methods.

## Dependency Inversion Principle

Look at the class badexamples/dependencyinversion/BadOverdueNotifier.java. It holds the high-level business rule of telling members when a book is overdue, but it creates a concrete EmailSender itself with new EmailSender(). This violates the Dependency Inversion Principle, which says high-level modules should not depend on low-level modules; both should depend on abstractions. Because the notifier is hard-wired to email, switching to SMS or using a fake sender in a unit test means modifying BadOverdueNotifier.

Look at the class goodexamples/dependencyinversion/OverdueNotifier.java for the fixed version. It depends on the NotificationSender interface, and the concrete sender is passed in through its constructor (dependency injection). EmailNotificationSender and SmsNotificationSender both implement NotificationSender, so the caller decides how members are notified, and OverdueNotifier never changes.
    
## For teachers: moving on to domain models and mappers

This `main` branch is the starting point of the lesson. When the class is ready for a more mature version of the same library, switch to the `feature/domain-models-and-mappers` branch:

```
git switch feature/domain-models-and-mappers
```

That branch builds on everything here and adds:

- **Domain models** (`models/`): `Book` and `AudioBook` hold the business rules, separate from the DTOs that only carry data in and out of the app.
- **A `Borrowable` interface and an abstract `LibraryItem` base class**: the borrowing logic lives once in `LibraryItem`, and each item type only says how long its loans last.
- **Mappers** (`mappers/`): `BookMapper`, `AudioBookMapper` and `LoanMapper` convert between DTOs and models, so models never depend on DTOs.
- **A `LoanService`** that takes a DTO, maps it to a model, applies the borrowing rules, and returns a `LoanDTO`.

Commit or stash any live edits before switching, and run `git switch main` to come back. The branches are kept separate on purpose, so don't merge one into the other.
