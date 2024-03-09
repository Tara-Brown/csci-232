/* *****************************************************************************
 *  Name:              Tara Brown
 *  Last modified:     January 29, 2024
 **************************************************************************** */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.QuickFindUF;

public class Percolation {
    WeightedQuickUnionUF matrixConnect;
    int[][] matrixVal;
    int matrixSize;
    int openCount;

    public Percolation(int N)  {
        //check conditions
        if (N<= 0){
            throw new IndexOutOfBoundsException();
        }
        //create object
        else{
            matrixVal = new int[N][N]; //0 means blocked, one means open
            matrixConnect = new WeightedQuickUnionUF(N*N+2); //two extra spots to connect top and bottom
            matrixSize = N;
        }
        // create N-by-N grid, with all sites initially blocked
    }
    public void open(int row, int col) {
        //check bounds
        if (row< 0||row>=matrixSize||col<0||col >=matrixSize){
            throw new IndexOutOfBoundsException();
        }

        // open the site (row, col) if it is not open already
        if (matrixVal[row][col] == 1) //check if open
            return;

        matrixVal[row][col] = 1;
        openCount++;

        //check surrounding sites for connections
        int matrixNum = row*matrixSize+col;
        //check top
        if(row == 0)
            matrixConnect.union(matrixNum, matrixSize * matrixSize);
        else if (matrixVal[row-1][col] ==1)
            matrixConnect.union(matrixNum-matrixSize, matrixNum);
        //check bottom
        if(row == matrixSize-1)
            matrixConnect.union(matrixNum, matrixSize*matrixSize+1);
        else if ((matrixVal[row+1][col] ==1))
            matrixConnect.union(matrixNum+matrixSize, matrixNum);
        //check left
        if (col != 0 && (matrixVal[row][col-1] ==1))
            matrixConnect.union(matrixNum-1, matrixNum);
        //check right
        if (col != matrixSize-1 && (matrixVal[row][col+1] ==1))
            matrixConnect.union(matrixNum+1, matrixNum);

    }
    public boolean isOpen(int row, int col) {
        // is the site (row, col) open?
        if (row< 0||row>=matrixSize||col<0||col >=matrixSize){
            throw new IndexOutOfBoundsException();
        }
        return matrixVal[row][col] ==1;
    }
    public boolean isFull(int row, int col) {
        // is the site (row, col) full?
        if (row< 0||row>=matrixSize||col<0||col >=matrixSize){
            throw new IndexOutOfBoundsException();
        }
        return matrixConnect.connected(row*matrixSize+col, matrixSize*matrixSize);
    }
    public int numberOfOpenSites() {
        // number of open sites
        return openCount;
    }
    public boolean percolates() {
        // does the system percolate?
        return matrixConnect.connected(matrixSize*matrixSize, matrixSize*matrixSize+1);
    }

    public static void main(String[] args) {
        // unit testing (suggested)
    }
}