package Study.Sorting.Second;

public class MergeSort {

    static int[] tmp;
    public static void main(String[] args) {
        int[] arr = new int[]{10,7,9,4,1,3,5,2,4,6,8};
        //
        tmp = new int[arr.length];
        merge(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    private static void merge(int[] arr, int l, int r) {
        if(l < r){
            int mid = l + (r-l) /2;
            merge(arr,l,mid);
            merge(arr,mid+1,r);
            mergeSort(arr,l,mid,r);

        }
    }

    private static void mergeSort(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;

        while(i <= mid && j <= r){
            if(arr[i] < arr[j]){
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            tmp[k++] = arr[i++];
        }

        while(j <= r){
            tmp[k++] = arr[j++];
        }

        for (int m = l; m <= r; m++) {
            arr[m] = tmp[m];
        }
    }

}
