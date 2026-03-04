public class Tile {
    private String value;
    private boolean isShowing;
    private boolean isMatched;

    public Tile(String val) {
        value = val;
        isShowing = false;
        isMatched = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setShowing(boolean showing) {
        isShowing = showing;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public String toString() {
        return value;
    }
}