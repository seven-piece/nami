package org.kaybee.service;


import jakarta.enterprise.context.ApplicationScoped;
import org.kaybee.model.DailyExpenseEntry;
import org.kaybee.model.ExpenseEntry;

import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class ExpenditureService implements IExpenditureService {

    private HashMap<Long, ExpenseEntry> expenseEntryHashMap = new HashMap<>();
    private HashMap<String, DailyExpenseEntry> dailyExpenseEntryHashMap = new HashMap<>();

    
    @Override
    public void addExpense(long id, String date, double expense) {
        ExpenseEntry expenseEntry = new ExpenseEntry(id, expense, date);
        expenseEntryHashMap.put(id, expenseEntry);

        if (dailyExpenseEntryHashMap.containsKey(date)) {
            DailyExpenseEntry dailyExpenseEntry = dailyExpenseEntryHashMap.get(date);
            dailyExpenseEntry.addExpenseEntryList(expenseEntry);
        } else {
            DailyExpenseEntry dailyExpenseEntry = new DailyExpenseEntry(date);
            dailyExpenseEntry.addExpenseEntryList(expenseEntry);
            dailyExpenseEntryHashMap.put(date, dailyExpenseEntry);
        }
    }

    @Override
    public void deleteExpense(long id) {
        ExpenseEntry expenseEntry = expenseEntryHashMap.get(id);
        String date = expenseEntry.getDate();
        DailyExpenseEntry dailyExpenseEntry = dailyExpenseEntryHashMap.get(date);
        List<ExpenseEntry> expenseEntryList = dailyExpenseEntry.getExpenseEntryList();
        for (ExpenseEntry e : expenseEntryList) {
            if (e.getId() == id) {
                double updatedExpense = dailyExpenseEntry.getTotalExpense() - expenseEntry.getExpense();
                dailyExpenseEntry.setTotalExpense(updatedExpense);

                //save to db
                dailyExpenseEntryHashMap.put(date, dailyExpenseEntry);
            }
        }
        expenseEntryHashMap.remove(id);

    }
}
