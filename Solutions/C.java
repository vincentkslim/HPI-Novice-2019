import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();

        int r6 = 0;
        int c6 = 0;

        int c = n / r;

        int[][] leprechauns = new int[r][c];

        int count = 0;
        int ans;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                leprechauns[i][j] = count+1;

                if (count == 5) {
                    r6 = i+1;
                    c6 = j-1;
                }
                count++;
            }
        }

        System.out.println(leprechauns[r6][c6]*3+4);
    }
}