package Node;

public class Node {

    //instances new variables
    public String data;
    private Node next;
  
    //constructor that takes String data as argumento and sets the data instance var to it as well as sets next to null
    //it sets next to null because there is no next item yet
    public Node(String data) {
      this.data = data;
      this.next = null;
    }
  
    //set next node sets this.next (that was previously null as the node)
    public void setNextNode(Node node) {
      this.next = node;
    }

    //so in a impplementation where i would like to add 'love' as next node that would be ->  setNextNode('love') and that should make the link part of the current node point to 'love' memory address
    
    //just returns the node added in last sentence  c
    public Node getNextNode() {
      return this.next;
    }

    
  
  }
