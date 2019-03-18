import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int index = 0;
        int maxIndex = -1;
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            sc.nextLine();

            if(v1*v2 > max) {
                max = v1*v2;
                maxIndex = index;
            }

            index++;
        }

        System.out.println(maxIndex +1);

    }
}