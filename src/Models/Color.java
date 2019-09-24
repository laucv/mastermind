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

    public boolean doesColorExits(char character){
        for (Color color : Color.values()){
            if(color.toString().equals(String.valueOf(character))){
                return true;
            }
        }
        return false;
    }
}
