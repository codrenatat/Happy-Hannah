package Entity;

import main.GamePanel;
import main.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Sprites {
    GamePanel gamePanel;
    Keys keys;

    public final int screenX;
    public final int screenY;

    int counter2 = 0;

    public Player(GamePanel gamePanel, Keys keys){
        this.gamePanel = gamePanel;
        this.keys = keys;
        screenX = gamePanel.Width/2 - (gamePanel.TileSize/2);
        screenY = gamePanel.Height/2- (gamePanel.TileSize/2);
        Area = new Rectangle();
        Area.x = 0;//8
        Area.y = 0;//16
        Area.width = 48;//32
        Area.height = 48;//32
        Default();
        getPlayerImage();
    }

    public void Default(){
        worldX = gamePanel.TileSize * 23;
        worldY = gamePanel.TileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/girl-up-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/girl-up-2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/girl-down-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/girl-down-2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/girl-left-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/girl-left-2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/girl-right-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/girl-right-2.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keys.up == true){
            direction = "up";
        } else if (keys.down == true) {
            direction = "down";
        } else if (keys.left == true) {
            direction = "left";
        } else if(keys.right == true){
            direction = "right";
        }

        collisionOn = false;
        gamePanel.check.Check(this);

        if (collisionOn == false){
            switch (direction){
                case "up": worldY = worldY - speed;break;
                case "down": worldY = worldY + speed;break;
                case "left": worldX = worldX - speed;break;
                case "right": worldX = worldX + speed;break;
            }
        }

        Counter++;
        if(Counter > 10){
            if(number == 1){
                number = 2;
            }
            else if (number == 2){
                number = 1;
            }
            Counter = 0;
        }
    }

    public void draw(Graphics2D g){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if(number == 1){
                    image = up1;
                }
                if(number == 2){
                    image = up2;
                }
                break;
            case "down":
                if(number == 1) {
                    image = down1;
                }
                if(number == 2){
                    image = down2;
                }
                break;
            case "right":
                if(number == 1) {
                    image = right1;
                }
                if(number == 2){
                    image = right2;
                }
                break;
            case "left":
                if(number == 1){
                    image = left1;
                }
                if(number == 2){
                    image = left2;
                }
                break;
            default:
                System.out.println("Error");
        }
        g.drawImage(image,screenX,screenY,gamePanel.TileSize, gamePanel.TileSize, null);
    }

}
