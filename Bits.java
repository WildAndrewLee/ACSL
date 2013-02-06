public class Bits {
	public static void main(String[] args){
		String[] input = {"*0, 2, 00, 10", "*01, 2, 111, 101", "**1, 3, 001, 101, 000", "0*0, 2, 010, 001", "**, 2, 01, 00"};
		
		for(int n = 0; n < input.length; n++){
			String[] vals = input[n].split("\\s*,\\s*");
			String template = vals[0].replaceAll("\\*", "[01]");
			boolean match = false;
			
			for(int k = 2; k < vals.length; k++){				
				if(vals[k].matches(template)){
					match = true;
					System.out.print(vals[k] + " ");
				}
			}
			
			if(!match) System.out.println("NONE");
			System.out.println();
		}
	}
}