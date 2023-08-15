package edu.step;

import edu.step.db.Employee;
import edu.step.db.EmployeeDB;

public class Main {
    public static void main(String[] args) {
        EmployeeDB db = new EmployeeDB();
//        for (int i = 0; i < 20; i++) {
//            db.createWithPreparedStatement("Peter" + i , "Smith" + i , "wsmith" + i + " @gmail.com");
//        }
        db.update(new Employee(25, "Ion", "Popescu", "ipopescu@yahoo.fr"));
        db.delete(15);
        db.selectAll();
    }
}