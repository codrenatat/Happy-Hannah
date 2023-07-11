package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprites {
    public int worldX;
    public int worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int Counter = 0;
    public int number = 1;
    public Rectangle Area;
    public boolean collisionOn = false;

}
