import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] data = {10, 11, 12, 10, 9, 11, 50, 10, 12, 11};

        int windowRadius = 1;   // k
        double nSigma = 3.0;

        boolean[] outliers = HampelFilter.detectOutliers(data, windowRadius, nSigma);

        System.out.println("Data:     " + Arrays.toString(data));
        System.out.println("Outliers: " + Arrays.toString(outliers));

        System.out.print("Detected outlier values: ");
        for (int i = 0; i < data.length; i++) {
            if (outliers[i]) {
                System.out.print(data[i] + " ");
            }
        }
        System.out.println();
    }
}