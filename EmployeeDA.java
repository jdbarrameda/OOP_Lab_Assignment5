import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee;

    EmployeeDA(String empNo) {
        this.employee = scanEmpFile(empNo);
    }

    public Employee getEmployee() {
        return employee;
    }

    public Employee scanEmpFile(String empNo) {
        Employee emp = new Employee();
        try {
            Scanner employeeFile = new Scanner(new FileReader("emp.csv"));
            employeeFile.nextLine();
            while (employeeFile.hasNext()) {
                String empLine = employeeFile.nextLine();
                String[] empArr = empLine.split(",");
                if (empArr[0].equals(empNo)) {
                    emp.setEmpNo(empArr[0].trim());
                    emp.setLastName(empArr[1].trim());
                    emp.setFirstName(empArr[2].trim());
                }
            }
            employeeFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }
}