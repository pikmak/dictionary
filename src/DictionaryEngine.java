import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryEngine {

    public void runDictionary() {
        DictionarySteps dictionarySteps = new DictionarySteps();

        System.out.println(Constants.MENU_TITLE);

        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();

        List<String> words = new ArrayList<>();

        if (str != 3) {
            boolean boo = true;

            while (boo) {
                switch (str) {
                    case (1):
                        do {
                            dictionarySteps.addWord(words);
                            str = sc.nextInt();
                        }
                        while (str == 1);
                        break;

                    case (2):
                        dictionarySteps.browseWords(words);
                        str = sc.nextInt();
                        break;

                    case (3):
                        dictionarySteps.exitDictionary();
                        boo = false;
                }
            }
        }
        else dictionarySteps.exitDictionary();
    }
}
