package cc;

public class rottenOranges {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 },
				{ 0, 1, 1 },
				{ 1, 0, 1 } };

//		System.out.println(orangesRotting(grid));
		
		System.out.println(brokenCalc(5, 15));
		
	}

	 public static int brokenCalc(int x, int y) {
	        
	        int rv=0;
	        if(x==y){
	            
	        }else if(x>y){
	            rv=x-y;
	        }else{
	            while(x<y){
	                x*=2;
	                ++rv;
	            }
	            rv+=x-y;
	        }        
	        return rv;
	    }
	
	public static int orangesRotting(int[][] grid) {
		int count = -1, pass = 0, jugad = 1;

		while (count != 0) {
			count = 0;
			++pass;
			++jugad;
			for (int i = 0; i < grid.length; ++i) {
				for (int j = 0; j < grid[0].length; ++j) {
					if (grid[i][j] == jugad) {
						grid[i][j] = 0;

						if (i + 1 < grid.length && grid[i + 1][j] == 1) {
							grid[i + 1][j] = jugad + 1;
							++count;
						}
						if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
							grid[i][j + 1] = jugad + 1;
							++count;
						}

						if (i - 1 >= 0 && grid[i - 1][j] == 1) {
							grid[i - 1][j] = jugad + 1;
							++count;
						}
						if (j - 1 >= 0 && grid[i][j - 1] == 1) {
							grid[i][j - 1] = jugad + 1;
							++count;
						}
					}
				}
			}
		}

		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return pass == 0 ? -1 : pass - 1;
	}
}
