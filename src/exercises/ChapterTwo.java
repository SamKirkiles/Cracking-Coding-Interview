package exercises;
import java.util.*;

public class ChapterTwo {
	
	//2.1
	public static void removeDuplicates(Node list) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		
		while(list != null) {
			if (set.contains(list.data)) {
				previous.next = list.next;
			}else {
				set.add(list.data);
				previous = list;
			}
			list = list.next;
		}
	
	}
	public static void removeDuplicatesInPlace(Node list) {
		Node current = list;
		while(current != null) {
			Node runner = current;
			
			while(runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			current = current.next;
		}	
	}
	// 2.2
	public static int kToLast(Node list, int k) {
		if (list == null) {
			return 0;
		}
		int index = kToLast(list.next,k) + 1;
		
		if (index == k) {
			System.out.println(k + "th to last node is " + list.data);
		}
		return index; 
	}
	//2.3
	public static void removeNode(Node n) {
		n.data = n.next.data;
		n.next = n.next.next;
	}
	//2.4
	public static void partition(Node list, int partition) {
		Node current = list;
		while (current != null) {
			Node next = current.next;
			if (current.data < partition) {
				int data = current.data;
				current.data = next.data;
				current.next = next.next;
				
				Node start = new Node(data);
				start.next = list;
				list = start;
			}else {
				current = current.next;
			}
		}
	}
	//2.5
	public static Node sumList(Node n1, Node n2,int carry){
		if (n1 == null && n2 == null && carry == 0)
			return null;
		
		int value = carry;
		if (n1 != null)
			value += n1.data;
		if (n2 != null)
			value += n2.data;
		
		carry = (value %100)/10;
		value = value%10;
		
		Node sum = new Node(value);
		Node next = sumList(n1 == null ? null:n1.next,n2==null?null:n2.next,carry);
		sum.next = next;
		return sum;
	}
	
	public static int length(Node list) {
		int count = 0;
		Node n = list;
		while (n != null) {
			count++;
			n = n.next;
		}
		return count;
	}
	
	public static Node insertBefore(int n, Node list) {
		Node newNode = new Node(n);
		if(list != null)
			newNode.next = list;
		return newNode;
	}
	
	public static Node padZeros(Node list, int len) {
		Node n = list;	
		for(int i = 0; i<len; i++) {
			n = insertBefore(0,n);
		}
		return n;
	}
	
	public static SumCarry sumHelper(Node n1, Node n2) {
		if(n1 == null && n2 == null) {
			SumCarry sum = new SumCarry();
			return sum;
		}
		
		SumCarry sum = sumHelper(n1.next,n2.next);
		int value = sum.carry + n1.data + n2.data;
		
		sum.sum = insertBefore(value%10,sum.sum);
		sum.carry = value/10;
		
		return sum;
	}
	
	public static Node sumListReverse(Node n1, Node n2, int carry) {
		
		int n1Len = length(n1);
		int n2Len = length(n2);
		
		if(n1Len > n2Len)
			n2 = padZeros(n2, n1Len-n2Len);
		else
			n1 = padZeros(n1,n2Len-n1Len);
		
		SumCarry sum = sumHelper(n1,n2);
		if (sum.carry == 0)
			return sum.sum;
		else
			return insertBefore(sum.carry,sum.sum);
	}
}
