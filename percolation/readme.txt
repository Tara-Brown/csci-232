/******************************************************************************
 *  Name:  Tara Brown
 *
 *  Hours to complete assignment (optional): 3-4 hours
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates? This should be something like 3-5 sentences.
 *****************************************************************************/
WeightedQuickUnion was called with N*N+2 values, and an 2D N*N array was created.
To open a site, conversion was made (2d -> 1d) by multiplying the row by N, adding
the column number, and then calling the function. To find which unions should be called,
the array value was checked (1 means connection is open). The last two values in the array
corresponded with an imaginary topmost and bottommost node. When top or bottom values were
opened, they connected to these nodes and connected was called on these two values to check percolation.

/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to at most a few
 *  minutes. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be double the size of the preceding data point
 *****************************************************************************/

(keep T constant; n doubles)

 n          time (seconds)
------------------------------
50          .122
100         1.027
200         13.999
400         227.443


(keep n constant; T doubles)

 T          time (seconds)
------------------------------
50          .123
100         .212
200         .342
400         .633
800         1.209

/******************************************************************************
 *  Using the empirical data from the above two tables, give an estimate
 *  of the running time of PercolationStats.java as function of both n and 
 *  T, using asymptotic notation, like:
 *
 *       O( n^5.0 * T^1.5 )
 *
 *  Recall that with asymptotic notation, you are interested in the
 *  growth rate of run time as input sizes grow - you drop lower-order
 *  terms and constant factors. In class, we've discussed a way to 
 *  estimate polynomial factors from empirical run times.
 *
 *  How does this estimate compare to the theoretical run time growth
 *  rate, according to analysis of your code?
 *
 *****************************************************************************/
The estimated runtime is O( n^4.0 * T)
Since the amount of operations based on T increases linearly (one for loop of length T),
the runtime growth rate of T is as expected. While empirical performance was better than expected
for low numbers, optimization was likely at work, but the rough numbers still approach 1 as T increases
(the estimate was rounded from .88 to 1).

n corresponds to n^2 indices and quickFind takes N^2 time for the union operation, so the
theoretical run time is also around O(n^4), or O((n^2)^2), which corresponds to the estimate of O(n^4).
(estimate rounded from 4.02 to 4)


/******************************************************************************
 *  Repeat the previous three questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant; n doubles)

 n          time (seconds)
------------------------------
100         .152
200         .298
400         1.031
800         3.877
1600        22.05
3200        161.598

(keep n constant; T doubles)

 T          time (seconds)
------------------------------
50        .188
100       .29
200       .518
400       .896
800       1.717


Run time estimate:
O(n^2.5*T)

The theoretical runtime for T remains the same for both weightedQuickUnion and QuickFind. Trials increase linearly,
and so does the run-time. Therefore, the theoretical and estimated runtimes match.

The estimated runtime for weighted quick union was a bit higher than theoretically expected. Since around half of the
squares need to be filled before the trial ends, it makes sense that the runtime would scale quadratically. The size
of the array is n^2, after all. Each union action takes log(n) time, which according to graphs we have been shown
should be a rather low increase to the runtime. However, this is the case for larger numbers than in my estimate. For
smaller numbers, log(n) has a larger effect on the total runtime, leading to an estimated O(n^2.5*T) and a theoretical
O(log(n)*n^2*T)






 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
isFull() fills nodes from the bottom up as well.



/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/




/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/

How to find isFull() with a constant number of calls when connecting the top node to a bottom node will fill nodes connected
only to the bottom node with water.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed (or hated) doing it.                                             
 *****************************************************************************/

