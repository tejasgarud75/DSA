package org.example;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;


public class inheritance {


//    public static void main(String[] ik) {
//      Child.sing();
//        Abstract a = new Abstract(){};
//        a.sing();

//        HashMap<String, Integer> object = new HashMap<>();
//        object.put("aa",1);
//        object.put("bb",2);
//        object.put("cc",3);
//        Iterator<String> i = object.keySet().iterator();
//        System.out.println(i.next());
//        ArrayList<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//
//        // Get the iterator
//        Iterator<String> it = cars.iterator();

    // Print the first item
//        System.out.println(it.next());
//        for (Iterator<String> iter = it; iter.hasNext(); ) {
//            String i = iter.next();
//            System.out.println(i);
//
//        }
//        String words = "One Two Three Four";
//        String rev = "";
//        for (int i = 0; i < words.length(); i++) {
//            rev = words.charAt(i) + rev;
//
//        }
//        System.gc();

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 2);
//        map.put(1, 3);
//
//        map.forEach((i, j) -> {
//            System.out.println(i + " " + j);
//        });

//    }

    public static void main(String[] args) {

        String str = "aabbcc";
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            str1 = str.charAt(i) + str1;
        }
        System.out.println(str1);
    }


}

