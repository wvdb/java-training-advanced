package be.ictdynamic.functional_interfaces;

public interface TextUtil {
    public static String formatQuote(String string) {
        return String.format(">>%s<<", string);
    }
}
