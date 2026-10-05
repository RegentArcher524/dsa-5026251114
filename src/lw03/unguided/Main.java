package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> courses = new LinkedHashMap<>();
        int failedOperations =0;
        System.out.println("===== Enrollment Checks =====");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(" ", 2);
            String operations = parts[0];
            String course = parts[1];
            if(operations.equals("REGISTER")) {
                String[] insertData = course.split(" ");
                String courseName = insertData[0];
                int units = Integer.parseInt(insertData[1]);
                if(units != 0 && courses.containsKey(courseName)){
                    courses.put(courseName, courses.get(courseName) + units);
                }
                else if(units != 0){
                    courses.put(courseName, units);
                }
                else{
                    failedOperations++;
                }
            }
            else if (operations.equals("WITHDRAW")) {
                String[] insertData = course.split(" ");
                String courseName = insertData[0];
                int units = Integer.parseInt(insertData[1]);
                if(courses.containsKey(courseName) && courses.get(courseName) >= units){
                    courses.put(courseName, courses.get(courseName) - units);
                }
                else{
                    failedOperations++;
                }
            }
            else if(operations.equals("CHECK")){
                if(courses.containsKey(course)){
                    System.out.println(course + ": " + courses.get(course));
                }
                else{
                    System.out.println(course + ": Not found");
                }
            }
        }
        input.close();
        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for(String name : courses.keySet()){
            System.out.println(name + ": " + courses.get(name));
        }
        System.out.println();
        System.out.println("Rejected operations: " + failedOperations);
    }
}
