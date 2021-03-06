package daybreak.utils;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import daybreak.Tile;

public class MapParser
{
	File file;
	//Never used
	public MapParser(File newFile)
	{
		file = newFile;
	}
	
	//Takes in the exact parameters for storyMap.csv
	public static Tile[][] parseStoryMap() throws FileNotFoundException
	{
		// 1st, creates a CSV parser with the configs
	    CsvParser parser = new CsvParser(new CsvParserSettings());

	    // 2nd, parses all rows from the CSV file into a 2-dimensional array
	    List<String[]> resolvedData = parser.parseAll(new FileReader("maps/storyMap.csv"));
	   
	    //Convert to array for easier traversal
	    String[][] tempArr = resolvedData.toArray(new String[0][0]);
	    
	    Tile[][] ret = new Tile[20][80];
	    
	    for (int i = 0; i < tempArr.length - 1; i++)
	    {
	    	for(int j = 0; j < tempArr[0].length; j++)
	    	{
	    		switch(tempArr[i][j])
	    		{
	    		case "-1"://No tile
	    			break;
	    		case "2": //wall
	    			ret[i][j] = new Tile(Tile.WALL);
	    			break;
	    		case "13": //Interior Door
	    			ret[i][j] = new Tile(Tile.INTERIOR_DOOR);
	    			break;
	    		case "18": //Floor
	    			ret[i][j] = new Tile(Tile.FLOOR);
	    			break;
	    		case "21": //Exterior Door
	    			ret[i][j] = new Tile(Tile.EXTERIOR_DOOR);
	    			break;
	    		}
	    	}
	    }
	       
	 
	  //  System.out.println(resolvedData.toArray());
	    //There's going to be a problem where I still have to convert everything to the right type.s
	    return  ret;
		
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(new File("maps/storyMap.csv"));
//		Tile[][] ret = new Tile[80][20];
//		while(scanner.hasNextLine())
//		{
//			String line = scanner.nextLine();
//			Scanner s = new Scanner(line);
//			
//		}
//		
//		return ret;
		
	}
//	public static void main(String[] args)
//	{
//		try
//		{
//			parseStoryMap();
//		} catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
