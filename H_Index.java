
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class H_Index {

    static Scanner in = new Scanner();

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int testCases, n;

    static long a[];

    static StringBuilder ans = new StringBuilder();

    static void solve(int left, int right) {

        long copyA[] = new long[-left + right + 1];

        for (int i = left; i <= right; i++) {

            copyA[i] = a[i];

        }

        sort(copyA, left, right);

        if (copyA[left] >= -left + right + 1) {

            ans.append(right - left + 1).append(" ");

            return;

        }

        int high = right;
        int low = left;
        int mid;
        int candidate = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (copyA[mid] >= (right - left + 1) - mid) {
                candidate = (right - left + 1) - mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        ans.append(candidate).append(" ");

    }

    static void solve(int testCases) {

        ans.append("Case #").append(testCases).append(": ");

        //System.out.print("1 ");
        /*for (int i = 0; i < n; i++) {

            solve(0, i);

        }*/
        PriorityQueue<citation> pq = new PriorityQueue<>();

        int si = 0, ans1 = 0;

        for (int i = 0; i < n; i++) {

            while (!pq.isEmpty() && pq.peek().element <= ans1) {

                si--;

                pq.poll();

            }

            if (a[i] > ans1) {

                pq.add(new citation(a[i]));
                si++;

            }

            if (si == ans1+1) {

                ++ans1;

            }

            ans.append(ans1).append(" ");

        }

        ans.append("\n");

    }

    public static void main(String[] amit) throws IOException {

        testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {

            n = in.nextInt();

            a = new long[n];

            for (int i = 0; i < n; i++) {

                a[i] = in.nextLong();

            }

            solve(t);

        }

        out.println(ans.toString());

        out.flush();

    }

    static void merge(long a[], int left, int right, int mid) {

        int n1 = mid - left + 1, n2 = right - mid;

        long L[] = new long[n1];

        long R[] = new long[n2];

        for (int i = 0; i < n1; i++) {

            L[i] = a[left + i];

        }

        for (int i = 0; i < n2; i++) {

            R[i] = a[mid + 1 + i];

        }

        int i = 0, j = 0, k1 = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {

                a[k1] = L[i];

                i++;

            } else {

                a[k1] = R[j];

                j++;

            }

            k1++;

        }

        while (i < n1) {

            a[k1] = L[i];

            i++;

            k1++;

        }

        while (j < n2) {

            a[k1] = R[j];

            j++;
            k1++;

        }

    }

    static void sort(long a[], int left, int right) {

        if (left >= right) {

            return;

        }

        int mid = (left + right) / 2;

        sort(a, left, mid);

        sort(a, mid + 1, right);

        merge(a, left, right, mid);

    }

    static class Scanner {

        BufferedReader in;
        StringTokenizer st;

        public Scanner() {

            in = new BufferedReader(new InputStreamReader(System.in));

        }

        String next() throws IOException {

            while (st == null || !st.hasMoreElements()) {

                st = new StringTokenizer(in.readLine());

            }

            return st.nextToken();

        }

        int nextInt() throws IOException {

            return Integer.parseInt(next());

        }

        long nextLong() throws IOException {

            return Long.parseLong(next());

        }

        String nextLine() throws IOException {

            return in.readLine();

        }

        char nextChar() throws IOException {

            return next().charAt(0);

        }

        double nextDouble() throws IOException {

            return Double.parseDouble(next());

        }

        float nextFloat() throws IOException {

            return Float.parseFloat(next());

        }

        boolean nextBoolean() throws IOException {

            return Boolean.parseBoolean(next());

        }

        void close() throws IOException {

            in.close();

        }

    }

    static class citation implements Comparable<citation> {

        long element;

        public citation(long element) {
            this.element = element;
        }

        @Override
        public int compareTo(citation t) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            return Long.compare(this.element, t.element);

        }

    }

}
/*

1
3
5 1 2

 */

 /*

1
6
1 3 3 2 2 15

 */
