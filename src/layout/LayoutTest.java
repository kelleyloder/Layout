/*  Layout Test (Array Operations)
 *  by Rajveer Parikh and Kelley Loder
 */

package layout;

import static org.junit.Assert.*;

import org.junit.Test;

public class LayoutTest {

	@Test(expected = IllegalArgumentException.class)
	public void testLayout2DArray() throws Exception {
		
		int[][] array = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		Layout something = new Layout(array);
		assertArrayEquals(something.layoutArray, array);
		
		int[][] array1;
		array1 = new int[0][0];
		//this one throws an exception
		Layout something1 = new Layout(array1);
		
		// These assertions are never run because Exception was caught
        assertTrue(false);
        assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLayout1DArray() throws Exception {
		
		int[] array = {1, 2, 3, 4, 5};
		int[][] array1 = {{}};
		array1[0] = array;
		Layout something = new Layout(array);
		assertArrayEquals(something.layoutArray, array1);
		
		int[] array2;
		array2 = new int[0];
		//this one throws an exception
		Layout something2 = new Layout(array2);
		
		// These assertions are never run because Exception was caught
        assertTrue(false);
        assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLayoutLength() throws Exception {
		
		int[][]array = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
		Layout something = new Layout(10);
		assertArrayEquals(something.layoutArray, array);
		
		//this one throws an exception
		Layout something1 = new Layout(0);
		
		// These assertions are never run because Exception was caught
        assertTrue(false);
        assertFalse(true);
	}

	@Test
	public void testReverse() {
		
		int[][] array = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		int[][] arrayReverse = {
				{4, 3, 2, 1}, 
				{8, 7, 6, 5}, 
				{12, 11, 10, 9}};
	
		Layout something = new Layout(array);
		Layout somethingReverse = new Layout(arrayReverse);
		assertEquals(something.reverse(), somethingReverse);
	}

	@Test
	public void testRotateRight() {
		
		int[][] array1 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
				
		int[][] array2 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] arrayRotateRight1 = {
				{9, 5, 1}, 
				{10, 6, 2}, 
				{11, 7, 3}, 
				{12, 8, 4}};
		
		int[][] arrayRotateRight2 = {
				{16, 11, 6, 1}, 
				{17, 12, 7, 2}, 
				{18, 13, 8, 3}, 
				{19, 14, 9, 4}, 
				{20, 15, 10, 5}};
		
		Layout something1 = new Layout(array1);
		Layout somethingRotateRight1 = new Layout(arrayRotateRight1);
		assertEquals(something1.rotateRight(), somethingRotateRight1);
		
		Layout something2 = new Layout(array2);
		Layout somethingRotateRight2 = new Layout(arrayRotateRight2);
		assertEquals(something2.rotateRight(), somethingRotateRight2);
	}
	
	@Test
	public void testRotateLeft() {
		
		int[][] array1 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
				
		int[][] array2 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
			
		int[][] arrayRotateLeft1 = {
				{4, 8, 12}, 
				{3, 7, 11}, 
				{2, 6, 10}, 
				{1, 5, 9}};
			
		int[][] arrayRotateLeft2 = {
				{5, 10, 15, 20}, 
				{4, 9, 14, 19}, 
				{3, 8, 13, 18}, 
				{2, 7, 12, 17}, 
				{1, 6, 11, 16}};
		
		Layout something1 = new Layout(array1);
		Layout somethingRotateLeft1 = new Layout(arrayRotateLeft1);
		assertEquals(something1.rotateLeft(), somethingRotateLeft1);
		
		Layout something2 = new Layout(array2);
		Layout somethingRotateLeft2 = new Layout(arrayRotateLeft2);
		assertEquals(something2.rotateLeft(), somethingRotateLeft2); 
	
	}

	@Test
	public void testTranspose() {
		
		int[][] array1 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
				
		int[][] array2 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] arrayTranspose1 = {
				{1, 5, 9}, 
				{2, 6, 10}, 
				{3, 7, 11}, 
				{4, 8, 12}};
		
		int[][] arrayTranspose2 = {
				{1, 6, 11, 16}, 
				{2, 7, 12, 17}, 
				{3, 8, 13, 18}, 
				{4, 9, 14, 19}, 
				{5, 10, 15, 20}};
		
		Layout something1 = new Layout(array1);
		Layout somethingTranspose1 = new Layout(arrayTranspose1);
		assertEquals(something1.transpose(), somethingTranspose1);
		Layout something2 = new Layout(array2);
		Layout somethingTranspose2 = new Layout(arrayTranspose2);
		assertEquals(something2.transpose(), somethingTranspose2); 
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRavel() throws Exception {
		
		int[][] array1 = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};
		
		int[][] arrayRavel1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}};
		
		int[][] arrayRavel2 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
				{10, 11, 12},
				{13, 14, 15}};
		
		Layout something1 = new Layout(array1);
		Layout somethingRavel1 = new Layout(arrayRavel1);
		Layout somethingRavel2 = new Layout(arrayRavel2);
		assertEquals(something1.ravel(5), somethingRavel1);
		assertEquals(something1.ravel(3), somethingRavel2);
		
		int[][] array = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		
		Layout something = new Layout(array);
		//this one throws an exception
		something.ravel(3);
				
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test
	public void testUnravel() {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}};
		
		int[][] array2 = {{1, 2, 3, 4, 5}};
		
		int[][] arrayUnravel = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}};
		
		Layout something1 = new Layout(array1);
		Layout somethingUnravel = new Layout(arrayUnravel);
		Layout something2 = new Layout(array2);
		assertEquals(somethingUnravel, something1.unravel());
		assertEquals(something2, something2.unravel());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testReshape() throws Exception {
		
		int[][] array1 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		
		int[][] array2 = {{1, 2, 3, 4, 5, 6}};
				
		int[][] arrayReshape1 = {
				{1, 2},
				{3, 4}, 
				{5, 6}, 
				{7, 8}, 
				{9, 10}, 
				{11, 12}};
		
		int[][] arrayReshape2 = {{1}, {2}, {3}, {4}, {5}, {6}};
		
		Layout something1 = new Layout(array1);
		Layout somethingReshape1 = new Layout(arrayReshape1);
		Layout something2 = new Layout(array2);
		Layout somethingReshape2 = new Layout(arrayReshape2);
		assertEquals(something1.reshape(2), somethingReshape1);
		assertEquals(something2.reshape(6), something2);
		assertEquals(something2.reshape(1), somethingReshape2);
				
		Layout something = new Layout(array1);
		//this one throws an exception
		something.reshape(5);
				
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testJoin() throws Exception {
		
		int[][] array1 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		
		int[][] array2 = {
				{11, 22},
				{55, 66},
				{99, 100}};
				
		int[][] array3 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}};
		
		int[][] arrayJoin = {
				{1, 2, 3, 4, 11, 22},
				{5, 6, 7, 8, 55, 66},
				{9, 10, 11, 12, 99, 100}};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		Layout something3 = new Layout(array3);
		Layout somethingJoin = new Layout(arrayJoin);
		assertEquals(something1.join(something2), somethingJoin);
	
		//this one throws an exception
		something1.join(something3);
				
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testStack() throws Exception {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] array2 = {
				{21, 22, 23, 24, 25},
				{26, 27, 28, 29, 30},
				{31, 32, 33, 34, 35}};
		
		int[][] arrayStack = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20},
				{21, 22, 23, 24, 25},
				{26, 27, 28, 29, 30},
				{31, 32, 33, 34, 35}};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		Layout somethingStack = new Layout(arrayStack);
		assertEquals(something1.stack(something2), somethingStack);
	
		int[][] array3 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
		
		int[][] array4 = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
		
		Layout something3 = new Layout(array3);
		Layout something4 = new Layout(array4);
	
		//this one throws an exception
		something3.stack(something4);
				
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test
	public void testRowCount() {
		
		int[][] array = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		Layout something = new Layout(array);
		assertEquals(something.rowCount(), 4);
	}

	@Test
	public void testColumnCount() {
		
		int[][] array = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		Layout something = new Layout(array);
		assertEquals(something.columnCount(), 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRows() throws Exception {
		
		int[][] array = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] arrayRows = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}};
		
		Layout something = new Layout(array);
		Layout somethingRows = new Layout(arrayRows);
		assertEquals(something.rows(0, 2), somethingRows);
		
		//this one throws an exception
		something.rows(2, 0);
						
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testColumns() throws Exception {
		
		int[][] array = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] arrayColumns = {
				{2, 3, 4},
				{7, 8, 9},
				{12, 13, 14},
				{17, 18, 19}};
		
		Layout something = new Layout(array);
		Layout somethingColumns = new Layout(arrayColumns);
		assertEquals(something.columns(1, 3), somethingColumns);
		
		//this one throws an exception
		something.columns(2, 5);
								
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSlice() throws Exception {
		
		int[][] array = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] arraySlice = {
				{8, 9, 10},
				{13, 14, 15},
				{18, 19, 20}};
		
		Layout something = new Layout(array);
		Layout somethingSlice = new Layout(arraySlice);
		assertEquals(something.slice(1, 3, 2, 4), somethingSlice);
		
		//this one throws an exception
		something.slice(3, 2, 2, 4);
										
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testReplace() throws Exception {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5, 10},
				{6, 7, 8, 9, 10, 10},
				{11, 12, 13, 14, 15, 10},
				{16, 17, 18, 19, 20, 10}};
		
		int[][] array2 = {
				{55, 66, 77},
				{88, 99, 100}};
		
		int[][] arrayReplace = {
				{1, 2, 3, 4, 5, 10},
				{6, 7, 55, 66, 77, 10},
				{11, 12, 88, 99, 100, 10},
				{16, 17, 18, 19, 20, 10}};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		Layout somethingReplace = new Layout(arrayReplace);
		assertEquals(somethingReplace, something1.replace(something2, 1, 2));
		
		//this one throws an exception
		something1.replace(something2, 0, 4);
												
		// These assertions are never run because Exception was caught
		assertTrue(false);
		assertFalse(true);
	}

	@Test
	public void testEquals() {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] array2 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] array3 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 200}};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		Layout something3 = new Layout(array3);
		assertTrue(something1.equals(something2));
		assertFalse(something1.equals(something3));		
	}

	@Test
	public void testHashCode() {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		int[][] array2 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		assertEquals(something1.hashCode(), something2.hashCode());
	}

	@Test
	public void testToArray1D() {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}};
				
		int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		assertArrayEquals(array2, something1.toArray1D());
		assertArrayEquals(array2, something2.toArray1D());
	}

	@Test
	public void testToArray2D() {
		
		int[][] array1 = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15}};
		
		int[] array2 = {1, 2, 3, 4, 5};
		
		int[][] array3 = {{1, 2, 3, 4, 5}};
		
		Layout something1 = new Layout(array1);
		Layout something2 = new Layout(array2);
		assertArrayEquals(array1, something1.toArray2D());
		assertArrayEquals(array3, something2.toArray2D());		
	}

	@Test
	public void testAt() {
		
		int[][] array = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}};
		
		Layout something = new Layout(array);
		assertEquals(something.at(0, 0), 1);
		assertEquals(something.at(3, 4), 20);
		assertEquals(something.at(1, 3), 9);
	}

}
