/**
 * 
 */
package everton.cracking.list;

/**
 * @author everton
 */
public class ListNode {
	private ListNode next;
	private int value;
	
	public static void main(String ... args) {
		ListNode n1 = new ListNode(); n1.value = 1;  
		ListNode n2 = new ListNode(); n2.value = 2;
		ListNode n3 = new ListNode(); n3.value = 3;
		ListNode n4 = new ListNode(); n4.value = 4;
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode head = n1;
		
		printList(n1);
		head = reverseListInPlace(head);
		printList(head);
	}

	private static void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.value + " ");
			head = head.next;
		}
		
	}

	private static ListNode reverseListInPlace(ListNode head) {
		
		ListNode first = null;
		ListNode second = head != null ? head : null;
		ListNode third = second != null ? second.next : null;
		
		while (second != null) {
			second.next = first;
			first = second;
			second = third;
			third = third != null ? third.next : third;
		}
		
		
		return first;
		
	}
	
}
