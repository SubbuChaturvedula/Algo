package strings;

public class Palindrome {
    public static void main(String...args){
        String inputString="abbaa"; //String to be reversed     
        System.out.println(isPalindrome(inputString) ? inputString+ " is a palindrome." :  inputString+ "is not a palindrome.");     
    }
    
    /*
     * returns true if inputString is palindrome.
     */
    public static boolean isPalindrome(String inputString){
        char arr[]=inputString.toCharArray();
        int i=0; 
        int j=arr.length-1;
        int half=arr.length/2;
        
        while(i<half&&j>half){
        	if(arr[i]!=arr[j]){
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
}
