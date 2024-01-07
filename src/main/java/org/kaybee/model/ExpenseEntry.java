package org.kaybee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ExpenseEntry {

    @Id
    @GeneratedValue
    private final Long id;
    private Double expense;
    private final String date;

    public ExpenseEntry(Long id, Double expense, String date) {
        this.id = id;
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
}
