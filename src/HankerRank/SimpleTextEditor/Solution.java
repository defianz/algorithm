package HankerRank.SimpleTextEditor;

import java.io.*;
import java.util.*;

public class Solution {

//    Implement a simple text editor. The editor initially contains an empty string, . Perform  operations of the following  types:
//
//    append - Append string  to the end of .
//    delete - Delete the last  characters of .
//    print - Print the  character of .
//    undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int queryNum = Integer.parseInt(br.readLine());
        Stack<String> prevs = new Stack<>();
        String s = "";

        String undo = "";
        for (int i = 0; i < queryNum; i++) {
            String[] inputs = br.readLine().split(" ");
            switch ( Integer.parseInt(inputs[0])){
                case 1:
                    undo = s;
                    s += inputs[1];
                    prevs.push(undo);
                    break;
                case 2:
                    int deleteIdx = Integer.parseInt(inputs[1])-1;
                    undo = s;
                    s = s.substring(0,s.length()-deleteIdx-1);
                    prevs.push(undo);
                    break;
                case 3:
                    System.out.println(s.charAt(Integer.parseInt(inputs[1])-1));
                    break;
                case 4:
                    String pop = prevs.pop();
                    s = pop;
                    break;
            }
        }

        br.close();
    }
}