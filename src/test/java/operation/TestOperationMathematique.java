package operation;

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
    
    assertTrue(res == 120, num + "! = " + res);
  }

}
