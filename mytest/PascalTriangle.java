

public class PascalTriangle {


	public static int[][] constructPascalTriangel(int n) {
		int[][] pt = new int[n][];
		for (int i = 0; i < n; i++) {
			pt[i] = new int[i+1];
			pt[i][0] = 1;
			for (int j = 1; j < i; j++) {
				pt[i][j] = pt[i-1][j-1] + pt[i-1][j];
			}
			pt[i][i] = 1;
		}
		return pt;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] pt = constructPascalTriangel(5);
		for (int i = 0; i < pt.length; i++) {
			for (int j = 0; j < pt[i].length; j++) {
				System.out.print(pt[i][j] + " ");
			}
			System.out.println();
		}
	}
}