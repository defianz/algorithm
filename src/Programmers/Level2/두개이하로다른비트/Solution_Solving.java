package Programmers.Level2.두개이하로다른비트;

class Solution_Solving {
    public long[] solution(long[] numbers) {

        int nLen = numbers.length;
        long[] answer = new long[nLen];

        for (int i = 0; i < nLen; i++) {
            long currN = numbers[i];
            String currB = Long.toBinaryString(currN);
            long nxt = currN + 1;
            while(true){

            }

        }

        return answer;
    }
}
