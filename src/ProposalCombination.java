public class ProposalCombination extends Combination {

    public boolean isValid(String string) {

        if (!this.checkLength(string)) {
            System.out.println("Solo puedes introducir cuatro colores.");
            return false;
        } else if (!this.checkColors(string)) {
            System.out.println("Los colores válidos son: r, g, y, b, o, p.");
            return false;
        } else if (this.checkRepeatColors()) {
            System.out.println("No puedes repetir colores.");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkLength(String string) {
        return string.length() == this.colors.length;
    }

    private boolean checkColors(String string) {
        boolean isValid = false;
        Color colorUser = Color.r;
        for (int i = 0; i < this.colors.length; i++) {
            colorUser = colorUser.getColor(string.charAt(i));
            for (Color color : Color.values()) {
                if (color == colorUser) {
                    this.setColorsInPosition(i, color);
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;
    }

    private boolean checkRepeatColors(){
        return (this.colors[0] == this.colors[1] || this.colors[0] == this.colors[2] || this.colors[0] == this.colors[3] ||
                this.colors[1] == this.colors[2] || this.colors[1] == this.colors[3] || this.colors[2] == this.colors[3]);
    }
}
