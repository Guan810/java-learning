import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class decimal {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res=new int[alice.length];
        int curr=alice.length-1;
        alice[curr]=1;
        for(int i=0;i<scores.length;i++){
            if(curr>=0&&scores[i]>alice[curr]){
                if(i==0||scores[i]!=scores[i-1]){
                    res[curr]++;
                }
            }else if(curr<0){
                break;
            }else{
                curr--;
                res[curr]+=res[curr+1];
                i--;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        // for (int i = 0; i < result.length; i++) {
        //     bufferedWriter.write(String.valueOf(result[i]));

        //     if (i != result.length - 1) {
        //         bufferedWriter.write("\n");
        //     }
        // }

        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
