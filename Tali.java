import java.util.ArrayList;
import java.util.Arrays;

public class Tali {
	public static void main(String[] args){
		String[] input = {
			//"1643 6663 6643 6631",
			//"6666 4366 3144 1111",
			//"3166 3366 4646 6646",
			//"1414 1134 1311 4366",
			//"1343 4144 1616 3131",
			"1166 3434 3333 3144",
			//"3133 1414 4444 3434",
			//"1441 6611 4141 1144",
			//"4666 6466 6643 6664",
			//"1414 3133 4411 1333"

		};
		
		String[] score = {
			"1346",
			"6666",
			"6664",
			"6663",
			"6644",
			"6661",
			"6643",
			"6633",
			"6641",
			"6631"
		};
		
		for(int n = 0; n < input.length; n++){
			String[] numbers = input[n].split("(\\s?,\\s?)|(\\s)");
			String[] numbers2 = numbers.clone();
			ArrayList<Integer> scored = new ArrayList<Integer>();
			ArrayList<Integer> unscored = new ArrayList<Integer>();
			
			for(int k = 0; k < numbers.length; k++){
				String[] split = numbers[k].split("");
				Arrays.sort(split);
				numbers[k] = "";
				
				for(int g = split.length - 1; g >= 0; g--){
					numbers[k] += split[g];
				}
				
				if(new StringBuilder(numbers[k]).reverse().toString().equals(score[0])){
					numbers[k] = "1";
					scored.add(1);
				}
				else{
					boolean yes = false;
					
					for(int q = 1; q < score.length; q++){
						if(numbers[k].equals(score[q])){
							numbers[k] = q + 1 + "";
							scored.add(q + 1);
							yes = true;
						}
					}
					
					if(!yes){
						int tot = 0;
						
						for(int q = 0; q < numbers[k].length(); q++){
							tot += Integer.parseInt(numbers[k].charAt(q) + "");
						}
						
						numbers[k] = tot + "";
						unscored.add(tot);
					}
				}
			}
			
			int[] fscored = new int[scored.size()];

			for(int k = 0; k < fscored.length; k++){
				fscored[k] = scored.get(k);
			}
			
			int[] funscored = new int[unscored.size()];

			for(int k = 0; k < funscored.length; k++){
				funscored[k] = unscored.get(k);
			}
			
			Arrays.sort(fscored);
			Arrays.sort(funscored);
			
			String rank = "ABCD", output = "";
			int x = 0, y = funscored.length - 1;
			
			for(int k = 0; k < rank.length(); k++){
				inner: for(int g = 0; g < numbers.length; g++){
					if(x < fscored.length){
						if(numbers[g].equals(fscored[x] + "") && x + 1 < fscored.length && !numbers[g].equals(fscored[x + 1])){
							output += rank.charAt(g) + "";
							x++;
							break inner;
						}
						else if(x + 1 < fscored.length && numbers[g].equals(fscored[x + 1])){
							int highest = 0;
							
							for(int q = 0; q < numbers2.length; q++){
								int tot = 0;
								
								for(int a = 0; a < numbers2[q].length(); a++){
									tot += Integer.parseInt("" + numbers2[q].charAt(a));
								}
								
								if(numbers[g].equals(tot + "")){
									if(Integer.parseInt(numbers2[q]) > Integer.parseInt(numbers2[highest])){
										highest = q;
									}
								}
							}
							
							output += rank.charAt(highest) + "";
							numbers2[highest] = "0";
							x++;
							break inner;
						}
					}
					else if(y >= 0){						
						if(Integer.parseInt(numbers[g]) == funscored[y] && y - 1 >= 0 && Integer.parseInt(numbers[g]) != funscored[y - 1]){							
							output += rank.charAt(g) + "";
							y--;
							break inner;
						}
						else if(y - 1 >= 0 && Integer.parseInt(numbers[g]) == funscored[y - 1]){
							int highest = 0;
							
							for(int q = 0; q < numbers2.length; q++){
								int tot = 0;
								
								for(int a = 0; a < numbers2[q].length(); a++){
									tot += Integer.parseInt("" + numbers2[q].charAt(a));
								}
								
								if(numbers[g].equals(tot + "")){
									if(Integer.parseInt(numbers2[q]) > Integer.parseInt(numbers2[highest])){
										highest = q;
									}
								}
							}
							
							output += rank.charAt(highest) + "";
							numbers2[highest] = "0";
							y--;
							break inner;
						}
						else{
							output += rank.charAt(g) + "";
							break inner;
						}
					}
				}
			}
			
			System.out.println(n + 1 + ". " + output);
		}
	}
}