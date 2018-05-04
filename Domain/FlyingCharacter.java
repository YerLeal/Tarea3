/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author Yerlin Leal
 */
public class FlyingCharacter extends Character {

    private int movimiento = 300;
    private int image = 0;

    public FlyingCharacter(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 6; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Fly" + i + ".png")));

        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        while (true) {
            try {
                super.setImage(sprite.get(image));
                image++;
                super.setX(movimiento);
                movimiento += 5;

                if (movimiento == 810) {
                    movimiento = 0;
                }
                if (image == 6) {
                    image = 0;
                }
                sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }

}
