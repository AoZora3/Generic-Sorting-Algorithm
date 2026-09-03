public class SelectionSort<T extends Comparable<T>> {
    public void sort(SortValue<T>[] arr, boolean ascending, boolean visualize) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if ((ascending && arr[j].getValue().compareTo(arr[minIndex].getValue()) < 0) ||
                    (!ascending && arr[j].getValue().compareTo(arr[minIndex].getValue()) > 0)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortValue<T> temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            if (visualize) {
                Visualizer.visualizeSort(arr, "Selection Sort - Step " + (i + 1));
            }
        }
    }

}
