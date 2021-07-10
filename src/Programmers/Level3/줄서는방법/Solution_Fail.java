package Programmers.Level3.줄서는방법;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution_Fail {
    long factorial(int n){
        long result = 1;
        while(n>=1) result *= n--;
        return result;
    }

    public int[] solution(int n, long k) {
        ArrayList<Integer> arl = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arl.add(i);
        }


        return go(0,0,n,k,new int[n],arl);
    }

    int[] go(long cnt, int idx , int n , long k , int[] answer, ArrayList<Integer> arl){
        if(idx == n){
            return answer;
        }

        int num = 0;
        long add = factorial(n-(idx+1));
        Collections.sort(arl);

        while(true){
            num = arl.remove(0);
            if(cnt + add >= k) break;
            cnt += add;
            arl.add(num);
        }

        answer[idx] = num;
        return go(cnt,idx+1,n,k,answer,arl);


    }

}