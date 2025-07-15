public class Flood_Fill {

    public static void floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor= image[sr][sc];
        if (orgColor == color) print(image); // Prevent infinite loop
        // boolean visited[][]= new boolean[image.length][image[0].length];
        fillPixels(image, sr, sc, color, orgColor);
        print(image);
    }

    public static void print(int[][] image){
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void fillPixels(int[][] image, int sr, int sc, int color,int orgColor){
        if(sr < 0 || sc < 0 || sr>=image.length || sc >= image[0].length || image[sr][sc] != orgColor){
            return; 
        }

        image[sr][sc]= color;

        //left
        fillPixels(image, sr, sc-1, color, orgColor);

        //right
        fillPixels(image, sr, sc+1, color, orgColor);

        //up
        fillPixels(image, sr-1, sc, color, orgColor);

        //down
        fillPixels(image, sr+1, sc, color, orgColor);
    }

    public static void main(String[] args) {
        int image[][]= {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        floodFill(image, sr, sc, color);
    }
}
