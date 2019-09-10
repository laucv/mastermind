import java.util.Arrays;
import java.util.Random;

public class CombinacionSecreta {
    private char[] secreto;

    public CombinacionSecreta() {
        this.secreto = new char[4];
    }

    public CombinacionSecreta(char[] secreto) {
        this.secreto = secreto;
    }

    @Override
    public String toString() {
        return Arrays.toString(secreto);
    }

    public char[] getSecreto() {
        return secreto;
    }

    public void setSecreto(char[] colores) {
        int random;
        char[] copiaColores = new char[colores.length];
        for (int i = 0; i < colores.length; i++) {
            copiaColores[i] = colores[i];
        }
        Random rand = new Random();

        for (int i = 0; i < this.secreto.length; i++) {
            random = rand.nextInt(copiaColores.length - i);
            this.secreto[i] = copiaColores[random];
            for (int j = random; j < copiaColores.length - 1; j++) {
                copiaColores[j] = copiaColores[j + 1];
            }
        }
    }

}
