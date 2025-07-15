public class rotatedSearch {
    
    public static int rotatedSearch(int arr[] , int target , int startIdx , int endIdx){
        
        if(startIdx > endIdx){
            return -1;
        }
        
        int midIdx = startIdx + (endIdx - startIdx)/2;
        
        // found at mid only
        if(arr[midIdx] == target){
            return midIdx;
        }
        
        // mid lie on Line1
        if(arr[startIdx] <= arr[midIdx]){
            // case a : left of line1
            if(arr[startIdx] <= target && target <= arr[midIdx]){
                return rotatedSearch(arr, target, startIdx, midIdx-1);

            }else{
                // case b : right of mid on line1
                return rotatedSearch(arr, target, midIdx+1, endIdx);
            }
        }else{ //mid lie on line2
            // case c : right of line2
            if(arr[midIdx] <= target && target <= arr[endIdx]){
                return rotatedSearch(arr, target, midIdx+1, endIdx);
            }else{
                // case d : left of mid on line2
                return rotatedSearch(arr, target, startIdx, midIdx-1);
            }
        }

    }
    public static void main(String[] args) {
         int arr[] = {4, 5, 6, 7, 0, 1, 2};  //target 0
         int targetIdx = rotatedSearch(arr, 0, 0, arr.length-1);  //output 4
        System.out.println(targetIdx);
        }
}
