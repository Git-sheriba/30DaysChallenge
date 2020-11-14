import java.util.HashMap;
/*
 * PROGRAM TO FIND THE NUMBER OF SUBARRAYS IN A GIVEN ARRAY
 * THAT SUMS TO THE GIVEN NUMBER
 *1. Travel through the arrays 
 *2. Find the sum of the continuous elements in the array
 *3. Check if the sum is equal to the target value 
 *4. Increment the count whenever the sum adds upto the target value
 */
public class Day7_Challenge {
	public static void main(String[] args) {
		int nums[] = { 10, 1, 2, 5, 4, 3, 7};
        int target = 7;
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == target)
                    count++;
            }
        }
        System.out.println("The given array is: ");
        for (int i = 0; i < nums.length; i++) {
        	System.out.print(nums[i] + " ");
		}
        System.out.println("\nThe total no of subarrays whose sum is "+ target + " is: " + count);
    }
}

