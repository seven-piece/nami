package org.kaybee.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.kaybee.model.ExpenseEntry;

@ApplicationScoped
public class ExpenseRepository implements PanacheRepository<ExpenseEntry> {

}
