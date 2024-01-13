package org.kaybee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expense_entry")
public class ExpenseEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private Double expense;
    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    private DailyExpenseEntry dailyExpenseEntry;

    public ExpenseEntry() {}

    public ExpenseEntry(Double expense, String date) {
        this.expense = expense;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public String getDate() {
        return date;
    }

    public DailyExpenseEntry getDailyExpenseEntry() {
        return dailyExpenseEntry;
    }

    public void setDailyExpenseEntry(DailyExpenseEntry dailyExpenseEntry) {
        this.dailyExpenseEntry = dailyExpenseEntry;
    }
}
