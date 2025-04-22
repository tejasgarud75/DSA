package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayProblem {

  public static void main(String args[]) throws FileNotFoundException {


   /* int len = arr.length;

    System.out.println(secondNumber(arr, len));
    System.out.println(isSorted(arr));
    System.out.print(removeDuplicate(arr));
    leftRotate(arr);
    leftRotateByD(arr, 4);
    int num = 4;
    revArray(arr, 0, num);
    revArray(arr, num, arr.length + num);
    revArray(arr, 0, arr.length);*/
//    moveZeroToLast(arr);
//    moveZeroToLast2Pointer(arr);

//    System.out.println(intersectionOfTwoArray(arr, arr2));
//    System.out.println(missingNumber(arr, 5));

//    int[] arr = {1, 9, 8, 8};
//    arr = plusOne(arr);
//    System.out.println();
//    for (int no : arr) {
//      System.out.print(no + " ");
//    }
//    System.out.println();
//  }

    //          1,3,5,6
    int[] arr = {2, 2, 3, 1, 1, 1, 1, 9, 2, 1};

    System.out.println(longestSubArray(arr, 4));

  }

  public static int longestSubArray(int[] arr, int sum) {
    int max = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      int sum1 = 0;
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        sum1 = sum1 + arr[j];
        count++;
        if (sum1 == sum && max < count) {
          max = count;
        } else if (sum1 > sum) {
          break;
        }
      }
    }
    return max;

  }

  public static int consecutive(int[] arr) {
    int max = 0;
    int cons = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        if (cons > max) {
          max = cons;
        }
        cons = 0;
      } else {
        cons++;
      }
    }
    if (cons > max) {
      max = cons;
    }

    return max;
  }


  public static int[] plusOne(int[] digits) {
    int n = digits.length;

    for (int i = n - 1; i >= 0; i++) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }
    digits = new int[n + 1];
    digits[0] = 1;
    return digits;
  }

  public static int searchInsert(int[] nums, int target) {
    if (target == 0) {
      return 0;
    }
    int counter = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == target) {
        return i;
      } else if (nums[i] < target && target < nums[i + 1]) {
        return i + 1;
      } else {
        counter = i;
      }
    }
    return counter + 2;

  }

  public static int removeElement(int[] nums, int val) {
    int counter = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[counter] = nums[i];
        counter++;
      }
    }
    return counter;
  }

  private static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int counter = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[counter] != nums[i]) {
        counter++;
        nums[counter] = nums[i];
      }
    }
    return counter + 1;
  }

  private static int missingNumber(int[] arr, int no) {

    ArrayList arrayList = new ArrayList();

    for (int i = 0; i < arr.length; i++) {
      arrayList.add(i, arr[i]);
    }
    for (int i = 0; i < arrayList.size(); i++) {
      if (!arrayList.contains(i + 1)) {
        return i + 1;
      }
    }
    return -1;
  }

  private static ArrayList unionOfArrayUsingSet(int[] arr, int[] arr2) {
    Set set = new HashSet();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      set.add(arr2[i]);
    }
    return new ArrayList(set);
  }

  private static ArrayList intersectionOfTwoArray(int[] arr, int[] arr2) {
    ArrayList arrayList = new ArrayList();
    var count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr2.length; j++) {
        if (arr[i] == arr2[j]) {
          arrayList.add(arr[i]);
        }
        count++;
      }
    }
    System.out.println(count);
    return arrayList;
  }

  // 1,2,0,2,0
  public static void moveZeroToLast(int[] arr) {

    ArrayList arrayList = new ArrayList();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        arrayList.add(arr[i]);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      if (!arrayList.isEmpty()) {
        arr[i] = (int) arrayList.get(0);
        arrayList.remove(0);
      } else {
        arr[i] = 0;
      }
    }

  }

  public static void moveZeroToLast2Pointer(int[] arr) {

    int j = 0;
    for (int i = 0; i < arr.length; i++) {  // 1 0 1 0 2 3 0 4
      if (arr[i] == 0) {
        j = i;
        break;
      }
    }
    for (int i = j; i < arr.length - 1; i++) {
      if (arr[i + 1] != 0) {
        int temp = arr[i + 1];
        arr[i + 1] = arr[j];
        arr[j] = temp;
        j++;
      }
    }

  }

  public static void revArray(int[] arr, int start, int no) {
    for (int i = start; i < no / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[no - i - 1];
      arr[no - i - 1] = temp;
    }
  }

  public static void leftRotateByD(int[] arr, int index) {
    int[] temp = new int[index];
    int count = 0;
    for (int i = 0; i < index; i++) {
      temp[i] = arr[i];
    }
    for (int i = index; i < arr.length; i++) {
      arr[i - index] = arr[i];
    }
    for (int i = arr.length - index; i < arr.length; i++) {
      arr[i] = temp[count++];
    }

  }

  public static void leftRotate(int[] arr) {
    int firstNo = arr[0];
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = firstNo;

  }

  private static int secondNumber(int[] arr, int len) {
    int larNo = arr[0];
    int secondNo = arr[1];

    if (secondNo > larNo) {
      int temp = larNo;
      larNo = secondNo;
      secondNo = temp;
    }

    for (int i = 2; i < len; i++) {
      if (secondNo < arr[i] && arr[i] != secondNo && arr[i] != larNo) {

        secondNo = arr[i];
        if (secondNo > larNo) {
          int temp = larNo;
          larNo = secondNo;
          secondNo = temp;

        }
      }
    }

    return secondNo;

  }

  public static boolean isSorted(int[] arr) {
    boolean isSorted = true;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] < arr[i + 1]) {
        isSorted = false;
        break;
      }

    }
    return isSorted;
  }

  public static ArrayList removeDuplicate(int[] arr) {
    ArrayList arrayList = new ArrayList<>();

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] != arr[i + 1]) {
        arrayList.add(arr[i]);
      }
    }
    return arrayList;
  }


}
