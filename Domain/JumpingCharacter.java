package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    private int jump = 200;
    private int fall = 370;

    public JumpingCharacter(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping" + i + ".png")));
        }

    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();

        while (true) {
            try {
                Thread.sleep(3);
                if (fall == 370) {
                    super.setImage(sprite.get(2));
                    jump = 370;
                    fall = 200;
                    this.sleep(200);
                }
                if (jump > 200) {
                    super.setImage(sprite.get(0));
                    jump--;
                    this.setY(jump);
                } else {
                    this.sleep(2);
                    super.setImage(sprite.get(1));
                    this.setY(fall);
                    fall++;
                }

            } catch (InterruptedException ex) {
            }
        }
    }
}
