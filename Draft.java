public class Draft {
	public static void main(String[] args){
		String[] players = {
			"5, 57.5",
			"6, 56.5",
			"6, 72",
			"6, 60",
			"5, 51",
			"5, 50",
			"5, 49",
			"5, 33.4",
			"5, 23",
			"5, 18.9"
		};
		
		for(double n = 0, sal16 = 0, sal18 = 0, l18 = 0, h18 = 0, l16 = 0, h16 = 0, lSal = 0, l = -1, aSal = 0, len = players.length; n < len; n++){			
			int pyears = Integer.parseInt(players[(int) n].split(",")[0].replaceAll("[\\s\\D]", ""));
			double psal = Double.parseDouble(players[(int) n].split(pyears + ", ")[1].replaceAll("[^\\d\\.]", ""));
			
			if(l == -1 || psal / pyears > lSal){
				lSal = psal / pyears;
				l = n;
			}
			
			h16 = (psal / pyears / 16 > h16) ? psal / pyears / 16 : h16;
			l16 = ((l16 == 0 || psal / pyears / 16 < l16)) ? psal / pyears / 16 : l16;
			h18 = ((psal / pyears / 18 > h18)) ? psal / pyears/ 18 : h18;
			l18 = (l18 == 0 || psal / pyears / 18 < l18) ? psal / pyears / 18 : l18;
			aSal += psal / pyears;
			sal16 += psal / pyears / 16;
			sal18 += psal / pyears / 18;
			
			if(n + 1 == players.length){
				System.out.println((int) (aSal / players.length * 1000000));
				System.out.println((int) (lSal * 1000000) + " by " + (int) (l + 1));
				System.out.println((int) ((h16 - l16) * 1000000));
				System.out.println((int) ((h18 + l18) * 1000000) / 2);
				System.out.println((int) ((sal16 - sal18) / players.length * 1000000));
			}
		}
	}
}