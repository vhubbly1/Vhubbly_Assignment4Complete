/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: This Junit Test tests all the Plot methods.
 * Due: 07/13/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Vivek Hubbly
*/
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {
	private Plot plot1, plot2;

	@BeforeEach
	public void setUp() throws Exception {
		plot1 = new Plot(4, 4, 5, 3);
		plot2 = new Plot(1, 1, 2, 3);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		plot1 = plot2 = null;
	}
	
	@Test
	void testPlot() {
		Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
	}

	@Test
	void testOverlaps() {
		Plot plot3 = new Plot(7, 7, 2, 2);
        Plot plot4 = new Plot(10, 10, 2, 2);

 
	}

	@Test
	void testEncompasses() {
		Plot plot3 = new Plot(6, 6, 1, 1);
        Plot plot4 = new Plot(4, 4, 8, 8);

		assertFalse(plot1.encompasses(plot2));
        assertTrue(plot1.encompasses(plot3));
        assertFalse(plot1.encompasses(plot4));
	}

	@Test
	void testGetX() {
		 assertEquals(4, plot1.getX());
	     assertEquals(1, plot2.getX());
	}

	@Test
	void testSetX() {
		plot1.setX(10);
        assertEquals(10, plot1.getX());

        plot2.setX(3);
        assertEquals(3, plot2.getX());
	}

	@Test
	void testGetY() {
		assertEquals(4, plot1.getY());
        assertEquals(1, plot2.getY());
	}

	@Test
	void testSetY() {
		plot1.setY(10);
        assertEquals(10, plot1.getY());

        plot2.setY(3);
        assertEquals(3, plot2.getY());
	}

	@Test
	void testGetWidth() {
		assertEquals(5, plot1.getWidth());
        assertEquals(2, plot2.getWidth());
	}

	@Test
	void testSetWidth() {
		plot1.setWidth(10);
        assertEquals(10, plot1.getWidth());

        plot2.setWidth(3);
        assertEquals(3, plot2.getWidth());
	}

	@Test
	void testGetDepth() {
		assertEquals(3, plot1.getDepth());
        assertEquals(3, plot2.getDepth());
	}

	@Test
	void testSetDepth() {
		plot1.setDepth(10);
        assertEquals(10, plot1.getDepth());

        plot2.setDepth(5);
        assertEquals(5, plot2.getDepth());
	}

	@Test
	void testToString() {
		assertEquals("4,4,5,3", plot1.toString());
        assertEquals("1,1,2,3", plot2.toString());
	}

}
