
package list;

/**
 *  A LockDList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list. Nodes in it are LockDListNodes.
 */
public class LockDList extends DList {

	/**
   *  newNode() calls the LockDListNode constructor.  Use this class to allocate
   *  new LockDListNodes rather than calling the LockDListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }

	/**
	* Locks a node in this list. This node cannot be remove from list.
	* @param node the node needs to be locked.
	*/
	public void lockNode(DListNode node) {
		if (node == null) {
			return;
		}
		if (node instanceof LockDListNode) {
			((LockDListNode)node).isLocked = true;
		}
	}

  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  if node is a LockDListNode and is locked, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    // Your solution here.
    // if node is a LockDListNode and is locked, it cannot be removed.
    if (node != null && !((LockDListNode)node).isLocked) {
    	super.remove(node);
    }
  }


  public static void main(String[] args) {
  	System.out.println("Testing Constructor");
  }
}