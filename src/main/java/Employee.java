
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

import com.besere.EmployeeAdding.AddContractBasedEmployee;
import com.besere.EmployeeAdding.AddFullTimeEmployee;
import com.besere.EmployeeAdding.AddPartTimeEmployee;
import com.besere.ProcessPayroll.PayrollEmployeeCalc;
import com.besere.exceptions.InvalidUserChoices; // -> Exceptions
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//MAIN
public class Employee{
    
    private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private final int choices;
    
    //Set to non-final object type;
    private AddFullTimeEmployee fullTime;
    private AddPartTimeEmployee partTime;
    private AddContractBasedEmployee contractBased;
    
    public Employee(int choices) {
        this.choices = choices;
    }
    
    protected void inputData() throws InvalidUserChoices{
        
        try {
            
            switch (choices) {
                
                case 1 -> {
                    
                    System.out.print("\tEnter Name : ");
                        String name = input.readLine();

                    System.out.print("\tEnter ID : ");
                        int id = Integer.parseInt(input.readLine());
                
                    System.out.print("\tEnter Salary : ");
                        double salary = Double.parseDouble(input.readLine());

                    System.out.print("\tEnter Bonus : ");
                        double bonus = Double.parseDouble(input.readLine());
                        //go to the fulltime employee adding
                        
                        AddFullTimeEmployee addFulltime = new AddFullTimeEmployee(name,id,salary,bonus);
                        addFulltime.addFulltimeEmployee();
                        addFulltime.displayDetails();
                }
                case 2 -> {
                    
                    System.out.print("\tEnter Name : ");
                        String name = input.readLine();

                    System.out.print("\tEnter ID : ");
                        int id = Integer.parseInt(input.readLine());
                        
                    System.out.print("\tEnter Hourly Rate : ");
                    int hourlyRate = Integer.parseInt(input.readLine());
                    
                    System.out.print("\tEnter Hours Worked : ");
                    int hoursWorked = Integer.parseInt(input.readLine());
                        //go to the part time employee adding
                        AddPartTimeEmployee parttime = new AddPartTimeEmployee(name, id, hourlyRate, hoursWorked);
                        parttime.addPartTimer();
                        parttime.displayDetails();
                }
                case 3 ->{
                    
                    System.out.print("\tEnter Name : ");
                        String name = input.readLine();

                    System.out.print("\tEnter ID : ");
                        int id = Integer.parseInt(input.readLine());

                    //add based contract employee handler
                    System.out.print("\tEnter Project Fee : ");
                    double projectFee = Double.parseDouble(input.readLine());
                    
                    System.out.print("\tEnter project Done : ");
                    int doneProject = Integer.parseInt(input.readLine());
                    
                    AddContractBasedEmployee contractbased = new AddContractBasedEmployee(name, id, projectFee, doneProject);
                    contractbased.addContractEmployee();
                    contractbased.displayDetails();
                }
                case 4 ->{
                    //process payroll handler
                    PayrollEmployeeCalc payrollObj = new PayrollEmployeeCalc();
                    payrollObj.payrollOption();
                }
                case 5 ->{
                    // display employee salaries handler
                }
                default -> throw new AssertionError();
            }
            
        }catch (IOException e) {
            System.out.println("Error : " + e.getMessage() + "!");
        }
    }
    
    public int getChoices(){
        return choices;
    }
    
    //USER INTERACTION
    static public void main(String...x) throws IOException,InvalidUserChoices{
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        String[] choices = {
            "1.Add Full-Time Employee",
            "2.Add Part-Time Employee",
            "3.Add Based Contract Employee",
            "4.Process Payroll",
            "5.Display Employee Salaries",
            "6.Exit"
        };
        
        int updatedChoice;
        int userChoices = 0;
        
        do {
            
            for (String choice : choices) {
                System.out.println(choice);
            }
            System.out.println();
           
            try {
             
                System.out.print("Enter choices : ");
                    userChoices = Integer.parseInt(input.readLine());
                
                if (userChoices < 0 || userChoices > 6) {
                    throw new InvalidUserChoices("Invalid choices!");
                }
                    //Call the employee class
                    Employee empObj = new Employee(userChoices);
                    empObj.inputData();
            
            } catch (InvalidUserChoices | IOException | NumberFormatException e) {
                System.out.println("Error : " + e.getMessage());
            }
                updatedChoice = userChoices;  
           
        } while (updatedChoice != 6);
    }
    
}
