package Study.Sorting.Second;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10,7,9,4,1,3,5,2,4,6,8};
        //
        Sort(arr);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    private static void Sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIdx]) minIdx = j;
            }
            swap(arr,minIdx,i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
