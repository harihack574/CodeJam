package Jam;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AllYourbaseTest {

	@Test
	public void getBaseValue1() {
		assertEquals(AllYourbase.getBaseValue("11001001", 2), 201 + "");
	}

	@Test
	public void getDec() {

		assertEquals(AllYourbase.getDec("11001001"), 201 + "");

	}

	@Test
	public void main() {
	}
}
