package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.stjean.operation.OperationMathematique;

public class TestOperationMathematique {

    @Test
    public void testEstPositif() {
        OperationMathematique op = new OperationMathematique();
        assertTrue(op.estPositif(5));
        assertFalse(op.estPositif(-3));
    }

    @Test
    public void testFactorial() {
        OperationMathematique op = new OperationMathematique();
        assertEquals(1, op.factorial(0));
        assertEquals(120, op.factorial(5));
    }
}
