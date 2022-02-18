
import java.util.Scanner;

public class Centauri_Prime {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static String s;

    static char a[];

    static void solve(int testCases) {

        boolean alice = false, bob = false;

        switch (a[n - 1]) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':    
                alice = true;
                break;
            case 'y':
            case 'Y':    
                alice = false;
                bob = false;
                break;
            default:
                bob = true;
                break;
        }

        String ans = alice == true ? "Alice." : "Bob.";

        ans = alice == false && bob == false ? "nobody." : ans;

        System.out.println("Case #" + testCases + ": " + new String(a) + " is ruled by " + ans);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {

            s = in.next();

            a = s.toCharArray();

            n = a.length;

            solve(t);

        }

    }

}
/*

3
Mollaristan
Auritania
Zizily


 */
