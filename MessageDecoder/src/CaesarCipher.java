import java.util.HashMap;

public class CaesarCipher {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet;

    private void setShiftedAlphabet(int shift) {
        this.shiftedAlphabet = alphabet.substring(alphabet.length() - shift) + alphabet.substring(0, alphabet.length() - shift);
    }

    public String caesarDecoder(String encrypted) {
        String message = encrypted.toUpperCase();
        StringBuilder decoded = new StringBuilder();
        Character c = findMostCommonLetter(message);
        int shift = findShift(c);
        setShiftedAlphabet(shift);
        for(int i = 0; i < message.length(); i++) {
            Character current = message.charAt(i);
            if(!(current >= 'A' && current <= 'Z')) {
                decoded.append(current);
                continue;
            }
            int index = shiftedAlphabet.indexOf(current);
            if(Character.isUpperCase(encrypted.charAt(i))) decoded.append(alphabet.charAt(index));
            else decoded.append(Character.toLowerCase(alphabet.charAt(index)));
        }
        return decoded.toString();
    }

    private int findShift(Character c) {
        int start = alphabet.indexOf(c);
        int end = alphabet.indexOf('E');
        if(end - start >= 0) return end - start;
        else return alphabet.length() - start + end;
    }

    private Character findMostCommonLetter(String message) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxValueInMap = 1;
        Character max = 'a';
        for (int i = 0; i < message.length(); i++) {
            Character c = message.charAt(i);
            if(!Character.isLetter(c)) continue;
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            if(map.get(c) > maxValueInMap) {
                maxValueInMap = map.get(c);
                max = c;
            }
        }
        return max;
    }
}
