import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

class EmployeeThree implements Comparable<EmployeeThree> {
    private int id;
    private String name;

    public EmployeeThree(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Two EmployeeThrees are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeThree EmployeeThree = (EmployeeThree) o;
        return id == EmployeeThree.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Compare EmployeeThrees based on their IDs
    @Override
    public int compareTo(EmployeeThree EmployeeThree) {
        return this.getId() - EmployeeThree.getId();
    }

    @Override
    public String toString() {
        return "EmployeeThree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


public class TreeSetUserDefinedObjectExample {
    public static void main(String[] args) {
        // Creating a TreeSet of User Defined Objects.

        /*
           The requirement for a TreeSet of user defined objects is that

           1. Either the class should implement the Comparable interface and provide
              the implementation for the compareTo() function.
           2. Or you should provide a custom Comparator while creating the TreeSet.
        */

        SortedSet<EmployeeThree> EmployeeThrees = new TreeSet<>();

        // TreeSet uses the compareTo() method of the EmployeeThree class to compare two EmployeeThrees and sort them
        EmployeeThrees.add(new EmployeeThree(1010, "Rajeev"));
        EmployeeThrees.add(new EmployeeThree(1005, "Sachin"));
        EmployeeThrees.add(new EmployeeThree(1008, "Chris"));

        System.out.println("EmployeeThrees (sorted based on EmployeeThree class's compareTo() function)");
        System.out.println(EmployeeThrees);

        // Providing a Custom Comparator (This comparator compares the EmployeeThrees based on their Name)
        EmployeeThrees = new TreeSet<>(Comparator.comparing(EmployeeThree::getName));

        EmployeeThrees.add(new EmployeeThree(1010, "Rajeev"));
        EmployeeThrees.add(new EmployeeThree(1005, "Sachin"));
        EmployeeThrees.add(new EmployeeThree(1008, "Chris"));

        System.out.println("\nEmployeeThrees (sorted based on the supplied Comparator)");
        System.out.println(EmployeeThrees);

    }
}
