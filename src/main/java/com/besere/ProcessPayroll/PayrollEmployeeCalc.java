
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.besere.ProcessPayroll;

import com.besere.EmployeeAdding.AddFullTimeEmployee;
import com.besere.EmployeeAdding.AddPartTimeEmployee;
import com.besere.EmployeeAdding.AddContractBasedEmployee;
import com.besere.exceptions.InvalidUserChoices; // -> Exceptions
import com.besere.Interface.Payroll;
import com.besere.exceptions.DatabaseEmpty;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;


//FULL TIME CALCULATION EMPLOYEE
class FullTimer implements Payroll
{
    private final Collection<AddFullTimeEmployee> fulltimeData;
    private final AddFullTimeEmployee fulltime;
    
    public FullTimer(AddFullTimeEmployee fulltime){
        this.fulltime = fulltime; // Error in debugger
        this.fulltimeData = fulltime.getData();
    }

    @Override
    public double calculateSalary()
    {
        double totalSalary = 0;
        for (AddFullTimeEmployee addFullTimeEmployee : fulltimeData) {
             double calculateBonus = addFullTimeEmployee.getSalary() * (addFullTimeEmployee.getBonus() / 100.0);
             totalSalary += (addFullTimeEmployee.getSalary() + calculateBonus);
        }
        return totalSalary;
    }
    
    @Override
    public void printReceipt() {
        
        String receipt = """
                       --------------------------------------------------------------
                                        Welcome to Payroll System 
                                              2024 - 2025
                       --------------------------------------------------------------
                                           com.besere.@gmail.com
                        """;
        System.out.println(receipt);
        
        for (AddFullTimeEmployee fullTimeDetails : fulltimeData) {
            System.out.println("====================================");
            System.out.println("Employee Details -:");
            System.out.println("ID           : " + fullTimeDetails.getemployeeID());
            System.out.println("Name         : " + fullTimeDetails.getname());
            System.out.println("Salary       : " + fullTimeDetails.getSalary());
            System.out.println("Bonus        : " + fullTimeDetails.getBonus());
            System.out.println("------------------------------------");
            System.out.println("Total Wage : " + calculateSalary());
            System.out.println("====================================\n");
        }
    }
}

//PART TIME CALCULATION EMPLOYEE
class PartTimerClass implements Payroll
{
    private final Collection<AddPartTimeEmployee> partTimeData;
    private final AddPartTimeEmployee partTime;
    
    public PartTimerClass() {
        this.partTime = new AddPartTimeEmployee("", 0, 0, 0);
        this.partTimeData = partTime.getData();
    }

    @Override
    public double calculateSalary()
    {
        double totalSalary = 0;
        for (AddPartTimeEmployee addPartTimeEmployee : partTimeData) {
        
        }
    }
    
    @Override
    public void printReceipt() 
    {
         String receipt = """
                       --------------------------------------------------------------
                                        Welcome to Payroll System 
                                              2024 - 2025
                       -------------------------------------------------------------- 
                                           com.besere.@gmail.com
                        """;
        System.out.println(receipt);
        
        for (AddPartTimeEmployee CData : partTimeData) {
            System.out.println("====================================");
            System.out.println("Employee Details:");
            System.out.println("ID             : " + CData.getemployeeID());
            System.out.println("Name         : " + CData.getname());
            System.out.println("Salary       : " + CData.getHourlyRate());
            System.out.println("Bonus        : " + CData.getHourlyWorked());
            System.out.println("------------------------------------");
            System.out.println("Total Salary : " + calculateSalary());
            System.out.println("====================================\n");
        }
    }
}

//PART TIME CALCULATION EMPLOYEE
class ContractBased implements Payroll
{
    private final Collection<AddContractBasedEmployee> contractBasedData;
    private final AddContractBasedEmployee contractBasedObj;
    
    public ContractBased() {
        this.contractBasedObj = new AddContractBasedEmployee("", 0, 0, 0);
        this.contractBasedData = contractBasedObj.getData();
    }
    
    @Override
    public double calculateSalary()
    {
        double result = contractBasedObj.getProjectFee() * contractBasedObj.getProjectDone();
        return result;
    }
    
    @Override
    public void printReceipt() {
         String receipt = """
                        --------------------------------------------------------------
                                        Welcome to Payroll System 
                                              2024 - 2025
                        --------------------------------------------------------------
                                           com.besere.@gmail.com
                        """;
        System.out.println(receipt);
        
        for (AddContractBasedEmployee CData : contractBasedData) {
            System.out.println("====================================");
            System.out.println("Employee Details:");
            System.out.println("ID           : " + CData.getemployeeID());
            System.out.println("Name         : " + CData.getname());
            System.out.println("Salary       : " + CData.getProjectFee());
            System.out.println("Bonus        : " + CData.getProjectDone());
            System.out.println("------------------------------------");
            System.out.println("Total Salary : " + calculateSalary());
            System.out.println("====================================\n");
        }
        
    }
}

//PAYMENT SELECTION CHOICES
public class PayrollEmployeeCalc 
{
    private final AddFullTimeEmployee fullTime;
    private final AddPartTimeEmployee partTime;
    private final AddContractBasedEmployee contractBased;
    
    private final Collection<AddFullTimeEmployee> fulltimeData;
    private final Collection<AddPartTimeEmployee> partTimeData; 
    private final Collection<AddContractBasedEmployee> contractBasedData;
    
    private Payroll payroll;
    
    public PayrollEmployeeCalc() {
        //Set the constructor value to default
        this.fullTime = new AddFullTimeEmployee("",0,0,0);
        this.partTime = new AddPartTimeEmployee("",0,0,0);
        this.contractBased = new AddContractBasedEmployee("",0,0,0);
        
        this.fulltimeData = fullTime.getData();
        this.partTimeData = partTime.getData();
        this.contractBasedData = contractBased.getData();
    }
    
    // SELECTION OF TYPES OF PAYROLL METHOD
    private void userSelection(int userChoices){

        switch (userChoices) {
        
            case 1 -> {
                if (fulltimeData.isEmpty()) {
                    try {
                        throw new DatabaseEmpty("No Data found , Empty Database!");
                    } catch (DatabaseEmpty e) {
                        System.out.println(e.getMessage());
                    }
                }
                payroll = new FullTimer(fullTime); // Call Stack Line
            }
            
            case 2 -> {
                if (partTimeData.isEmpty()) {
                    try {
                        throw new DatabaseEmpty("No Data found , Empty Database!");
                    } catch (DatabaseEmpty e) {
                        System.out.println(e.getMessage());
                    }
                }
                payroll = new PartTimerClass();
            }
            
            case 3 ->{
                if (contractBasedData.isEmpty()) {
                    try {
                        throw new DatabaseEmpty("No Data found , Empty Database!");
                    } catch (DatabaseEmpty e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            default -> throw new AssertionError();
        }
            payroll.calculateSalary();
            payroll.printReceipt();
            
    }
    
    //PAYROLL OPTION USERINPUT CHOICES
    public void payrollOption() throws IOException, InvalidUserChoices
    {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         String [] choices = {
            "1.Full Time Employee",
            "2.Part Time Employee",
            "3.Contract Based Employee",
            "4.Exit"
            };
         
        try
        {
            int choiceUpdate;
            do {
                
                for (String choice : choices) {
                    System.out.print(choice + " ");
                }
                
                System.out.print("Enter your choice : ");
                int choice = Integer.parseInt(input.readLine());
                
                if (choice < 0 || choice > 4) {
                    throw new InvalidUserChoices("Invalid choices");
                }
                
                //Call the userSelection method
                PayrollEmployeeCalc payrollObj = new PayrollEmployeeCalc();
                payrollObj.userSelection(choice); // Call Stack Line
                
                choiceUpdate = choice;
            } while (choiceUpdate != 4);
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid Unecessary input or not valid!");
        }finally{
            input.close();
        }
    }   
}


