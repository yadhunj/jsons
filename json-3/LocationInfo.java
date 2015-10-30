import java.io.FileReader;
import java.util.Iterator;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LocationInfo
{
  Double latitude;
  Double longitude;
  String timezone;
  Double offset;

  public void read(JSONObject jsonObj)
  {
    try
    {
      latitude = (Double) jsonObj.get("latitude");

      longitude = (Double) jsonObj.get("longitude");

      timezone = (String) jsonObj.get("timezone");

      offset = (Double) jsonObj.get("offset");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void print()
  {
    System.out.println(latitude);

    System.out.println(longitude);

    System.out.println(timezone);

    System.out.println(offset);  
  }
}
