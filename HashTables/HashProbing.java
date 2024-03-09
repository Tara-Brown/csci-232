import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

public class HashProbing {
    boolean[] hashArray;
    public HashProbing(int N){
        hashArray = new boolean[(int)(1.25*N)];
        for(int i = 0; i < N; i++){
            int key = (int)(Math.random()*hashArray.length);
            while(hashArray[key%hashArray.length]){
                key++;
            }
            hashArray[key%hashArray.length] = true;
        }
    }

    public double averageCost(){
        double sumProbes = 0;
       for(int i = 0; i < 10000; i++){
           sumProbes += missingSearch();
       }
       return sumProbes/10000;
    }

    public double missingSearch(){
        int countSearch = 1;
        int key = (int)(Math.random()*hashArray.length);
        while(hashArray[key%hashArray.length]){
            key++;
            countSearch++;
        }
        return countSearch;
    }

    public static void main(String[] args) {
        for (int N = 1000; N <=1000000; N*=10) {
            HashProbing tester = new HashProbing(N);
            double mean = tester.averageCost();
            
            StdOut.println("Average probes for a miss with N="+N+" is: "+mean);
        }
    }
}