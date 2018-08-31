package be.ictdynamic.oefeningGenerics_0;

/**
 * Created by admin on 20/08/2018.
 */
public class NameUtilityImpl<T extends String> implements NameUtility<T> {
    @Override
    public int getLengthOfName(T name) {
        return name.length();
    }

    @Override
    public String getLowercaseValue(T name) {
        return name.toLowerCase();
    }

    @Override
    public String getUpperCaseValue(T t) {
        return t.toUpperCase();
    }

}
