import java.util.*;

public class generateBinaryStrings {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public static void backtrack(List<String> res, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            backtrack(res, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        if (close < open) {
            sb.append(')');
            backtrack(res, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        return;
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
