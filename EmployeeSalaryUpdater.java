import java.io.*;
import java.util.*;

public class EmployeeSalaryUpdater {
    public static void main(String[] args) {
        String fileName = "employee.txt";

        List<String[]> employees = new ArrayList<>();

        // Read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip the header
                    continue;
                }
                String[] parts = line.split(" ");
                employees.add(parts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the salaries
        for (String[] employee : employees) {
            int yearsWorked = Integer.parseInt(employee[2]);
            double salary = Double.parseDouble(employee[3]);

            if (yearsWorked < 5) {
                salary *= 1.05;
            } else if (yearsWorked <= 10) {
                salary *= 1.15;
            } else {
                salary *= 1.30;
            }

            employee[3] = String.format("%.2f", salary); // Update the salary in the array
        }

        // Write the updated information back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Name Surname Years Worked Salary");
            bw.newLine();
            for (String[] employee : employees) {
                bw.write(String.join(" ", employee));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
