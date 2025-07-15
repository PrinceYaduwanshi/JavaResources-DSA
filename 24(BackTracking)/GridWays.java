public class GridWays {

    public static int gridWays(int row , int col , int n , int m){
        if( row==n-1 && col==m-1 ){
            return 1;
        }else if( row==n || col==m){
            return 0;
        }
        int way1 = gridWays(row+1, col, n, m);
        int way2 = gridWays(row, col+1, n, m);
        return way1 + way2;
    }

    public static void main(String[] args) {
        int n=4,m=5;
        System.out.println(gridWays(0, 0, n, m));
    }
}
