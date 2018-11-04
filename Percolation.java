
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final int size;
    private int[] state;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        // initialize Percolation model with n*n grid and two virutual site
        uf = new WeightedQuickUnionUF(n * n + 2);
        // 需要状态来存储 cell 的 isOpen 0表示close 1表示open
        state = new int[n * n + 2];
        for (int i = 0; i < n * n; i++) {
            state[i] = 0;
        }
        state[n * n] = 1;
        state[n * n + 1] = 1;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        checkArg(row, col);
        if (isOpen(row, col)) return;
        int position = getPosition(row, col);
        state[position] = 1;
        // StdOut.println("row: " + row + ", col: " + col + ", position: " + position);

        // check site left
        if (col != 1 && isOpen(row, col - 1)) {
            uf.union(getPosition(row, col - 1), position);
        }
        // check site right
        if (col != size && isOpen(row, col + 1)) {
            uf.union(position, getPosition(row, col + 1));
        }
        // check site top
        if (row == 1) {
            uf.union(position, size * size);
        }
        else if (isOpen(row - 1, col)) {
            uf.union(position, getPosition(row - 1, col));
        }
        // union site bottom
        if (row == size) {
            uf.union(position, size * size + 1);
        }
        else if (isOpen(row + 1, col)) {
            uf.union(position, getPosition(row + 1, col));
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkArg(row, col);
        int position = getPosition(row, col);
        return state[position] == 1;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        checkArg(row, col);
        return uf.connected(size * size, getPosition(row, col));
    }

    // number of open sites
    public int numberOfOpenSites() {
        int openSites = 0;
        for (int i = 0; i < size * size; i++) {
            if (state[i] == 1) {
                openSites++;
            }
        }
        return openSites;
    }


    private void checkArg(int row, int col) {
        if (row > size || row <= 0) {
            throw new IllegalArgumentException();
        }
        if (col > size || col <= 0) throw new IllegalArgumentException();
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(size * size, size * size + 1);
    }

    private int getPosition(int row, int col) {
        int position = ((row - 1) * size) + col - 1;
        return position;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(2, 2);
        p.open(3, 3);
        // p.open(4, 4);
        p.open(5, 5);
        StdOut.print(p.percolates());
    }
}
