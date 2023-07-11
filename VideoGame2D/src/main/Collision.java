package main;

import Entity.Sprites;

public class Collision {
    GamePanel gamePanel;
    public Collision(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void Check(Sprites sprites){
        int LeftWorldX = sprites.worldX + sprites.Area.x;
        int RightWorldX = sprites.worldX + sprites.Area.x + sprites.Area.width;
        int TopWorldY = sprites.worldY + sprites.Area.y;
        int BottomWorldY = sprites.worldY + sprites.Area.y + sprites.Area.height;

        int LeftCol = LeftWorldX/gamePanel.TileSize;
        int RightCol = RightWorldX/gamePanel.TileSize;
        int TopRow = TopWorldY/gamePanel.TileSize;
        int BottomRow = BottomWorldY/gamePanel.TileSize;

        int Tile1;
        int Tile2;

        switch (sprites.direction){
            case "up":
                TopRow = (TopWorldY - sprites.speed)/gamePanel.TileSize;
                Tile1 = gamePanel.tileM.Map[LeftCol][TopRow];
                Tile2 = gamePanel.tileM.Map[RightCol][TopRow];
                if (gamePanel.tileM.tiles[Tile1].collision == true || gamePanel.tileM.tiles[Tile2].collision == true){
                    sprites.collisionOn = true;
                }
                break;
            case "down":
                BottomRow = (BottomWorldY + sprites.speed)/gamePanel.TileSize;
                Tile1 = gamePanel.tileM.Map[LeftCol][BottomRow];
                Tile2 = gamePanel.tileM.Map[RightCol][BottomRow];
                if (gamePanel.tileM.tiles[Tile1].collision == true || gamePanel.tileM.tiles[Tile2].collision == true){
                    sprites.collisionOn = true;
                }
                break;
            case "left":
                LeftCol = (LeftWorldX - sprites.speed)/gamePanel.TileSize;
                Tile1 = gamePanel.tileM.Map[LeftCol][BottomRow];
                Tile2 = gamePanel.tileM.Map[LeftCol][BottomRow];
                if (gamePanel.tileM.tiles[Tile1].collision == true || gamePanel.tileM.tiles[Tile2].collision == true){
                    sprites.collisionOn = true;
                }
                break;
            case "right":
                RightCol = (RightWorldX - sprites.speed)/gamePanel.TileSize;
                Tile1 = gamePanel.tileM.Map[RightCol][BottomRow];
                Tile2 = gamePanel.tileM.Map[RightCol][BottomRow];
                if (gamePanel.tileM.tiles[Tile1].collision == true || gamePanel.tileM.tiles[Tile2].collision == true){
                    sprites.collisionOn = true;
                }
                break;
        }
    }
}
