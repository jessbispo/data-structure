
// Nó (node) usado para uma lista simplesmente encadeada
// contém duas partes:
// 1 - Dados (data).
// 2 - Referência para o próximo nó (next).
public class Node {
	
	private float data;
	private Node next;
	private Node prev;

	public Node() { this(0.0f, null, null); }
	public Node(float data) { this(data, null, null);	}
	public Node(float data, Node next, Node prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public float getData() { return data; }
	public void setData(float data) { this.data = data;	}
	
	public Node getNext() { return next; }
	public void setNext(Node next) { this.next = next; }

	public Node getPrev() { return prev; }
	public void setPrev(Node prev) { this.prev = prev; }

	
}
