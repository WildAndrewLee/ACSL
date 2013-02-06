import java.util.ArrayList;
import java.util.Stack;

public class BooleanExtended {
	public static void main(String[] args){
		String[] input = {
			"AB!",
			"ABC$",
			"AAA#",
			"CAAB$!",
			"ABB!CD&!",
			"ABC!ABC!#!",
			"ABB#ADD$!",
			"AAAAA%DD!!!",
			"ABC$ABD&!BCD#ABCD%$",
			"C"
		};
		
		for(int p = 0; p < input.length; p++){
			String postfix = input[p];
			int total = 0;

			ArrayList<String> combos = new ArrayList<String>();
			
			String vars = "";
			
			for(int n = 0; n < postfix.length(); n++){
				if((postfix.charAt(n) + "").matches("[ABCD]") && vars.indexOf(postfix.charAt(n)) == -1){
					vars += postfix.charAt(n);
				}
			}
			
			combos.add(vars);
			
			for(int n = 0; n < combos.size(); n++){
				for(int k = 0; k < combos.get(n).length(); k++){
					if(combos.get(n).indexOf('A') != -1){
						combos.add(combos.get(n).replaceFirst("A", "0"));
						combos.add(combos.get(n).replaceFirst("A", "1"));
						
						combos.remove(n);
						n = 0;
					}
					if(combos.get(n).indexOf('B') != -1){
						combos.add(combos.get(n).replaceFirst("B", "0"));
						combos.add(combos.get(n).replaceFirst("B", "1"));

						combos.remove(n);
						n = 0;
					}
					if(combos.get(n).indexOf('C') != -1){
						combos.add(combos.get(n).replaceFirst("C", "0"));
						combos.add(combos.get(n).replaceFirst("C", "1"));
						
						combos.remove(n);
						n = 0;
					}
					if(combos.get(n).indexOf('D') != -1){
						combos.add(combos.get(n).replaceFirst("D", "0"));
						combos.add(combos.get(n).replaceFirst("D", "1"));
						
						combos.remove(n);
						n = 0;
					}
				}
			}
			
			for(int n = 0; n < combos.size(); n++){
				total += eval(combos.get(n), postfix);
			}
			
			System.out.println(p + 1 + ". " + total);
		}
	}
	
	public static int eval(String string, String postfix){
		int index = 0;
		
		if(postfix.indexOf('A') != -1){
			postfix = postfix.replaceAll("A", string.charAt(index++) + "");
		}
		
		if(postfix.indexOf('B') != -1){
			postfix = postfix.replaceAll("B", string.charAt(index++) + "");
		}
		
		if(postfix.indexOf('C') != -1){
			postfix = postfix.replaceAll("C", string.charAt(index++) + "");
		}
		
		if(postfix.indexOf('D') != -1){
			postfix = postfix.replaceAll("D", string.charAt(index++) + "");
		}
		
		Stack<Integer> values = new Stack<Integer>();
		
		for (int n = 0; n < postfix.length(); n++) {
			try {
				int q = Integer.parseInt(postfix.charAt(n) + "");
				values.push(q);
			} catch (Exception ex) {
				char operator = postfix.charAt(n);

				switch (operator) {
				case '!':
					double first = values.pop();
					double second = values.pop();
					
					if(first == 0 && second == 0){
						values.push(1);
					}
					else if(first == 1 && second == 1){
						values.push(1);
					}
					else{
						values.push(0);
					}
					break;

				case '#':
					first = values.pop();
					second = values.pop();
					double third = values.pop();
					
					if(first == 0 && second == 1 && third == 1){
						values.push(1);
					}
					else if(first == 1 && second == 0 && third == 1){
						values.push(1);
					}
					else if(first == 1 && second == 1 && third == 0){
						values.push(1);
					}
					else if(first == 1 && second == 1 && third == 1){
						values.push(1);
					}
					else{
						values.push(0);
					}
					break;

				case '$':
					first = values.pop();
					second = values.pop();
					third = values.pop();
					
					if(first == 1 && second == 0 && third == 0){
						values.push(1);
					}
					else if(first == 0 && second == 1 && third == 0){
						values.push(1);
					}
					else if(first == 0 && second == 0 && third == 1){
						values.push(1);
					}
					else if(first == 0 && second == 0 && third == 0){
						values.push(1);
					}
					else{
						values.push(0);
					}
					break;

				case '&':
					first = values.pop();
					second = values.pop();
					third = values.pop();
					
					if(first == 1 && second == 0 && third == 0){
						values.push(1);
					}
					else if(first == 0 && second == 1 && third == 0){
						values.push(1);
					}
					else if(first == 0 && second == 0 && third == 1){
						values.push(1);
					}
					else if(first == 1 && second == 1 && third == 1){
						values.push(1);
					}
					else{
						values.push(0);
					}
					break;

				case '%':
					first = values.pop();
					second = values.pop();
					third = values.pop();
					double fourth = values.pop();
					
					if(first == 0 && second == 1 && third == 1 && fourth == 1){
						values.push(1);
					}
					else if(first == 1 && second == 0 && third == 1 && fourth == 1){
						values.push(1);
					}
					else if(first == 1 && second == 1 && third == 0 && fourth == 1){
						values.push(1);
					}
					else if(first == 1 && second == 1 && third == 1 && fourth == 0){
						values.push(1);
					}
					else if(first == 0 && second == 0 && third == 0 && fourth == 1){
						values.push(1);
					}
					else if(first == 0 && second == 0 && third == 1 && fourth == 0){
						values.push(1);
					}
					else if(first == 0 && second == 1 && third == 0 && fourth == 0){
						values.push(1);
					}
					else if(first == 1 && second == 0 && third == 0 && fourth == 0){
						values.push(1);
					}
					else{
						values.push(0);
					}
					break;
				}
			}
		}
		
		return values.pop();
	}
}