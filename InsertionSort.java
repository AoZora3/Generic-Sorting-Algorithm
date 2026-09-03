public class InsertionSort<T extends Comparable<T>> {
    public void sort(SortValue<T>[] arr, boolean ascending, boolean visualize) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            SortValue<T> key = arr[i];
            int j = i - 1;

            while (j >= 0 && (ascending ? arr[j].getValue().compareTo(key.getValue()) > 0 : arr[j].getValue().compareTo(key.getValue()) < 0)) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            if (visualize) {
                Visualizer.visualizeSort(arr, "Insertion Sort Step " + i);
            }
        }
    }
}