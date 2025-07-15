public class quickSort {

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[] , int startIdx , int endIdx){
        if(startIdx >= endIdx){
            return;
        }
        // for last element
        int pivot_idx = partition(arr , startIdx , endIdx);
        quickSort(arr, startIdx, pivot_idx-1);
        quickSort(arr, pivot_idx+1, endIdx);
    }

    public static int partition(int arr[] , int startIdx , int endIdx){
        int pivot_element = arr[endIdx];
        int i = startIdx-1;//to make space for elemnts less than pivot

        for(int j=startIdx ; j<endIdx ; j++){
            if(arr[j] <= pivot_element){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = pivot_element;
        arr[endIdx] = arr[i];
        arr[i] = temp;
        return i;
        
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

    }
}
