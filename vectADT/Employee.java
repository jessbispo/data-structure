package vectADT;

//Lists in overall are the best when you can iterate over looking for the data, it will be great if you know your item index. Its not so good when inserting or removing itens because you have to move the others items in the list to match the size. In cases where you have to m 

public class Employee {

    //constructor

    private String firstName;
    private String lastName;
    private int id;

    //methods to guarantee that you do not accept a new instance if that already exist
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //generate a string with the result

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]" + System.lineSeparator();
    }

    
}

//https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
//https://www.baeldung.com/java-string-newline

//Array x Vector => Vector is multi-thread and arr is not but vector is slower. ArrayList are 