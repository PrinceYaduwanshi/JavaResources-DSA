
public class q2_brute_force{

    public static int majorityElement(int arr[]){
        int maxCount = arr.length/2;
        for(int i=0 ; i<arr.length ; i++){
            int count = 0 ;
            for(int j=0 ; j<arr.length ; j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count > maxCount){
                return arr[i];
            }
        }
        return -1;
    }

    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 2, 1, 1, 1, 2, 2, 2};
        printArr(arr);
        System.out.println(majorityElement(arr));
    }
}
