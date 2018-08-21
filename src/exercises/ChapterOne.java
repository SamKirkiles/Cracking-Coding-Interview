package exercises;
import java.util.*;
public class ChapterOne {
	//1.1
	public static boolean isUnique(String str) {
		for(int i = 0; i<str.length()-1; i++) {
			for (int j=i+1; j< str.length(); j++) {

				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	//1.2
	public static boolean isPermutation(String s1, String s2) {
		return insertionSort(s1).equals(insertionSort(s2));
	}
	
	public static String insertionSort(String s1) {
		String copy = s1;
		
		for (int i=0; i<copy.length();i++) {
			int j = i-1;
			char key = copy.charAt(i);

			while(j>=0 && copy.charAt(j)>key) {
				char t = copy.charAt(j);
				copy = copy.substring(0, j+1)+ t + copy.substring(j+2);
				j--;
			}
			copy = copy.substring(0,j+1) + key + copy.substring(j+2);
		}
		return copy;
	}
	// 1.3
	
	public static String replaceChars(String str) {
		char[] charArray = str.toCharArray();
		int i = 0;
		while (i < charArray.length-1){
			
			if (charArray[i] == ' ' && charArray[i+1] != ' ') {
				// Shift everything over by one
				char[] repl = {'%','2','0'};
				for(int l =0; l<repl.length-1;l++) {
					for (int j = charArray.length-1; j>i; j--) {
						charArray[j] = charArray[j-1];
					}
				}
				charArray[i] = repl[0];
				charArray[i+1] = repl[1];
				charArray[i+2] = repl[2];

				i+=3;

			}else {
				i++;
			}
			
		}
		return new String(charArray);

	}
	
	//1.4 Had bug in own method this is implementation with hash tables
	
	public static boolean palindromePermutation(String input) {
		int[] table = stringHashTable(input);
		boolean found = false;
		for (int x: table) {
			if (x%2 == 1) {
				if (found)
					return false;
				found = true;
			}
		}
		return true;
	}
	
	public static int getCharNumber(char character) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int c = Character.getNumericValue(character);
		if (!(c >= a) || !(c<=z)) {
			return -1;
		}else {
			return c;
		}
	}
	
	public static int[] stringHashTable(String input) {
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a') + 1 ];
		for (char c : input.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1) {
				table[x] ++;
			}
		}
		return table;
	}
	//1.5
	
	public static boolean editsAway(String s1, String s2) {
		if (s1.length() == s2.length())
			return replaceCharacter(s1,s2);
		else if (s1.length() == s2.length()-1)
			return removeCharacter(s1,s2);
		else if (s1.length() == s2.length()+1)
			return addCharacter(s1,s2);
		
		return false;
	}
	
	public static boolean replaceCharacter(String s1, String s2) {
		boolean missmatch = false;
		for(int i = 0; i<s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (missmatch)
					return false;
				missmatch = true;
			}
		}
		return true;
	}
	
	public static boolean removeCharacter(String s1, String s2) {
		int foundExtra = 0;
		int i = 0;
		while(i<s1.length()) {
			if(s1.charAt(i) != s1.charAt(i + foundExtra)) {
				if (foundExtra > 0){
					return false;
				}
				foundExtra += 1;
			}else {
				i+= 1;
			}
		}
		return true;
	}
	
	public static boolean addCharacter(String s1, String s2) {
		int foundExtra = 0;
		int i = 0;
		while(i<s1.length()) {
			if(s1.charAt(i) != s1.charAt(i - foundExtra)) {
				if (foundExtra > 0){
					return false;
				}
				foundExtra += 1;
			}else {
				i+= 1;
			}
		}
		return true;
	}
	// 1.6
	
	public static String compress(String str) {
		String out ="";
		for (int i = 0; i<str.length();) {
			
			char c = str.charAt(i);
			int l = 0;
			while(i < str.length() && str.charAt(i)==c) {
				i++;
				l++;
			}
			out += c + Integer.toString(l);
			
		}
		return out;
	}
	//1.7
	public static void rotate(int[][] image) {
		int n = image[0].length;

		for (int offset = 0; offset<n/2; offset ++) {
			for (int b = offset; b<n-offset-1 ; b++) {

				int tl = image[offset][b];
				int tr = image[b][n-offset-1];
				int br = image[n-offset-1][n-b-1];
				int bl = image[n-b-1][offset];
				
				
				image[offset][b] = bl;
				image[b][n-offset-1] = tl;
				image[n-offset-1][n-b-1] = tr;
				image[n-b-1][offset] = br;
				
			}
		}
	}
	
	//1.8
	public static void zeroMatrix(int[][] matrix) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		
		for (int row =0; row<matrix.length; row++) {
			for(int col=0; col<matrix[0].length;col++) {
				if(matrix[row][col] == 0) {
					x.add(row);
					y.add(col);
				}
			}
		}
		for(int c = 0; c< x.size(); c++) {
			for(int i = 0; i<matrix[0].length;i++) {
				matrix[x.get(c)][i] = 0;
			}
			for(int j = 0; j<matrix.length;j++) {
				matrix[j][y.get(c)] = 0;
			}

		}
	}
	
}
