/******************************************************************************
 *  Name: Tara
 *
 *  Hours to complete assignment (optional): 3.5
 *
 ******************************************************************************/

Programming Assignment 2: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
The method acts like a typical binary search until the specified key is reached, with each iteration
halving the search area. When a matching key is found, the program checks whether or not it is the first key.
if it is not, the next iteration checks the midpoint of the original low and mid-1. If it does not equal the key,
the program sets low as mid+1, and so on until the search finds the correct index.



/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?  (Big-Oh notation)
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: O(nlogn)

allMatches(): O(log n +mlogm)

numberOfMatches(): O(logn)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
    My initial (regular) binary search was copied from https://www.baeldung.com/java-binary-search and then modified.

/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/





/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/


