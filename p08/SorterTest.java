package p08;

import static org.junit.Assert.*;

import org.junit.Test;

public class SorterTest {

	@Test
	public void shouldNotDoAnythingForNull() {
		int[] parameter = null;
		Sorter.sort(parameter);
		assertNull(parameter);
	}
	

	@Test
	public void shouldNotDoAnythingForSingleElement() {
		int[] parameter = {1};
		int[] expected = {1};
		Sorter.sort(parameter);
		assertArrayEquals(expected, parameter);
	}
	
	@Test
	public void shouldKeepAlreadySortedArray() {
		int[] parameter = {-10, -3, 0, 0, 1, 1, 111, 39393939};
		int[] expected = {-10, -3, 0, 0, 1, 1, 111, 39393939};
		Sorter.sort(parameter);
		assertArrayEquals(expected, parameter);
	}
	
	@Test
	public void shouldSortAscending() {
		int[] parameter = {4, -10, 2, 5, -10, 3, 202, -111, 0, 1};
		int[] expected = {-111, -10, -10, 0, 1, 2, 3, 4, 5, 202};
		Sorter.sort(parameter);
		assertArrayEquals(expected, parameter);
	}
	
}
