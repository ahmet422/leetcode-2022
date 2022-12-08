package medium;
// https://leetcode.com/problems/longest-repeating-character-replacement/
public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABBBAAAAA",2));
    }
    public static int characterReplacement(String s, int k) {

        int rep = k;
        int size = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <s.length() ; j++) {
                r = j;
                if(s.charAt(i) == s.charAt(j)){
                    continue;
                }else if(rep>0){
                    rep--;
                    continue;
                }else{
                    size = Math.max(size, j-i);
                    rep = k;
                    break;
                }
            }
            size = Math.max(size,r-i+1);
        }

        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i-1; j >=0  ; j--) {
                r = j;
                if(s.charAt(i) == s.charAt(j)){
                    continue;
                }else if(rep>0){
                    rep--;
                    continue;
                }else{
                    size = Math.max(size, j-i);
                    rep = k;
                    break;
                }
            }
            size = Math.max(size,r-i+1);
        }
        return size;
    }
}
