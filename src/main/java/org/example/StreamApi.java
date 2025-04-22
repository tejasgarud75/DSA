package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.sort;

public class StreamApi {

  public static void main(String[] args) {

       /* List<Integer> i = List.of(1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10, 28);

        i = i.stream().filter(j -> j % 2 == 0).collect(Collectors.toList());

        System.out.println(i);*/

//    List<Integer> arr = List.of(1, 2, 3, 4);
//
//    var response = arr.stream()
//        .map(i -> i * 2)
//        .collect(Collectors.toList());

//        System.out.println(stream);

//        List<String> n = Arrays.stream(name).filter(c -> c.startsWith("N")).collect(Collectors.toList());

//        System.out.println("N = " + n);

//        List<Integer> list = List.of(1, 2, 3, 4, 0);
//        list = list.stream().filter(in -> in % 2 == 0).collect(Collectors.toList());
//        System.out.println(list);

//        String str = "bas";
//        String str1 = "abs";

//        var strA = str.toCharArray();
//        sort(strA);
//        var strB =str1.toCharArray();
//        sort(strB);
//        if(Arrays.toString(strB).equals(Arrays.toString(strA))){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }

//        Arrays.stream(arr).max();
//        System.out.println(Arrays.stream(arr).max().getAsInt());
//        arr = Arrays.stream(arr).sorted().toArray();
//        System.out.println(Arrays.toString(arr));

//        String sortedStr = new String(strA);
//        Integer i = list.stream().max(Integer::compareTo
//        ).get();
//        System.out.println(sortedStr);

//        int arr[]={1,40,2,3,0 ,5,6,89};
//        sort(arr);
//        int i = arr[arr.length-2];
//        System.out.println(i);

        /*String name="aaayytt";

        var arr=name.toCharArray();
        Map<Character, Integer>  list = new HashMap<>();
        for (char c : arr){
            if (list.containsKey(c)){
                list.put(c, list.get(c)+1);
            }else {
                list.put(c,1);
            }
        }

        System.out.println(list);

        Map<String, Integer> map = new HashMap();

        for (var ii : map.entrySet()) {
            System.out.println("Key :" + ii.getKey() + "Value :" + ii.getValue());
        }*/

        /*String abc = "aaBBss";
        Map<Character, Integer> map = new HashMap<>();

        for (var ii : abc.toCharArray()) {
            if (map.containsKey(ii)) {
                map.put(ii, map.get(ii) + 1);
            } else {
                map.put(ii, 1);
            }
        }

        System.out.println(map);*/
   /* try {
      recursiveMethod();
    } catch (Exception e) {
      System.out.println("AHHAHHA");
    }*/
  }

  static int count = 0;

  public static void recursiveMethod() {
    recursiveMethod(); // Infinite recursion leading to StackOverflowError
  }

}

