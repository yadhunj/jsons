import java.io.*;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class flight
{ 
  public static void main(String[] args) 
  {
    try 
    {                       
      JSONParser parser = new JSONParser();                                
      FileReader file = new FileReader("/home/yadhunj/Flight/Dflight/SFlight/dflight.json");                                                                                 
      JSONObject jObj = (JSONObject) parser.parse(file);
      	
      JSONObject trips = (JSONObject) jObj.get("trips");
      readTripOption(trips);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }      
  static void readTripOption(JSONObject jObject)
  {
    try
    {
      JSONArray tripOption = (JSONArray) jObject.get("tripOption");
      Iterator j = tripOption.iterator();
      System.out.println("\nSOLUTION #");
      while (j.hasNext())
      {
        JSONObject jObjt = (JSONObject) j.next();    
        String saletotal = (String) jObjt.get("saleTotal");
        System.out.println("Sale Price:" + saletotal);
    
        JSONArray slice = (JSONArray) jObjt.get("slice");
        Iterator i = slice.iterator();
        JSONObject jt = (JSONObject) i.next();

        JSONArray segment = (JSONArray) jt.get("segment");
        Iterator k = segment.iterator();                                                                                                        
        JSONObject jot = (JSONObject) k.next();

        JSONObject Jot = (JSONObject) jot.get("flight");
        String carrier = (String) Jot.get("carrier");
        System.out.print("\n" + carrier);
        String number = (String) Jot.get("number");
        System.out.print("  " + number);

        JSONArray leg = (JSONArray) jot.get("leg");
        Iterator l = leg.iterator();
        JSONObject jObt = (JSONObject) l.next();
        String origin = (String) jObt.get("origin");
        System.out.print("  " + origin);
        String departureTime = (String) jObt.get("departureTime");
        System.out.print("  " + departureTime);
        String destination = (String) jObt.get("destination");
        System.out.print("  " + destination);
        String arrivalTime = (String) jObt.get("arrivalTime");
        System.out.println("  " + arrivalTime);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }      
  }
}
