package RemoteRXComponents.Table;

public class Filter {
    private final String columnName;
    private final Order order;

    public enum Order {Ascending, Descending}

    public Filter(final String columnName, final Order order) {
        this.columnName = columnName;
        this.order = order;
    }
}
