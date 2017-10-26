package com.akki.dynamic.programming;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Akhilesh.Agarwal
 *
 */
/**
 * @author Akhilesh.Agarwal
 *
 */
/**
 * @author Akhilesh.Agarwal
 *
 */
/**
 * @author Akhilesh.Agarwal
 *
 */
/**
 * @author Akhilesh.Agarwal
 *
 */
/**
 * @author Akhilesh.Agarwal
 *
 */
class LIS {
	/*
	 * lis() returns the length of the longest increasing subsequence in arr[]
	 * of size n
	 */
	static int lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 0; i < n; i++)
			for (j = i + 1; j < n; j++)
				if (arr[j] > arr[i] && lis[j] < lis[i] + 1)
					lis[j] = lis[i] + 1;

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}

	static int construct_lis(int arr[], int n) {
		Set<Integer> lis[] = new TreeSet[n];
		int i, j, max = 0;
		Set<Integer> lisSet = null;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++) {
			lis[i] = new TreeSet<>();
			lis[i].add(arr[i]);
		}

		/* Compute optimized LIS values in bottom up manner */
		for (i = 0; i < n; i++) {
			for (j = i + 1; j < n; j++) {
				if (arr[j] > arr[i] && lis[j].size() < lis[i].size() + 1) {
					lis[j].addAll(lis[i]);
				}
			}
		}
		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++) {
			if (max < lis[i].size()) {
				lisSet = lis[i];
				max = lis[i].size();
			}
		}

		lisSet.stream().forEach(System.out::println);
		return max;
	}
	
	
	//
	 // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    
    /**
     * LCS with nlogn complexity
     * @param A
     * @param size
     * @return
     */
    static int longestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 28,30,32,1 };
		int n = arr.length;
		System.out.println("Length of lis is " + longestIncreasingSubsequenceLength(arr, n) + "n");
	}
}