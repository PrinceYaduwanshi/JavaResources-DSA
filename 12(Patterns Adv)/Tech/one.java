class one{
    public static void main(String[] args) {
        int n = 4 ; int s=3;
        for(int i= -(n) ; i<=n ; i++){
            if( i !=0){
                for(int j =1 ; j<= n-Math.abs(i)+1 ; j++){
                    System.out.print(s+n-Math.abs(i));
                }
                System.out.println();
            }
        }
    }
}