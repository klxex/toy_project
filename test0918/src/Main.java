import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.*;
import java.io.InputStreamReader;


class Main {
    public static void main(String args[]) throws Exception {
        int a[] = {3, 5, 1, 2, 6, 8, 0};
        long start = System.nanoTime();
         quickSort(a,0,a.length-1);
        long end = System.nanoTime();

        for (int t : a) {
            System.out.println(t);
        }

        System.out.println(end - start);
    }

    public static void selectionSort(int a[]) {
        int len = a.length;

        for (int i = 0; i < len; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (a[index] > a[j]) {
                    index = j;
                }
            }
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    public static int[] mergeSort(int a[], int start, int end) {
        int len = end - start + 1;
        if(len==1){
            return new int[]{a[start]};
        }
        int mid = (start + end) / 2;

        int m1[] = mergeSort(a, start, mid);
        int m2[] = mergeSort(a, mid + 1, end);

        int merge[] = new int[len];

        int index = 0;
        int m1_index = 0;
        int m2_index = 0;

        while (index < len) {
            if (m2_index == m2.length) {
                merge[index++] = m1[m1_index++];
            } else if (m1_index == m1.length) {
                merge[index++] = m2[m2_index++];
            } else if (m1[m1_index] < m2[m2_index]) {
                merge[index++] = m1[m1_index++];
            } else if (m1[m1_index] > m2[m2_index]) {
                merge[index++] = m2[m2_index++];
            }

        }

        return merge;

    }

    public static void quickSort(int a[],int start,int end){
       if(end-start<1){
           return;
       }
       int pivot=start;
       int end1=end;
       int start1=start;

       start=start+1;
       while(start<=end){
           while(a[pivot]>a[start]){
               start++;
           }

           while(a[pivot]<=a[end]){
               end--;
           }
           if(start>end){
               int temp=a[pivot];
               a[pivot]=a[end];
               a[end]=temp;
               break;
           }
           int temp1=a[start];
           a[start]=a[end];
           a[end]=temp1;


       }

       quickSort(a,start1,end-1);
       quickSort(a,end+1,end1);
    }
}



