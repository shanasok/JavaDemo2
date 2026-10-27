package dtos;

import java.util.Objects;

public class BookDTO {

    private BookMetadata metadata;
    private double shippingWeightPounds;

    //Constructors

    public BookDTO() {
        super();
    }

    public BookDTO(BookMetadata metadata, double shippingWeightPounds) {
        this.metadata = metadata;
        this.shippingWeightPounds = shippingWeightPounds;
    }

    // equals and hashCode methods for comparing BookDTO objects based on metadata and shipping weight

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Double.compare(shippingWeightPounds, bookDTO.shippingWeightPounds) == 0 && Objects.equals(metadata, bookDTO.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, shippingWeightPounds);
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "metadata=" + metadata +
                ", shippingWeightPounds=" + shippingWeightPounds +
                '}';
    }

    // Getters and Setters

    public BookMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(BookMetadata metadata) {
        this.metadata = metadata;
    }

    public double getShippingWeightPounds() {
        return shippingWeightPounds;
    }

    public void setShippingWeightPounds(double shippingWeightPounds) {
        this.shippingWeightPounds = shippingWeightPounds;
    }


}
