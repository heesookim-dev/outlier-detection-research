import java.util.Arrays;

public class BoxplotDetector {

    public static boolean[] detectOutliers(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data array must not be null or empty.");
        }

        double[] sorted = Arrays.copyOf(data, data.length);
        Arrays.sort(sorted);

        double q1 = quartile(sorted, 0.25);
        double q3 = quartile(sorted, 0.75);
        double iqr = q3 - q1;

        double lowerBound = q1 - 1.5 * iqr;
        double upperBound = q3 + 1.5 * iqr;

        boolean[] outliers = new boolean[data.length];
        for (int i = 0; i < data.length; i++) {
            outliers[i] = data[i] < lowerBound || data[i] > upperBound;
        }

        return outliers;
    }

    private static double quartile(double[] sorted, double percentile) {
        double index = percentile * (sorted.length - 1);
        int lower = (int) Math.floor(index);
        int upper = (int) Math.ceil(index);

        if (lower == upper) {
            return sorted[lower];
        }

        double weight = index - lower;
        return sorted[lower] * (1 - weight) + sorted[upper] * weight;
    }
}