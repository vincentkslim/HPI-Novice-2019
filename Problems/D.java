import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result = "";

        String str = sc.nextLine();

        str = str.toUpperCase();

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ') {
                int num = (int)(str.charAt(i))-65;

                if(num <= 7) {
                    result += (char)(65+num+3);
                }
                else if(num <= 15) {
                    int d1 = num%10;
                    int d2 = num/10;

                    result += (char)(65+2*(d1+d2));
                }
                else {
                    result += (char)(65+num%5);
                }
            }
            else {
                result += " ";
            }
        }

        System.out.println(result.toLowerCase());
    }
}