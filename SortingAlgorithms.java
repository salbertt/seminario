/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.util.Scanner;

/**
 *
 * @author sof
 */
public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        selectionSort​(arr); 
        insertionSort​(arr); 
        bubbleSort​(arr);  
        quickSort​(arr, 0, n-1); 
        mergeSort​(arr, 0, n-1); 

        System.out.println("\nThe sorted array : ;");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void bubbleSort(int[] arr) {
         int len = arr.length, tmp;
        boolean flag;
        for (int i = 0; i < len; i++) {
            flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    
}

    private static void selectionSort(int[] arr) {
               int len = arr.length, pos, tmp;
        for (int i = 0; i < len; i++) {
            pos = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[pos])
                    pos = j;
            }
            tmp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = tmp;
        }
    }

    private static void insertionSort(int[] arr) {
int len = arr.length, tmp, j;
        for (int i = 1; i < len; i++) {
            tmp = arr[i];
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > tmp)
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = tmp;
    }
    }

    private static void quickSort(int[] arr, int lower, int upper) {
        if (lower >= upper)
            return;
        int p = partition(arr, lower, upper);
        quickSort(arr, lower, p - 1);
        quickSort(arr, p + 1, upper);
    }

    /**
     * @param arr   The array of elements
     * @param lower The lower index of the elements
     * @param upper The upper index of the elements
     * @return The index of the pivot element
     */
    private static int partition(int arr[], int lower, int upper) {
        int pivot = arr[upper];
        int j = lower;
        int tmp;
        for (int i = lower; i <= upper; i++) {
            if (arr[i] < pivot) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }
        tmp = arr[upper];
        arr[upper] = arr[j];
        arr[j] = tmp;

        return j;
    }

    private static void mergeSort(int[] arr,int lower, int upper) {
        if (lower >= upper)
            return;
        int m = (lower + upper) / 2;
        mergeSort(arr, lower, m);
        mergeSort(arr, m + 1, upper);
        merge(arr, lower, upper);
    }

    private static void merge(int arr[], int lower, int upper) {
        int m = (lower + upper) / 2;
        int a[] = new int[m - lower + 1];
        int b[] = new int[upper - m];
        int i, k = 0, k1 = 0, k2 = 0;
        for (i = lower; i <= m; i++, k++)
            a[k] = arr[i];
        k = 0;
        for (; i <= upper; i++, k++)
            b[k] = arr[i];
        for (i = lower; i <= upper && k1 < m - lower + 1 && k2 < upper - m; i++) {
            if (a[k1] < b[k2]) {
                arr[i] = a[k1];
                k1++;
            } else {
                arr[i] = b[k2];
                k2++;
            }
        }
        for (; k1 < m - lower + 1; k1++)
            arr[i++] = a[k1];
        for (; k2 < upper - m; k2++)
            arr[i++] = b[k2];
    }
}
