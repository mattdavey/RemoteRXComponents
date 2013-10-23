package RemoteRXComponents.Table;

import java.util.ArrayList;

public class DataView<T extends Row> implements View {
    private final DataTable<T> dataTable;
    private int viewPointSize;
    private int begin=0, end=0;
    private final ArrayList<T> viewport = new ArrayList<>();

    public DataView(final DataTable<T> dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public int getCount() {
        return viewport.size();
    }

    @Override
    public View setViewPortSize(final int rowCount) {
        this.viewPointSize = rowCount;
        this.end = rowCount-1;
        return this;
    }

    @Override
    public View connect() {
        for (int rows=begin; rows <= end; rows++) {
            final T obj = dataTable.getRow(rows);
            viewport.add(obj);

        }

        return this;
    }

    @Override
    public T getRow(int row) {
        return viewport.get(row);
    }

    @Override
    public void forward(final int count) {
        for (int row=0; row < count; row++) {
            viewport.remove(begin+row);
            viewport.add(dataTable.getRow(end + row + 1));
        }

        begin += count;
        end += count;
    }

    @Override
    public void back(int count) {
        for (int row=0; row < count; row++) {
            viewport.remove(viewport.size()-1);
            viewport.add(0, dataTable.getRow(begin - row - 1));
        }

        begin -= count;
        end -= count;
    }
}
