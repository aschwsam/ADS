package p02;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MyStackTest {

	@Test
	public void shouldReturnTrueOnEmptyStack(){
		MyStack stack = new MyStack();
		
		assertTrue(stack.isEmpty());
	}

	@Test
	public void shouldReturnFalseOnStackWithElements(){
		MyStack stack = new MyStack();
		stack.push(1);
		
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void shouldPopElementsInReversedPushOrder(){
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		for(int i=4;i>0;i--){
			assertEquals(i, stack.pop());
		}
	}
	
	@Test
	public void shouldTakeIntegerAsPushArgument(){
		MyStack stack = new MyStack();
		
		stack.push(1);
	}
	
	@Test
	public void shouldTakeObjectAsPushArgument(){
		MyStack stack = new MyStack();
		
		stack.push(new Object());
	}
	
	@Test
	public void shouldNotRemoveElementOnTop(){
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		assertEquals(stack.top(),stack.pop());
	}
}
