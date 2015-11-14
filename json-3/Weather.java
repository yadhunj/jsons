// This program parses a json file that has information about the weather
// conditions of a place and saves them in data structures and prints them
// using the print methods.

import java.io.FileReader;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class Weather
{ 
  public static void main(String[] args) 
  {
    JSONParser parser = new JSONParser();

    try 
    {                                                       
      FileReader file = new FileReader("/home/yadhunj/jsons/json-3/tw.json");                                                                                 
      JSONObject jObj = (JSONObject) parser.parse(file);
      
      // Get location information  
      LocationInfo locinf =new LocationInfo();
      locinf.read(jObj);
      locinf.print();

      // Get current weather condition
      JSONObject currently = (JSONObject) jObj.get("currently");
      DataPoints dPoints = new DataPoints();
      dPoints.read(currently);
      dPoints.print();
 
      // Get hourly weather condition
      JSONObject hourly = (JSONObject) jObj.get("hourly");
      ArrayList hpt;
      hpt =  readHourlyData(hourly);
      printHourlyData(hpt);
      // Get daily weather condition
      JSONObject daily = (JSONObject) jObj.get("daily");
      ArrayList dpt;
      dpt = readDailyData(daily);
      printDailyData(dpt);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }      
  }

  public static ArrayList readHourlyData(JSONObject jObject)
  {   
    ArrayList hourlist = new ArrayList();  
    JSONArray hourlydata = (JSONArray) jObject.get("data");
    Iterator i = hourlydata.iterator();
    while (i.hasNext())
    {
      JSONObject jObjt = (JSONObject) i.next();
      HourlyDataPoints hPoints = new HourlyDataPoints();
      hPoints.read(jObjt);
      hourlist.add(hPoints);
    } 
    return hourlist;
  }
   
  public static void printHourlyData(ArrayList hpt)
  {
    for(int k = 0; k < hpt.size(); k++)
    {
      HourlyDataPoints hPoints;
      hPoints = (HourlyDataPoints) hpt.get(k);
      hPoints.print();
    }
  }
  
  public static ArrayList readDailyData(JSONObject jObj)
  {
    ArrayList dailylist = new ArrayList();
    JSONArray dailydata = (JSONArray) jObj.get("data");
    Iterator j = dailydata.iterator();
    while (j.hasNext())
    {
      JSONObject jObjt = (JSONObject) j.next();
      DailyDataPoints dDPoints = new DailyDataPoints();
      dDPoints.read(jObjt);
      dailylist.add(dDPoints);
    }
    return dailylist;
  } 
 
  public static void printDailyData(ArrayList dpt)
  {
    for(int l = 0; l < dpt.size(); l++)
    {
      DailyDataPoints dPoints;
      dPoints = (DailyDataPoints) dpt.get(l);
      dPoints.print();
    }
  }
}
