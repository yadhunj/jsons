import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class ColorTab
{ 
   public static void main(String[] args) 
   {
      JSONParser parser = new JSONParser();

      try 
      {
         // Parse and get the array.
         Object obj = parser.parse(new FileReader("/home/yadhunj/json-1/colors.json"));
         JSONObject jsonObject = (JSONObject) obj;
         JSONArray ColorArray = (JSONArray) jsonObject.get("Colorsarray");

         // Prepare for the loop.
         Iterator i = ColorArray.iterator();
         int k = 1;
         String colorName, hexValue;
         JSONObject slide; 
 
         // Print the array in tabular form with serial number.
         while (i.hasNext())
         {
            slide = (JSONObject) i.next();
            colorName = (String)slide.get("colorName");
            hexValue = (String)slide.get("hexValue");

            System.out.print(k + ". ");  
            System.out.print(colorName + " ");
            System.out.println(hexValue);

            k++;
         }
      }
      catch (Exception e) 
      {
         e.printStackTrace();
      }

   }
}
