package be.ictdynamic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratingApplication {
    public static void main(String[] args) {
        iterateMethod1();
//        iterateMethod2();
    }

    public static void iterateMethod1() {
//        List<String> strings = Arrays.asList(new String("aaa"), new String("bbb"), new String("ccc"));

        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");

        /* for (int i=0; i<20; i++) {
            strings.add("aaa");
            strings.add("bbb");
            strings.add("ccc");
        } */

        int index = 0;

        for (String string: strings) {
            if (string.startsWith("b")) {
                strings.remove(index);
            }
            index += 1;
        }

        System.out.println("Number of elements = " + strings.size());
    }

    public static void iterateMethod2() {
        ArrayList<String> strings = new ArrayList<>();

        for (int i=0; i<20; i++) {
            strings.add("aaa");
            strings.add("bbb");
            strings.add("ccc");
        }

        /* Note that Iterator.remove() is the only safe way to modify a collection during iteration;
           the behavior is unspecified when the underlying collection is modified in any other way while
           the iteration is in progress.
         */

        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            if (iterator.next().startsWith("b")) {
                iterator.remove();
            }
        }

        System.out.println("Number of elements = " + strings.size());
    }
}
