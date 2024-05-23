import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalcTest {
	private Calc c;

	@BeforeEach
	void setUp() throws Exception {
		c = new Calc();
		System.out.println("new calc instance");
	}

	@Test
	void testAdd() {
		System.out.println("addition test");
		assertEquals(5, c.add(2, 3), "2 + 3 should equal to 5");
		System.out.println("add test clear: 2 + 3 = " + c.add(2, 3));
	}

	@Test
	void testSub() {
		System.out.println("subtraction test");
		assertEquals(1, c.sub(4, 3), "4 - 3 should equal to 1");
		System.out.println("sub test clear");
	}

	@Test
	void testMul() {
		System.out.println("multiplication test");
		assertEquals(18, c.mul(6, 3), "6 * 3 should equals to 18");
		System.out.println("mul test clear");
	}

	@Test
	void testDiv() {
//		System.out.println("Div test");
//		assertEquals(2, c.div(4, 2), "4 / 2 should equals to 2");
//		System.out.println("div test clear");
		System.out.println("division by zero test");
		assertThrows(IllegalArgumentException.class, () -> c.div(1, 0), "Divisor cannot be zero");
		System.out.println("test clear");
	}
	

}
