package org.kaybee;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.kaybee.model.ExpenseEntry;

import java.util.ArrayList;
import java.util.List;

@Path("/expense")
public class ExpenseResource {

    public static List<ExpenseEntry> expenseEntryList = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExpense() {
        return Response.ok(expenseEntryList).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer countExpense() {
        return expenseEntryList.size();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createExpense(ExpenseEntry newExpenseEntry) {
        expenseEntryList.add(newExpenseEntry);
        return Response.ok(expenseEntryList).build();
    }
}
