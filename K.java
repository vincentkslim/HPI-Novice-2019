import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.parseInt(sc.nextLine());

        long[] field = new long[1000002];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            char c = st.nextToken().charAt(0);
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if(c == 'P') {
                field[left]++;
                field[right+1]--;
            } else {
                field[left]--;
                field[right+1]++;
            }
        }
        long[] potatoes = new long[1000002];
        long running = 0;
        for (int i = 0; i < 1000001; i++) {
            running+=field[i];
            potatoes[i] = running;
        }

        long[] prefix = new long[1000002];
        running=0;
        for (int i = 0; i < 1000001; i++) {
            running+=potatoes[i];
            prefix[i] = running;
        }

        int R = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());

            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            System.out.println(prefix[right] - prefix[left-1]);
        }
    }
}