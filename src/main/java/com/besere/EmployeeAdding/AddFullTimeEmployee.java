
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.besere.EmployeeAdding;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class AddFullTimeEmployee 
{
    private final String name;
    private final int employeeID;
    private final double salary;
    private final double bonus;
    
    private static final Set<AddFullTimeEmployee> fulltimeData = new LinkedHashSet<>();
    
    public AddFullTimeEmployee(String name,int employeeID,double salary,double bonus) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
        this.bonus = bonus;
    }
    
    public void addFulltimeEmployee(){
        fulltimeData.add(this);
        System.out.println("\tSuccessfully Added!");
    }
    
   //DISPLAY ONLY THE NAME OF THE FTIME EMPLOYEE.
    public void displayDetails(){
        System.out.println();
        System.out.println("Full Time Employee Details");
        System.out.println("\n==========================================\n");
        for (AddFullTimeEmployee addFullTimeEmployee : fulltimeData) {
         
            System.out.print("\t" + addFullTimeEmployee.getemployeeID() + "." + addFullTimeEmployee.getname() + " ");
            System.out.print(addFullTimeEmployee.getSalary() + " $");
            System.out.print(addFullTimeEmployee.getBonus() + " ");
        }
        System.out.println("\n==========================================\n");
    }
    
        public String getname(){
            return name;
        }
        public int getemployeeID(){
            return employeeID;
        }
        public double getSalary(){
            return salary;
        }
        public double getBonus(){
            return bonus;
        }
        public Collection<AddFullTimeEmployee> getData(){
            return fulltimeData;
        }
        
}

