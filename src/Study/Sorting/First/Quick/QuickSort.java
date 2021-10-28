package Study.Sorting.First.Quick;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,24,45,45,2,3,4,61,20,9};
        QuickSort.sort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int l, int r) {
        if(l<r){
            int p = partition(arr,l,r);
            sort(arr,l,p-1);
            sort(arr,p+1,r);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left; int j = right;

        while( i< j){
            while(pivot < arr[j]){
                j--;
            }

            while(pivot > arr[i]){
                i++;
            }
            Swap(arr,i,j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        return i;
    }

    private static void Swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
