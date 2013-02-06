public class DNA {
	public static void main(String[] args){
		String[] input = {
			"ACT, AT", "AT, CG", "ATG, TG", "ATGC, ATGC", "ATG, TGC", "ATG, TGA", "AGCT, TGAC", "ATGC, TGTG", "ATGC, TGGC", "ATGC, AGTA"
			
		};
		
		for(int n = 0; n < input.length; n++){
			System.out.print(n+1+".\n");
			String first = input[n].split("\\s?,\\s?")[0];
			String second = input[n].split("\\s?,\\s?")[1];
			
			int[][] matrix = new int[second.length() + 1][first.length() + 1];
			
			for(int i = 1; i < matrix.length; i++)
				matrix[i][0] = i * -2;	
			
			for(int i = 1; i < matrix[0].length; i++)
				matrix[0][i] = i * -2;
			
			for(int row = 1; row < matrix.length; row++)
			{
				for(int col = 1; col < matrix[row].length; col++)
				{
					int match = 0; 
					if((second.charAt(row-1) + "").equals(first.charAt(col-1) + ""))
						match = 2;
					else
						match = -1;		
					int num1 = matrix[row-1][col-1] + match;
					int num2 = matrix[row][col-1] - 2;
					int num3 = matrix[row-1][col] - 2;
					int largest = num1;
					if(num2 > largest)
						largest = num2;
					if(num3 > largest)
						largest = num3;
					matrix[row][col] = largest;
				}
			}
			
			align(matrix, second, first, matrix.length - 1, matrix[0].length - 1, "", "");
		}
	}
	
	static void align(int[][] matrix, String first, String second, int x, int y, String fs, String ss){		
		int top = matrix[x][y];
		
		if(x >= 1 && y >= 1){
			if(first.charAt(x - 1) == second.charAt(y - 1)){
				if(matrix[x - 1][y - 1] + 2 == top){
					align(matrix, first, second, x - 1, y - 1, first.charAt(x - 1) + fs, second.charAt(y - 1) + ss);
				}
				if(matrix[x - 1][y] - 2 == top){
					align(matrix, first, second, x - 1, y, first.charAt(x - 1) + fs, "-" + ss);
				}
				if(matrix[x][y - 1] - 2 == top){
					align(matrix, first, second, x - 1, y, "-" + fs, second.charAt(y - 1) + ss);
				}
			}
			else{
				if(matrix[x - 1][y - 1] - 1 == top){
					align(matrix, first, second, x - 1, y - 1, first.charAt(x - 1) + fs, second.charAt(y - 1) + ss);
				}
				if(matrix[x - 1][y] - 2 == top){
					align(matrix, first, second, x - 1, y, first.charAt(x - 1) + fs, "-" + ss);
				}
				if(matrix[x][y - 1] - 2 == top){
					align(matrix, first, second, x, y - 1, "-" + fs, second.charAt(y - 1) + ss);
				}
			}
		}
		else if(x >= 1){
			if(first.charAt(x - 1) == second.charAt(y)){
				if(matrix[x - 1][y] - 2 == top){
					align(matrix, first, second, x - 1, y, first.charAt(x - 1) + fs, "-" + ss);
				}
			}
			else{
				if(matrix[x - 1][y] - 2 == top){
					align(matrix, first, second, x - 1, y, first.charAt(x - 1) + fs, "-" + ss);
				}
			}
		}
		else if(y >= 1){
			if(first.charAt(x) == second.charAt(y - 1)){
				if(matrix[x][y - 1] - 2 == top){
					align(matrix, first, second, x, y - 1, "-" + fs, second.charAt(y - 1) + ss);
				}
			}
			else{
				if(matrix[x][y - 1] - 2 == top){
					align(matrix, first, second, x, y - 1, "-" + fs, second.charAt(y - 1) + ss);
				}
			}
		}
		
		if(x == 0 && y == 0){
			System.out.println(fs + " and " + ss);
		}
	}
}