
/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class WeightedQuickUnionUF {
    private int[] id;
    private int[] h;

    WeightedQuickUnionUF(int n) {
        id = new int[n];
        h = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            h[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    boolean connected(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        return rootP == rootQ;
    }

    void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        int hP = h[rootP];
        int hQ = h[rootQ];
        if (rootP == rootQ) return;
        if (hP < hQ) {
            h[rootP] = hP + 1;
            id[rootP] = rootQ;
        }
        else {
            h[rootQ] = hQ + q;
            id[rootQ] = rootP;
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF u = new WeightedQuickUnionUF(10);
        u.union(1, 3);
        u.union(3, 5);
        System.out.print(u.connected(1, 4));
    }
}
