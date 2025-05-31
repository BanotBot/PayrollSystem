
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.besere.EmployeeAdding;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author admin
 */

public class AddContractBasedEmployee {
    
    private final String name;
    private final int employeeID;
    private final double projectFee;
    private final int projectDone;
    private static final Set<AddContractBasedEmployee>  contractEmployeeData = new LinkedHashSet<>();

    public AddContractBasedEmployee(String name, int employeeID, double projectFee, int projectDone) {
        this.name = name;
        this.employeeID = employeeID;
        this.projectFee = projectFee;
        this.projectDone = projectDone;
    }
    
    public void addContractEmployee(){
        contractEmployeeData.add(this);
    }
    
    public void displayDetails(){
        System.out.println();
        System.out.println("Contract Based Employee Details");
        for (AddContractBasedEmployee contractbased : contractEmployeeData) {
            System.out.println("==========================================");
            System.out.print("\t" + contractbased.getemployeeID()+ "." + contractbased.getname() + " ");
            System.out.print(contractbased.getProjectFee()+ " $");
            System.out.print(contractbased.getProjectDone()+ " ");
            System.out.println("\n==========================================\n");
        }
    }

        public String getname(){
            return name;
        }
        public int getemployeeID(){
            return employeeID;
        }
        public double getProjectFee(){
            return projectFee;
        }
        public int getProjectDone(){
            return projectDone;
        }
        public Collection<AddContractBasedEmployee> getData(){
            return contractEmployeeData;
        }
}
