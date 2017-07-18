package io.mypersonaltrainer.mypersonaltrainer.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya on 7/17/17.
 */

public class ExerciseHolder {

    public JSONObject obj;
    public JSONArray arr;
    public static ArrayList<String> exerciseNames;
    public ArrayList<Exercise> exerciseArrayList;
    public static Map<String, ArrayList<Exercise>> map;

    public ExerciseHolder(String json){
        try {
            obj = new JSONObject(json);
            exerciseNames = new ArrayList<>();

            map = new HashMap<>();

            buildMap("Arms");
            buildMap("Back");
            buildMap("Chest");
            buildMap("Shoulder");
            buildMap("Legs");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void buildMap(String key){
        try {
            exerciseArrayList = new ArrayList<>();
            arr = obj.getJSONArray(key);
            exerciseNames.add(key);
            for(int i = 0 ; i < arr.length() ; i++){
                JSONObject o = arr.getJSONObject(i);
                exerciseArrayList.add(new Exercise(o.getString("id"),
                        o.getString("name"),
                        o.getString("description"),
                        o.getString("vidUrl")));
            }
            map.put(key, exerciseArrayList);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}

