package akki.algos.datastructure.arrays;

public class MaximumDiffrence 
{
    /* The function assumes that there are at least two
       elements in array.
       The function returns a negative value if the array is
       sorted in decreasing order.
       Returns 0 if elements are equal  */
    int maxDiff(int arr[], int arr_size) 
    {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        int i;
        for (i = 1; i < arr_size; i++) 
        {
        	int curr_diff= arr[i] - min_element;
            if (curr_diff > max_diff)
                max_diff = curr_diff;
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }
 
    /* Driver program to test above functions */
    public static void main(String[] args) 
    {
        MaximumDiffrence maxdif = new MaximumDiffrence();
        int arr[] = {2,0,1, 90, 10,111, 110};
        int size = arr.length;
        System.out.println("MaximumDifference is " + 
                                maxdif.maxDiff(arr, size));
    }
}