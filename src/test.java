import java.util.*;

public class test {
    public static void main(String[] args) {
//        int x = 10;
//        int y = x;
//        y = y-1;
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
//
//
//        int[] arr = {12,3,4,5,5};
//        System.out.println("Arrays.stream(arr).max() = " + (Arrays.stream(arr).max().getAsInt()+1));
//        int[] arr2= Arrays.stream(arr).filter(i -> i != 12).toArray();
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.println(arr2[i]);
//        }
//
//        System.out.println(Math.floor(Math.sqrt(3)));
//        System.out.println(Math.sqrt(3));
//        System.out.println((long)Math.sqrt(3));

        HashMap<String, Integer> arr = new HashMap<>();
        arr.put("hi",10);
        arr.put("hi",20);

        Set<Integer> s = new HashSet<>();

        arr.put("hhh",null);
        System.out.println("arr.get(\"hi\") = " + arr.get("hi"));
        System.out.println("arr.get(\"dht\") = " + arr.get("dht"));
        System.out.println("arr.get(\"hhh\") = " + arr.get("hhh"));

        HashSet<String> arr2 = new HashSet<>();
        arr2.add("hi");
        arr2.add("hi");


        int[] aaa = new int[]{1,2,3};
        ArrayList<Integer> hi = new ArrayList<>();

        String a = "Rnjsguasdf";
        a.split("");
        a.toCharArray();


        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        map.put("권혁찬", new ArrayList<Integer>());
        map.get("권혁찬").add(10);
        System.out.println("map.get(\"권혁찬\").get(0) = " + map.get("권혁찬").get(0));


        arr2.contains("hi");

    }
}
