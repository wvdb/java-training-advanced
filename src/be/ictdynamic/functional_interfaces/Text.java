package be.ictdynamic.functional_interfaces;

public class Text {
    private String sentence;

    public Text(String sentence) {
        this.sentence = sentence;
    }

    public void printFilteredWords(WordFilter wordFilter) {
        // we want all the words except for the dot
        for (String word : sentence.replace(".", "").split(" ")) {
//            System.out.println("Word " + word + ":" + wordFilter.isValid(word));
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

}
