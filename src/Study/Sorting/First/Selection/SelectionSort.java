package Study.Sorting.First.Selection;


public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,24,45,45,2,3,4,61,20,9};
        SelectionSort.sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIdx] > arr[j]) minIdx = j;
            }
            Swap(arr, i, minIdx);
        }
    }

    private static void Swap(int[] arr, int i, int minIdx) {
        int tmp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = tmp;
    }
}
