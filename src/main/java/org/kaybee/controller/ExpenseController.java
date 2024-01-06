package org.kaybee.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.kaybee.model.DailyExpenseEntry;
import org.kaybee.model.ExpenseEntry;
import org.kaybee.service.IExpenditureService;

@RequestScoped
@Path("/v1/expense")
public class ExpenseController {

    private final IExpenditureService expenditureService;

    @Inject
    public ExpenseController(IExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }

    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExpense(@PathParam("date") String date) {
        DailyExpenseEntry dailyExpense = expenditureService.getDailyExpense(date);
        return Response.ok(dailyExpense).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createExpense(ExpenseEntry expenseEntry) {
        ExpenseEntry addedExpense = expenditureService.addExpense(expenseEntry.getId(), expenseEntry.getDate(), expenseEntry.getExpense());
        return Response.ok(addedExpense).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateExpense(ExpenseEntry newExpenseEntry) {
        ExpenseEntry updatedExpenseEntry = expenditureService.updateExpense(newExpenseEntry.getId(), newExpenseEntry.getDate(), newExpenseEntry.getExpense());
        return Response.ok(updatedExpenseEntry).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteExpense(@PathParam("id") long id) {
        expenditureService.deleteExpense(id);
        return Response.noContent().build();
    }
}
