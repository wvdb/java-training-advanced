package be.ictdynamic.functional_interfaces;

@FunctionalInterface
public interface WordFilter {
   // Classes implementing this interface have only ONE function

   // isValid method accepts a String as a parameter and returns a boolean
   public boolean isValid(String s);
//   public boolean isValidX(String s);
}
