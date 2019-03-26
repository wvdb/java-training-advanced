package be.ictdynamic.functional_interfaces;

public class Text {
    private String sentence;

    public Text(String sentence) {
        this.sentence = sentence;
    }

    public void printFilteredWords(WordFilter wordFilter) {
        // we want all the words except for the dot
//        for (String word : sentence.replace(".", "").split(" ")) {

        String[] words = sentence.split(" ");
        for (String word : words) {
            if (wordFilter.isValid(word)) {
                System.out.println(word);
            }
        }
    }

    public void printProcessedWords(WordProcessor wordProcessor) {
        // we want all the words except for the dot
        for (String word : sentence.replace(".", "").split(" ")) {
            System.out.println(wordProcessor.process(word));
        }
    }

    public void printNumberValues(NumberParser numberParser) {
        for (String word : sentence.split(" ")) {
            System.out.print(String.format("%d\n", numberParser.parse(word)));
        }
    }

}
