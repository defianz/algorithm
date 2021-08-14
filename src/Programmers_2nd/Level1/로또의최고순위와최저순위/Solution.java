package Programmers_2nd.Level1.로또의최고순위와최저순위;

import java.util.Arrays;
import java.util.stream.LongStream;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        return LongStream.of(
                (lottos.length + 1 ) - Arrays.stream(lottos).filter(i -> Arrays.stream(win_nums).anyMatch(w -> i == w) || i == 0).count(),
                (lottos.length + 1 ) - Arrays.stream(lottos).filter(i -> Arrays.stream(win_nums).anyMatch(w -> i == w)).count()
        )
                .mapToInt(i -> (int) (i > 6 ? i - 1 : i))
                .toArray();
    }
}