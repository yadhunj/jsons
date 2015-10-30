import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HourlyDataPoints
{
  long time;
  String summary;
  String icon;
  long precipIntensity;
  long precipProbability;
  Double temperature;
  Double apparentTemperature;
  Double dewPoint;
  Double humidity;
  Double windSpeed;
  long windBearing;
  Double cloudCover;
  Double pressure;
  Double ozone;

  public void read(JSONObject jObject) // this method should read for only one hour, like you do for currently
  {
    try
    {
        time = (long) jObject.get("time");

        summary = (String) jObject.get("summary");

        icon = (String) jObject.get("icon");

        precipIntensity = (long) jObject.get("precipIntensity");

        precipProbability = (long) jObject.get("precipProbability");
  
        temperature = (Double) jObject.get("temperature");

        apparentTemperature = (Double) jObject.get("apparentTemperature");

        dewPoint = (Double) jObject.get("dewPoint");

        humidity = (Double) jObject.get("humidity");

        windSpeed = (Double) jObject.get("windSpeed");

        windBearing = (long) jObject.get("windBearing");

        cloudCover = (Double) jObject.get("cloudCover");

        pressure = (Double) jObject.get("pressure");

        ozone = (Double) jObject.get("ozone");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void print()
  {
    Date date = new Date(time * 1000L);
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    sd.setTimeZone(TimeZone.getTimeZone("GMT"));
    String ourtime = sd.format(date);

    System.out.print(ourtime + ", ");
    
    System.out.print(summary + ", ");

    System.out.print(icon  + ", ");

    System.out.print(precipIntensity + ", ");

    System.out.print(precipProbability + ", ");

    System.out.print(temperature + ", ");

    System.out.print(apparentTemperature + ", ");

    System.out.print(dewPoint + ", ");

    System.out.print(humidity + ", ");

    System.out.print(windSpeed + ", ");

    System.out.print(windBearing + ", ");
    
    System.out.print(cloudCover + ", ");

    System.out.print(pressure + ", ");

    System.out.println(ozone);
  }
}
