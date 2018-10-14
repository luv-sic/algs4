import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;

public class One_one {
    //1.1.11
    public static void func1() {
        int row = 10;
        int col = 2;
        boolean[][] arr = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                arr[i][0] = false;
                arr[i][1] = true;
            } else {
                arr[i][0] = true;
                arr[i][1] = false;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (arr[i][k]) {
                    System.out.println("row: ;" + i + "col: ;" + k + "val: *");
                } else {
                    System.out.println("row: ;" + i + "col: ;" + k + "val: ");
                }
            }
        }
    }

    //1.1.12
    public static void func2() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    //1.1.13
    public static void func3() {
        int M = 10;
        int N = 5;
        int[][] a = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                a[i][k] = k;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int k = N - 1; k > -1; k--) {
                StdOut.println(String.format("x: %d, y: %d", i, k));
            }
        }
    }

    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 1) + n;
    }

    public static int findCount(int[] a, int val) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) {
                count++;
            }
        }
        return count;
    }

    public static void histogram(int a[], int M) {
        int[] ret = new int[M];
        for (int i = 0; i < M; i++) {
            ret[i] = findCount(a, i);
        }
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || a[i] > (M - 1)) {
                flag = true;
                break;
            }
        }
    }

    //1.1.24 辗转相除法 欧几里得
    public static int euclidean(int m, int n) {
        StdOut.println(String.format("m: %d, n: %d", m, n));
        if (m == 0) return n;
        if (n == 0) return m;
        int max = m > n ? m : n;
        int min = m > n ? n : m;
        int dist = max - min;
        return euclidean(min, dist);
//        int m = Integer.parseInt(args[0]);
//        int n = Integer.parseInt(args[1]);
//        StdOut.println("result: " + euclidean(m, n));
    }

    public static void main(String[] args) {

    }
}