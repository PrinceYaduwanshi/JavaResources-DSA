

public class q2_divide_conquer {

    public static int countMajority(int arr[] , int num , int startIdx , int endIdx){
        int count=0;
        for(int i=startIdx ; i<=endIdx ; i++){
            if(arr[i]==num){
                count++;
            }
        }
        return count;
    }

    public static int majorityElementRec(int arr[] , int startIdx , int endIdx){
        if(startIdx == endIdx){
            return arr[startIdx];
        }

        int midIdx = startIdx + (endIdx - startIdx)/2;
        int leftMajority = majorityElementRec(arr , startIdx , midIdx);
        // System.out.println("left majorty is"+leftMajority);
        int rightMajority = majorityElementRec(arr , midIdx + 1 , endIdx);
        // System.out.println("right majorty is"+rightMajority);

        if(leftMajority == rightMajority){
            return leftMajority;
        }

        int leftMajorityCount = countMajority(arr, leftMajority , startIdx, endIdx);
        int rightMajorityCount = countMajority(arr, rightMajority , startIdx , endIdx);

        return leftMajorityCount>rightMajorityCount ? leftMajority : rightMajority;
    }


    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 2, 1, 1, 1, 2, 2, 2};
        System.out.println(majorityElementRec(arr, 0, arr.length-1));
        printArr(arr);
    }
}
