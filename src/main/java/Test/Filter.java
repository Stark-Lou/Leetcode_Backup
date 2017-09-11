package Test;

/**
 * Created by Lou on 2017/4/10.
 */
public interface Filter {
    void setFilter(String fltr);

    boolean applyFilter(String value);
}
