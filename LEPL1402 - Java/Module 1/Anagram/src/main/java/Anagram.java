import java.util.HashMap;

public class Anagram {

    /**
     * Count the number of occurrences of each letter of the alphabet
     * (from 'A' to 'Z') in the given string. The function must return
     * an array containing 26 elements: The item with index 0 contains
     * the number of 'A' in the string, the item with index 1 contains
     * the number of 'B', and so on.
     *
     * This function must be case-insensitive, i.e. the character 'f'
     * must be considered as the same as character 'F'.
     *
     * Characters that are neither in the range 'a' to 'z', nor in the
     * range 'A' to 'Z' must be ignored.
     * 
     * @param s The string of interest.
     * @return An array counting the number of occurrences of each
     * letter.
     **/
    public static int[] countAlphabet(String s) {
        HashMap<String, Integer> answer = new HashMap<>();
        String[] tab = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
        for (int i = 0; i < s.length(); i++) {
            if (IsIn(s.charAt(i), tab)){
                answer.get(answer.put(i, 0)+1);
            };
        }
        return null;
    }

    public static Boolean IsIn(char toSearch, String[] SearchIn){
        for (String i: SearchIn) {
            if (SearchIn == toSearch){
                return true;
            }
        }
        return false;
    }


    /**
     * Check whether one string is an anagram of another string. It is
     * strongly advised to use the function "countAlphabet()" as a
     * building block for function "isAnagram()".
     * @param s1 The first string.
     * @param s2 The second string.
     * @return <code>true</code> iff. the two strings are anagrams.
     **/
    public static boolean isAnagram(String s1,
                                    String s2) {
        // TODO
        return false;
    }
}
