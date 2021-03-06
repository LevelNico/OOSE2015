package med4.game_of_oose.mapping;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import med4.game_of_oose.entities.BasicEnemy;
import med4.game_of_oose.objects.Block;
import med4.game_of_oose.objects.MovingBlock;

public class Map {
	
	private String path;
	private String line;
	private int width, height;
	
	private Block[][] blocks;
	private ArrayList<MovingBlock> movingBlocks;
	private ArrayList<BasicEnemy> basicEnemy;
	
	public Map(String loadPath) {
		path = loadPath;
		
		loadMap();
		
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < blocks.length; i++){
			for(int j = 0; j < blocks[0].length; j++){
				blocks[i][j].draw(g);
			}
		}
		for (int i = 0; i < movingBlocks.size(); i++){
			movingBlocks.get(i).draw(g);
		}
		for (int i = 0; i < basicEnemy.size(); i++){
			basicEnemy.get(i).draw(g);
		}
	}
	
	public void tick(){
		for (int i = 0; i < movingBlocks.size(); i++){
			movingBlocks.get(i).tick();
		}
		for (int i = 0; i < basicEnemy.size(); i++){
			basicEnemy.get(i).tick();
		}
	}
	
	public void loadMap(){
		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		try {
			width = Integer.parseInt(br.readLine());
			height = Integer.parseInt(br.readLine());
			
			blocks = new Block[height][width];
			
			for(int y = 0; y < height; y++){
				line = br.readLine();
				
				String[] tokens = line.split("\\s+");
				
				for(int x = 0; x < width; x++){
					blocks[y][x]= new Block(x * Block.blockSize, y * Block.blockSize, Integer.parseInt(tokens[x]));
				}
			}
			
			line = br.readLine();//read blank line
			line = br.readLine();//read length
			int length = Integer.parseInt(line);
			movingBlocks = new ArrayList<MovingBlock>();
		
			for(int i = 0; i < length; i++){
				line = br.readLine(); //read movingblock stats
				String[] tokens = line.split("\\s+"); //splits the line into tokens
				
				movingBlocks.add(new MovingBlock(Integer.parseInt(tokens[0]) * Block.blockSize, //x
						Integer.parseInt(tokens[1]) * Block.blockSize, //y
						Integer.parseInt(tokens[2]), //id
						Integer.parseInt(tokens[3]) * Block.blockSize, //leftBound
						Integer.parseInt(tokens[4]) * Block.blockSize, //rightBound
						Integer.parseInt(tokens[5]), //w
						Integer.parseInt(tokens[6]))); //h
			}
			
			line = br.readLine();//read blank line
			line = br.readLine();//read length
			int length2 = Integer.parseInt(line);
			basicEnemy = new ArrayList<BasicEnemy>();
			
			for(int i = 0; i < length2; i++){
				line = br.readLine(); //read basicEnemy stats
				String[] tokens = line.split("\\s+"); //splits the line into tokens
				
				basicEnemy.add(new BasicEnemy(Integer.parseInt(tokens[0]) * Block.blockSize, //x
						Integer.parseInt(tokens[1]) * Block.blockSize, //y
						Integer.parseInt(tokens[2]), //id
						Integer.parseInt(tokens[3]) * Block.blockSize, //leftBound
						Integer.parseInt(tokens[4]) * Block.blockSize, //rightBound
						Integer.parseInt(tokens[5]), //xSize
						Integer.parseInt(tokens[6]))); //ySize
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}
	
	public ArrayList<MovingBlock> getMovingBlocks() {
		return movingBlocks;
	}
	
	public ArrayList<BasicEnemy> getBasicEnemies() {
		return basicEnemy;
	}
	
}
