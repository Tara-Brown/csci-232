/* *****************************************************************************
 *  Name:              Tara Brown
 *  Last modified:     Feb 2, 2024
 **************************************************************************** */
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    int N;
    int T;
    double[] percentOpen;
    public PercolationStats(int N, int T) {
        // perform T independent experiments on an N-by-N grid
        percentOpen = new double[T];
        this.N = N;
        this.T = T;

        //Performs T experiments
        for (int i = 0; i < T; i++){
            //new grid/order per experiment
            int [] randomOrder = StdRandom.permutation(N*N);
            Percolation grid = new Percolation(N);
            //one experiment
            for (int k = 0; k < N*N; k++){
                if(grid.percolates()){
                    break;
                }
              grid.open(randomOrder[k]/N, randomOrder[k]%N);
                percentOpen[i]++;
            }
            percentOpen[i] /= N*N;
        }
    }

    public double mean() {
        // sample mean of percolation threshold
        return StdStats.mean(percentOpen);
    }
    public double stddev() {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(percentOpen);
    }
    public double confidenceLow() {
        // low  endpoint of 95% confidence interval
        return mean()-(1.96*stddev()/Math.sqrt(T));
    }
    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        return mean()+(1.96*stddev()/Math.sqrt(T));
    }

    public static void main(String[] args) {
        // Not required for the API, but useful to test if
        // your code is doing reasonable things
        Stopwatch watch = new Stopwatch();
        PercolationStats st = new PercolationStats(200,800);
        double time = watch.elapsedTime();
        System.out.println(time);
    }
}