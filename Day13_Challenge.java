
import java.util.ArrayList;
import java.util.List;

public class Day13_Challenge {

	// Method to insert the given target value in the given position
	public static void insertTarget(int[] arr, int target, int pos) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer entry : arr) {
			list.add(entry);
		}
		System.out.println("Array elements BEFORE insertion of the target value");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		list.add(pos, target);
		System.out.println("\nArray elements AFTER insertion of the target value");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	public static void main(String[] args) {

		// int[] arr = {20, 21, 24, 29, 30};
		int[] arr = { 20, 21, 24, 27, 30 };
		int target = 29;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				System.out.println("Index of the given target value is:" + i);
				break;
			} else if (arr[i] > target) {
				insertTarget(arr, target, i);
				break;
			}
		}
	}
}
