import java.util.Arrays;

public class CombinacionPropuesta {

    private char[] propuesta;

    private int heridos;

    private int muertos;

    public CombinacionPropuesta() {
        this.propuesta = new char[4];
        this.heridos = 0;
        this.muertos = 0;
    }

    public CombinacionPropuesta(char[] propuesta, int heridos, int muertos) {
        this.propuesta = propuesta;
        this.heridos = heridos;
        this.muertos = muertos;
    }

    public boolean comprobarCombinacionPropuesta(CombinacionPropuesta combinacionPropuesta, CombinacionSecreta combinacionSecreta) {
        if (combinacionPropuesta.getMuertos() == combinacionSecreta.getSecreto().length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarCondicionesCombinacionPropuesta(String prediccionString, char[] colores, CombinacionPropuesta combinacionPropuesta, CombinacionSecreta combinacionSecreta) {
        boolean correcto = true;

        if (prediccionString.length() != combinacionSecreta.getSecreto().length) {
            correcto = false;
            System.out.println("Solo puedes introducir cuatro colores.");
        } else {

            for (int i = 0; i < combinacionPropuesta.getPropuesta().length; i++) {
                for (int j = 0; j < colores.length; j++) {
                    if (prediccionString.charAt(i) == colores[j]) {
                        combinacionPropuesta.setPropuesta(i, prediccionString.charAt(i));
                        correcto = true;
                        j = colores.length;
                    } else {
                        correcto = false;
                    }
                }
            }

            if (!correcto) {
                System.out.println("Los colores válidos son: r, g, y, b, o, p.");
            } else {
                if (combinacionPropuesta.getPropuesta()[0] == combinacionPropuesta.getPropuesta()[1] ||
                        combinacionPropuesta.getPropuesta()[0] == combinacionPropuesta.getPropuesta()[2] ||
                        combinacionPropuesta.getPropuesta()[0] == combinacionPropuesta.getPropuesta()[3] ||
                        combinacionPropuesta.getPropuesta()[1] == combinacionPropuesta.getPropuesta()[2] ||
                        combinacionPropuesta.getPropuesta()[1] == combinacionPropuesta.getPropuesta()[3] ||
                        combinacionPropuesta.getPropuesta()[2] == combinacionPropuesta.getPropuesta()[3]) {
                    correcto = false;
                    System.out.println("No puedes repetir colores.");
                }
            }
        }

        return correcto;
    }

    public void comprobarMuertos(CombinacionPropuesta combinacionPropuesta, CombinacionSecreta combinacionSecreta) {
        for (int i = 0; i < combinacionSecreta.getSecreto().length; i++) {
            if (combinacionSecreta.getSecreto()[i] == combinacionPropuesta.getPropuesta()[i]) {
                combinacionPropuesta.setMuertos(combinacionPropuesta.getMuertos() + 1);
            }
        }
    }

    public void comprobarHeridos(CombinacionPropuesta combinacionPropuesta, CombinacionSecreta combinacionSecreta) {
        for (int i = 0; i < combinacionSecreta.getSecreto().length; i++) {
            for (int j = 0; j < combinacionSecreta.getSecreto().length; j++) {
                if (combinacionSecreta.getSecreto()[i] == combinacionPropuesta.getPropuesta()[j]) {
                    combinacionPropuesta.setHeridos(combinacionPropuesta.getHeridos() + 1);
                }
            }
        }
        combinacionPropuesta.setHeridos(combinacionPropuesta.getHeridos() - combinacionPropuesta.getMuertos());
    }

    public char[] getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(char[] propuesta) {
        this.propuesta = propuesta;
    }

    public void setPropuesta(int posicion, char color) {
        this.propuesta[posicion] = color;
    }


    public int getHeridos() {
        return heridos;
    }

    public void setHeridos(int heridos) {
        this.heridos = heridos;
    }

    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    @Override
    public String toString() {
        return Arrays.toString(propuesta);
    }
}
