package Jam;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AllYourbase {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			String num = in.next();
			System.out.println("Case #" + i + ": " + getDec(num));

		}
		in.close();
	}

	
	public static String getDec(String num) {

		String newNum = "";
		Map<Character, Integer> assignMap = new HashMap<Character, Integer>();

		int start = 0;
		int curAssign = 1;

		for (; start < num.length(); start++) {
			Character character = num.charAt(start);

			if (!assignMap.containsKey(character)) {

				assignMap.put(character, curAssign);
				if (curAssign == 0) {
					newNum = newNum + curAssign;
					break;
				} else {
					curAssign = 0;
				}
			}

			newNum = newNum + assignMap.get(character);

		}

		curAssign = 2;
		start++;
		for (; start < num.length(); start++) {
			Character character = num.charAt(start);

			if (!assignMap.containsKey(character)) {
				assignMap.put(character, curAssign);
				curAssign++;
			}
			int a = assignMap.get(character);
			if (a >= 10) {
				a = a - 10;
				char c = (char) ('a' + a);
				newNum = newNum + c;

			} else {
				newNum = newNum + a;

			}

		}

		return getBaseValue(newNum, curAssign);
	}

	public static String getBaseValue(String num, int base) {

		BigInteger bigInteger = new BigInteger("0");
		long result = 0;
		long b = 1;
		for (int i = num.length() - 1; i >= 0; i--) {
			char c = num.charAt(i);
			int cvalue = 0;
			if (c >= 'a') {
				cvalue = 10 + (c - 'a');
			} else {
				cvalue = c - '0';
			}
			if (cvalue < 0) {
				System.out.println("hehe");
			}
			BigInteger bigInteger2 = new BigInteger((b * cvalue) + "");
			bigInteger = bigInteger.add(bigInteger2);
			// result = result + b * cvalue;
			b = b * base;
		}
		return bigInteger.toString();

	}
}
