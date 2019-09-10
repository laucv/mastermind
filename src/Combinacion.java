public class Combinacion {
    public char[] secreto;

    public char[] colores;

    public char[] propuesta;

    public int muertos;

    public int heridos;

    public Combinacion(char[] secreto, char[] colores, char[] propuesta, int muertos, int heridos) {
        this.secreto = secreto;
        this.colores = colores;
        this.propuesta = propuesta;
        this.muertos = muertos;
        this.heridos = heridos;
    }

    public String getSecreto() {
        String secretoString = new String(secreto);
        return secretoString;
    }
}
