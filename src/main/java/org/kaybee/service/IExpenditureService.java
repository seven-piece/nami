package org.kaybee.service;

import org.kaybee.model.DailyExpenseEntry;
import org.kaybee.model.ExpenseEntry;

public interface IExpenditureService {

    ExpenseEntry addExpense(long id, String date, double expense);

    DailyExpenseEntry getDailyExpense(String date);

    ExpenseEntry getExpenseEntry(long id);

    ExpenseEntry updateExpense(long id, String date, double expense);

    void deleteExpense(long id);

}
