package Programmers_1st.Level3.다단계칫솔판매;

import java.util.HashMap;

class Solution {

    class node {
        String name;
        String parent;
        int hap=0;

        node(String a, String b){
            this.name = a;
            this.parent = b;
        }
    }

    void addHap(HashMap<String, node> hm, String name, int price){
        if(name.equals("-")) return;
            int price10 = (int) (price * 0.1);
            if(price10 < 1) {
                node cur = hm.get(name);
                cur.hap += price;
                return;
            } else {
                int price90 = price - price10;
                node cur = hm.get(name);
                cur.hap += price90;
                addHap(hm,cur.parent,price10);
            }
    }


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, node> hm = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            node cur =  new node(enroll[i],referral[i]);
            hm.put(cur.name,cur);
        }

        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int sellAmount = amount[i];
            int sellPrice = sellAmount * 100;
            addHap(hm,sellerName,sellPrice);
        }


        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            answer[i] = hm.get(name).hap;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}, new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});
        for (int i = 0; i <tmp.length ; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}