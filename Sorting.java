import java.util.*;
import java.util.function.Function;

class SortValue<T> {
    private T value;

    public SortValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class InsertionSort<T extends Comparable<T>> {
    public void sort(SortValue<T>[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            SortValue<T> key = arr[i];
            int j = i - 1;

            while (j >= 0 && (ascending
                    ? arr[j].getValue().compareTo(key.getValue()) > 0
                    : arr[j].getValue().compareTo(key.getValue()) < 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}

class SelectionSort<T extends Comparable<T>> {
    public void sort(SortValue<T>[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending
                        ? arr[j].getValue().compareTo(arr[minIndex].getValue()) < 0
                        : arr[j].getValue().compareTo(arr[minIndex].getValue()) > 0) {
                    minIndex = j;
                }
            }
            SortValue<T> temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

class MergeSort<T extends Comparable<T>> {
    public void sort(SortValue<T>[] arr, boolean ascending) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        SortValue<T>[] left = Arrays.copyOfRange(arr, 0, mid);
        SortValue<T>[] right = Arrays.copyOfRange(arr, mid, arr.length);

        sort(left, ascending);
        sort(right, ascending);
        merge(arr, left, right, ascending);
    }

    private void merge(SortValue<T>[] arr, SortValue<T>[] left, SortValue<T>[] right, boolean ascending) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (ascending
                    ? left[i].getValue().compareTo(right[j].getValue()) <= 0
                    : left[i].getValue().compareTo(right[j].getValue()) >= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

class QuickSort<T extends Comparable<T>> {
    public void sort(SortValue<T>[] arr, boolean ascending) {
        quickSort(arr, 0, arr.length - 1, ascending);
    }

    private void quickSort(SortValue<T>[] arr, int low, int high, boolean ascending) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(arr, low, high, ascending);
        quickSort(arr, low, pivotIndex - 1, ascending);
        quickSort(arr, pivotIndex + 1, high, ascending);
    }

    private int partition(SortValue<T>[] arr, int low, int high, boolean ascending) {
        SortValue<T> pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean shouldSwap = ascending
                    ? arr[j].getValue().compareTo(pivot.getValue()) <= 0
                    : arr[j].getValue().compareTo(pivot.getValue()) >= 0;

            if (shouldSwap) {
                i++;
                SortValue<T> temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        SortValue<T> temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

public class Sorting {
    private static <T> SortValue<T>[] readUserArray(Scanner scan, int length, Function<String, T> parser) {
        @SuppressWarnings("unchecked")
        SortValue<T>[] values = (SortValue<T>[]) new SortValue[length];

        for (int i = 0; i < length; i++) {
            System.out.print("Array [" + i + "]: ");
            String input = scan.nextLine();
            values[i] = new SortValue<>(parser.apply(input));
        }

        return values;
    }

    private static void printArray(SortValue<?>[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i].getValue() + " ");
        }
        System.out.println();
    }

    private static void sortIntegers(Scanner scan) {
        System.out.print("How many values do you want to enter: ");
        int valLength = scan.nextInt();
        scan.nextLine();

        SortValue<Integer>[] values = readUserArray(scan, valLength, Integer::parseInt);

        System.out.println("Choose a sorting algorithm");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Enter choice: ");
        int algoChoice = scan.nextInt();
        System.out.println("Choose either Ascending or Descending");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int sortChoice = scan.nextInt();
        boolean ascending = sortChoice == 1;

        switch (algoChoice) {
            case 1:
                new InsertionSort<Integer>().sort(values, ascending);
                break;
            case 2:
                new SelectionSort<Integer>().sort(values, ascending);
                break;
            case 3:
                new MergeSort<Integer>().sort(values, ascending);
                break;
            case 4:
                new QuickSort<Integer>().sort(values, ascending);
                break;
            default:
                System.out.println("Invalid sorting choice");
                return;
        }

        printArray(values);
    }

    private static void sortStrings(Scanner scan) {
        System.out.print("How many values do you want to enter: ");
        int valLength = scan.nextInt();
        scan.nextLine();

        SortValue<String>[] values = readUserArray(scan, valLength, s -> s);

        System.out.println("Choose a sorting algorithm");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Enter choice: ");
        int algoChoice = scan.nextInt();
        System.out.println("Choose either Ascending or Descending");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int sortChoice = scan.nextInt();
        boolean ascending = sortChoice == 1;

        switch (algoChoice) {
            case 1:
                new InsertionSort<String>().sort(values, ascending);
                break;
            case 2:
                new SelectionSort<String>().sort(values, ascending);
                break;
            case 3:
                new MergeSort<String>().sort(values, ascending);
                break;
            case 4:
                new QuickSort<String>().sort(values, ascending);
                break;
            default:
                System.out.println("Invalid sorting choice");
                return;
        }

        printArray(values);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose a data type");
        System.out.println("1. String");
        System.out.println("2. Integer");
        System.out.print("Enter choice: ");
        int dataChoice = scan.nextInt();
        scan.nextLine();

        if (dataChoice == 1) {
            sortStrings(scan);
        } else if (dataChoice == 2) {
            sortIntegers(scan);
        } else {
            System.out.println("Invalid choice.");
        }

        scan.close();
    }
}                System.out.print("Array [" + i + "]" + ": ");
                String strVal = scan.nextLine();
            }
        }

        System.out.println("Choose a sorting algorithm");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Merge Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Enter choice: ");
        int algoChoice = scan.nextInt();

        System.out.println("Choose either Ascending or Descending");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int ascChoice = scan.nextInt();

    }

}
