package Study.Sorting.Bubble;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,24,45,45,2,3,4,61,20,9};
        BubbleSort.sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    swapArr(arr,j,j+1);
                }
            }
        }
    }

    private static void swapArr(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = tmp;
        return;
    }
}
