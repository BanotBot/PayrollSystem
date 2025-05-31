
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.besere.EmployeeAdding;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class AddPartTimeEmployee 
{
    
    private final String name;
    private final int employeeID;
    private final double hourlyRate;
    private final double hoursWorked;
     private static final Set<AddPartTimeEmployee> parttimer = new LinkedHashSet<>();

    public AddPartTimeEmployee(String name,int employeeID,double hourlyRate,double hoursWorked) {
        this.name = name;
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    public void addPartTimer(){
        parttimer.add(this);
    }
    
   public void displayDetails(){
        System.out.println();
        System.out.println("Part Time Employee Details");
        for (AddPartTimeEmployee partTimer : parttimer) {
            System.out.println("==========================================");
            System.out.print("\t" + partTimer.getemployeeID()+ "." + partTimer.getname() + " ");
            System.out.print(partTimer.getHourlyRate() + " $");
            System.out.print(partTimer.getHourlyWorked() + " ");
            System.out.println("\n==========================================\n");
        }
    }
    
    public String getname(){
        return name;
    }
    public int getemployeeID(){
        return employeeID;
    }
    public double getHourlyRate(){
        return hourlyRate;
    }
    public double getHourlyWorked(){
        return hoursWorked;
    }
    
    public Collection<AddPartTimeEmployee> getData(){
        return parttimer;
    }
    
    
}
