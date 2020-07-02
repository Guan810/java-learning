import java.util.Arrays;
import java.util.Scanner;

public class finalInArray {
    public static void main(String[] args) {
        final int[] a={1,1,1,1};
        System.out.println(Arrays.toString(a));
        tryToChange(a);
        System.out.println(Arrays.toString(a));
    }

    private static void tryToChange(int[] a) {
        a[0]=0;
    }
}

