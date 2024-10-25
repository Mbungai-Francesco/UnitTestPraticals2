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
}
