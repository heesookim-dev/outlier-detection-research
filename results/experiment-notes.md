# Experiment Notes

## Dataset
A simple simulated dataset was used to evaluate outlier detection performance:

[10, 11, 12, 10, 9, 11, 50, 10, 12, 11]

This dataset contains one obvious extreme outlier (50) and otherwise tightly clustered values.

---

## Methods Compared
- Hampel method (median + MAD, sliding window)
- Boxplot method (IQR-based detection)

---

## Results

### Hampel Method
- Successfully detected the extreme outlier (50)
- Performance depends on window size (k)
- More robust to local variations due to median-based approach

### Boxplot Method
- Detected the extreme outlier using IQR thresholds
- Performance depends on overall distribution spread
- Less sensitive to local patterns compared to Hampel

---

## Observations

- Both methods successfully detect strong outliers in simple datasets
- Hampel is more flexible due to local window-based detection
- Boxplot is simpler but may fail when distribution is wide or skewed

---

## Insight

The Hampel method provides stronger robustness due to its reliance on median and MAD, while the Boxplot method offers simplicity but may lose sensitivity depending on the distribution.

---

## Next Step

- Evaluate the paper-proposed method (replacing MAD with mean)
- Test its impact on robustness and sensitivity
- Develop and test an alternative variable to improve performance in small-sample datasets
