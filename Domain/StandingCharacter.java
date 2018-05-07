package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 4; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Standing" + i + ".png")));     
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int image = 0;
        while (true) {
            try {
                super.setImage(sprite.get(image));
                sleep(150);
                image++;
                if(image==3){
                    image=0;
                }
                if(image==1){
                    sleep(500);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(StandingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
