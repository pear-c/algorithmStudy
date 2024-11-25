package CodingTest.Chap06;

import java.util.Arrays;

public class Chap06 {
    static void SelectSort(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    static void InsertSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else
                    break;
            }
        }
    }

    static void QuickSort(int[] arr, int start, int end){
        if(start >= end) return;
        // 피벗은 첫 번째 원소
        int pivot = start;
        int left = start+1;
        int right = end;

        while(left <= right) {
            // 피벗보다 큰 데이터 찾을 때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            // 피벗보다 작은 데이터를 찾을 때까지 반복
            while(right > start && arr[right] >= arr[pivot]) {
                right--;
            }
            // 엇갈렸으면 작은 데이터와 피벗을 교체
            if(left > right) {
                int temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            // 안 엇갈렸으면 작은 데이터와 큰 데이터 교체
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        QuickSort(arr, start, right-1);
        QuickSort(arr, right+1, end);
    }
    // 모든 원소의 값이 0보다 크거나 같다고 가정
    static void CountSort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();
        // 모든 범위 포함하는 배열 선언
        int[] temp = new int[max+1];

        for(int i=0; i<arr.length; i++){
            temp[arr[i]]++;
        }

        for(int i=0; i<temp.length; i++){
            if(temp[i] > 0){
                for(int j=0; j<temp[i]; j++)
                    System.out.print(i+" ");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        int[] arr2 = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
//        SelectSort(arr);
//        InsertSort(arr);
//        QuickSort(arr, 0, arr.length-1);
        CountSort(arr2);

//        for(int i : arr) System.out.print(i + " ");
    }
}
