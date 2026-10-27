package goodexamples.openclosed;

/*
* Example of a class that follows the Open/Closed Principle (OCP).
* Compare with badexamples/openclosed/BadFeeCalculator.java.
*/
public class FeeCalculator {

    // ✅ OPEN for extension: support a new item type (e.g. e-books) by writing a new
    // LateFeePolicy implementation such as EBookLateFeePolicy.
    // ✅ CLOSED for modification: this method never needs to change when that happens.
    public double calculateLateFee(LateFeePolicy policy, int daysLate) {
        if (daysLate < 0) {
            throw new IllegalArgumentException("Days late cannot be negative: " + daysLate);
        }

        return policy.calculateLateFee(daysLate);
    }

}
