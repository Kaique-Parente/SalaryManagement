package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner e = new Scanner(System.in);
        SimpleDateFormat sf1 = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Enter department's name: ");
        String departmentName = e.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = e.nextLine();
        System.out.print("Level: ");
        String workerLevel = e.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = e.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
        
        System.out.print("How many contracts to this worker? ");
        int n = e.nextInt();
        System.out.println("");
        
        for(int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sf1.parse(e.next());
            System.out.print("Value per hour: ");
            double valuePerHour = e.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = e.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
            System.out.println("");
        }
        
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = e.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f",worker.income(year, month)));
    }
 
}
