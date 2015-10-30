import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataPoints
{
  long time;
  String ourtime;
  String summary;
  String icon;
  long nearestStormDistance;
  long nearestStormBearing;
  long precipIntensity;
  long precipProbability;
  long temperature;
  long apparentTemperature;
  Double dewPoint;
  Double humidity;
  Double windSpeed;
  long windBearing;
  Double visibility;
  Double cloudCover;
  Double pressure;
  Double ozone;

  public void read(JSONObject jsonObject)
  {
    try
    {
      time = (long) jsonObject.get("time");
      Date date = new Date(time*1000L);
      SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
      sd.setTimeZone(TimeZone.getTimeZone("GMT"));
      ourtime = sd.format(date);

      summary = (String) jsonObject.get("summary");

      icon = (String) jsonObject.get("icon");

      nearestStormDistance = (long) jsonObject.get("nearestStormDistance");

      nearestStormBearing = (long) jsonObject.get("nearestStormBearing"); 
 
      precipIntensity = (long) jsonObject.get("precipIntensity");

      precipProbability = (long) jsonObject.get("precipProbability");
  
      temperature = (long) jsonObject.get("temperature");

      apparentTemperature = (long) jsonObject.get("apparentTemperature");

      dewPoint = (Double) jsonObject.get("dewPoint");

      humidity = (Double) jsonObject.get("humidity");

      windSpeed = (Double) jsonObject.get("windSpeed");

      windBearing = (long) jsonObject.get("windBearing");

      visibility = (Double) jsonObject.get("visibility");

      cloudCover = (Double) jsonObject.get("cloudCover");

      pressure = (Double) jsonObject.get("pressure");

      ozone = (Double) jsonObject.get("ozone");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void print()
  {
    System.out.println(ourtime);
    
    System.out.println(summary);

    System.out.println(icon);

    System.out.println(nearestStormDistance);

    System.out.println(nearestStormBearing);

    System.out.println(precipIntensity);

    System.out.println(precipProbability);

    System.out.println(temperature);

    System.out.println(apparentTemperature);

    System.out.println(dewPoint);

    System.out.println(humidity);

    System.out.println(windSpeed);

    System.out.println(windBearing);

    System.out.println(visibility);

    System.out.println(cloudCover);

    System.out.println(pressure);

    System.out.println(ozone);
  }

}

