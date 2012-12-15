/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.se.jpa.basic.createdtables.onetableperclass;

import javax.persistence.Entity;

/**
 *
 * @author kyu
 */
@Entity
public class T_SalaryEmployee extends T_Employee{
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
