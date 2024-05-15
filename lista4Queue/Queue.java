public class Queue<T> {
    private int capacity;
    private T[] queue;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    //FIFO -> First In, First Out

    //always points to the earliest added item in the queue, so always when a item is dequeued, front start to point to the next item in the queue
    public T front(){
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
            return null;
        }
        return queue[front];
    }

    //returns amount of items in a queue
    /*every insert => increment count and last()
    every remove => decrement counter and increment first */
    //add to the the end of the queue

    public void enqueue(T data){
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue item: " + data);
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
    }
    //here i changed method to T type, so i could return whatever data type is used in the queue
    public T dequeue(){

        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }

        T data = queue[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void clear(){
        for (int i = 0; i < capacity; i++) {
            queue[i] = null;
        }
        front = 0;
        rear = -1;
        size = 0;
    }
    public int capacity(){
        return capacity;
    }

}

//queue is data structure type where every item is placed above and every item is added at end of the array, except when the beggining of the arr starts to become empty, then items start to be placed there,

   
//first, understanding Queue
//https://www.simplilearn.com/tutorials/java-tutorial/queue-in-java#:~:text=Queue%20in%20Java%20is%20a,offer%2C%20poll%2C%20and%20remove.
//https://www.freecodecamp.org/news/queue-data-structure-definition-and-java-example-code/
//https://homepages.dcc.ufmg.br/~fsantos/ECO030/generics.pdf --> Java's Generics use case, something that bothered me while i was developing the Queue was how didnt seemed to be possible to enable my Queue to receive all datatypes, and doing a research i found a way to do that with Generics.
// https://www.youtube.com/watch?v=PvDoT79oHTs  --> implementation of the method
//