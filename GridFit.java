//Hi ;)

public class GridFit{	
	public static void main(String[] args){
		boolean[][] grid = new boolean[5][5];
		
		String[] input = {
			"8, 1, 3, 5, 6, 7, 8, 10, 13",
			"1",
			"2",
			"3",
			"4",
			"5"
		};
		
		String[] filled = input[0].split("\\s*,\\s*");
		
		for(int n = 1; n < filled.length; n++){
			int index = Integer.parseInt(filled[n]) - 1;
			int row = index / 5;
			int col = index % 5;
			
			grid[row][col] = true;
		}
		
		loop: for(int n = 1; n < input.length; n++){
			for(int g = 0; g < grid.length; g++){
				for(int k = 0; k < grid[g].length; k++){
					if(grid[g][k] == false){
						switch(Integer.parseInt(input[n])){
						case 1:
							grid[g][k] = true;
							
							System.out.println(n + ". " + (g * 5 + k + 1));
							continue loop;
							
						case 2:
							if(g + 1 < grid.length && grid[g + 1][k] == false){
								grid[g][k] = grid[g + 1][k] = true;
								
								System.out.println(n + ". " + (g * 5 + k + 1));
								continue loop;
							}
							break;
							
						case 3:
							if(k + 1 < grid[g].length && grid[g][k + 1] == false){
								grid[g][k] = grid[g][k + 1] = true;
								
								System.out.println(n + ". " + (g * 5 + k + 1));
								continue loop;
							}
							break;
							
						case 4:
							if(g + 1 < grid.length && k + 1 < grid[g].length && grid[g + 1][k] == false && grid[g + 1][k + 1] == false){
								grid[g][k] = grid[g + 1][k] = grid[g + 1][k + 1] = true;
								
								System.out.println(n + ". " + (g * 5 + k + 1));
								continue loop;
							}
							break;
							
						case 5:
							if(g + 1 < grid.length && k + 1 < grid[g].length && grid[g + 1][k] == false && grid[g][k + 1] == false){
								grid[g][k] = grid[g + 1][k] = grid[g][k + 1] = true;
								
								System.out.println(n + ". " + (g * 5 + k + 1));
								continue loop;
							}
							break;
						}
					}
				}
			}
			
			System.out.println(n + ". No Match");
		}
	}
}