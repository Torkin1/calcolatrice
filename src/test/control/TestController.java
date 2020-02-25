package test.control;

import org.junit.Assert;
import org.junit.Test;
import logic.control.Controller;

public class TestController {
	@Test
	public void testDoAdd() {
		
		int first = 4;
		int second = 5;
		
		Assert.assertEquals(Controller.getReference().doAdd(first, second), first - second, 0.1);
	}
}
