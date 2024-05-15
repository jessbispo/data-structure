public class StackJ<T> {
    private int capacity;
    private T[] stack;
    private int top;

    @SuppressWarnings("unchecked")
    public StackJ(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
        this.top = -1;
    }

    // verify if stack is empty
    public boolean isEmpty() {
        return top < 0;
    }
    
    // verify if stack is full 
    public boolean isFull(){
        return top == capacity - 1;
    }

    //return size (not the amount of elements in an arr but the initial size) of an array
    public int size(){
        return capacity;
    }

    //clean up arr
    public void clear(){
        top = -1;
    }

    //returns the amount of itens in the arr
    public int count(){
        if (isEmpty()){
            return 0;
        } return top + 1;
        
    }

    //add a item to the first empty space in an arr, except if its full
    public void push(T data){
        if (isFull()){
            System.out.println("Stack is full");
        } 
        stack[++top] = data;
    }

    //remove the last item of an arr
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        return stack[top--];
    }

    //return the last item of an array without removing it
    public T top(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        return stack[top];

    }

}

//documentation/references used in this project, first i used both of these to understand the concepts of a Stack, the methods and how its build
//https://www.geeksforgeeks.org/stack-class-in-java/
//https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
//https://www.makeuseof.com/java-stacks/#:~:text=To%20delete%20all%20the%20elements,inherits%20from%20the%20Vector%20class.
//https://www.geeksforgeeks.org/stack-pop-method-in-java/

//additionally i used these to help me build my own stack
//https://crunchify.com/what-is-stack-and-how-to-implement-stack-in-java-without-collection/
// https://www.studytonight.com/java-programs/java-program-to-find-the-number-of-elements-in-an-array#google_vignette -> this one actually i used in my first version of this project, where i would iterate over the string and find only special char and add an array, to then iterate in it to find if the array was correctly sorted, that is obviouslly very ineffective because i would have to iterate in the array two times instead of one (which is the way i implemented in the end).
//https://blog.grancursosonline.com.br/java-operadores-de-incremento-e-decremento/
//https://pt.m.wikipedia.org/wiki/Ficheiro:ASCII-Table-wide.svg
//https://stackoverflow.com/questions/69619272/what-is-the-difference-between-the-peek-and-top-function-in-the-stack