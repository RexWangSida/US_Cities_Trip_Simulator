package Graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DFSTest {
	private city[] x ;
	DFS D;
	Iterable <Integer> result;
	@Before
	public void setUp() throws Exception {
		CityGraph a = new CityGraph();
		a.add_all_edges();
		x = dataRead.Build_cities();
		code_to_name.resort(x,x.length);
		D = new DFS(a,0);
		result = D.pathTo(21);
	}

	@Test
	public void testhasPathTo() {
		for(int i = 1; i < 32; i ++)
			assertTrue(D.hasPathTo(i));
	}
	
	@Test
	public void testPathTo1() {
		for(int i = 0; i < 0; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 0);
	}
	
	@Test
	public void testPathTo2() {
		for(int i = 0; i < 1; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 1);
	}
	
	@Test
	public void testPathTo3() {
		for(int i = 0; i < 2; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 7);
	}
	
	@Test
	public void testPathTo4() {
		for(int i = 0; i < 3; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 8);
	}
	
	@Test
	public void testPathTo5() {
		for(int i = 0; i < 4; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 20);
	}
	
	@Test
	public void testPathTo6() {
		for(int i = 0; i < 5; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 10);
	}
	
	@Test
	public void testPathTo7() {
		for(int i = 0; i < 6; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 17);
	}
	
	@Test
	public void testPathTo8() {
		for(int i = 0; i < 7; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 13);
	}
	
	@Test
	public void testPathTo9() {
		for(int i = 0; i < 8; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 29);
	}
	
	@Test
	public void testPathTo10() {
		for(int i = 0; i < 9; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 23);
	}
	
	@Test
	public void testPathTo11() {
		for(int i = 0; i < 10; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 12);
	}
	
	@Test
	public void testPathTo12() {
		for(int i = 0; i < 11; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 22);
	}
	
	@Test
	public void testPathTo13() {
		for(int i = 0; i < 12; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 27);
	}
	
	@Test
	public void testPathTo14() {
		for(int i = 0; i < 13; i++)
			((Stack<Integer>)result).pop();
		assertTrue(((Stack<Integer>)result).pop() == 21);
	}
}
