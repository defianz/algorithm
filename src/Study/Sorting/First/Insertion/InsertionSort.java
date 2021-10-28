package Study.Sorting.First.Insertion;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,24,45,45,2,3,4,61,20,9};
        InsertionSort.sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j ;
            for ( j = i-1; j >= 0; j--) {
                if(arr[j] <= arr[j+1]) break;
                arr[j+1] = arr[j];
            }
            arr[j] = arr[i];
        }
    }
}
