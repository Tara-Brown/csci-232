/******************************************************************************
 *  Name:  Tara Brown
 *
 *  Hours to complete assignment (optional): 1/2 hour
 *
 ******************************************************************************/

Programming Assignment 8: Hash Tables

***For a = 1/2

Average probes for a miss with N=1000 is: 2.6053
Average probes for a miss with N=10000 is: 2.4989
Average probes for a miss with N=100000 is: 2.5219
Average probes for a miss with N=1000000 is: 2.4741

The average number of probes needed in a half full array, regardless of size is around 2.5. Proposition M states an average time of
1/2(1+ (1/(1-a)^2) where a is the percent of the array that is filled. For a = 1/2, that number is 2.5.

***For a = 2/3

Average probes for a miss with N=1000 is: 4.5968
Average probes for a miss with N=10000 is: 4.886
Average probes for a miss with N=100000 is: 4.9751
Average probes for a miss with N=1000000 is: 5.0265

For a = 2/3, proposition M gives an average of 5, similar to the experimental results.

***For a = 4/5

Average probes for a miss with N=1000 is: 14.3781
Average probes for a miss with N=10000 is: 14.0816
Average probes for a miss with N=100000 is: 12.9326
Average probes for a miss with N=1000000 is: 13.0431

for a = 4/5, Proposition M gives an average of 13, which is slightly lower than the experimental results, likely due to higher
variability at this proportion.

These results validate Proposition M by providing validating evidence (the averages are very similar).