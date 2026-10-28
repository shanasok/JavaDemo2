package models;

import enums.AudienceAgeEnum;

/*
* Domain model for a physical book.
* Takes plain fields rather than a BookDTO so the model never depends on the dtos package.
*/
public class Book extends LibraryItem {

    private static final int LOAN_PERIOD_DAYS = 21;

    private final double shippingWeightPounds;

    public Book(String isbn, String title, String author, AudienceAgeEnum audienceAge, double shippingWeightPounds) {
        super(isbn, title, author, audienceAge);
        this.shippingWeightPounds = shippingWeightPounds;
    }

    @Override
    protected int getLoanPeriodDays() {
        return LOAN_PERIOD_DAYS;
    }

    // Getters

    public double getShippingWeightPounds() {
        return shippingWeightPounds;
    }

}
