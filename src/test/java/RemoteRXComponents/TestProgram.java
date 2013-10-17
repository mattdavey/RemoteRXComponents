package RemoteRXComponents;

import RemoteRXComponents.Table.DataTable;
import RemoteRXComponents.Table.Filter;
import RemoteRXComponents.Table.Row;
import RemoteRXComponents.Table.View;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class TestProgram {

    public class SomeRow implements Row {
        public int id;
        public String instrument;
        public String counterparty;
        public String side;
        public double notional;

        public SomeRow(final int id, final String instrument, final String counterparty, final String side, final double notional) {
            this.id = id;
            this.instrument = instrument;
            this.counterparty = counterparty;
            this.side = side;
            this.notional = notional;
        }
    }

    public static void main(final String[] args) {
        new TestProgram().run();
    }

    private void run() {
        final DataTable<SomeRow> table = new DataTable(SomeRow.class);
        final SomeRow someRow = new SomeRow(4, "GBPUSD", "counterparty1", "Sell", 12.2);
        table.add(someRow);

        final SomeRow row = table.getRow(1);
        assertNotNull("Row NOT found", row != null);
        assertEquals("Row isn't GPBUSD", row.instrument, "GBPUSD");

        final SomeRow someRow1 = new SomeRow(2, "GBPEUR", "counterparty2", "Buy", 12.3);
        table.add(someRow1);

        // an update
        someRow.counterparty = "Counterparty2";

        final View view = table.getView().setRowWindow(2).connect();
        view.applyFilter(new Filter("name", Filter.Order.Ascending));
        assertEquals("Number of rows in view", 2, view.getCount());

        final SomeRow someRow2 = new SomeRow(3, "GBPJPY", "counterparty2", "Buy", 12.3);
        table.add(someRow2);

        assertEquals("Number of rows in view", 3, view.getCount());
    }
}
