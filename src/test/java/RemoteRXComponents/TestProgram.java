package RemoteRXComponents;

import RemoteRXComponents.Table.DataTable;
import RemoteRXComponents.Table.Row;
import RemoteRXComponents.Table.View;

import java.util.Comparator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class TestProgram {
    public static void main(final String[] args) {
        new TestProgram().run();
    }

    private void run() {
        final DataTable<SomeRow> table = new DataTable();
        final SomeRow someRow = new SomeRow(4, "GBPUSD", "counterparty1", "Sell", 12.2);
        table.add(someRow);

        final SomeRow row = table.getRow(0);
        assertNotNull("Row NOT found", row != null);
        assertEquals("Row isn't GPBUSD", row.instrument, "GBPUSD");

        final SomeRow someRow1 = new SomeRow(2, "GBPEUR", "counterparty2", "Buy", 12.3);
        table.add(someRow1);

        final View<SomeRow> view = table.getView().setViewPortSize(2).connect();

        assertEquals("Incorrect number of rows", 2, view.getCount());

        final SomeRow someRow2 = new SomeRow(3, "GBPJPY", "counterparty3", "Buy", 12.3);
        table.add(someRow2);

        assertEquals("Incorrect number of rows", 2, view.getCount());

        final SomeRow viewRow = view.getRow(0);
        assertNotNull("Row NOT found", viewRow != null);
        assertEquals("Row isn't GPBUSD", viewRow.instrument, "GBPUSD");

        view.forward(1);
        assertEquals("Incorrect number of rows", 2, view.getCount());

        final SomeRow viewRow1 = view.getRow(0);
        assertNotNull("Row NOT found", viewRow1 != null);
        assertEquals("Row isn't GBPEUR", viewRow1.instrument, "GBPEUR");

        view.back(1);
        assertEquals("Incorrect number of rows", 2, view.getCount());

        final SomeRow viewRow2 = view.getRow(0);
        assertNotNull("Row NOT found", viewRow2 != null);
        assertEquals("Row isn't GBPUSD", viewRow2.instrument, "GBPUSD");


        table.applySort(new Comparator<SomeRow>() {
            @Override
            public int compare(final SomeRow row1, final SomeRow row2) {
                return row1.instrument.compareTo(row2.instrument);
            }
        });


    }
}
