# Finding of the longest stable subsequence

Programming tool:

Java JDK 8

Description and solution of the problem:

After reading the input data from the file, the program begins to go through all elements of the string, searching for all stable sequences. After each pass of the loop, we create an abstract segment of the sequence, consisting of all elements of the sequence with the absence of one element at the beginning of the string from the previous loop run. Then the while loop starts working, whose task is to find the maximum and minimum values (min_val, max_val) so that when subtracting the minimum value from the maximum value and comparing with the maxDiff value, we come to the conclusion at which element from the sequence we need to finish the while loop , remember the beginning of the stable sequence and its length. After finding a new stable sequence we have to check if it is longer than the previous one. If this is the case - we update the data of the longest stable subsequence and start the next course of the for loop. Finally, the program outputs the received data as follows:

firstelement_index lastelement_index subsequence_elements

Analysis:

Pessimistic time complexity of the algorithm - n ^ 2: from the conclusion that we have a for loop, which from the beginning of the array to the end goes through the entire array, and a inserted loop, which visits all elements of the array starting from the next element from the for loop. The worst case will be when the whole array will be a stable substring. Then at the first iteration of the for loop, the while loop will be executed n-1 times. At the second - n-2 and so on. Then the entire complexity of the algorithm method will be: W (n) = (n-1) + (n-2) + ... + 1 = (n-1) (n-1 + 1) / 2 =
= (n ^ 2-n) / 2 = O (n ^ 2).
Memory complexity - O (1), because we don't need any additional arrays during the program, we only create additional variables, then the complexity is determined by a constant.
