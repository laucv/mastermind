import java.util.ArrayList;
import java.util.Random;

public class SecretCombination extends Combination {

    public SecretCombination() {
        this.colors = new Color[4];
        this.setSecret();
    }

    public void setSecret() {
        int random;
        ArrayList<Color> copiaColores = new ArrayList<Color>();
        for (Color color : Color.values()) {
            copiaColores.add(color);
        }
        Random rand = new Random();

        for (int i = 0; i < this.colors.length; i++) {
            random = rand.nextInt(copiaColores.size());
            this.colors[i] = copiaColores.get(random);
            copiaColores.remove(random);
        }
    }

    public Color[] getSecret() {

        return colors;
    }
}
