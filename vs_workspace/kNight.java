import java.util.*;

public class kNight {

    public static boolean isKvalid(int[][] arr ,int col ,int row){
        if(row<0||row>=arr.length||col<0||col>=arr.length){
            return false;
        }else if(arr[row][col]!=-1){
            return false;
        }else{
            return true;
        }
    }


    public static void KnightsTour(int[][] arr,  int row, int col ,int counter){

        if(counter==arr.length*arr.length-1){

            arr[row][col]=counter;
            for(int i=0;i<arr.length;++i){
                for(int j=0;j<arr.length;++j){
                    System.out.print(arr[row][col]+" ");
                }
                System.out.println();
            }
            System.out.println();
            arr[row][col]=-1;
            return;
        }

        arr[row][col]=counter;

        if(isKvalid(arr, row-2, col+1)) {
			KnightsTour(arr, row-2, col+1, counter+1);
		}
		if(isKvalid(arr, row-2, col-1)) {
			KnightsTour(arr, row-2, col-1, counter+1);
		}
		if(isKvalid(arr, row+2, col+1)) {
			KnightsTour(arr, row+2, col+1, counter+1);
		}
		if(isKvalid(arr, row+2, col-1)) {
			KnightsTour(arr, row+2, col-1, counter+1);
		}
		if(isKvalid(arr, row+1, col-2)) {
			KnightsTour(arr, row+1, col-2, counter+1);
		}
		if(isKvalid(arr, row+1, col+2)) {
			KnightsTour(arr, row+1, col+2, counter+1);
		}
		if(isKvalid(arr, row-1, col-2)) {
			KnightsTour(arr, row-1, col-2, counter+1);
		}
		if(isKvalid(arr, row-1, col+2)) {
			KnightsTour(arr, row-1, col+2, counter+1);
		}

        arr[row][col]=-1;

    }



    public static void main(String[] args){

        int[][] arr = new int[5][5];

        for(int i=0;i<arr.length;++i)
        Arrays.fill(arr[i], -1);


        KnightsTour(arr, 0, 0, 0);

    }
}
