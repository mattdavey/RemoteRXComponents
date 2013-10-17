package RemoteRXComponents.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataTable<T extends Row> {
    private final ArrayList<T> rows = new ArrayList<T>();

    public DataTable(Class<T> type) {

//        for (final Field field : type.getDeclaredFields()) {
//            final String fieldName = field.getName();
//            final String s = field.getType().toString();
//            if (s.equals("int")) {
//            } else if (s.equals("String")) {
//            }
//        }
    }

    public View getView() {
        return new DataView<T>(this);
    }

    public void add(final T row) {
        rows.add(row);
    }

    public T getRow(int row) {
        return rows.get(row-1);
    }
}
