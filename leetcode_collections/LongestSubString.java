import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;

/** Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 */

public class LongestSubString {

    // for non-repeating specialty, use hashset solve the problem
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int maxLen = 0, i = 0, j = 0;
        Set<Character> set = new HashSet();
        while (i < length && j < length) {
            if ( !set.contains(s.charAt(j)) ){
                set.add(s.charAt( j ++ ));
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt( i ++ ));
            }
        }
        return maxLen;
    }
}