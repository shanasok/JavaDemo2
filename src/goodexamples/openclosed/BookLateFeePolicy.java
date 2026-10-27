package goodexamples.openclosed;

public class BookLateFeePolicy implements LateFeePolicy {

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.20; // 20p per day
    }

}
