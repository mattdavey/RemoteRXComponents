package RemoteRXComponents;

import RemoteRXComponents.Table.Row;

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

    @Override
    public int getId() {
        return id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new SomeRow(id, instrument, counterparty, side, notional);
    }
}