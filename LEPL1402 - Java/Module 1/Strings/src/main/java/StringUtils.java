import java.util.Arrays;

public class StringUtils {


    /**
     * Split a string according to a delimiter
     *
     * @param str       The string to split
     * @param delimiter The delimiter
     * @return An array containing the substring which fall
     * between two consecutive occurence of the delimiter.
     * If there is no occurence of the delimiter, it should
     * return an array of size 1 with the string at element 0
     */
    public static String[] split(String str, char delimiter) {
        char[] tab = str.toCharArray();
        int parts = 1;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == delimiter) {
                parts++;
            }
        }
        String[] answer = new String[parts];

        int landmark = 0;
        int placeInTab = 0;
        int i = 0;
        int reminder = parts;
        while (i != tab.length) {
            char elem = tab[i];
            if (reminder == 1){
                answer[placeInTab] = str.substring(landmark);
            } else {
                if (elem == delimiter){
                    answer[placeInTab] = str.substring(landmark, i);
                    landmark = i+1;
                    placeInTab++;
                    reminder--;
                }
            }
            i++;
        }
        return answer;
    }


    /**
     * Find the first occurence of a substring in a string
     *
     * @param str The string to look in
     * @param sub The string to look for
     * @return The index of the start of the first appearance of
     * the substring in str or -1 if sub does not appear
     * in str
     */
    public static int indexOf(String str, String sub) {
        int l = sub.length();
        for (int i = 0; i < str.length(); i++) {
            int check = str.length() - i;
            if (l <= check){
                String verif = str.substring(i, l+i);
                if (verif.equals(sub)){
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * Convert a string to lowercase
     *
     * @param str The string to convert
     * @return A new string, same as str but with every
     * character put to lower case.
     */
    public static String toLowerCase(String str) {
        char [] helper = str.toCharArray();
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] >= 65 && helper[i] <= 90 ){
                int charrette = helper[i] + 32;
                helper[i] = (char) charrette;
            }
        }
        return String.valueOf(helper);
    }

    /**
     * Check if a string is a palyndrome
     * <p>
     * A palyndrome is a sequence of character that is the
     * same when read from left to right and from right to
     * left.
     *
     * @param str The string to check
     * @return true if str is a palyndrome, false otherwise
     */
    public static boolean palindrome(String str) {
        char [] test = str.toCharArray();
        char [] compare = new char[str.length()];
        int j = 0;
        for (int i = test.length-1; i >= 0; i--) {
            char a = test[i];
            compare[j] = a;
            j++;
        }
       if (String.valueOf(compare).equals(str)) {
           return true;
       }
       return false;
    }
}
