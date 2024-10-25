package test;
	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;


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
	    
	    @Test
	    public void testSort() {
	        OperationMathematique op = new OperationMathematique();
	        Integer[] input = {1, 5, 3, 9, 2};
	        Integer[] expected = {9, 5, 3, 2, 1};
	        assertArrayEquals(expected, op.sort(input));
	    }

	}

