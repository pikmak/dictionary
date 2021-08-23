import java.util.List;
import java.util.Scanner;

public class DictionarySteps {

    public void addWord(List<String> words) {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n" + Constants.ENGLISH_WORD_INPUT);
        String word1 = addStringAndCheckIsEmpty(sc1);

        System.out.println("\n" + Constants.RUSSIAN_WORD_INPUT);
        String word2 = addStringAndCheckIsEmpty(sc1);

        words.add(word1.trim() + " - " + word2.trim());

        System.out.println("\n" + Constants.MENU_TITLE);
    }

    public void browseWords(List<String> words) {
        for (String word : words) {
            System.out.println("\n" + word + "\n");
        }

        System.out.println(Constants.MENU_TITLE);
    }

    public void exitDictionary() {
        System.out.println("Exit");
    }

    private String addStringAndCheckIsEmpty(Scanner sc1) {
        String string1 = sc1.nextLine();
        while (string1.isEmpty()) {
            System.out.println(Constants.EMPTY_STRING);
            string1 = sc1.nextLine();
        }
        return string1;
    }
}
