package Models;

public enum Color {
    r,
    b,
    y,
    g,
    o,
    p;

    public Color getColor(char character){
        return Color.valueOf(String.valueOf(character));
    }

}
