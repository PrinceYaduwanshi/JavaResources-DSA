public class backTrackArray {

    public static void trackArray(int arr[] , int i , int value){
        //BASE CASE
        if(i == arr.length){
            printArr(arr);
            return;
        }
        //RECURSION 
        arr[i]= value;
        trackArray(arr, i+1, value+1);
        arr[i] = arr[i] - 2 ;

    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = new int[5];
        trackArray(arr, 0, 1);
        printArr(arr);
    }
}