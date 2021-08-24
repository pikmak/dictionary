import java.io.IOException;
import java.util.Scanner;

public class DictionaryEngine {

    public void runDictionary() throws IOException {
        DictionarySteps dictionarySteps = new DictionarySteps();

        System.out.println(Constants.MENU_TITLE);

        Scanner scanner = new Scanner(System.in);
        int menuItem = scanner.nextInt();

        if (menuItem != 4) {
            boolean isInfinite = true;

            while (isInfinite) {
                switch (menuItem) {
                    case (1):
                        do {
                            dictionarySteps.addWord();
                            menuItem = scanner.nextInt();
                        }
                        while (menuItem == 1);
                        break;

                    case (2):
                        dictionarySteps.browseWords();
                        menuItem = scanner.nextInt();
                        break;

                    case (3):
                        dictionarySteps.deleteWord();
                        menuItem = scanner.nextInt();
                        break;

                    case (4):
                        dictionarySteps.exitDictionary();
                        isInfinite = false;
                }
            }
        }
        else dictionarySteps.exitDictionary();
    }
}
