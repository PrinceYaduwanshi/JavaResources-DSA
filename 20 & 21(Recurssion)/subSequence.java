import java.util.*;
class subSequence{

    // TC: O(2^n * n)
    public static void generate(int idx, int arr[], ArrayList<Integer> seq){
        if(idx >= arr.length){
            System.out.println(seq);
            return;
        }

        seq.add(arr[idx]);
        generate(idx+1, arr, seq);

        seq.remove(seq.size()-1);
        generate(idx+1, arr, seq);
    }

    public static void main(String[] args) {
        int arr[]= {3, 1, 2};
        generate(0, arr, new ArrayList<>());
    }
}