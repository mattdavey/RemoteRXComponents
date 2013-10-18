package RemoteRXComponents.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DataTable<T extends Row> {
    private final ArrayList<T> rows = new ArrayList<T>();

    public View getView() {
        return new DataView<T>(this);
    }

    public void add(final T row) {
        rows.add(row);
    }

    public T getRow(int row) {
        return rows.get(row);
    }

    public void applySort(final Comparator<T> sort) {
        Collections.sort(rows, sort);
    }
}
