import java.io.*;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int count;

    public CircularLinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void appendLine(String line) {
        Node newNode = new Node(line);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            newNode.setNext(head);
            head.setPrev(newNode);
            tail = newNode;
        }
        count++;
    }

    public void insertLineAt(int index, String line) {
        if (index < 1 || index > count + 1) {
            System.out.println("Indice invalido.");
            return;
        }

        Node newNode = new Node(line);
        if (index == 1) {
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                newNode.setNext(newNode);
                newNode.setPrev(newNode);
            } else {
                newNode.setNext(head);
                newNode.setPrev(tail);
                head.setPrev(newNode);
                tail.setNext(newNode);
                head = newNode;
            }
        } else {
            Node current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            if (newNode.getNext() == head) {
                tail = newNode;
            }
        }
        count++;
    }

    public void removeLineAt(int index) {
        if (index < 1 || index > count) {
            System.out.println("Indice invalido.");
            return;
        }

        if (index == 1) {
            if (count == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrev(tail);
                tail.setNext(head);
            }
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            if (current == tail) {
                tail = current.getPrev();
            }
        }
        count--;
    }

    public void display(int start, int end) {
        if (isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = head;
        int lineNumber = 1;
        do {
            if (lineNumber >= start && lineNumber <= end) {
                System.out.println(lineNumber + ". " + current.getLine());
            }
            current = current.getNext();
            lineNumber++;
        } while (current != head && lineNumber <= end);
    }

    public boolean loadFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appendLine(line);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean saveFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Node current = head;
            if (current == null) return true;
            do {
                writer.write(current.getLine());
                writer.newLine();
                current = current.getNext();
            } while (current != head);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Método para buscar e substituir um elemento por outro em todas as linhas
    public void replaceAll(String oldElement, String newElement) {
        if (isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = head;
        do {
            if (current.getLine().contains(oldElement)) {
                current.setLine(current.getLine().replace(oldElement, newElement));
            }
            current = current.getNext();
        } while (current != head);
    }

    // Método para buscar e substituir um elemento por outro em uma linha específica
    public void replaceInLine(int lineIndex, String oldElement, String newElement) {
        if (isEmpty() || lineIndex < 1 || lineIndex > count) {
            System.out.println("Indice invalido.");
            return;
        }
        Node current = head;
        for (int i = 1; i < lineIndex; i++) {
            current = current.getNext();
        }
        if (current.getLine().contains(oldElement)) {
            current.setLine(current.getLine().replace(oldElement, newElement));
        }
    }

    // Método para buscar um elemento e exibir as linhas que o contêm
    public void searchAndDisplay(String element) {
        if (isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = head;
        int lineNumber = 1;
        do {
            if (current.getLine().contains(element)) {
                System.out.println(lineNumber + ". " + current.getLine());
            }
            current = current.getNext();
            lineNumber++;
        } while (current != head);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        if (current == null) return "";
        do {
            sb.append(current.getLine()).append("\n");
            current = current.getNext();
        } while (current != head);
        return sb.toString();
    }

    // public static void main(String[] args) {
    //     CircularLinkedList list = new CircularLinkedList();
    //     list.appendLine("First line");
    //     list.appendLine("Second line");
    //     list.appendLine("Third line");

    //     System.out.println("Initial list:");
    //     System.out.println(list);

    //     list.insertLineAt(2, "Inserted line");
    //     System.out.println("After inserting a line at position 2:");
    //     System.out.println(list);

    //     list.removeLineAt(3);
    //     System.out.println("After removing the line at position 3:");
    //     System.out.println(list);

    //     list.replaceAll("line", "LINE");
    //     System.out.println("After replacing 'line' with 'LINE':");
    //     System.out.println(list);
    // }
}
