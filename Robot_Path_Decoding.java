import java.util.Scanner;

public class Robot_Path_Decoding {

    static Scanner in = new Scanner(System.in);

    static int testCases, n;

    static char a[];

    static long mod = (long) Math.pow(10, 9);

    static void solve(int testCases) {

        long x = 0, y = 0, num = 1;

        Stack<Long> stack = new Stack<>();

        stack.push((long) 1);

        for (int i = 0; i < n; i++) {

            char ch = a[i];

            if (Character.isDigit(ch)) {

                num = (num * (ch - '0')) % mod;

                stack.push(num);

            } else if (ch == '(') {

                continue;

            } else if (ch == ')') {

                stack.pop();

                num = stack.top();

            } else if (ch == 'N') {

                x = (x - num);

                if (x < 0) {

                    x += mod;

                }

            } else if (ch == 'S') {

                x = (x + num) % mod;

            } else if (ch == 'E') {

                y = (y + num) % mod;

            } else if (ch == 'W') {

                y = (y - num);

                if (y < 0)
                    y += mod;

            }

            // System.out.println("x: " + x + " y: " + y + " num: " + num);

            // stack.print();

        }

        System.out.println("Case #" + testCases + ": " + ++y + " " + ++x);

    }

    public static void main(String[] amit) {

        testCases = in.nextInt();

        for (int t = 1; t <= testCases; t++) {

            a = in.next().toCharArray();

            n = a.length;

            solve(t);

        }

    }

    static class Node1<T> {

        T data;

        Node1 next;

        public Node1(T data) {
            this.data = data;

            this.next = null;

        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node1 getNext() {
            return next;
        }

        public void setNext(Node1 next) {
            this.next = next;
        }

    }

    static class Stack<T> {

        int len;

        Node1<T> node;

        public Stack() {

            len = 0;

            node = null;

        }

        boolean isEmpty() {

            return len == 0;

        }

        int size() {

            return len;

        }

        void push(T data) {

            Node1<T> temp = new Node1<>(data);

            temp.setNext(this.node);

            node = temp;

            len++;

        }

        T top() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            return this.node.getData();

        }

        T pop() {

            if (isEmpty()) {

                throw new ArrayIndexOutOfBoundsException();

            }

            T data = this.node.getData();

            this.node = this.node.getNext();

            len--;

            return data;

        }

    }

}

/* 

1
N3(S)N2(E)N

*/

/*

1
SSSEEE

*/