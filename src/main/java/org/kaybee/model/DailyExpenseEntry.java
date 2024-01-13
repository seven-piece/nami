package org.kaybee.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "daily_expense_entry")
public class DailyExpenseEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String date;

    @OneToMany(
            mappedBy = "expense_entry",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ExpenseEntry> expenseEntryList;
    private double totalExpense;

    public DailyExpenseEntry(){}

    public DailyExpenseEntry(String Date) {
        this.expenseEntryList = new ArrayList<>();
        this.totalExpense = 0;
    }

    public Long getId() {
        return id;
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
        expenseEntry.setDailyExpenseEntry(this);
    }

    public void removeExpenseEntryList(ExpenseEntry expenseEntry) {
        this.expenseEntryList.remove(expenseEntry);
        expenseEntry.setDailyExpenseEntry(null);
    }

}
