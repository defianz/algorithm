package Programmers.Level2.두개이하로다른비트;

class Solution {
    public long[] solution(long[] numbers) {
        int len = numbers.length;
        long[] answer = new long[len];


        for (int i = 0; i < len; i++) {
            long currN = numbers[i];
            if(currN % 2 == 0) {
                answer[i] = currN+1;
            } else {
                String tmp = Long.toBinaryString(currN);
                if(!tmp.contains("0")){
                    StringBuilder sb = new StringBuilder();
                    sb.append("10");
                    for (int j = 0; j < tmp.length()-1; j++) {
                        sb.append("1");
                    }
                    answer[i] = Long.parseLong(sb.toString(),2);
                } else {
                    char[] tmp2 = tmp.toCharArray();
                    for (int j = tmp2.length-2; j >= 0; j--) {
                        if(tmp2[j] == '0') {
                            tmp2[j] = '1';
                            tmp2[j+1] = '0';
                            break;
                        }
                    }
                    answer[i] = Long.parseLong(new String(tmp2),2);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long tmp[] = s.solution(new long[]{2,7});
        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}
