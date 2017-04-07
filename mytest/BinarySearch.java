
public class BinarySearch {

	private static final int FAILURE = -1;

	/**
	* Find the index of findMe in an sorted array.
	* @Return return the index of findMe in arr, otherwise return -1;
	*/
	public static int search(int[] arr, int findMe) {
		return search(arr, findMe, 0, arr.length - 1);
	}

	/**
	* Find the index of findMe in arr from "left" to "right"
	*
	*/
	private static int search(int[] arr, int findMe, int left, int right) {
		if (left > right) {
			return FAILURE;
		}
		int mid = (left + right) / 2;
		if (findMe == arr[mid]) {
			return mid;
		}
		else if (findMe < arr[mid]) {
			return search(arr, findMe, left, mid - 1);
		}
		else {
			return search(arr, findMe, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 9, 18, 23};
		System.out.println(search(arr, 18) + " it should be 4");
		System.out.println(search(arr, 3) + " it should be -1");
	}
}