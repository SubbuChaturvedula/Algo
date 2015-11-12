package array;
public class SecondLargestElement {

	public static int findSecond(int[] A) {
		int firstNum=A[0];
		int secondNum=-1;
		for(int i=1;i<A.length;i++){
			if(firstNum<A[i]){
				secondNum=firstNum;
				firstNum=A[i];
			}else if(secondNum<A[i]){
				secondNum=A[i];
			}
		}
		return secondNum;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };
		System.out.println("Second largest Element : " + findSecond(A));

	}

}