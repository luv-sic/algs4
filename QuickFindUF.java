
/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class QuickFindUF {
    int[] id;

    QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    void union(int p, int q) {
        int pValue = id[p];
        int qValue = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pValue) id[i] = qValue;
        }
    }

    public static void main(String[] args) {
        QuickFindUF u = new QuickFindUF(10);
        u.union(1, 3);
        u.union(3, 5);
        System.out.print(u.connected(1, 4));
    }
}
