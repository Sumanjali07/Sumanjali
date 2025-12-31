import java.util.Scanner;

public class search {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            swap(arr, smallest, i);
        }
    }

    static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void quick(int[] nums, int low, int hi) {
        if (low >= hi) {
            return;
        }

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }

            while (nums[e] > pivot) {
                e--;
            }

            if (s <= e) {
                swap(nums, s, e);
                s++;
                e--;
            }
        }

        quick(nums, low, e);
        quick(nums, s, hi);
    }

    static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s, j = m, k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k++] = arr[i++];
            } else {
                mix[k++] = arr[j++];
            }
        }

        while (i < m) {
            mix[k++] = arr[i++];
        }

        while (j < e) {
            mix[k++] = arr[j++];
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        System.out.println("Choose Search Method:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int searchChoice = sc.nextInt();

        switch (searchChoice) {

            case 1:
                int ls = linearSearch(arr, key);
                if (ls == -1)
                    System.out.println("Element not found");
                else
                    System.out.println("Element found at index " + ls);
                break;

            case 2:
                System.out.println("Choose Sorting Method:");
                System.out.println("1. Bubble Sort");
                System.out.println("2. Selection Sort");
                System.out.println("3. Insertion Sort");
                System.out.println("4. Quick Sort");
                System.out.println("5. Merge Sort");

                int sortChoice = sc.nextInt();

                switch (sortChoice) {
                    case 1:
                        bubbleSort(arr);
                        break;
                    case 2:
                        selectionSort(arr);
                        break;
                    case 3:
                        insertion(arr);
                        break;
                    case 4:
                        quick(arr, 0, arr.length - 1);
                        break;
                    case 5:
                        mergeInPlace(arr, 0, arr.length / 2, arr.length);
                        break;
                    default:
                        System.out.println("Invalid sorting choice");
                        return;
                }

                int bs = binarySearch(arr, key);
                if (bs == -1)
                    System.out.println("Element not found");
                else
                    System.out.println("Element found at index " + bs);
                break;

            default:
                System.out.println("Invalid search choice");
        }
    }
}
