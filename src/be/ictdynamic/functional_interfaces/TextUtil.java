package be.ictdynamic.functional_interfaces;

public class TextUtil {
    public static String format(String string) {
        return String.format(">>%s<<", string);
    }
    public static String reverse(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString();
    }
}
