package Study.Sorting.First.Merge;

public class MergeSort {

    static int[] sorted;

    public static void main(String[] args) {
        int[] arr = new int[]{1,24,45,45,2,3,4,61,20,9};
        sorted = new int[arr.length];
        MergeSort.sort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int l, int r) {
        if(l<r){
            int mid = l + (r-l)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int i, j, k, a;
        i = l;
        j = mid+1;
        k = l;

        while(i <= mid && j <= r){
            if(arr[i] <= arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        }

        while(i <= mid)
            sorted[k++] = arr[i++];
        while(j <= r)
            sorted[k++] = arr[j++];

        for (int m = l; m <= r; m++) {
            arr[m] = sorted[m];
        }
    }
}
