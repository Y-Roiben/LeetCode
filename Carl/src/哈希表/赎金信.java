package 哈希表;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        char[] chars1 = magazine.toCharArray();
        for (char c : chars1) {
            record[c -  'a'] ++;
        }
        char[] chars2 = ransomNote.toCharArray();
        for (char c : chars2) {

            record[c - 'a'] -= 1;
            if (record[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
