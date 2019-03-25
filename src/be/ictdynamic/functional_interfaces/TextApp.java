package be.ictdynamic.functional_interfaces;

import java.util.ArrayList;
import java.util.List;

public class TextApp {

    class DummyClass {
        public String toUpperCase(String s) {
            return s.toUpperCase();
        }
    }

    public static void main(String[] args) {
        Text text = new Text("You can't stop the waves, but you can learn how to surrrrf.");

        // ex 0A
        System.out.println("Anonymous impl of WordFilter");

        WordFilter wordFilter = new WordFilter() {
            @Override
            public boolean isValid(String s) {
                return s.contains("e");
            }
        };
        text.printFilteredWords(wordFilter);

        // ex 0A (lambda of 1 line in stead of anonymous class of 7 lines)
        System.out.println("Usage 0A of FunctionalInterface");
        text.printFilteredWords((String myWord) -> myWord.contains("e"));

        // ex 0B
        System.out.println("Usage 0B of FunctionalInterface");
        text.printFilteredWords(myWord -> myWord.startsWith("s"));

        System.out.println("Usage 0C of FunctionalInterface: words containing an 'e' and and 'a'");
        text.printFilteredWords(myWord -> {
            if (myWord.contains("e") && myWord.contains("a")) {
                return true;
            }
            else {
                return false;
            }
        });

        System.out.println("Usage 0D of FunctionalInterface: words with 2 occurrences of 'r'");
        text.printFilteredWords(myWord -> {
            int count = 0;
            for (char c : myWord.toCharArray()) {
                if (c == 'r')
                    count++;
            }
            if (count >= 2) {
                return true;
            }
            else {
                return false;
            }
        });

        // printProcessedWords
        // -------------------

        // ex 1 : lambda
//        System.out.println("Usage 1 of FunctionalInterface");
//        text.printProcessedWords(myWord -> String.format(">>%s<<", myWord));

        // ex 2 : static method reference
//        System.out.println("Usage of static method reference");
//        text.printProcessedWords(TextUtil::formatQuote);

        // ex 3 : unbound method reference
//        System.out.println("Usage of unbound method reference");
//        text.printProcessedWords(String::toUpperCase);

//        TextApp textApp = new TextApp();
//        textApp.method1();
//        textApp.method_OCA();

    }

    private void method1() {
        Text text = new Text("You can't stop the waves, but you can learn how to surf.");

        // ex 4 : bound method reference
        System.out.println("Usage of bound method reference");
        DummyClass dummyClass = new DummyClass();
        text.printProcessedWords(dummyClass::toUpperCase);
    }

    private void method_OCA() {
        List<String> words = new ArrayList();
        words.removeIf(w -> w.isEmpty());
        words.removeIf((String w) -> w.isEmpty());
        words.removeIf(w -> {return w.isEmpty();});

        words
                .stream()
                .filter((String word) -> word.length() > 5)
                .forEach(word -> {System.out.println(word);});

        words
                .stream()
                .filter((String word) -> { return word.length() > 5; } );

//        words
//                .stream()
//                .filter((String word) -> { word.length() > 5; } );

    }
}
