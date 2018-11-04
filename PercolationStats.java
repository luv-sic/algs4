import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] thresholds;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        thresholds = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            thresholds[i] = (double) p.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(thresholds.length));
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(thresholds.length));
    }

    // test client (described below)
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int trials = StdIn.readInt();
        PercolationStats ps = new PercolationStats(n, trials);
        StdOut.print(ps.mean());
    }
}
