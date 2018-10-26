
public class Percolation {
    private QuickUnionUF UF;
    private int virtualHead;
    private int virtualTail;
    private int size;
    private int openSites = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        // initialize Percolation model with n*n grid and two virutual site
        UF = new QuickUnionUF(n * n + 2);
        virtualHead = 0;
        virtualTail = n * n + 1;
        size = n;
        // union virtualHead with first row of sites
        for (int i = 1; i <= n; i++) {
            UF.union(virtualHead, i);
        }
        // union virtualTail with last row of sites
        for (int i = n * (n - 1); i <= (n * n); i++) {
            UF.union(virtualTail, i);
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        checkArg(row, col);
        if (isOpen(row, col)) return;
        int position = (row - 1) * size + col;
        // union site left
        if (col == 1) {
        }
        else {
            UF.union(position, position - 1);
        }
        // union site right
        if (col == size) {

        }
        else {
            UF.union(position, position + 1);
        }
        // union site top
        if (row == 1) {

        }
        else {
            UF.union(position, position - size);
        }
        // union site bottom
        if (row == size) {

        }
        else {
            UF.union(position, position + size);
        }
        openSites++;
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkArg(row, col);
        int position = (row - 1) * size + col;
        int openSide = 0;
        // check is site left open
        if (col == 1) {
            openSide++;
        }
        else {
            if (UF.connected(position, position - 1)) openSide++;
        }
        // check is site right open
        if (col == size) {
            openSide++;
        }
        else {
            if (UF.connected(position, position + 1)) openSide++;
        }
        // check is site top open
        if (row == 1) {
            openSide++;
        }
        else {
            if (UF.connected(position, position - size)) openSide++;
        }
        // check is site bottom open
        if (row == size) {
            openSide++;
        }
        else {
            if (UF.connected(position, position + size)) openSide++;
        }
        return openSide == 4;
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        checkArg(row, col);
        return !isOpen(row, col);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    private void checkArg(int row, int col) {
        if (row > size || row < 0) {
            throw new IllegalArgumentException();
        }
        if (col > size || col < 0) throw new IllegalArgumentException();
    }

    // does the system percolate?
    public boolean percolates() {
        return UF.connected(virtualHead, virtualTail);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(2, 2);
        p.open(3, 3);
        // p.open(4, 4);
        p.open(5, 5);
        System.out.print(p.percolates());
    }
}
