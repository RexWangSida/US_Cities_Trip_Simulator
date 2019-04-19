package Graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BFSTest {
	private city[] x ;
	BFS B;
	Iterable <Integer> result;
	@Before
	public void Setup() throws Exception{
		CityGraph a = new CityGraph();
		a.add_all_edges();
		x = dataRead.Build_cities();
		code_to_name.resort(x,x.length);
		B = new BFS(a,0);
		result = B.pathTo(21);
	}

	@Test
	public void testhasPathTo() {
		for(int i = 1; i < 32; i ++)
			assertTrue(B.hasPathTo(i));
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
		assertTrue(((Stack<Integer>)result).pop() == 21);
	}



}
