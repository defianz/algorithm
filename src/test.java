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
        System.out.println("'A'-0 = " + (int)'A');
        System.out.println("'J' = " + (int)'Z');
        
        String tmp = "CBD";
        String tmp2 = "BACDE";
        String tmp3 = tmp2.replaceAll("[^"+tmp+"]","");
        System.out.println("tmp = " + tmp);
        System.out.println("tmp2 = " + tmp2);
        System.out.println("tmp3 = " + tmp3);

        String[] hi = new String[]{"1111","222","33","9"};
        Arrays.sort(hi);



        System.out.println("Integer.parseInt(\"000011\") = " + Integer.parseInt("000011"));

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
//        ArrayList<Integer> hi = new ArrayList<>();

        String a = "Rnjsguasdf";
        a.split("");
        a.toCharArray();


        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        map.put("권혁찬", new ArrayList<Integer>());
        map.get("권혁찬").add(10);
        System.out.println("map.get(\"권혁찬\").get(0) = " + map.get("권혁찬").get(0));


        arr2.contains("hi");


        System.out.println("\"-----------------\" = " + "-----------------");

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(1);
        pq.add(2);
        pq.add(5);

        Iterator<Integer> aa = pq.iterator();
        while(aa.hasNext()){
            System.out.println("aa = " + aa.next());
        }

    }
}
