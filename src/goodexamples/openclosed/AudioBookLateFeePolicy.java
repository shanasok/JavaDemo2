package goodexamples.openclosed;

public class AudioBookLateFeePolicy implements LateFeePolicy {

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.10; // 10p per day
    }

}
