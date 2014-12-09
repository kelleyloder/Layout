/*  Layout (Array Operations)
 *  by Rajveer Parikh and Kelley Loder
 */


package layout;

import java.util.Arrays;

import layout.Layout;

public class Layout {
	
	int layoutArray[][] = {{}};

	public Layout(int[][] array) {
	//constructor that creates new Layout when given a 2D array
		if(array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty");
		}
		
		layoutArray = array;
	}

	public Layout(int[] array) {
	//constructor that creates new Layout when given a 1D array
		if(array.length == 0) {
			throw new IllegalArgumentException("Array cannot be empty");
		}
		
		layoutArray[0] = array;
	}
	
	public Layout(int length) {
	//constructor that creates new Layout when given a length
		if(length == 0) {
			throw new IllegalArgumentException("Length cannot be 0");
		}
		
		int[] newArray;
		newArray = new int[length];
		for(int i = 0; i < length; i++) {
			newArray[i] = i + 1;
		}
		
		layoutArray[0] = newArray;
	}
	
	public Layout reverse() {
	//reverses this.layoutArray and and creates and returns a new Layout with it		
		int row = this.rowCount();
		int col = this.columnCount();
		int[][] reverseArray = this.layoutArray;
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col / 2; j++) {
				int temp = reverseArray[i][j];
				reverseArray[i][j] = reverseArray[i][col - j - 1];
				reverseArray[i][col - j - 1] = temp;
			}
		}
		
		return new Layout(reverseArray);
	}


	public Layout rotateRight() {
	//rotates this.layoutArray 90 degrees to the right and creates and returns a new Layout with it		
		int rowNewArray = this.columnCount();
		int colNewArray = this.rowCount();
		int rotateRight[][] = new int[rowNewArray][colNewArray];
		
		for(int i = 0; i < rowNewArray; i++) {
			for(int j = 0; j < colNewArray; j++) {
				rotateRight[i][j] = layoutArray[this.rowCount() - j - 1] [i];
			}
		}

		return new Layout(rotateRight);
	}
	
	public Layout rotateLeft() {
	//rotates this.layoutArray 90 degrees to the left and creates and returns a new Layout with it		
		int rowNewArray = this.columnCount();
		int colNewArray = this.rowCount();
		int rotateLeft[][] = new int[rowNewArray][colNewArray];
		
		for(int i = 0; i < rowNewArray; i++) {
			for(int j = 0; j < colNewArray; j++) {
				rotateLeft[i][j] = layoutArray[j] [this.columnCount() - i - 1];
			}
		}

		return new Layout(rotateLeft);
	}
	
	public Layout transpose() {
	//transposes this.layoutArray and creates and returns a new Layout with it		
		int rowNewArray = this.columnCount();
		int colNewArray = this.rowCount();
		int transpose[][] = new int[rowNewArray][colNewArray];
		
		for(int i = 0; i < rowNewArray; i++) {
			for(int j = 0; j < colNewArray; j++) {
				transpose[i][j] = layoutArray[j] [i];
			}
		}

		return new Layout(transpose);
	}
	
	public Layout ravel(int n) {
	//transforms this.layoutArray (that only has 1 row) into n columns and creates and returns a new Layout with it		
		if(this.columnCount() % n != 0) {
			throw new IllegalArgumentException("Number of columns must be evenly divisible by n");
		}
		
		int cols = n;
		int rows = this.columnCount() / cols ;
		int[][] ravelArray;
		ravelArray = new int[rows][cols];
		int counter = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				ravelArray[i][j] = layoutArray[0][counter];
				counter++;
			}
		}
		
		return new Layout(ravelArray);
	}
	
	public Layout unravel() {
	//transforms this.layoutArray into array with 1 row and creates and returns a new Layout with it		
		int cols = this.columnCount() * this.rowCount();
		int[][] unravelArray;
		unravelArray = new int[1][cols];
		int counter = 0;
		
		for(int i = 0; i < this.rowCount(); i++) {
			for(int j = 0; j < this.columnCount(); j++) {
				unravelArray[0][counter] = layoutArray[i][j];
				counter++;
			}
		}
		
		return new Layout(unravelArray);
	}
	
	public Layout reshape(int n) {
	//transforms this.layoutArray (with any # rows) into array with n rows and creates and returns a new Layout with it		
		if((this.columnCount() * this.rowCount()) % n != 0) {
			throw new IllegalArgumentException("Rows * columns must be evenly divisible by n");
		}
		
		Layout somethingUnravel = this.unravel();
		return somethingUnravel.ravel(n);		
	}
	
	public Layout join(Layout layout) {
	//joins together this.layoutArray and layout.layoutArray into one array, then creates and returns a new Layout
		if(this.rowCount() != layout.rowCount()) {
			throw new IllegalArgumentException("Number of rows in each array must be equal");
		}
		
		int totalCols = layout.columnCount() + this.columnCount();
		int[][] joinArray;
		joinArray = new int[this.rowCount()][totalCols];
		
		for(int i = 0; i < this.rowCount(); i++) {
			for(int j = 0; j < this.columnCount(); j++) {
				joinArray[i][j] = this.layoutArray[i][j];	
			}
		}
		
		for(int i = 0; i < this.rowCount(); i++) {
			for(int j = 0; j < layout.columnCount(); j++) {
				joinArray[i][j + this.columnCount()] = layout.layoutArray[i][j];
			}
		}
		
		return new Layout(joinArray);
	}
	
	public Layout stack(Layout layout) {
	//stacks up this.layoutArray and layout.layoutArray into one array, then creates and returns a new Layout
		if(this.columnCount() != layout.columnCount()) {
			throw new IllegalArgumentException("Number of columns in each array must be equal");
		}
		
		int totalRows = layout.rowCount() + this.rowCount();
		int[][] stackArray;
		stackArray = new int[totalRows][this.columnCount()];
		
		for(int i = 0; i < this.rowCount(); i++) {
			stackArray[i] = this.layoutArray[i];	
		}
		
		for(int i = 0; i < layout.rowCount(); i++) {
			stackArray[i + this.rowCount()] = layout.layoutArray[i];
		}
		
		return new Layout(stackArray);
	}
	
	public int rowCount() {
	//returns the number of rows in this.layoutArray
		return layoutArray.length;
	}

	public int columnCount() {
	//returns the number of columns in this.layoutArray
		return layoutArray[0].length;
	}
	
	public Layout rows(int firstRow, int lastRow) {
	//creates array from this.layoutArray only from firstRow and lastRow, then creates and returns a new Layout
		if(firstRow > lastRow) {
			throw new IllegalArgumentException("First row can't be bigger than last row");
		}
		
		else if(lastRow >= this.rowCount()) {
			throw new IllegalArgumentException("Not enough rows");
		}
		
		int rows = lastRow - firstRow + 1;
		int cols = this.columnCount();
		int[][] rowsArray;
		rowsArray = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			rowsArray[i] = this.layoutArray[i + firstRow];
		}
		
		return new Layout(rowsArray);
	}
	
	public Layout columns(int firstColumn, int lastColumn) {
	//creates array from this.layoutArray only from firstColumn and lastColumn, then creates and returns a new Layout
		if (firstColumn > lastColumn) {
			throw new IllegalArgumentException("First column can't be bigger than last column");
		}
		
		else if(lastColumn >= this.columnCount()) {
			throw new IllegalArgumentException("Not enough columns");
		}
		
		int rows = this.rowCount();
		int cols = lastColumn - firstColumn + 1;
		int[][] columnsArray;
		columnsArray = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				columnsArray[i][j] = this.layoutArray[i][j + firstColumn];
			}
		}
		
		return new Layout(columnsArray);
	}
	
	public Layout slice(int firstRow, int lastRow, int firstColumn, int lastColumn) {
	//creates array from this.layoutArray using input params as boundaries, then creates and returns a new Layout
		if (firstColumn > lastColumn) {
			throw new IllegalArgumentException("First column can't be bigger than last column");
		}
		
		else if(firstRow > lastRow) {
			throw new IllegalArgumentException("First row can't be bigger than last row");
		}
		
		else if(lastRow >= this.rowCount()) {
			throw new IllegalArgumentException("Not enough rows");
		}
		
		else if(lastColumn >= this.columnCount()) {
			throw new IllegalArgumentException("Not enough columns");
		}
		
		int rows = lastRow - firstRow + 1;
		int cols = lastColumn - firstColumn + 1;
		int[][] sliceArray;
		sliceArray = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sliceArray[i][j] = this.layoutArray[i + firstRow][j + firstColumn];
			}
		}
		
		return new Layout(sliceArray);
	}
	
	public Layout replace(Layout layout, int row, int column) {
	//replaces portion of this.layoutArray with layout.layoutArray, then creates and returns a new Layout
		if ((row + layout.rowCount()) > this.rowCount()) {
			throw new IllegalArgumentException("Not enough rows");
		}
		else if((column + layout.columnCount()) > this.columnCount()) {
			throw new IllegalArgumentException("Not enough columns");
		}
		
		int[][] replaceArray = this.layoutArray;
		for (int i = 0; i < layout.rowCount(); i++){
			for (int j = 0; j < layout.columnCount(); j++){
				replaceArray[i + row][j + column] = layout.layoutArray[i][j];
			}
		}

		return new Layout(replaceArray);		
	}
	
	@Override
	public boolean equals(Object o) {
	//override for establishing whether two objects are equal
		//Check if other is an instance of Layout
		if (!(o instanceof Layout)) {
			return false;
		}
		
		//Cast o to a Layout object
		Layout that = (Layout) o;
		
		if(that.rowCount() != this.rowCount()) {
			return false;
		}
		
		if(that.columnCount() != this.columnCount()) {
			return false;
		}
		
		for(int i = 0; i < this.rowCount(); i++) {
			for(int j = 0; j < this.columnCount(); j++) {
				if(that.layoutArray[i][j] != this.layoutArray[i][j]) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	@Override
	public int hashCode() {
	
		return Arrays.deepHashCode(layoutArray);
	}
	
	public int[] toArray1D() {
	//returns 1D array
		Layout that = this.unravel();
		return that.layoutArray[0];
	}
	
	public int[][] toArray2D() {
	//returns 2D array
		Layout that = new Layout(this.layoutArray);
		return that.layoutArray;
	}
	
	public int at(int row, int column) {
	//returns value at row, col of this.layoutArray
		return layoutArray[row][column];
	}
}
