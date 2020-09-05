package akki.algos.searching;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result1 = recursiveBinarySearch(arr, 0, n-1, x);
        int result2 = iterativeBinarySearch(arr, x);

        System.out.println(result1);
        System.out.println(result2);
    }

    public static int recursiveBinarySearch(int[] arr, int l, int r, int num) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - 1) / 2;
        if (arr[mid] == num) {
            return mid;
        }
        if (arr[mid] > num) {
            return recursiveBinarySearch(arr, l, mid - 1, num);
        } else {
            return recursiveBinarySearch(arr, mid + 1, r, num);
        }
    }

    public static int iterativeBinarySearch(int[] arr, int num) {
        int l = 0, r = arr.length-1;
        while (l < r) {
            int mid = l + (r - 1) / 2;
            if (arr[mid] == num) {
                return mid;
            }

            if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
