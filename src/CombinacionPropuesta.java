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

    public boolean comprobarCombinacionPropuesta(CombinacionSecreta combinacionSecreta) {
        return this.getMuertos() == combinacionSecreta.getSecreto().length;
    }

    public boolean comprobarCondicionesCombinacionPropuesta(String prediccionString, char[] colores, CombinacionSecreta combinacionSecreta) {
        boolean correcto = true;

        if (prediccionString.length() != combinacionSecreta.getSecreto().length) {
            correcto = false;
            System.out.println("Solo puedes introducir cuatro colores.");
        } else {

            for (int i = 0; i < this.getPropuesta().length; i++) {
                for (int j = 0; j < colores.length; j++) {
                    if (prediccionString.charAt(i) == colores[j]) {
                        this.setPropuesta(i, prediccionString.charAt(i));
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
                if (this.getPropuesta()[0] == this.getPropuesta()[1] || this.getPropuesta()[0] == this.getPropuesta()[2] ||
                        this.getPropuesta()[0] == this.getPropuesta()[3] || this.getPropuesta()[1] == this.getPropuesta()[2] ||
                        this.getPropuesta()[1] == this.getPropuesta()[3] || this.getPropuesta()[2] == this.getPropuesta()[3]) {
                    correcto = false;
                    System.out.println("No puedes repetir colores.");
                }
            }
        }

        return correcto;
    }

    public void comprobarMuertos(CombinacionSecreta combinacionSecreta) {
        int contadorMuertos = 0;
        for (int i = 0; i < combinacionSecreta.getSecreto().length; i++) {
            if (combinacionSecreta.getSecreto()[i] == this.getPropuesta()[i]) {
                contadorMuertos++;
            }
        }
        this.setMuertos(contadorMuertos);
    }

    public void comprobarHeridos(CombinacionSecreta combinacionSecreta) {
        int contadorHeridos = 0;
        for (int i = 0; i < combinacionSecreta.getSecreto().length; i++) {
            for (int j = 0; j < combinacionSecreta.getSecreto().length; j++) {
                if (combinacionSecreta.getSecreto()[i] == this.getPropuesta()[j]) {
                    contadorHeridos++;
                }
            }
        }
        this.setHeridos(contadorHeridos- this.getMuertos());
    }

    public char[] getPropuesta() {
        return propuesta;
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
