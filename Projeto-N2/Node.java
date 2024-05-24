public class Node {
	
	private String line;
    private Node next;
    private Node prev;

	public Node(String line) {
        this.line = line;
        this.next = null;
        this.prev = null;
    }

	public String getLine() { return line; }
    public void setLine(String line) { this.line = line;}
	
	public Node getNext() { return next; }
	public void setNext(Node next) { this.next = next; }

	public Node getPrev() { return prev; }
	public void setPrev(Node prev) { this.prev = prev; }
	
}
