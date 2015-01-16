import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import GridMap.java;
import AStarPathFinder.java;
import Path.java;
import PathFinder.java;
import AdmissibleHeuristic.java;
import NonAdmissibleHeuristic.java;

public class RobotsAI {
  public static void main(String[] args) throws Exception {
    InputStream is = null;
    InputStreamReader isr = null;
    BufferedReader br = null;
    try{
      // open input stream mytext.txt for reading purpose.
      is = new FileInputStream("c:/mytext.txt");
      // create new input stream reader
      isr = new InputStreamReader(is);
      // create new buffered reader
      br = new BufferedReader(isr);
      int value=0;
      // reads to the end of the stream
      int [] numbers;
      numbers = new int[8];
      int i = 0;
      int j = 0;
      while (((value = br.read()) != 1) &&  !(i==8)
      {
        if ( ((value)!= ' ') && ((value) != '\n') ) {
        numbers[i] = value;
        i+=1;
      }
      }
      GridMap gridmap = new GridMap(numbers[0],numbers[1]);
      for (int i = 0;i < numbers[0];i++){
        for (int j= 0;j < numbers[1];j++){
        value = br.read();
        if ( value == 'X' ) gridmap.setObstacle(i,j);
        }
      }
    
      int x1 = numbers[2];
      int y1 = numbers[3];
      int x2 = numbers[4];
      int y2 = numbers[5];
      int tx = numbers[6];
      int ty = numbers[7];
      
      private PathFinder finder;
      AdmissibleHeuristic manhattan = new AdmissibleHeuristic();
      private Path path1;
      private Path path2;
    
      finder = new AStarPathFinder(grid, grid.getWidthInTiles()*grid.getHeightInTiles(), false, manhattan);
      path1 = finder.findPath(new Robot(), x1, y1, tx, ty);
      //if (path1 = null) no path!
      path2 = finder.findPath(new Robot(), x2, y2, tx, ty);
      //if (path2 = null) no path!
      if (path1.getLength() = path2.getLength()) {
      	int i = 0;
      	int n = path1.getLength();
      	while ( !(path1.getStep(i).equals(path2.getStep(i))) && (i < n)){
      		i++;
      	}
      	if (i != n) { //Collision detected! Recalculating path for robot 2
        	Path collisionPath = new Path();
        	int colStep = i;
        	Path temp = path2;
        	while (i < n) {
        		collisionPath.prependStep(path1.getX(i),path1.getY(i));
        		i++;
        	}
        	path2 = finder.findPathNoCollision(new Robot(), path2.getX(colStep-1), path2.getY(colStep-1), tx, ty, collisionPath);
        	i = 1;
        	while (i <= colStep) {
        		path2.prependStep(temp.getX(colStep - i),temp.getY(colStep - i));
        		i++;
        	}
        }
      	path1.appendStep(tx,ty);
      }
      else {
  	    path1.appendStep(tx,ty);
      }
      //print results
      
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      // releases resources associated with the streams
      if(is!=null)
      is.close();
      if(isr!=null)
      isr.close();
      if(br!=null)
      br.close();
    }
  }
}
