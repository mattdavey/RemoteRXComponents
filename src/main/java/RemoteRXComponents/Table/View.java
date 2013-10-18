package RemoteRXComponents.Table;

public interface View<T extends Row> {
    int getCount();
    View setViewPortSize(final int rowCount);
    View connect();
    T getRow(final int row);
    void forward(final int count);
    void back(final int count);
}
