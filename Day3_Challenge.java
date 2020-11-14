import java.util.HashMap;

public class Day3_Challenge {

	static void sum(int nums[], int target) {
		System.out.println("Method 1 using arrays");
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					System.out.println("[" + i + "," + j + "]");
				}
			}
		}
	}

	public static void findSumUsingMap(int num[], int X) {
		System.out.println("Method 2 using Hash Map");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			map.put(num[i], i);
		}
		for (int i = 0; i < num.length; i++) {
			if (map.containsKey(X - num[i])) {
				System.out.println(num[i] + "," + (X - num[i]));
			}
		}
	}

	public static void main(String[] args) {
		sum(new int[] { 2, 11, 15, 7, 3 }, 9);
		findSumUsingMap(new int[] { 2, 11, 15, 7, 3 }, 9);
	}
}
