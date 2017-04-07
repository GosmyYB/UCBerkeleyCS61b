
public class DListNode {
	public int item;
	public DListNode prev, next;

	public DListNode(int i, DListNode p, DListNode n) {
		item = i;
		prev = p;
		next = n;
	}

	public static DListNode makeList(int[] counts) {
		if (counts == null || counts.length == 0) return null;
		// first node
		DListNode head = new DListNode(counts[0], null, null);
		DListNode current = head;
		for (int j = 1; j < counts[0]; j++) {
			current.next = new DListNode(counts[0], current, null);
			current = current.next;
		}
		// other nodes
		for (int i = 1; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				current.next = new DListNode(counts[i], current, null);
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		int[] counts = {3, 5, 1};
		DListNode current = makeList(counts);

		while (current != null) {
			System.out.print(current.item + " ");
			current = current.next;
		}
	}
}