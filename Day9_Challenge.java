import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Day9_Challenge {
	/*
	 * PROGRAM TO FIND AN ALGORITHM TO CALCULATE THE MAXIMUM PROFIT
	 * 
	 */

	// Method for getting the minimum value
	public static int getLeastValue(int arr[]) {
		int leastValue = arr[0];
		int day = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < leastValue) {
				leastValue = arr[i];
				day = i + 1;
			}
		}
		System.out.println("Best day for purchasing the stock at the lowest price: Day " + day);
		return day;
	}

	// Algorithm to find the maximum profit
	public static void findMaxProfit(int arr[], int day) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int profit = 0;

		for (int i = day - 1; i < arr.length - 1; i++) {
			profit = arr[i + 1] - arr[day - 1];
			map.put(i + 1, profit);
		}

		Map<Integer, Integer> hm1 = sortByValue(map);

		List<Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(hm1.entrySet());
		final Entry<Integer, Integer> lastEntry = entryList.get(entryList.size() - 1);
		Integer key = lastEntry.getKey();
		System.out.println("Day of selling the stock at a maximum profit is : Day " + (key + 1));
		System.out.println("Price of the stock on Day " + (key + 1) + "is: " + arr[key]);
		System.out.println("Profit :" + lastEntry.getValue());

	}
    // Program to sort the Map using List
	public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
		// Create a list from elements of HashMap
		List<Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		// put data from sorted list to hashmap
		HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 7, 5, 1, 3, 8, 4 };
		int dayOfLeastValue = getLeastValue(arr);
		System.out.println("Least price that can be purchased : " + arr[dayOfLeastValue - 1]);
		findMaxProfit(arr, dayOfLeastValue);

	}

}
