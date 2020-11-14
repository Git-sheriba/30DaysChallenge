import java.util.ArrayList;
import java.util.List;
/*
 * Program to replace all the vowels in a given string
 */
public class Day5_Challenge {
	public static String removeVowelList(String strVowel) {
		String vow = "aeiou";
		System.out.println("Vowel String : "+ vow );
		List<Character> li = new ArrayList<Character>();
		for (Character character : vow.toCharArray()) {
			li.add(character);
		}
		StringBuffer sb = new StringBuffer(strVowel);
		for (int a = 0; a < sb.length(); a++) {
			if (li.contains(sb.charAt(a))) {
				sb.replace(a, a + 1, "");
				a--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String test = "feelinggoodalways";
		System.out.println("Input String : "+ test);
		System.out.println("Output String: "+removeVowelList(test));
	}
}
