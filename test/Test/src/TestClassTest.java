import static org.junit.Assert.*;

import org.junit.Test;

public class TestClassTest {

	@Test
	public void test() {
		if(TestClass.sum(1, 3) != (1+3)){
			fail("Invalid Answer");
		}
		if(TestClass.multiply(1, 2)==0){
			fail("Not implemented yet");
		}
		

	}

}
