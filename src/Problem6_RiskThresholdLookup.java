import java.util.*;

public class Problem6_RiskThresholdLookup {

    // 🔹 Linear Search (unsorted)
    public static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index: " + i + " (comparisons: " + comparisons + ")");
                return i;
            }
        }

        System.out.println("Linear: Not found (comparisons: " + comparisons + ")");
        return -1;
    }

    // 🔹 Binary Search (exact match)
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                System.out.println("Binary Found at index: " + mid + " (comparisons: " + comparisons + ")");
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Binary: Not found (comparisons: " + comparisons + ")");
        return -1;
    }

    // 🔹 Floor (largest ≤ target)
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                result = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    // 🔹 Ceiling (smallest ≥ target)
    public static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // 🔹 Insertion Point
    public static int insertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        // Linear
        linearSearch(risks, 30);

        // Binary
        binarySearch(risks, 50);

        // Floor & Ceiling
        System.out.println("Floor of 30: " + floor(risks, 30));
        System.out.println("Ceiling of 30: " + ceiling(risks, 30));

        // Insertion Point
        System.out.println("Insertion index for 30: " + insertionPoint(risks, 30));
    }
}