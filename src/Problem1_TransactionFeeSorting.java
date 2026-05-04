import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class Problem1_TransactionFeeSorting {

    // 🔹 Bubble Sort (by fee ASC)
    public static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        boolean swapped;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimization
        }

        System.out.println("Bubble Sort Result: " + list);
        System.out.println("Total swaps: " + swaps);
    }

    // 🔹 Insertion Sort (fee + timestamp)
    public static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).timestamp.compareTo(key.timestamp) > 0))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result: " + list);
    }

    // 🔹 High fee detection
    public static void findHighFee(List<Transaction> list) {
        System.out.println("High Fee Transactions (>50):");
        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t);
            }
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        // Bubble Sort
        bubbleSort(new ArrayList<>(transactions));

        // Insertion Sort
        insertionSort(new ArrayList<>(transactions));

        // High fee check
        findHighFee(transactions);
    }
}