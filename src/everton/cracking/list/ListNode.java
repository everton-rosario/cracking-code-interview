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
		
		reverseListInPlace(n1);
	}

	private static void reverseListInPlace(ListNode head) {
		ListNode secondChanger = head;
		ListNode firstChanger = head != null ? head.next : null;
		ListNode headChanger = firstChanger != null ? firstChanger.next : null;
		
		if (head.next != null) {
			
		}
		
	}
	
}
