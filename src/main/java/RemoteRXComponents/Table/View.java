package RemoteRXComponents.Table;

/**
 * Created with IntelliJ IDEA.
 * User: mattdavey
 * Date: 17/10/2013
 * Time: 01:23
 * To change this template use File | Settings | File Templates.
 */
public interface View {
    void applyFilter(Filter name);

    int getCount();

    View setRowWindow(final int rowCount);

    View connect();
}
