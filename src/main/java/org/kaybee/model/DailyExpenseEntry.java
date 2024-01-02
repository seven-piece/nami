package org.kaybee.model;

import java.util.ArrayList;
import java.util.List;

public class DailyExpenseEntry {

    private final String date;
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
        this.totalExpense += expenseEntry.getExpense();
    }

}
