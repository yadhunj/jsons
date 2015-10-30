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
      FileReader file = new FileReader("/home/yadhunj/json-3/tw.json");                                                                                 
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
      readHourlyData(hourly);
      Weather wr = new Weather();
      System.out.println(wr.hourlist);
     // printHourlyData(hourlist);      
      // Get daily weather condition
      JSONObject daily = (JSONObject) jObj.get("daily");
      readDailyData(daily);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }      
  }

  public static ArrayList readHourlyData(JSONObject jObject)
  {   
    ArrayList hourlist = new ArrayList();  
    try
    {
      JSONArray hourlydata = (JSONArray) jObject.get("data");
    //  ArrayList hourlist = new ArrayList();
      Iterator i = hourlydata.iterator();
      while (i.hasNext())
      {
        JSONObject jObjt = (JSONObject) i.next();
        HourlyDataPoints hPoints = new HourlyDataPoints();
        hPoints.read(jObjt);
        hourlist.add(hPoints);
//        hPoints.print();
      } 
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return hourlist;
  }
   
/*  public static void printHourlyData(ArrayList hourlist)
  {
    try
    {
    //  JSONObject pData = (JSONObject) hourlist.get("hourlist");
      HourlyDataPoints HPoint = new HourlyDataPoints();
    //  HPoint.read(pData);
      HPoint.print();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }*/
  
  public static ArrayList readDailyData(JSONObject jObj)
  {
    ArrayList dailylist = new ArrayList();
    try
    {
      JSONArray dailydata = (JSONArray) jObj.get("data");
    //  ArrayList dailylist = new ArrayList();
      Iterator j = dailydata.iterator();
      while (j.hasNext())
      {
        JSONObject jObjt = (JSONObject) j.next();
        DailyDataPoints dDPoints = new DailyDataPoints();
        dDPoints.read(jObjt);
        dailylist.add(dDPoints);
//        dDPoints.print();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return dailylist;
  } 
}
