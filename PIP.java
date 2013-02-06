public class PIP {
	public static void main(String[] args){
		String[] input = {"A * B", "A * B * C", "A + (B - C)", "(A + B) * C", "A - (B + C) * D"};	
		
		for(int n = 0; n < input.length; n++){				
			java.util.Stack<Character> op = new java.util.Stack<Character>();
			java.util.Stack<String> num = new java.util.Stack<String>();
			String prefix = "";
			input[n] = input[n].replaceAll("\\s", "");
			
			for(int k = 0; k < input[n].length(); k++){			
				if(input[n].charAt(k) == '*' || input[n].charAt(k) == '('){
					op.push(input[n].charAt(k));
				}
				else if(input[n].charAt(k) == '+' || input[n].charAt(k) == '-'){
					while(!op.isEmpty() && op.peek() != '('){
						num.push(new StringBuffer(num.pop() + num.pop() + op.pop()).reverse().toString());
					}
					op.push(input[n].charAt(k));
				}
				else if(input[n].charAt(k) == ')'){
					while(!op.isEmpty() && op.peek() != '('){
						num.push(new StringBuffer(num.pop() + num.pop() + op.pop()).reverse().toString());
					}
					op.pop();
				}
				else{
					num.push(input[n].charAt(k) + "");
				}
			}
			
			while(!op.isEmpty()){
				String temp = num.pop();
				prefix = num.size() > 0 ? op.pop() + num.pop() + temp + prefix : op.pop() + temp + prefix;
			}			
			
			System.out.println(prefix);
		}
	}
}

/*
//ADDITION
while(!op.isEmpty() && op.peek() != '('){
	String temp = num.pop();
	num.push(op.pop() + (num.size() > 0 ? num.pop() + temp : temp));
}

//MULTIPLICATION
if(op.isEmpty() || op.peek() == '+' || op.peek() == '-'){
	op.push(input[n].charAt(k));
}
else{					
	String sub = "";
	while(!op.isEmpty() && !num.isEmpty() && op.peek() != '+' && op.peek() != '-'){
		String temp = num.pop();
		sub = op.pop() + temp + num.pop() + sub;
	}
	num.add(sub);
}

else if(input[n].charAt(k) == '*'){
	while(!op.isEmpty() && op.peek() != '*'){
		num.push(new StringBuffer(num.pop() + num.pop() + op.pop()).reverse().toString());
	}
	op.push(input[n].charAt(k));
}

//EXTRA		
while(!num.isEmpty()){
	prefix += num.pop();
}
 */