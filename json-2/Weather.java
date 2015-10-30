import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class Weather
{ 
  public static void main(String[] args) 
  {
    JSONParser parser = new JSONParser();

    try 
    {                                                       
      FileReader file = new FileReader("/home/yadhunj/json-2/weather.json");                                                                                 
      JSONObject jObj = (JSONObject) parser.parse(file);
        
      Double latitude = (Double) jObj.get("latitude");         
      System.out.println(latitude);

      Double longitude = (Double) jObj.get("longitude");
      System.out.println(longitude);
        
      String timezone = (String) jObj.get("timezone");
      System.out.println(timezone);

      long offset = (long) jObj.get("offset");
      System.out.println(offset);

      JSONObject currently = (JSONObject) jObj.get("currently");
      DataPoints dPoints = new DataPoints();
      dPoints.read(currently);
      dPoints.print();
      //readDataPoints(currently); 
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }      
  } 

/*
  // Method to read a given object and print.
  public static void readDataPoints(JSONObject jsonObject)
  {
    try
    {   
      long time = (long) jsonObject.get("time");
      Date date = new Date(time*1000L);
      SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); 
      sd.setTimeZone(TimeZone.getTimeZone("GMT"));
      String ourtime = sd.format(date);
      System.out.println(ourtime);
     
      String summary = (String) jsonObject.get("summary");
      System.out.println(summary);                                                                                                                                  
      String icon = (String) jsonObject.get("icon");
      System.out.println(icon);
    
      long nearestStromDistance = (long) jsonObject.get("nearestStormDistance");               
      System.out.println(nearestStromDistance);

      long nearestStromBearing = (long) jsonObject.get("nearestStormBearing");        
      System.out.println(nearestStromBearing);

      long precipIntensity = (long) jsonObject.get("precipIntensity");
      System.out.println(precipIntensity);

      long precipProbability = (long) jsonObject.get("precipProbability");      
      System.out.println(precipProbability);
      
      long temperature = (long) jsonObject.get("temperature");                             
      System.out.println(temperature);
      
      long apparentTemperature = (long) jsonObject.get("apparentTemperature");                  
      System.out.println(apparentTemperature);
      
      Double dewPoint = (Double) jsonObject.get("dewPoint");                             
      System.out.println(dewPoint);
      
      Double humidity = (Double) jsonObject.get("humidity");                               
      System.out.println(humidity);
  
      Double windSpeed = (Double) jsonObject.get("windSpeed");                                  
      System.out.println(windSpeed);
     
      long windBearing = (long) jsonObject.get("windBearing");                                
      System.out.println(windBearing);
     
      Double visibility = (Double) jsonObject.get("visibility");      
      System.out.println(visibility);
     
      Double cloudCover = (Double) jsonObject.get("cloudCover");             
      System.out.println(cloudCover);
       
      Double pressure = (Double) jsonObject.get("pressure");                
      System.out.println(pressure);
        
      Double ozone = (Double) jsonObject.get("ozone");                              
      System.out.println(ozone);
    }
    catch (Exception e) 
    {   
      e.printStackTrace();
    }
  }
*/
}
