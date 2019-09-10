import java.util.Arrays;
import java.util.Random;

public class CombinacionSecreta {
    private char[] secreto;

    public CombinacionSecreta() {
        this.secreto = new char[4];
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
        System.arraycopy(colores,0,copiaColores,0,colores.length);
        Random rand = new Random();

        for (int i = 0; i < this.secreto.length; i++) {
            random = rand.nextInt(copiaColores.length - i);
            this.secreto[i] = copiaColores[random];
            System.arraycopy(copiaColores,random +1, copiaColores, random,copiaColores.length - random - 1);
        }
    }

}
