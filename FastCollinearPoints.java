import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

//
public class FastCollinearPoints {
    private final LineSegment[] segs = new LineSegment[1];
    private int numberOfSegs = 0;

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        checkArgs(points);
        for (Point p : points) {
            Arrays.sort(points, p.SLOPE_ORDER);
            for (int i = 0; i < points.length; ) {
                if (points[i] == null) break;
                int j = i + 1;
                if (points[j] == null) break;
                while (points[j] != null && p.slopeTo(points[i]) == p.slopeTo(points[j])) {
                    StdOut.println(i);
                    StdOut.println(j);
                    j++;
                }
                if (j - i >= 4) {
                    segs[numberOfSegs++] = new LineSegment(points[i], points[j]);
                }
                i += j;
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return numberOfSegs;
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

    // the line segments
    public LineSegment[] segments() {
        return segs;
    }

    public static void main(String[] args) {
        Point[] ps = new Point[10];
        for (int i = 9; i >= 0; i--) {
            ps[i] = new Point(i, i);
        }
        // StdDraw.enableDoubleBuffering();
        // StdDraw.setXscale(0, 10);
        // StdDraw.setYscale(0, 10);
        // for (Point p : ps) {
        //     p.draw();
        // }
        // StdDraw.show();

        FastCollinearPoints cp = new FastCollinearPoints(ps);
        for (LineSegment ls : cp.segments()) {
            // ls.draw();
            StdOut.println(ls.toString());
        }
        // StdDraw.show();

        StdOut.println(cp.numberOfSegments());
    }
}
