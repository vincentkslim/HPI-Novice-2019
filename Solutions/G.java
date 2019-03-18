import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dp = new int[(int)1e7+5];

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] price = new int[N];
        int[] mass = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(sc.nextLine());
            price[i] = Integer.parseInt(st.nextToken());
            mass[i] = Integer.parseInt(st.nextToken());
        }

        int[] maxPrice = new int[M+1]; //maxPrice[i] is the maximum price achievable with mass i
        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.copyOf(maxPrice, maxPrice.length);
            for (int j = 0; j < temp.length; j++) {
                if(j + mass[i] <= M) {
                    temp[j + mass[i]] = Math.max(maxPrice[j+mass[i]], maxPrice[j] + price[i]);
                }
            }
            maxPrice = temp;
        }

//        System.out.println(Arrays.toString(maxPrice));
        int max = 0;
        for (int i = M; i >= 0; i--) {
            max = Math.max(max, maxPrice[i]);
        }
        System.out.println(max);
    }
}