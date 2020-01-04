import java.util.Objects;
import java.util.PriorityQueue;

class EmployeeTwo implements Comparable<EmployeeTwo> {
    private String name;
    private double salary;

    public EmployeeTwo(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTwo EmployeeTwo = (EmployeeTwo) o;
        return Double.compare(EmployeeTwo.salary, salary) == 0 &&
                Objects.equals(name, EmployeeTwo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return "EmployeeTwo{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    // Compare two EmployeeTwo objects by their salary
    @Override
    public int compareTo(EmployeeTwo EmployeeTwo) {
        if(this.getSalary() > EmployeeTwo.getSalary()) {
            return 1;
        } else if (this.getSalary() < EmployeeTwo.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }
}


public class PriorityQueueUserDefinedObjectExample {
    public static void main(String[] args) {
        /*
           The requirement for a PriorityQueue of user defined objects is that

           1. Either the class should implement the Comparable interface and provide
              the implementation for the compareTo() function.
           2. Or you should provide a custom Comparator while creating the PriorityQueue.
        */

        // Create a PriorityQueue
        PriorityQueue<EmployeeTwo> EmployeeTwoPriorityQueue = new PriorityQueue<>();

        // Add items to the Priority Queue
        EmployeeTwoPriorityQueue.add(new EmployeeTwo("Rajeev", 100000.00));
        EmployeeTwoPriorityQueue.add(new EmployeeTwo("Chris", 145000.00));
        EmployeeTwoPriorityQueue.add(new EmployeeTwo("Andrea", 115000.00));
        EmployeeTwoPriorityQueue.add(new EmployeeTwo("Jack", 167000.00));


        /*
            The compareTo() method implemented in the EmployeeTwo class is used to determine
            in what order the objects should be dequeued.
        */
        while (!EmployeeTwoPriorityQueue.isEmpty()) {
            System.out.println(EmployeeTwoPriorityQueue.remove());
        }
    }
}
