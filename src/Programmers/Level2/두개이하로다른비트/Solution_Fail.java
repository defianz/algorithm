package Programmers.Level2.두개이하로다른비트;

class Solution_Fail {

    int check(long a, long b){
        long tmp = a^b;
        String tmpB = Long.toBinaryString(tmp).replaceAll("0","");
        return tmpB.length();
    }

    public long[] solution(long[] numbers) {

        int nLen = numbers.length;
        long[] answer = new long[nLen];

        for (int i = 0; i < nLen; i++) {
            long currN = numbers[i];
            if(currN %2 ==0) {
                answer[i] = currN+1;
                continue;
            }

            long nxt = currN + 1;
            while(true){
                if(check(nxt,currN) <=2 ) break;
                else{
                    nxt++;
                }
            }
            answer[i] = nxt;
        }

        return answer;
    }
}
