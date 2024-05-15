
// Nó (node) usado para uma lista simplesmente encadeada
// contém duas partes:
// 1 - Dados (data).
// 2 - Referência para o próximo nó (next).
package list;
public class Node {
	
	private float data;
	private Node next;

	public Node() { this(0.0f, null); }
	public Node(float data) { this(data, null);	}
	public Node(float data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public float getData() { return data; }
	public void setData(float data) { this.data = data;	}
	
	public Node getNext() { return next; }
	public void setNext(Node next) { this.next = next; }

	@Override
	public String toString() {
		return "data: " + data + ", next: " + (next != null ? next.getData() : "null");
	}
	
}
