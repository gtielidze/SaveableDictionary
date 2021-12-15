package dictionary;

public class Main {

    public static void main(String[] args) {
        // You can test your dictionary here
        SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        boolean wasSuccessful = dictionary.load();

        if (wasSuccessful) {
            System.out.println("Successfully loaded the dictionary from file");
        }

        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("ohjelmointi"));
        System.out.println(dictionary.translate("alla oleva"));
        dictionary.add("ohjelmointi", "programming");
        dictionary.delete("ohjelmointi");
        dictionary.delete("apina");
        dictionary.delete("alla oleva");
        System.out.println(dictionary.translate("programming"));
        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("alla oleva"));
        dictionary.add("traki", "dzudzy");
        dictionary.delete("traki");
        System.out.println(dictionary.translate("traki"));
    }
}
