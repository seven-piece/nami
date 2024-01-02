package org.kaybee.service;

public interface IExpenditureService {

    void addExpense(long id, String date, double expense);

    void deleteExpense(long id);

}
