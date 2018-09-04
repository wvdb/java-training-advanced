package be.ictdynamic.functional_interfaces;

@FunctionalInterface
public interface WorldFilter {
   // Classes implementing this interface have only ONE function
   public boolean isValid(String s);
}
