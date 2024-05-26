
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int count;
    private Node markStart;
    private Node markEnd;
    public CircularLinkedList clipboard;

    public CircularLinkedList() {
        head = null;
        tail = null;
        count = 0;
        markStart = null;
        markEnd = null;
        clipboard = null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        if (head == null) return 0;
        int count = 1;
        Node current = head;
        while (current.getNext() != head) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        markStart = null;
        markEnd = null;
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

    public void displayAll() {
        display();
    }

    public void display() {
        Node current = head;
        int count = 0;
        if (current != null) {
            do {
                System.out.println(current.getLine());
                count++;
                if (count % 20 == 0) {
                    System.out.print("Press Enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                current = current.getNext();
            } while (current != head);
        }
    }

    public void display(int start, int end) {
        Node current = head;
        int index = 1;
        int count = 0;
        if (current != null) {
            do {
                if (index >= start && index <= end) {
                    System.out.println(current.getLine());
                    count++;
                    if (count % 20 == 0) {
                        System.out.print("Press Enter to continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                current = current.getNext();
                index++;
            } while (current != head);
        }
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

    public void replaceInLine(String oldElement, String newElement, int lineIndex) {
        if (isEmpty() || lineIndex < 1 || lineIndex > count) {
            System.out.println("indice invalido.");
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

    public void markText(int start, int end) {
        if (start < 1 || end < start || end > count) {
            System.out.println("Intervalo de linhas invalido.");
            return;
        }
        Node current = head;
        for (int i = 1; i < start; i++) {
            current = current.getNext();
        }
        markStart = current;
        for (int i = start; i <= end; i++) {
            current = current.getNext();
        }
        markEnd = current.getPrev();
    }

    public void copyMarkedText() {
        if (markStart == null || markEnd == null) {
            System.out.println("Nenhum texto marcado.");
            return;
        }
        clipboard = new CircularLinkedList();
        Node current = markStart;
        do {
            clipboard.appendLine(current.getLine());
            current = current.getNext();
        } while (current != markEnd.getNext());
    }

    public void cutMarkedText() {
        if (markStart == null || markEnd == null) {
            System.out.println("Nenhum texto marcado.");
            return;
        }
        copyMarkedText();
        Node current = markStart;
        while (current != markEnd.getNext()) {
            Node next = current.getNext();
            removeLineAt(findLineIndex(current));
            current = next;
        }
        markStart = null;
        markEnd = null;
    }

    public void pasteText(int index) {
        if (clipboard == null || clipboard.isEmpty()) {
            System.out.println("Area de transferencia vazia.");
            return;
        }
        Node current = clipboard.head;
        do {
            insertLineAt(index++, current.getLine());
            current = current.getNext();
        } while (current != clipboard.head);
    }

    
    public void removeLinesFrom(int start) {
        if (start < 1 || start > count()) {
            System.out.println("indice invalido.");
            return;
        }

        Node current = head;
        for (int i = 1; i < start; i++) {
            current = current.getNext();
        }

        while (current != null && current != head) {
            Node next = current.getNext();
            removeNode(current);
            current = next;
        }
    }

    private void removeNode(Node node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else {
            if (node == head) {
                head = node.getNext();
            }
            if (node == tail) {
                tail = node.getPrev();
            }
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void removeLinesTo(int end) {
        if (end < 1 || end > count) {
            System.out.println("indice invalido.");
            return;
        }
        for (int i = 1; i <= end; i++) {
            removeLineAt(1);
        }
    }

    private int findLineIndex(Node node) {
        Node current = head;
        int index = 1;
        do {
            if (current == node) {
                return index;
            }
            current = current.getNext();
            index++;
        } while (current != head);
        return -1;
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
}
