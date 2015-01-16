import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import GridMap.java;

public class MapFromFile {
   public static void main(String[] args) throws Exception {
      
      InputStream is = null; 
      InputStreamReader isr = null;
      BufferedReader br = null;

      try{
         // open input stream mytext.txt for reading purpose.
         is = new FileInputStream("c:/mytext.txt");
         
         // create new input stream reader
         isr = new InputStreamReader(is);
         
         // create new buffered reader
         br = new BufferedReader(isr);
      
         int value=0;
         
         // reads to the end of the stream 
        
         int [] numbers;
         numbers = new int[8];
    
         int i = 0;
         int j = 0; 
    
         while ((value = br.read()) != -1) {
            if (i = 8) {
               break;
               }
            if ( ((value)!= ' ') && ((value) != '\n') ) {
               numbers[i] = value;
               i+=1;
            }
         }     
         
         GridMap gridmap = new GridMap(numbers[1],numbers[2]); 

         Boolean[][] map = new Boolean[numbers[1]][numbers[2]];
         Arrays.fill(map, Boolean.FALSE);
            
            for (int i = 0;i < numbers[1];i++){
               for (int j= 0;j < numbers[2];j++){
                  value = br.read();       
                  if ( value == 'X' ){
                     gridmap.setObstacle(i,j);
                     map[i][j] = Boolean.TRUE;
                  }
               }
            }
         
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         
         // releases resources associated with the streams
         if(is!=null)
            is.close();
         if(isr!=null)
            isr.close();
         if(br!=null)
            br.close();
      }
   }
}

