package fınalproj;

public class Node {
	Student item;
	Node nextNode;
	Node previous;
	
        // PARAMETRELI NODE CONSTRUCTOR'I
	public Node(Student item, Node nextNode, Node previous) {
		this.item = item;
		this.nextNode = nextNode;
		this.previous = previous;
	}
	
        // PARAMETRESIZ NODE CONSTRUCTOR'I
	public Node() {
		this.item = null;
		this.nextNode = null;
		this.previous = null;
	}

        // GETTER SETTER
	public Student getItem() {
		return item;
	}

	public void setItem(Student item) {
		this.item = item;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	
}
