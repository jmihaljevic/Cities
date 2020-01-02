import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VigenèreCipher {

    private CaesarCipher caesarCipher = new CaesarCipher();
    private static int key;

    public String VigenèreDecoder(String message) {
        for (int i = 1; i < 10; i++) {
            key = i;
            String decodedMessage = decodeMessage(message);
            decodedMessage = filterMessage(decodedMessage);
            if (findMostCommonWord(decodedMessage).equals("THE")) return decodedMessage;
        }
        return "Message can't be decoded.";
    }

    private String decodeMessage(String message) {
        ArrayList<String> codedStrings = (ArrayList<String>) collectStrings(message);
        ArrayList<String> decodedStrings = (ArrayList<String>) decodeStrings(codedStrings);
        int size = findSize(decodedStrings);
        char[] decodedMessage = new char[size];
        int j = 0;
        for (String s : decodedStrings) {
            int k = 0;
            for (int i = 0; i < s.length(); i++) {
                if (j + k * key >= size) break;
                decodedMessage[j + k * key] = s.charAt(i);
                k++;
            }
            j++;
        }
        return String.copyValueOf(decodedMessage);
    }

    private int findSize(ArrayList<String> strings) {
        int size = 0;
        for (String s : strings) size += s.length();
        return size;
    }

    private List<String> decodeStrings(ArrayList<String> codedStrings) {
        List<String> decodedStrings = new ArrayList<>();
        for (String s : codedStrings) {
            decodedStrings.add(caesarCipher.caesarDecoder(s));
        }
        return decodedStrings;
    }

    private List<String> collectStrings(String message) {
        List<String> strings = new ArrayList<>();
        for (int j = 0; j < key; j++) {
            StringBuilder string = new StringBuilder();
            int x = 0;
            for (int i = j; i < message.length(); i++) {
                Character c = message.charAt(i);
                if (Character.isLetter(c)) {
                    if (x % key == 0) string.append(c);
                    x++;
                } else {
                    string.append(c);
                }
            }
            strings.add(string.toString());
        }
        return strings;
    }

    private String findMostCommonWord(String text) {
        text = text.toUpperCase();
        String[] words = text.split("\\W+");
        HashMap<String, Integer> map = new HashMap<>();
        String mostCommonWord = "";
        int maxRepetitionNumber = 0;
        for (String word : words) {
            if (!map.containsKey(word)) map.put(word, 1);
            else map.put(word, map.get(word) + 1);

            if (map.get(word) > maxRepetitionNumber) {
                maxRepetitionNumber = map.get(word);
                mostCommonWord = word;
            }
        }
        return mostCommonWord;
    }

    private String filterMessage(String message) {
        StringBuilder filteredMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            Character c = message.charAt(i);
            filteredMessage.append(c);
            if (!Character.isLetter(c)) i += 2;
        }
        return filteredMessage.toString();
    }
}
