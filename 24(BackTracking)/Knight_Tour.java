
import java.util.*;

public class Knight_Tour {

    static int count= 0;
    static int drow[]= {-2, -1, 1, 2, 2, 1, -1, -2};
    static int dcol[]= {1, 2, 2, 1, -1, -2, -2, -1};

    public static void solveBoard(int board[][], int startRow, int startCol, int move, int n){
        
        if(move == (n*n)-1){
            count++;
            // board[startRow][startCol]= -1;
            return;
        }

        for(int i=0; i<8; i++){
            int row= startRow + drow[i];
            int col= startCol + dcol[i];
            if(isSafe(board, row, col, n)){
                board[startRow][startCol]= move+1;
                solveBoard(board, row, col, move+1, n);
                board[startRow][startCol]= -1;
            }
        }
    }

    public static void printBoard(int board[][]){
        System.out.println("--------------------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int board[][], int row, int col, int n){
        if( row < 0 || col < 0 || row >= n || col >= n || board[row][col] != -1){
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        
        int board[][]= new int[5][5];
        int n= board.length;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j]= -1;
            }
        }

        board[0][0]= 0; //starting point

        solveBoard(board, 0, 0, 0, board.length);
        System.out.println(count);//starting from (0, 0)


    }
}
