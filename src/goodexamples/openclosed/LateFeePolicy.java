package goodexamples.openclosed;

/*
* Abstraction that lets FeeCalculator follow the Open/Closed Principle (OCP).
* Each item type supplies its own implementation of how late fees are worked out.
*/
public interface LateFeePolicy {

    double calculateLateFee(int daysLate);

}
