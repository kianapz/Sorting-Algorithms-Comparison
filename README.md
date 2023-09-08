# Sorting Algorithm Comparison

This Java program compares various sorting algorithms using randomly generated arrays. The implemented sorting algorithms include:

1. Bubble Sort
2. Merge Sort
3. Quick Sort
4. Insertion Sort
5. Selection Sort
6. Heap Sort
7. Counting Sort
8. Radix Sort

## How to Run

1. Ensure you have Java installed on your system.
2. Open a terminal or command prompt.
3. Navigate to the directory containing the Java file (SortComparison.java).
4. Compile the Java file using the following command:

    ```bash
    javac SortComparison.java
    ```

5. Run the compiled Java file with the following command:

    ```bash
    java SortComparison
    ```

6. The program will execute and print the time taken by each sorting algorithm to the console.

## Customizing the Array

You can customize the size and range of the randomly generated array by modifying the code in the `main` method of the `SortComparison` class.

## Adding Additional Sorting Algorithms

If you want to add more sorting algorithms, you can do so by implementing the algorithm in the `SortComparison` class and adding a corresponding call in the `main` method.

## Conclusion

In this comparison, we've evaluated various sorting algorithms in terms of their performance on randomly generated arrays. Each algorithm has its strengths and weaknesses, making them suitable for different scenarios.

### Best, Worst, and Average Case Time Complexities:

1. **Bubble Sort:**
   - Best Case: O(n)
   - Worst Case: O(n^2)
   - Average Case: O(n^2)

2. **Merge Sort:**
   - Best Case: O(n log n)
   - Worst Case: O(n log n)
   - Average Case: O(n log n)

3. **Quick Sort:**
   - Best Case: O(n log n)
   - Worst Case: O(n^2) [However, with good pivot selection, it's effectively O(n log n)]
   - Average Case: O(n log n)

4. **Insertion Sort:**
   - Best Case: O(n)
   - Worst Case: O(n^2)
   - Average Case: O(n^2)

5. **Selection Sort:**
   - Best Case: O(n^2)
   - Worst Case: O(n^2)
   - Average Case: O(n^2)

6. **Heap Sort:**
   - Best Case: O(n log n)
   - Worst Case: O(n log n)
   - Average Case: O(n log n)

7. **Counting Sort:**
   - Best Case: O(n + k) [k is the range of input]
   - Worst Case: O(n + k)
   - Average Case: O(n + k)

8. **Radix Sort:**
   - Best Case: O(nk) [k is the number of digits]
   - Worst Case: O(nk)
   - Average Case: O(nk)

### Ranking:

Based on their performance characteristics, here's a **rough ranking** of the algorithms from most efficient to least efficient for general cases:

1. Merge Sort
2. Quick Sort
3. Heap Sort
4. Counting Sort (limited to a specific range of input)
5. Radix Sort (with small number of digits)
6. Insertion Sort (efficient for small datasets)
7. Bubble Sort (efficient for very small datasets)
8. Selection Sort (inefficient for large datasets)

Keep in mind that the efficiency of an algorithm can vary depending on the size and nature of the data being sorted. Therefore, it's important to consider the specific requirements of your application when choosing a sorting algorithm.
