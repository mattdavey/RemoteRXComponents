package RemoteRXComponents.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class DataTable<T extends Row> {
    private final ArrayList<T> rows = new ArrayList<T>();
    private final HashMap<Integer, T> rowAccess = new HashMap<>();

    public View getView() {
        return new DataView<T>(this);
    }

    public void add(final T row) {
        rows.add(row);
        rowAccess.put(row.getId(), row);
    }

    public T getRow(final int row) {
        return rows.get(row);
    }

    public void applySort(final Comparator<T> sort) {
        Collections.sort(rows, sort);
    }

    public T getRowById(final int id) {
        return rowAccess.get(id);
    }
}
