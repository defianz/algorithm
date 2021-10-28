package Study.Sorting.Second;

public class InsertionSort {
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
        for (int i = 1; i < n; i++) {
            int insertValue = arr[i];
            int j;
            for ( j = i-1; j >= 0; j--) {
                if(arr[j] < arr[j+1]) break;
                arr[j+1] = arr[j];
            }
            arr[j+1] = insertValue;
        }
    }
}
