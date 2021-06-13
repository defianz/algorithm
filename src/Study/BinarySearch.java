package Study;

public class BinarySearch {

    static int binarySearch1(int target, int[] arr){
        int mid;
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
             mid = (l+r)/2;
            if(target == arr[mid]){
               return mid;
            } else if (target < arr[mid]){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    static int binarySearch2(int target,int l,int r, int[] arr){
        int mid = (l+r)/2;

        if(l>r) return -1;

        if(target == arr[mid]){
            return mid;
        } else if (target < arr[mid]){
            return binarySearch2(target,l,mid-1,arr);
        } else {
            return binarySearch2(target,mid+1,r,arr);
        }
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        int findIdx1 = binarySearch1(10, arr);
        int findIdx2 = binarySearch2(10,0,arr.length-1,arr);

        System.out.println("findIdx1 = " + findIdx1);
        System.out.println("findIdx2 = " + findIdx2);
    }
}
