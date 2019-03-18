import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> suits = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            suits.add(Integer.parseInt(sc.nextLine()));
        }

        long price = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(sc.nextLine());
            int S = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            if(suits.contains(S)) {
                price+=P;
                suits.remove(S);
            }
        }
        System.out.println(price);
    }
}