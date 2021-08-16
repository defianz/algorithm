package Programmers_2nd.Level1.삼진법뒤집기;

class Solution {
    public int solution(int n) {
        String binary = Integer.toString(n,3);
        String reverseBinary = new StringBuilder(binary).reverse().toString();
        return  Integer.parseInt(reverseBinary,3);
    }
}