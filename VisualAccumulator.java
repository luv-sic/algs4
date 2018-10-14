import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class VisualAccumulator {
    private double total;
    private int N;
    public VisualAccumulator(int trials,double max) {
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(0.005);
    }
    public void addDataValue(double val){
        N++;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(N,val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(N,total/N);
        total += val;
    }

    public double mean (){
        return total/N;
    }

    @Override
    public String toString() {
        return "Mean(" + N + ") value: " +
                String.format("%7.5f",mean());
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        VisualAccumulator A = new VisualAccumulator(T,1.0);
        for (int i = 0;i < T;i++){
            A.addDataValue(Math.random());
        }
        StdOut.println(A);
    }
}
