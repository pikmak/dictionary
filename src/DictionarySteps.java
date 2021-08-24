import java.io.*;
import java.util.Scanner;

public class DictionarySteps {

    public void addWord() throws IOException {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("\n" + Constants.ENGLISH_WORD_INPUT);
        String word1 = addStringAndCheckIsEmpty(sc1);

        System.out.println("\n" + Constants.RUSSIAN_WORD_INPUT);
        String word2 = addStringAndCheckIsEmpty(sc1);

        String dictionaryWord = word1.trim() + " - " + word2.trim();

        FileWriter fileWriter = new FileWriter(Constants.DICTIONARY_FILENAME, true);

        fileWriter.write(dictionaryWord + "\n");
        fileWriter.close();

        System.out.println("\n" + Constants.MENU_TITLE);
    }

    public void browseWords() throws IOException {
        try {
            FileReader fileReader = new FileReader(Constants.DICTIONARY_FILENAME);
            Scanner scanner = new Scanner(fileReader);

            if(scanner.hasNextLine() == false) {
                System.out.println(Constants.DICTIONARY_IS_EMPTY);
            }

            int i = 1;
            while (scanner.hasNextLine()) {
                System.out.println(i + " " + scanner.nextLine());
                i++;
            }

            fileReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println(Constants.DICTIONARY_FILE_IS_NOT_FOUND);
        }

        finally {
            System.out.println(Constants.MENU_TITLE);
        }
    }

    public void exitDictionary() {
        System.out.println(Constants.EXIT_MESSAGE);
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
