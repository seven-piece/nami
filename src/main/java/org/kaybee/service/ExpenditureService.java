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
    public ExpenseEntry addExpense(long id, String date, double expense) {
        ExpenseEntry expenseEntry = new ExpenseEntry(id, expense, date);
        expenseEntryHashMap.put(id, expenseEntry);

        DailyExpenseEntry dailyExpenseEntry = (dailyExpenseEntryHashMap.containsKey(date)) ?
                dailyExpenseEntryHashMap.get(date) : new DailyExpenseEntry((date));

        dailyExpenseEntry.addExpenseEntryList(expenseEntry);
        double newTotalDailyExpense = dailyExpenseEntry.getTotalExpense() + expenseEntry.getExpense();
        dailyExpenseEntry.setTotalExpense(newTotalDailyExpense);
        dailyExpenseEntryHashMap.put(date, dailyExpenseEntry);

        return expenseEntry;
    }

    @Override
    public DailyExpenseEntry getDailyExpense(String date) {
        if (!dailyExpenseEntryHashMap.containsKey(date)) {
            // TODO Exception Handling & Logging
            System.out.println("Invalid Expense date");
        }

        return dailyExpenseEntryHashMap.get(date);
    }

    @Override
    public ExpenseEntry updateExpense(long id, String date, double expense) {
        if (!expenseEntryHashMap.containsKey(id)) {
            // TODO Exception Handling & Logging
            System.out.println("Invalid Expense Id");
        }

        ExpenseEntry expenseEntry = expenseEntryHashMap.get(id);
        double oldExpense = expenseEntry.getExpense();
        expenseEntry.setExpense(expense);
        expenseEntryHashMap.put(id, expenseEntry);

        double deltaExpense = expense - oldExpense;
        DailyExpenseEntry dailyExpenseEntry = dailyExpenseEntryHashMap.get(date);
        double updatedDailyExpense = dailyExpenseEntry.getTotalExpense() + deltaExpense;
        dailyExpenseEntry.setTotalExpense(updatedDailyExpense);
        dailyExpenseEntryHashMap.put(date, dailyExpenseEntry);

        return expenseEntry;
    }

    @Override
    public void deleteExpense(long id) {
        if (!expenseEntryHashMap.containsKey(id)) {
            // TODO Exception Handling & Logging
            System.out.println("Invalid Expense Id");
        }

        ExpenseEntry expenseEntry = expenseEntryHashMap.get(id);
        String date = expenseEntry.getDate();
        DailyExpenseEntry dailyExpenseEntry = dailyExpenseEntryHashMap.get(date);
        List<ExpenseEntry> expenseEntryList = dailyExpenseEntry.getExpenseEntryList();
        for (ExpenseEntry e : expenseEntryList) {
            if (e.getId() == id) {
                double updatedExpense = dailyExpenseEntry.getTotalExpense() - expenseEntry.getExpense();
                dailyExpenseEntry.setTotalExpense(updatedExpense);
                dailyExpenseEntryHashMap.put(date, dailyExpenseEntry);
                expenseEntryHashMap.remove(id);
                return;
            }
        }
    }
}
