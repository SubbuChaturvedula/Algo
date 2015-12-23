package programs;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n = 4;
		TOH(n, "A", "C", "B");
	}

	public static void TOH(int n, String src, String aux, String dest) {
		if (n == 1) {
			System.out.println("Move Disc " + n + " From " + src + " to " + dest);
		} else {
			TOH(n - 1, src, dest, aux);//make recursive call to move n-1 disks to aux nail
			System.out.println("Move Disc " + n + " From " + src + " to " + dest);//move the nth disc from "SRC" to "DEST"
			TOH(n - 1, aux, src, dest);//Move n-1 disc from aux mail to dest tail
		}
	}

}
