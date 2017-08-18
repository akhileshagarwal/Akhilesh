package com.akki;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Akhilesh {
	public static void main(String[] args) {
		String words[] = { "HELLO", "TO", "MY", "WORLD", "JADE" };
		System.out.println(Arrays.toString(words));
		String rule = "< c, C < a, A < f, F < e, E";
		// String rule ="<B,B<C,C<E,E<W,J<H,H<W,W<T";
		RuleBasedCollator collator = null;
		try {
			collator = new RuleBasedCollator(rule);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List list = Arrays.asList(words);
		Collections.sort(list, collator);
		list.toArray();
		String s = "BDKJSCDk";
		System.out.println(generateRule(s.toCharArray()));
	}

	// ADBFG
	static String generateRule(char[] c) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			if (c[i + 1] != 'k') {
				sb.append("< ").append(Character.toString(c[i]).toLowerCase()).append(", ").append(Character.toString(c[i]));
			} else {
				sb.append("< ").append(Character.toString(c[i]) + c[i + 1]);
				break;
			}
		}
		return sb.toString();
	}
}
