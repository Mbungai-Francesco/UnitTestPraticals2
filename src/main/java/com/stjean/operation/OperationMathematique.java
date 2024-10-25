package com.stjean.operation;

public class OperationMathematique {

  public boolean estPositif(int a) {
    return a > 0;
  }

  public int factorial(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * factorial(n - 1);
    }
  }

  public int[] sort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j] < array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }
}
