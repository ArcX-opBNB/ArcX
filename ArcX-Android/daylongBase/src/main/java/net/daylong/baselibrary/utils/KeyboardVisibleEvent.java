package net.daylong.baselibrary.utils;

public class KeyboardVisibleEvent {
    private boolean isVisible;
    private int heightDiff;

    public KeyboardVisibleEvent(boolean isVisible, int heightDiff) {
        this.isVisible = isVisible;
        this.heightDiff = heightDiff;
    }

    public boolean isVisible() {
        return isVisible;
    }


    public void setHeightDiff(int heightDiff) {
        this.heightDiff = heightDiff;
    }

    public int getHeightDiff() {
        return heightDiff;
    }


}
