import java.util.ArrayList;
import java.util.List;

public class binaryStrings {
    
    public static void printStrings(int n, int lastPlace , String str){

        if(n == 0){
            System.out.println(str);
            return;
        }

        printStrings(n-1, 0, str+"0");
        if(lastPlace == 0){
            printStrings(n-1, 1, str+"1");
        }

        // if(lastPlace == 0){
        //     printStrings(n-1, 0 , str.append("0"));
        //     printStrings(n-1, 1 , str.append("1"));
        // }else{
        //     printStrings(n-1, 0, str.append("0"));
        // }
        
    }

    public static void generateStr(List<String> res,  int lastPlace, int n, String str){
        if( n == 0){
            res.add(str);
            return;
        }

        // generateStr(res, 1, n-1, str+"1");
        // if( lastPlace == 1){
        //     generateStr(res, 0, n-1, str+"0");
        // }
        
        if( lastPlace == 1 || str==""){
            generateStr(res, 0, n-1, str+"0");
        }
        generateStr(res, 1, n-1, str+"1");
        // if(lastPlace == 1){
        //     generateStr(1, n-1, str+="1");
        //     generateStr(0, n-1, str+="0");
        // }else if( lastPlace == 0){
        //     generateStr(1, n-1, str+="1");
        // }
    }
    
    public static void main(String[] args) {
        // printStrings(5, 0, "");
        List<String> res = new ArrayList<>();
        generateStr(res, -1, 3, "");
        System.out.println(res);
    }
}
