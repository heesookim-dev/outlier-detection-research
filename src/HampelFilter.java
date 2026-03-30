import java.util.Arrays;

public class HampelFilter {

    public static boolean[] detectOutliers(double[] data, int k, double nSigma) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data array must not be null or empty.");
        }
        if (k < 1) {
            throw new IllegalArgumentException("Window radius k must be at least 1.");
        }

        boolean[] outliers = new boolean[data.length];

        for (int i = 0; i < data.length; i++) {
            int start = Math.max(0, i - k);
            int end = Math.min(data.length - 1, i + k);

            double[] window = Arrays.copyOfRange(data, start, end + 1);

            double median = median(window);

            double[] absDeviations = new double[window.length];
            for (int j = 0; j < window.length; j++) {
                absDeviations[j] = Math.abs(window[j] - median);
            }

            double mad = median(absDeviations);
            double sigma = 1.4826 * mad;

            // MAD가 0이면 division 문제/판정 불안정하므로 skip
            if (sigma == 0) {
                outliers[i] = false;
                continue;
            }

            outliers[i] = Math.abs(data[i] - median) > nSigma * sigma;
        }

        return outliers;
    }

    public static double median(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values must not be null or empty.");
        }

        double[] copy = Arrays.copyOf(values, values.length);
        Arrays.sort(copy);

        int n = copy.length;
        if (n % 2 == 1) {
            return copy[n / 2];
        } else {
            return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
        }
    }
}