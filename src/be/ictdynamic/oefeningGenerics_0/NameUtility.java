package be.ictdynamic.oefeningGenerics_0;

/**
 * Created by admin on 20/08/2018.
 */
public interface NameUtility<T extends String> {
    public int getLengthOfName(T t);
    public String getLowercaseValue(T t);
    public String getUpperCaseValue(T t);
}
