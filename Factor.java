import java.util.Arrays;

public class Factor {
	public static void main(String[] args){
		String[] input = {"72", "108", "5", "16", "24", "89", "51"};
		
		for(int n = 0; n < input.length; n++){
			int num = Integer.parseInt(input[n]);
			
			System.out.println(num);
			
			boolean done = false;
			java.util.ArrayList<Integer> numbers = new java.util.ArrayList<Integer>();
			String thing = "";
			
			while(!done){
				int div = 1;
				
				for(int k = div; k <= num / 2; k++){
					if(num % k == 0){
						div = k;
					}
				}
				
				if(div != 1){
					numbers.add(0, num / div);
					num = div;
					
					thing = num + " x ";
					
					for(int k = 0; k < numbers.size(); k++){
						thing += numbers.get(k);
						
						if(k + 1 < numbers.size()){
							thing += " x ";
						}
					}
					
					System.out.println(thing);
				}
				else{
					done = true;
				}
			}
			
			String[] vals = thing.split(" x ");
			Arrays.sort(vals);
			String fin = "";
			
			for(int k = 0; k < vals.length; k++){
				int ind = k, occ = 1;
				
				while(ind + 1 < vals.length && vals[ind].equals(vals[ind + 1])){
					occ++;
					ind++;
				}
				
				if(occ > 1){
					fin = vals[k] + " ^ " + occ + fin;
				}
				else{
					fin = vals[k] + fin;
				}
				
				if(ind + 1 < vals.length){
					fin = " x " + fin;
				}
				
				k = ind;
			}
			
			System.out.println(fin);
			System.out.println();
		}
	}
}