package org.example.string;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


class test {

  public static Integer a = 1;
}

public class StringProblem {

  public static void main(String args[]) throws FileNotFoundException {

  /*  List<String> list = List.of("Tejas", "Aish", "LM3");

    list.stream()
        .filter(name -> name.startsWith("T"))
        .collect(Collectors.toList());*/

    System.out.println(test.a++);
    System.out.println(test.a);




        /*String str = "ABC";
        char[] char1 = str.toCharArray();
        String rev = "";
        for (char a : char1) {
            rev = a + rev;
        }

        System.out.println(char1.length);
        int temp;
        boolean flag;
        int[] arr = {1, 2, 3, 4, 1, 2};
        do {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

            }
        } while (flag);

        for (int i : arr) {
            System.err.print(i + " ");
        }*/

        /*int a = 10;
        int b = 20;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a + " " + b);*/
//
//    FunctionalInterface1 add = (i, j) -> i + j;
//    System.out.println(add.opp(1, 2));
//
//    List<List> list = new ArrayList<>();
//    list.add(List.of(1, 2, 3, 4));
//    list.add(List.of(5, 6, 7, 8));
//    list.add(List.of(9, 10, 3, 4));
//    var list1 = list.stream().flatMap(Collection::stream).collect(Collectors.toSet());
//    System.out.println(list1);

        /*List<String> list = new ArrayList<>(List.of("Tejas", "Sam", "Ganesh"));
        List<Character> charList = new ArrayList<>();
        list.forEach(str -> {
            // Convert each string to a char array and add all characters to the charList
            for (char c : str.toCharArray()) {
                charList.add(c);
            }
        });
        System.out.println(charList);*/

        /*List<List<String>> list = new ArrayList<>();
        list.add(List.of("AA", "BB"));
        list.add(List.of("CC", "DD"));
        list.add(List.of("CC", "DD"));
        var list1 = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(list1);*/
       /* Map<String, String> map = new HashMap<>();
        map.put("Name", "Tejas");
        map.put("Surname", "Garud");
        map.put("email", "email");*/
        /*for (var stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
*/

        /*var map1 = map.entrySet().iterator();
        while (map1.hasNext()) {
            var itr = map1.next();
            System.out.println(itr.getKey() + " " + itr.getValue());
        }*/

//        Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();

        /*while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }*/


       /*

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    sum = sum + Integer.valueOf(String.valueOf(sb));
                    sb.setLength(0);
                }
            }
        }

        if (sb.length() > 0) {
            sum = sum + Integer.valueOf(String.valueOf(sb));
        }
        */
//    String str = "Teejas";
//    String vowel = "aeiouAEIOU";
//    int sum = 0;
//    for (int i = 0; i < str.length(); i++) {
//      if (vowel.contains(String.valueOf(str.charAt(i)))) {
//        sum += 1;
//      }
//    }
//    System.out.println(sum);
//
//    List<String> s = new ArrayList<>(List.of("a", "b", "c"));

    test();

  }


  public static String test() {
    try {
      System.out.println("Test ...");
//      System.exit(1);
      return "test ...";
    } catch (Exception e) {
      System.out.println("catch ...");
    } finally {
      System.out.println("Finally ...");
    }
    return "Null";
  }

}
