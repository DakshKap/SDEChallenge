package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.MovingAverage;
import main.MovingAverageArrayList;

class MovingAverageArrayLTest {

	@Test
	public void testEmptyList() throws Exception {
		MovingAverage ma = new MovingAverageArrayList(5);
		assertEquals(0, ma.getAverage());
	}
	
	@Test
	public void testNotFullWindow() throws Exception {
		MovingAverage ma = new MovingAverageArrayList(5);
		ma.add(10);
		ma.add(30);
		ma.add(20);
		assertEquals(20, ma.getAverage());
	}
	
	@Test
	public void testMovingWindow() throws Exception {
		MovingAverage ma = new MovingAverageArrayList(5);
		ma.add(10);
		ma.add(20);
		ma.add(30);
		assertEquals(20, ma.getAverage());
		ma.add(10);
		ma.add(20);
		ma.add(400);
        assertEquals(96, ma.getAverage());
        ma.add(1000);
        ma.add(1);
        ma.add(399);
        assertEquals(364, ma.getAverage());
	}
	
	@Test
	public void testPerformance() throws Exception {
		int windowSize = 100000;
		int storageSize = 1000000;
		MovingAverage ma = new MovingAverageArrayList(windowSize);
		long startTime = System.currentTimeMillis();
		for(int i=0; i<storageSize ;i++) {
			ma.add(5000);
		}
		assertEquals(5000, ma.getAverage());
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("Performance test took " + duration + " ms");
	}

}
