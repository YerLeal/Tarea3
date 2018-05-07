package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    private int movement = -50;
    private int image = 0;

    public RunningCharacter(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(image));

        while (true) {
            try {
                image++;
                super.setX(movement);
                movement += 10;
                super.setImage(sprite.get(image));
                sleep(100);
                if (image == 7) {
                    image = 0;
                }
                if (movement == 810) {
                    movement = 0;
                }
            } catch (InterruptedException ex) {
            }
        }
    }

} // fin de la clase
