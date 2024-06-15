import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start, end, weight;

    public Interval(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class WeightedIntervalScheduling {

    public static void main(String[] args) {
        Interval[] intervals = {
            new Interval(1, 3, 5),
            new Interval(2, 5, 6),
            new Interval(4, 6, 5),
            new Interval(6, 7, 4),
            new Interval(5, 8, 11),
            new Interval(7, 9, 2)
        };

        System.out.println("Maximum weight of non-overlapping intervals: " + findMaxWeight(intervals));
    }

    private static int findMaxWeight(Interval[] intervals) {
        int n = intervals.length;

        // Step 1: Sort intervals by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.end));

        // Step 2: Compute the p array using binary search
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = binarySearch(intervals, i);
        }

        // Step 3: Define the DP array
        int[] OPT = new int[n + 1];

        // Step 4: Fill the DP array
        for (int i = 1; i <= n; i++) {
            OPT[i] = Math.max(intervals[i - 1].weight + OPT[p[i - 1]], OPT[i - 1]);
        }

        // Step 5: The value OPT[n] gives the maximum weight
        return OPT[n];
    }

    private static int binarySearch(Interval[] intervals, int i) {
        int low = 0, high = i - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (intervals[mid].end <= intervals[i].start) {
                if (mid == high || intervals[mid + 1].end > intervals[i].start) {
                    return mid + 1;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}