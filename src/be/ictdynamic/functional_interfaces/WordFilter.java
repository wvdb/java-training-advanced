package be.ictdynamic.functional_interfaces;

@FunctionalInterface
public interface WordFilter {
   // Classes implementing this interface have only ONE function
   public boolean isValid(String s);
}
