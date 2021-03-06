import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DictionarySteps {

    public void addWord() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + Constants.ENGLISH_WORD_INPUT);
        String word1 = addStringAndCheckIsEmpty(scanner);

        System.out.println("\n" + Constants.RUSSIAN_WORD_INPUT);
        String word2 = addStringAndCheckIsEmpty(scanner);

        String dictionaryWord = word1.trim() + " - " + word2.trim();

        FileWriter fileWriter = new FileWriter(Constants.DICTIONARY_FILE_NAME, true);

        fileWriter.write(dictionaryWord + "\n");
        fileWriter.close();

        System.out.println("\n" + Constants.MENU_TITLE);
    }

    public void browseWords() throws IOException {
        try {
            FileReader fileReader = new FileReader(Constants.DICTIONARY_FILE_NAME);
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

    public void deleteWord() throws IOException {
        try {
            Scanner scanner = new Scanner(new File(Constants.DICTIONARY_FILE_NAME));
            List<String> dictionaryWords = new ArrayList<>();
            while (scanner.hasNextLine()) {
                dictionaryWords.add(scanner.nextLine());
            }

            if (dictionaryWords.size() == 0) {
                System.out.println(Constants.DICTIONARY_IS_EMPTY);
            }

            else {

                System.out.println(Constants.REMOVE_WORD_MESSAGE);

                int wordIndex = (new Scanner(System.in)).nextInt();

                if (wordIndex >= 0 && wordIndex <= dictionaryWords.size()) {
                    dictionaryWords.remove(wordIndex - 1);

                    PrintWriter printWriter = new PrintWriter(Constants.DICTIONARY_FILE_NAME);
                    printWriter.close();

                    FileWriter fileWriter = new FileWriter(Constants.DICTIONARY_FILE_NAME, true);
                    for (int i = 0; i < dictionaryWords.size(); i++) {
                        fileWriter.write(dictionaryWords.get(i) + "\n");
                    }
                    fileWriter.close();
                } else
                    System.out.println(Constants.REMOVE_WORD_ERROR_MESSAGE);
            }
        }

        catch(FileNotFoundException e) {
            System.out.println(Constants.DICTIONARY_FILE_IS_NOT_FOUND);
        }

        finally {
            System.out.println(Constants.MENU_TITLE);
        }
    }

    public void copyDictionary(String filePathAndName) {

    }

    public void deleteDictionary() {

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
