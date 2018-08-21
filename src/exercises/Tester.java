package exercises;

public class Tester {
	public static void main(String[] args) {
		//1.1
		//System.out.println(ChapterOne.isUnique("ABCDEFG"));
		//1.2
		//System.out.println(ChapterOne.isPermutation("ABCDE", "EDCBA"));
		//1.3
		//System.out.println(ChapterOne.replaceChars("Mr John Smith    "));
		//1.4
		//System.out.println(ChapterOne.palindromePermutation("aabbccd"));
		//1.5
		//System.out.println(ChapterOne.editsAway("pale", "bake"));
		//1.6
		//System.out.println(ChapterOne.compress("aabcccccaa"));
		/*1.7 Rotate matrix
		int[][] image = {{1,2,3,4,5,6},
						 {1,2,3,4,5,6},
						 {1,2,3,4,5,6},
						 {1,2,3,4,5,6},
						 {1,2,3,4,5,6},
						 {1,2,3,4,5,6}};
		
		ChapterOne.rotate(image);
		
		for (int[] x:image) {
			for (int y: x) {
				System.out.print(y);
			}
			System.out.println();
		}
		*/
		/*
		int[][] matrix = {{1,2,3,4,5,6},
				 {1,2,3,4,5,6},
				 {1,2,3,4,5,6},
				 {1,2,0,4,5,6},
				 {1,2,3,4,5,6},
				 {1,2,3,4,5,6}};

		ChapterOne.zeroMatrix(matrix);
		
		for (int[] x:matrix) {
			for (int y: x) {
				System.out.print(y);
			}
			System.out.println();
		}
		*/
		/*2.1
		Node list = new Node(4);
		list.appendToTail(4);
		list.appendToTail(4);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		list.appendToTail(6);
		
		ChapterTwo.removeDuplicatesInPlace(list);
		Node head = list;
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		*/
		
		/* 2.2
		Node list = new Node(4);
		list.appendToTail(4);
		list.appendToTail(4);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		list.appendToTail(6);

		ChapterTwo.kToLast(list,3);
		*/

		/*2.4
		Node list = new Node(3);
		list.appendToTail(5);
		list.appendToTail(8);
		list.appendToTail(5);
		list.appendToTail(10);
		list.appendToTail(2);
		list.appendToTail(1);
		
		ChapterTwo.partition(list,5);
		
		Node head = list;
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		*/
		//2.5
		Node list = new Node(6);
		list.appendToTail(1);
		list.appendToTail(7);

		Node list2 = new Node(2);
		list2.appendToTail(9);
		list2.appendToTail(5);


		//Node list3 = ChapterTwo.sumList(list,list2,0);
		Node list3 = ChapterTwo.sumListReverse(list, list2, 0);
		
		Node head = list3;
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
		
		

		

	}
}
