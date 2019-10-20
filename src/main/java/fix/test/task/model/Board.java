package fix.test.task.model;

public class Board {
    private int height;
    private int wight;

    public Board(int height, int wight) {
        this.wight = wight;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }
}
