
import java.util.HashSet;
public class LinkedList {

    private Node head;
    private Node tail;
    private int count;

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void insert(float value){

        Node node = new Node(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            node.setPrev(tail);
            head = node;
        }
        count++;
    }

    // append(value) Insere value no final da lista.
    public void append(float value){
        Node node = new Node(value);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            Node current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(node);
            tail = node;
        }
        count++;
    }

    // insertAsc(value) Insere value na lista, em ordem crescente, e aceita valores repetidos.
    public void insertAsc(float value) {
        Node node = new Node(value);
        if (isEmpty() || value <= head.getData()) { //insere no inicio
            node.setNext(head);
            head = node;
            if(isEmpty()){
                tail = node;
            }
            count++;
            return;
        } else {
            Node current = head;
            Node previous = null;
    
            // Percorrer a lista até encontrar o local de inserção
            while (current != null && current.getData() < value) {
                previous = current;
                current = current.getNext();
            }
            node.setNext(current);
            previous.setNext(node);
    
            if (current == null) {
                tail = node;
            }
        }
        count++;
    }

    // insertAscNoDup(value) Insere value na lista, em ordem crescente, somente se value não
    // existir na lista. A operação deve retornar true indicando que value foi inserido na lista ou false caso contrário.
    public boolean insertAscNoDup(float value){
        if (getNode(value) == null){
            insertAsc(value);
            return true;
        } return false;
    }

    // insertDesc(value) Insere value na lista, em ordem decrescente, e aceita valores repetidos.
    public void insertDesc(float value){
        Node node = new Node(value);
        if (isEmpty() || value >= head.getData()) { //insere no inicio
            node.setNext(head);
            head = node;
            if(isEmpty()){
                tail = node;
            }
            count++;
            return;
        } else {
            Node current = head;
            Node previous = null;
    
            // Percorrer a lista até encontrar o local de inserção
            while (current != null && current.getData() > value) {
                previous = current;
                current = current.getNext();
            }
            node.setNext(current);
            previous.setNext(node);
    
            if (current == null) {
                tail = node;
            }
        }
        count++;
    }


    public boolean insertDescNoDup(float value){
        if (getNode(value) == null){
            insertDesc(value);
            return true;
        } return false;
    }

    public void removeHead(){
        if(isEmpty()){
            return;
        }
        Node next = head.getNext();
        head = next;
    }

    public void removeTail(){
        if(isEmpty()){
            return;
        }  else if (head.getNext() == null) {
            // Se houver apenas um nó na lista (ou seja, head é tail)
            head = null;
            tail = null;
            count = 0;
            return;
        }


        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        current.setNext(null);
        tail = current; 
        count--;

    }

    public void removeNode(float value){
        Node current = head;
        if(isEmpty()){
            return;
        } else {
            while (current.getNext() != null) {
                if (current.getNext().getData() == value){
                    current.setNext(current.getNext().getNext()); //meu cerebro foi longe aq #proud

                    if (current.getNext() == null) {
                        tail = current;
                    }

                    return;
                }
                current = current.getNext();
            }
        }
    }


    //prof to usando hash aqui sei que vamos aprender no prox semestre mas foi o jeito que aprendi a fazer aqui, por favor considerar
    public void removeDup() {
        if (isEmpty() || head.getNext() == null) {
            return;
        }

        HashSet<Float> set = new HashSet<>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (set.contains(current.getData())) {
                previous.setNext(current.getNext());
                if (current == tail) {
                    tail = previous;
                }
                count--;
            } else {
                set.add(current.getData());
                previous = current;
            }
            current = current.getNext();
        }
    }

    public Node getHead(){
        if(isEmpty()){
            return null;
        } else {
            return head;
        }
    }

    public Node getTail(){
        if(isEmpty()){
            return null;
        } else {
            return tail;
        }
    }

    public Node getNode(float value){
        Node current = head;
        while(current != null){
            if(current.getData() == value){
                return current; 
            }
            current = current.getNext(); 
        }
        return null;
    }     


    // clear() Remove todos os elementos da lista.
    // As conexões entre os elementos (nós) também devem ser desfeitas.
    public void clear(){
        Node current = head;
        while (current != null){
            Node next = current.getNext();
            current.setNext(null);
            current = next;
        }
        head = null;
        tail = null;
        count = 0; //somente essas 3 ultimas linhas ja `limpariam` a listra porem nao desfariam as conexões entre os nós
    }

    
    public void sort() {
        if (isEmpty() || head.getNext() == null) {
            return;
        }
    
        Node sortedList = null;
    
        Node current = head;
        while (current != null) {

            Node next = current.getNext();
            sortedList = insertSorted(sortedList, current);
            current = next;
        }
        
        head = sortedList;
    }

    private Node insertSorted(Node sortedList, Node newNode) {
        if (sortedList == null || sortedList.getData() >= newNode.getData()) {
            newNode.setNext(sortedList);
            return newNode;
        }
        
        Node current = sortedList;
        while (current.getNext() != null && current.getNext().getData() < newNode.getData()) {
            current = current.getNext();
        }
        
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        return sortedList;
    }
    


    public void reverse() {
        if (isEmpty() || head.getNext() == null) {
            return;
        }
    
        Node previous = null;
        Node current = head;
        Node next = null;
    
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
    
        head = previous;
        tail = head;
    } 
    
    public int count(){
        return count;
    }
    
    public boolean isEqual(LinkedList list) {
        if (count != list.count()) {
            return false;
        }
    
        Node currentThis = head;
        Node currentOther = list.head;
    
        while (currentThis != null && currentOther != null) {
            if (currentThis.getData() != currentOther.getData()) {
                return false;
            }
            currentThis = currentThis.getNext();
            currentOther = currentOther.getNext();
        }
    
        return true;
    }

        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    

    public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
            System.out.println();
        }

       
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert
        list.insert(10);
        System.out.println("Apos inserir(10): " + list.toString());

        // Append
        list.append(20);
        System.out.println("Apos anexar(20): " + list.toString());

        // InsertAsc
        list.insertAsc(20);
        list.insertAsc(10);
        list.insertAsc(15);
        System.out.println("Apos inserirAsc(20), inserirAsc(10), inserirAsc(15): " + list.toString());

        // InsertAscNoDup
        list.insertAscNoDup(10);
        list.insertAscNoDup(20);
        list.insertAscNoDup(10); // Duplicado
        System.out.println("Apos inserirAscNoDup(10), inserirAscNoDup(20), inserirAscNoDup(10): " + list.toString());

        // InsertDesc
        list.insertDesc(10);
        list.insertDesc(20);
        list.insertDesc(15);
        System.out.println("Apos inserirDesc(10), inserirDesc(20), inserirDesc(15): " + list.toString());

        // InsertDescNoDup
        list.insertDescNoDup(10);
        list.insertDescNoDup(20);
        list.insertDescNoDup(10); // Duplicado
        System.out.println("Apos inserirDescNoDup(10), inserirDescNoDup(20), inserirDescNoDup(10): " + list.toString());

        // RemoveHead
        list.removeHead();
        System.out.println("Apos removerHead(): " + list.toString());

        // RemoveTail
        list.removeTail();
        System.out.println("Apos removerTail(): " + list.toString());

        // RemoveNode
        list.removeNode(20);
        System.out.println("Apos removerNode(20): " + list.toString());

        // RemoveDup
        list.insert(10);
        list.insert(20);
        list.insert(10); // Duplicados
        list.removeDup();
        System.out.println("Apos removerDup(): " + list.toString());

        // GetHead
        Node head = list.getHead();
        System.out.println("head: " + (head != null ? head.getData() : null));

        // GetTail
        Node tail = list.getTail();
        System.out.println("tail: " + (tail != null ? tail.getData() : null));

        // GetNode
        Node node = list.getNode(10);
        System.out.println("Nó com valor 10: " + (node != null ? node.getData() : null));

        // Count
        int count = list.count();
        System.out.println("count: " + count);

        // IsEmpty
        boolean isEmpty = list.isEmpty();
        System.out.println("Esta vazio: " + isEmpty);

        // Clear
        list.clear();
        System.out.println("Apos limpar(): " + list.toString());

        // Sort
        list.insert(10);
        list.insert(20);
        list.insert(15);
        list.sort();
        System.out.println("Apos ordenar(): " + list.toString());

        // Reverse
        list.insert(10);
        list.insert(20);
        list.insert(15);
        list.reverse();
        System.out.println("Apos inverter(): " + list.toString());

        // IsEqual
        LinkedList list1 = new LinkedList();
        list1.insert(10);
        list1.insert(20);

        LinkedList list2 = new LinkedList();
        list2.insert(10);
        list2.insert(20);

        boolean isEqual = list1.isEqual(list2);
        System.out.println("eh igual: " + isEqual);
    }
}