package 哈希表;

public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] record = new int[26];
        char[] chars1 = s.toCharArray();
        for (char c : chars1) {
            record[c -  'a'] ++;
        }
        char[] chars2 = t.toCharArray();
        for (char c : chars2) {

            record[c - 'a'] -= 1;
        }
        for (int j : record) {
            if (j != 0) {
                return false;
            }
        }
        return true;

    }
}
