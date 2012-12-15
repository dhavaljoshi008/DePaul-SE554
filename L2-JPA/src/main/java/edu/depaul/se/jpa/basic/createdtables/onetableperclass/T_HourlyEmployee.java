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
public class T_HourlyEmployee extends T_Employee {
    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
