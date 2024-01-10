package org.kaybee.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kaybee.model.ExpenseEntry;

import java.util.List;

@ApplicationScoped
public class ExpenseRepository implements PanacheRepository<ExpenseEntry> {

    public ExpenseEntry findFirstExpenseByDate(String date) {
        return find("date", date).firstResult();
    }

    public List<ExpenseEntry> findAllExpenseByDate(String date) {
        return list("date", date);
    }

    public ExpenseEntry findExpenseById(long id) {
        return findById(id);
    }

    public void deleteExpenseById(long id) {
        deleteById(id);
    }

}
