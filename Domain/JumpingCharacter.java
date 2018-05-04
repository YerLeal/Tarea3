package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

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
    private int salto = 200;
    private int caida = 370;

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                Thread.sleep(3);
                if(caida == 370){
                    super.setImage(sprite.get(2));
                    salto=370;
                    caida=200;
                    this.sleep(200);
                }
                if (salto > 200) {  
                    super.setImage(sprite.get(0));
                    salto--;
                    this.setY(salto);
                }else{
                    this.sleep(2);
                    super.setImage(sprite.get(1));
                    this.setY(caida);
                    caida++;
                }
                
            } catch (InterruptedException ex) {
            }
        }
    }
}
