package Study.Sorting.Second;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10,7,9,4,1,3,5,2,4,6,8};
        //
        quick(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    private static void quick(int[] arr, int l, int r) {
        if(l < r){
            int p = partition(arr,l,r);
            quick(arr,l,p-1);
            quick(arr,p+1,r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int i = l - 1;
        int p = r;
        for (int j = l; j < r; j++) {
            if(arr[j] <= arr[p]){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,p);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
