package vectADT;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;

public class Main {
        /**
         * @param args
         */
        public static void main(String[] args) {

            List<Employee> employeeList = new Vector<>();
            employeeList.add(new Employee("Jane", "Jones", 123));
            employeeList.add(new Employee("Jess", "Bispo", 124));
            employeeList.add(new Employee("Joao", "Santos", 125));

            // employeeList.forEach (employee -> System.out.print(employee));

            // System.out.println(employeeList.get(1));

            //  System.out.println(employeeList.isEmpty());
                                 
            // employeeList.set(1, new Employee("rara", "santos", 126));
            // //as long as we are providing index time complexity will always be O(1), the best one

            // employeeList.forEach (employee -> System.out.print(employee));

            //difference between set and add method is that set method can put the item in a defined index but add method will add it to the end of the list. exactly, you can use index on add too, but that will not overwrite the existing item instead it will push all items above (=>) the index to jump one more case

            Employee[] employeeArray = employeeList.toArray(new Employee [employeeList.size()]);
            for (Employee employee: employeeArray) {
                System.out.println(employee);
            }

        } 
}