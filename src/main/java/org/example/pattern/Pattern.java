package org.example.pattern;

public class Pattern {


  public static void main(String args[]) {

//    patter1();
//    patter2();
//    patter3();
//    pattern2();
//
//    pattern11();
//    pattern14();
//    pattern15();
//    pattern16();
//    pattern17();
//    pattern18();
    pattern19();

  }

  private static void pattern19() {
    int no = 5;
    for (int i = 0; i <= no / 2; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }

    for (int i = no/2-1; i >=0; i--) {
      for (int j = i; j >= 0; j--) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }


  public static void patter1() {

    for (int i = 0; i <= 5; i++) {
      //space
      for (int j = 0; j < 5 - i; j++) {
        System.out.print(" ");
      }
      //star
      for (int j = 0; j < i * 2 + 1; j++) {
        System.out.print("*");
      }
      //space
      for (int j = 0; j < 5 - i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static void patter2() {

    for (int i = 0; i <= 5; i++) {
      //space
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }

      //stars
      for (int j = 0; j < 5 * 2 - (2 * i) + 1; j++) {
        System.out.print("*");
      }

      //space
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static void patter3() {

    int no = 5;

    for (int i = 0; i <= no; i++) {
      //space
      for (int j = 0; j < no - i; j++) {
        System.out.print(" ");
      }

      //stars
      for (int j = 0; j < i * 2 + 1; j++) {
        System.out.print("*");
      }

      //space
      for (int j = 0; j < no - i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }

    for (int i = 0; i <= no; i++) {
      //space
      for (int j = 0; j < i + 1; j++) {
        System.out.print(" ");
      }

      //stars
      for (int j = 0; j < no * 2 - ((2 * i) + 1); j++) {
        System.out.print("*");
      }

      //space
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  public static void pattern4() {
    int no = 5;
    for (int i = 1; i <= (no * 2) - 1; i++) {
      int row = i;
      if (row > no) {
        row = (no * 2) - i;
      }
      for (int j = 1; j <= row; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

  public static void pattern5() {
    int no = 5;
    for (int i = 0; i <= no; i++) {
      boolean flag = true;
      if (i % 2 == 0) {
        flag = true;
      } else {
        flag = false;
      }
      for (int j = 0; j <= i; j++) {
        System.out.print(flag ? "1 " : "0 ");
        flag = !flag;
      }
      System.out.println();
    }
  }

  public static void pattern6() {
    int no = 4;
    for (int i = 1; i <= no; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(j);
      }
      for (int j = 0; j < (no * 2) - (2 * i); j++) {
        System.out.print(" ");
      }
      for (int j = i; j >= 1; j--) {
        System.out.print(j);
      }
      System.out.println();
    }
  }

  public static void pattern7() {
    int no = 10;
    int num = 1;
    for (int i = 1; i <= no; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(num++ + " ");
      }
      System.out.println();
    }
  }

  public static void pattern8() {
    int no = 5;
    for (int i = 1; i <= no; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print((char) (j + 64) + " ");
      }
      System.out.println();
    }
  }

  public static void pattern9() {
    int no = 5;
    for (int i = 1; i <= no; i++) {
      for (int j = 0; j <= no - i; j++) {
        System.out.print((char) (j + 65) + " ");
      }
      System.out.println();
    }
  }

  public static void pattern10() {
    int no = 5;
    for (int i = 1; i <= no; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print((char) (i + 64) + " ");
      }
      System.out.println();
    }
  }

  public static void pattern11() {
    int no = 5;
    for (int i = 0; i < no; i++) {

      for (int j = 1; j <= no - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= 2 * i + 1; j++) {
        System.out.print("*");
      }
      for (int j = 1; j <= no - i; j++) {
        System.out.print(" ");
      }

      System.out.println();
    }
  }

  public static void pattern12() {
    int no = 5;
    for (int i = 0; i < no; i++) {
      for (int j = 1; j < no - i; j++) {
        System.out.print(" ");
      }
      char c = 'A';
      int breakpoint = (i * 2 + 1) / 2;
      for (int j = 0; j < i * 2 + 1; j++) {
        System.out.print(c);
        if (breakpoint > j) {
          c++;
        } else {
          c--;
        }
      }
      for (int j = 1; j < no - i; j++) {
        System.out.print(" ");
      }
      System.out.println();
    }

  }

  private static void pattern13() {
    int no = 5 + 1;
    char c = 'A';
    c += no - 1;
    for (int i = 0; i < no; i++) {
      char temp = (char) (c - i);
      for (int j = 1; j <= i; j++) {
        System.out.print(temp++);
      }
      if (i != 0) {
        System.out.println();
      }
    }
  }

  private static void pattern14() {
    int no = 5;

    for (int i = 0; i < no; i++) {
      System.out.println();
      for (int j = 0; j < no - i; j++) {
        System.out.print("*");
      }
      for (int j = 0; j < i * 2; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < no - i; j++) {
        System.out.print("*");
      }
    }
    for (int i = 0; i <= no; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      for (int j = 0; j < no * 2 - (i * 2); j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void pattern15() {
    int no = 5;
    for (int i = 1; i <= no; i++) {

      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }

      for (int j = 1; j <= no * 2 - (i * 2); j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = 1; i <= no - 1; i++) {
      for (int j = 0; j < no - i; j++) {
        System.out.print("*");
      }

      for (int j = 1; j <= i * 2; j++) {
        System.out.print(" ");
      }

      for (int j = 0; j < no - i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

  public static void pattern17() {
    int no = 5;

    for (int i = 1; i <= no; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }


  public static void pattern16() {
    int no = 5;
    for (int i = 0; i < no; i++) {

      for (int j = 0; j < no; j++) {
        if (i == 0 || i == no - 1 || j == 0 || j == no - 1) {
          System.out.print(" *");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }

  private static void pattern18() {

    int no = 5;
    int line = no + (no - 1);

    for (int i = 1; i <= line; i++) {
      for (int j = 1; j <= line; j++) {

        int top = i - 1;
        int bottom = line - i;
        int left = j - 1;
        int right = line - j;

        int layer = top;
        if (bottom < layer) {
          layer = bottom;
        }
        if (left < layer) {
          layer = left;
        }
        if (right < layer) {
          layer = right;
        }
        System.out.print((layer + 1) + " ");
      }
      System.out.println();
    }

  }


}
