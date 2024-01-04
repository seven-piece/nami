package org.kaybee.service;

import org.kaybee.model.DailyExpenseEntry;

public interface IExpenditureService {

    void addExpense(long id, String date, double expense);

    DailyExpenseEntry getDailyExpense(String date);

    void updateExpense(long id, String date, double expense);

    void deleteExpense(long id);

}
