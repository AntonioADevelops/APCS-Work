public class IterationPractice {
	public int countCode(String str) {
    	int count = 0;
    	String co = "co";
		String e = "e";

		// since co + (any letter) + e spans 4 charachters, if str < 4 count has to be 0
		if (str.length() < 4) {
			return 0;
		}

		// str.length() - 3 as the last 3 characters cant be the 4 letter snippet we're looking for.
		for (int i = 0; i < str.length() - 3; i++) {
			if (co.equals(str.substring(i, i + 2)) == true && e.equals(str.substring(i + 3, i + 4)) == true) {
				count++;
			}
		}
		return count;
	}

  	public static String equalIsNot(String str) {
		int countIs = 0;
		int countNot = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i + 1).equals("is") == true) {
				countIs++;
			}
		}
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 2).equals("not") == true) {
				countNot++;
			}
		}
		return countIs + "and" + countNot;
	}

	public int maxBlock(String str) {
		int count = 0;
		int tempCount = 1;

		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				tempCount++;
			} 
			else {
				tempCount = 1;
			}
			if (tempCount > count) {
				count = tempCount;
			}
		}
		return count;
	}
}