import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DictionarySteps {

    public void addWord() throws IOException {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n" + Constants.ENGLISH_WORD_INPUT);
        String word1 = addStringAndCheckIsEmpty(sc1);

        System.out.println("\n" + Constants.RUSSIAN_WORD_INPUT);
        String word2 = addStringAndCheckIsEmpty(sc1);

        String dictionaryWord = word1.trim() + " - " + word2.trim();

        FileWriter fileWriter = new FileWriter("Dictionary.txt", true);

        fileWriter.write(dictionaryWord + "\n");
        fileWriter.close();

        System.out.println("\n" + Constants.MENU_TITLE);
    }

    public void addWord(List<String> words) {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n" + Constants.ENGLISH_WORD_INPUT);
        String word1 = addStringAndCheckIsEmpty(sc1);

        System.out.println("\n" + Constants.RUSSIAN_WORD_INPUT);
        String word2 = addStringAndCheckIsEmpty(sc1);

        String dictionaryWord = word1.trim() + " - " + word2.trim();
        words.add(dictionaryWord);

        System.out.println("\n" + Constants.MENU_TITLE);
    }

    public void browseWords(List<String> words) {
        for (String word : words) {
            System.out.println("\n" + word);
        }

        System.out.println(Constants.MENU_TITLE);
    }

    public void browseWords() throws IOException {
//        FileReader fileReader = new FileReader(Constants.DICTIONARY_FILE_PATH);
        FileReader fileReader = new FileReader("Dictionary.txt");
        Scanner scanner = new Scanner(fileReader);

        if(scanner.hasNextLine() == false) {
            System.out.println("File is empty");
        }

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        fileReader.close();

        System.out.println(Constants.MENU_TITLE);
    }

    public void exitDictionary() {
        System.out.println("Exit");
    }

    private String addStringAndCheckIsEmpty(Scanner scanner) {
        String string = scanner.nextLine();
        while (string.isEmpty()) {
            System.out.println(Constants.EMPTY_STRING);
            string = scanner.nextLine();
        }
        return string;
    }
}
