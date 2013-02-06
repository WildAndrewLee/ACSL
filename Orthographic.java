public class Orthographic {
	public static void main(String[] args){
		String[] input = {"F888 1200 1000 1020"};
		
		for(int n = 0; n < input.length; n++){
			//Split input set up cube.
			String[] layers = input[n].split(" ");
			String[][][] cube = new String[4][4][4];
			
			//Fill cube.
			for(int k = 0; k < layers.length; k++){
				for(int q = 0; q < layers[k].length(); q++){
					int hex = Integer.parseInt(layers[k].charAt(q) + "", 16);
					String binary = String.format("%04d", Integer.parseInt(Integer.toBinaryString(hex)));
					
					for(int g = 0; g < binary.length(); g++){
						cube[k][q][g] = binary.charAt(g) + "";
					}
					//End of row
				}
				
				//End of layer
			}
			
			for(int k = 0; k < cube.length; k++){
				for(int q = 0; q < cube[k].length; q++){
					for(int g = 0; g < cube[k][q].length; g++){
						System.out.print(cube[k][q][g]);
					}
					
					System.out.println();
				}
				
				System.out.println();
			}
			
			System.out.println("________________________");
			
			//4x4 array to represent visible side.
			String[][] side = new String[4][4];
			
			for(int q = 0; q < 4; q++){
				for(int g = 0; g < 4; g++){
					side[q][g] = "C";
				}
			}
			
			//Loop through every small cube.
			for(int y = 0; y < 4; y++){ //for each layer
				for(int z = 0; z < 4; z++){ //for each row
					for(int x = 0; x < 4; x++){ //for each column
						if(cube[y][z][x].equals("1") && side[y][x].equals("C")){
							side[y][x] = "X";
						}
					}
				}
			}
			
			//What's it look like from the side?
			for(int y = 3; y >= 0; y--){
				for(int x = 0; x < side[y].length; x++){
					System.out.print(side[y][x]);
				}
				
				System.out.println();
			}
			
			System.out.println("FRONT");
			
			//Rotate cube.
			System.out.println();
			
			//Reset side view.
			for(int q = 0; q < 4; q++){
				for(int g = 0; g < 4; g++){
					side[q][g] = "C";
				}
			}
			
			//Loop through every small cube.
			for(int y = 0; y < 4; y++){ //for each layer
				for(int x = 0; x < 4; x++){ //for each column
					for(int z = 0; z < 4; z++){ //for each row
						if(cube[y][z][x].equals("1") && side[y][z].equals("C")){
							side[y][z] = "X";
						}
					}
				}
			}
			
			//What's it look like from the side?
			for(int y = 3; y >= 0; y--){
				for(int x = 0; x < side[y].length; x++){
					System.out.print(side[y][x]);
				}
				
				System.out.println();
			}
			
			System.out.println("SIDE");
			
			//Rotate cube.
			System.out.println();
			
			//Reset side view.
			for(int q = 0; q < 4; q++){
				for(int g = 0; g < 4; g++){
					side[q][g] = "C";
				}
			}
			
			//Loop through every small cube.
			for(int z = 0; z < 4; z++){ //for each row
				for(int y = 0; y < 4; y++){ //for each layer
					for(int x = 0; x < 4; x++){ //for each column
						if(cube[z][y][x].equals("1") && side[y][x].equals("C")){
							side[y][x] = "X";
						}
					}
				}
			}
			
			//What's it look like from the side?
			for(int y = 3; y >= 0; y--){
				for(int x = 0; x < side[y].length; x++){
					System.out.print(side[y][x]);
				}
				
				System.out.println();
			}
			
			System.out.println("TOP");
		}
	}
}

//What's the cube look like from the front?
/*for(int k = 0; k < cube.length; k++){
	for(int q = 0; q < cube[k].length; q++){
		for(int g = 0; g < cube[k][q].length; g++){
			System.out.print(cube[k][q][g]);
		}
		
		System.out.println();
	}
	
	System.out.println();
}*/