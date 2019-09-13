package Models;

import java.util.Arrays;

public class Combination {

    Color[] colors;

    public Combination() {
        this.colors = new Color[4];
    }

    public Color[] colors() {
        return colors;
    }

    public void setColorsInPosition(int position, Color color) {
        this.colors[position] = color;
    }

    @Override
    public String toString() {
        return Arrays.toString(colors);
    }
}
