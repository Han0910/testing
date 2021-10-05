import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        String[] people ={"s123", "s456", "s789", "v123", "v456", "v789"};

        String[] recoveredPeople = {"s123", "v123"};

        String[] oneDosePeople = {"s123", "s456", "v456", "v789"};

        String[] anotherDosePeople = {"s456", "s789", "v789"};



        Campus c = new Campus();
        c.plan(people, recoveredPeople, oneDosePeople, anotherDosePeople);

        // First call
//        System.out.println(c.countEligible());
        // Second call
        System.out.println(c.isEligible("s09"));
    }
}

class Person{
    String id;
    boolean recovered;
    int numDoses;

    public Person(String person, boolean recoveredValue, int numDoses) {
    }
}
class Campus {
    ArrayList<Person> campus;

    public Campus() {
        campus = new ArrayList<Person>();
    }

    public void plan(String[] people, String[] recoveredPeople, String[] oneDosePeople, String[] anotherDosePeople) {
        for (int i = 0; i < people.length; i++) {
            boolean recoveredValue = false;
            int numDoses = 0;

            // Check if the person is recovered
            for (int a = 0; a < recoveredPeople.length; a++) {
                if (people[i].equals(recoveredPeople[a])) {
                    recoveredValue = true;
                }
            }

            // Check if the person has one dose
            for (int b = 0; b < oneDosePeople.length; b++) {
                if (people[i].equals(oneDosePeople[b])) {
                    numDoses = 1;
                }
            }

            // Check if the person has another dose
            for (int c = 0; c < anotherDosePeople.length; c++) {
                if (people[i].equals(anotherDosePeople[c])) {
                    numDoses = 2;
                }
            }

            // Create person
            Person p = new Person(people[i], recoveredValue, numDoses);

            // Add people to campus
            campus.add(p);
        }
    }
    public boolean isEligible(String id){
        boolean x = false;
        for (Person p : campus){
            if (p.recovered == true){
                return x = true;
            }
            if (p.numDoses ==2){
                return x =true;
            }
            else{
                return x = false;
            }
        }
        return x;

    }
}