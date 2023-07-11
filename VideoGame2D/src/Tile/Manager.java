package Tile;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Manager {
    GamePanel gamePanel;
    public tile[] tiles;
    public int Map[][];

    public Manager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tiles = new tile[10];
        Map = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        LoadMaps("/Map/1World.txt");
    }

    public void getTileImage(){
        try {
            tiles[0] = new tile();
            tiles[0].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/pastito.jpg"));

            tiles[1] = new tile();
            tiles[1].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/Wall.png"));
            tiles[1].collision = true;

            tiles[2] = new tile();
            tiles[2].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water.png"));
            tiles[2].collision = true;

            tiles[3] = new tile();
            tiles[3].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/arbol.jpg"));
            tiles[3].collision = true;

            tiles[4] = new tile();
            tiles[4].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/fence.jpg"));
            tiles[4].collision = true;

            tiles[5] = new tile();
            tiles[5].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/flores.jpg"));

            tiles[6] = new tile();
            tiles[6].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/hongo.jpg"));

            tiles[7] = new tile();
            tiles[7].Image = ImageIO.read(getClass().getResourceAsStream("/tiles/tierra.jpg"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void LoadMaps(String Path){
        try {
            InputStream is = getClass().getResourceAsStream(Path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow){
                String line = br.readLine();

                while (col < gamePanel.maxWorldCol){
                    String numbers[] = line.split("");
                    int num = Integer.parseInt(numbers[col]);

                    Map[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void Draw(Graphics2D graphics2D){
        int worldColumn = 0;
        int worldRow = 0;

        while (worldColumn < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){
            int Tile_Number = Map[worldColumn][worldRow];

            int worldX = worldColumn * gamePanel.TileSize;
            int worldY = worldRow * gamePanel.TileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;


            graphics2D.drawImage(tiles[Tile_Number].Image,screenX,screenY,gamePanel.TileSize, gamePanel.TileSize, null);
            worldColumn++;

            if(worldColumn == gamePanel.maxWorldCol){
                worldColumn = 0;
                worldRow++;
            }
        }
    }
}
