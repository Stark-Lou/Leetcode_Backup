package Test;

/**
 * Created by Lou on 2017/4/10.
 */
public class SimpleFilter implements Filter {
    String fltr = "";

    @Override
    public void setFilter(String fltr) {
        this.fltr = fltr;
    }

    @Override
    public boolean applyFilter(String value) {
        return false;
    }
}
