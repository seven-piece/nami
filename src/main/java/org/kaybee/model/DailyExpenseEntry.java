package org.kaybee.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DailyExpenseEntry {

    private final String date;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private final List<ExpenseEntry> expenseEntryList;
    private double totalExpense;

    public DailyExpenseEntry(String date) {
        this.date = date;
        this.expenseEntryList = new ArrayList<>();
        this.totalExpense = 0;
    }

    public String getDate() {
        return date;
    }

    public List<ExpenseEntry> getExpenseEntryList() {
        return expenseEntryList;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public void addExpenseEntryList(ExpenseEntry expenseEntry) {
        this.expenseEntryList.add(expenseEntry);
    }

}
