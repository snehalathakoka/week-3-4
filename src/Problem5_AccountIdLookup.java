import java.util.*;

public class Problem5_AccountIdLookup {

    // 🔹 Linear Search (first occurrence)
    public static int linearSearchFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i + " (comparisons: " + comparisons + ")");
                return i;
            }
        }

        System.out.println("Not found (comparisons: " + comparisons + ")");
        return -1;
    }

    // 🔹 Linear Search (last occurrence)
    public static int linearSearchLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last Index: " + index + " (comparisons: " + comparisons + ")");
        return index;
    }

    // 🔹 Binary Search
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                System.out.println("Binary Found at index: " + mid + " (comparisons: " + comparisons + ")");
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Not found (comparisons: " + comparisons + ")");
        return -1;
    }

    // 🔹 Count occurrences using Binary Search
    public static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accA", "accB", "accB", "accC"};

        // IMPORTANT: sort before binary search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        binarySearch(logs, "accB");

        System.out.println("Count: " + countOccurrences(logs, "accB"));
    }
}