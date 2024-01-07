package org.kaybee.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.kaybee.model.DailyExpenseEntry;

public class DailyExpenseRepository implements PanacheRepository<DailyExpenseEntry> {
}
