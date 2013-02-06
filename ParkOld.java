public class ParkOld {
	public static void main(String[] args){
		try{
			java.util.Scanner file = new java.util.Scanner(new java.io.File("PARKINPUT"));
			String keys = "123456789ABCDEFGH";
			
			while(file.hasNext()){
				String[] input = file.nextLine().split(",\\s?");
				double tot = 0, th = 0, loc = Integer.parseInt(input[0]);;
				
				for(int n = 1; n < input.length; n += 2){
					double h = (keys.indexOf(input[n + 1]) - keys.indexOf(input[n])) / 2.0;
					
					if(loc >= 100 && loc <= 399){
						int limit = loc < 200 ? 30 : loc < 300 ? 40 : 20;
						double per = loc < 200 ? 10 : loc < 300 ? 7.5 : 9.25, over = loc < 200 ? 15 : loc < 300 ? 15 : 10.5;
						
						tot += (th > limit) ? h * over : (th + h <= limit) ? h * per : ((limit - th) * per) + ((th + h - limit) * over);
						th += h;
					}
					else if(loc >= 400 && loc <= 499){
						tot += (n == 1 || n == 13) ? 13.5 * h : 6.75 * h;
					}
					else if(loc >= 500 && loc <= 599){					
						tot += (h <= 6) ? h * 8 : 48 + ((h - 6) * 12);
					}
				}
				
				System.out.println(new java.text.DecimalFormat("$0.00").format(tot));
			}
		}
		catch(java.io.IOException e){}
	}
}