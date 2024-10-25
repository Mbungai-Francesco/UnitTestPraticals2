package operation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stjean.operation.OperationMathematique;

public class TestOperationMathematique {

  private OperationMathematique operationMathematique;

  @BeforeEach
  public void setUp() {
    operationMathematique = new OperationMathematique();
  }

  @AfterEach
  public void tearDown() {
  }

  @Test
  public void testEstPositif() {
    int num = 5;

    boolean res = operationMathematique.estPositif(num);
    
    assertTrue(res, num + " is negative");
  }

  @Test
  public void testFactorial() {
    int num = 5;

    int res = operationMathematique.factorial(num);
    
    assertEquals(res, 120);
  }

  @Test
  public void sort(){
    int[] tab = {5, 3, 1, 4, 2};
    int[] expected = {5, 4, 3, 2, 1};

    int[] res = operationMathematique.sort(tab);
    
    assertArrayEquals(expected, res);
  }

  @Test
  public void testFactorialNegative(){
    int num = -5;

    try {
      operationMathematique.factorial(num);
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), num + " must be greater than or equal to 0");
    }
  }

}
