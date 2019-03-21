/** Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 * 
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solution1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            // As the number for the key, index for the value 
            map.put(nums[i],i);
        }
        for (int i=0; i<nums.length; i++) {
            int completion = target - nums[i];
            // ensure contains the completion and not itself
            if (map.containsKey(completion) && map.get(completion) != i) {
                result[0] = i;
                result[1] = map.get(completion);
            }
        }
        return result;
    }

    public int[] solution2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i ++) {
            int completion = target - nums[i];
            if (map.containsKey(completion)) {
                int[] result = new int[] {i, map.get(completion)};
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}