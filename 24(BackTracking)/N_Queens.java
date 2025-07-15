public class N_Queens {

    public static void nQuuens(char chessBoard[][] , int row){
        if(row == chessBoard.length){
            count++;
            printBoard(chessBoard);
            return;
        }
        for (int col = 0; col < chessBoard.length; col++) {
            if(isSafe(chessBoard, row, col)){
                chessBoard[row][col] = 'Q'; //row
                nQuuens(chessBoard, row+1); // place (n-1) queens in (n-1) rows 
                chessBoard[row][col] = 'X'; //backtrack line queen removed from previous position
            }
                
        }
    }

    public static boolean oneSolNQuuens(char chessBoard[][] , int row){
        if(row == chessBoard.length){
            count++;
            // printBoard(chessBoard);
            return true;
        }
        for (int col = 0; col < chessBoard.length; col++) {
            if(isSafe(chessBoard, row, col)){
                chessBoard[row][col] = 'Q'; //row
                if(oneSolNQuuens(chessBoard, row+1)){
                    return true;
                } //check for one solution only
                chessBoard[row][col] = 'X'; //backtrack line queen removed from previous position
            }
                
        }
        return false;
    }

    public static boolean isSafe(char chessBoard[][] , int row , int col){
        //vertical up
        for(int i=row-1 ; i>=0 ; i--){
            if(chessBoard[i][col] == 'Q' ){ //check at that particular postion of board
                return false;
            }
        }

        //left diagonal up
        for(int i=row-1 , j=col-1 ; i>=0 &&  j>=0 ; i--,j--){
            if(chessBoard[i][j] == 'Q'){
                return false;
            }
        }

        // right diagonal up
        for(int i=row-1 , j=col+1 ; i>=0 && j<chessBoard.length ; i--,j++){
            if(chessBoard[i][j] =='Q'){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char chessBoard[][]){
        System.out.println("-------chess board-------");
        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard.length; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
    static int count=0;
    public static void main(String[] args) {
        int n=4;
        char chessBoard[][] = new char[n][n];
        //initialize
        for(int i=0 ; i<n ; i++){
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = 'X';
            }
        }
        nQuuens(chessBoard, 0);
        if(oneSolNQuuens(chessBoard, 0)){
            System.out.println("solution is possible");
        }else{
            System.err.println("Solution not possble");
        }
        System.out.println("No. of ways are:" + count);
    }
}
