package RemoteRXComponents;

import RemoteRXComponents.Table.View;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TableDefinitions {
    private final RemoteRXComponents.Table.DataTable<SomeRow> table = new RemoteRXComponents.Table.DataTable();
    private View<SomeRow> view;

    @Given("^a table with the following data$")
    public void a_table_with_the_following_data(final DataTable dataTable) throws Throwable {
        final List<SomeRow> rows = dataTable.asList(SomeRow.class);

        for (final SomeRow row : rows) {
            table.add(row);
        }
    }

    @Given("^a viewpoint of (\\d+)$")
    public void a_viewpoint_of(final int rows) throws Throwable {
        view = table.getView().setViewPortSize(rows).connect();
        assertEquals("Incorrect number of rows", rows, view.getCount());
    }

    @When("^scolling forwards by (\\d+)$")
    public void scolling_forwards_by(final int forwardCount) throws Throwable {
        view.forward(forwardCount);
    }

    @When("^scolling backwards by (\\d+)$")
    public void scolling_backwards_by(final int backCount) throws Throwable {
        view.back(backCount);
    }

    @When("^the following data is changed$")
    public void the_following_data_is_changed(final DataTable dataTable) throws Throwable {
        final List<SomeRow> rows = dataTable.asList(SomeRow.class);

        for (final SomeRow row : rows) {
            final SomeRow tableRowToUpdate = table.getRowById(row.id);
            if (row.counterparty.length() > 0) {
                tableRowToUpdate.counterparty = row.counterparty;
            }

            if (row.instrument.length() > 0) {
                tableRowToUpdate.instrument = row.instrument;
            }

            if (row.side.length() > 0) {
                tableRowToUpdate.side = row.side;
            }

            if (row.notional != 0) {
                tableRowToUpdate.notional = row.notional;
            }
        }
    }

    @Then("^the viewport looks like$")
    public void the_viewport_looks_like(final DataTable dataTable) throws Throwable {
        final List<SomeRow> rows = dataTable.asList(SomeRow.class);

        for (int i=0; i<view.getCount(); i++) {
            final SomeRow viewRow = view.getRow(i);
            final SomeRow dataRow = rows.get(i);

            assertEquals("Incorrect id", dataRow.id, viewRow.id);
            assertEquals("Incorrect instrument", dataRow.instrument, viewRow.instrument);
            assertEquals("Incorrect counterparty", dataRow.counterparty, viewRow.counterparty);
            assertEquals("Incorrect side", dataRow.side, viewRow.side);
            assertEquals("Incorrect notional", dataRow.notional, viewRow.notional);
        }
    }
}
