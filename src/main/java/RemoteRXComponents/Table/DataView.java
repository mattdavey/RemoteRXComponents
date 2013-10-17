package RemoteRXComponents.Table;

/**
 * Comments here
 */
public class DataView<T extends Row> implements View {
    public DataView(DataTable<T> tDataTable) {
    }

    @Override
    public void applyFilter(Filter name) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public View setRowWindow(int rowCount) {
        return this;
    }

    @Override
    public View connect() {
        return null;
    }
}
