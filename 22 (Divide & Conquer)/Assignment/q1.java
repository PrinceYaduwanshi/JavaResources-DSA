public class q1 {
    
    public static void mergeSort(String arr[] , int startIdx , int endIdx){
        if(startIdx >= endIdx){
            return;
        }
        int midIdx = startIdx + (endIdx - startIdx)/2;
        mergeSort(arr, startIdx, midIdx);
        mergeSort(arr, midIdx+1, endIdx);

        mergeArr(arr , startIdx , midIdx , endIdx);
    }

    public static void mergeArr(String arr[] , int startIdx , int midIdx , int endIdx){
        String tempArr[] = new String[endIdx - startIdx +1];
        int i = startIdx;//iterator for left part
        int j = midIdx+1;//iterator for righnt part
        int k=0;//iterator for temp arr
        while( i <=midIdx && j<=endIdx ){
            if(isAlphabticallySmalller(arr[i] , arr[j])){
                tempArr[k] = arr[i];
                i++;
            }else{
                tempArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while( i <= midIdx){
            tempArr[k++] = arr[i++];
        }

        while( j <= endIdx){
            tempArr[k++] = arr[j++];
        }

        for(k=0 ,i=startIdx ; k<tempArr.length ; k++,i++){
            arr[i] = tempArr[k];
        }
    }

    public static boolean isAlphabticallySmalller(String str1 , String str2){
        return str1.compareTo(str2) < 0;
    }

    public static void printArr(String arr[]){
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        String arr[] = { "sun", "earth", "mars", "mercury"};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
