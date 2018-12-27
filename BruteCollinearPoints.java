import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

//
public class BruteCollinearPoints {
    private final LineSegment[] segs = new LineSegment[1];
    private int numberOfSegs = 0;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        checkArgs(points);
        Point minPoint = points[0];
        double[] slopes = new double[points.length - 1];
        for (int i = 1; i < points.length; i++) {
            slopes[i - 1] = minPoint.slopeTo(points[i]);
            // StdOut.println(slopes[i]);
        }
        double firstSlope = slopes[0];
        boolean isCollinear = true;
        StdOut.println(firstSlope);
        StdOut.println("firstslop");
        for (int i = 1; i < slopes.length; i++) {
            StdOut.println(slopes[i]);
            if (slopes[i] != firstSlope) {
                isCollinear = false;
            }
        }
        if (isCollinear) {
            Point maxPoint = points[points.length - 2];
            // StdOut.println(minPoint);
            // StdOut.println(maxPoint);
            segs[numberOfSegs++] = new LineSegment(minPoint, maxPoint);
        }
    }

    private void checkArgs(Point[] points) {
        if (points == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        for (int i = 0; i < points.length - 1; i++) {
            int j = i + 1;
            if (points[i].compareTo(points[j]) == 0) {
                throw new java.lang.IllegalArgumentException();
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return numberOfSegs;
    }

    // the line segments
    public LineSegment[] segments() {
        return segs;
    }

    public static void main(String[] args) {
        Point[] ps = new Point[10];
        for (int i = 9; i >= 0; i--) {
            ps[i] = new Point(i, i);
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        for (Point p : ps) {
            p.draw();
        }
        StdDraw.show();

        BruteCollinearPoints cp = new BruteCollinearPoints(ps);
        for (LineSegment ls : cp.segments()) {
            ls.draw();
        }
        StdDraw.show();

        StdOut.println(cp.numberOfSegs);
    }
}
