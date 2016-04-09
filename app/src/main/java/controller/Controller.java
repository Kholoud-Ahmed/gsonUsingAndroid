package controller;

import com.example.kholoud.pojo.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by KHoloud on 4/9/2016.
 */
public class Controller {

    private static Gson gson;
    public static Employee parseGsonObject(String jsonObject){

        gson = new Gson();
        Employee employee;

        //if i want to parse JSON array object
        if(jsonObject.contains("[")){
            Type listType = new TypeToken<List<Employee>>(){}.getType();
            List<Employee> posts = (List<Employee>) gson.fromJson(jsonObject, listType);
            return posts.get(0);
            
        }else {// if i parse noramal json object
            employee = gson.fromJson(jsonObject, Employee.class);
            return employee;
        }
        
    }

}
