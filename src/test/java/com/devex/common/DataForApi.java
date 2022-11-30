package com.devex.common;

import java.util.HashMap;
import java.util.Map;

public class DataForApi {


    public static Map<String,Object> registerUserBody(String email,String password,String name,String google,String facebook,String github){

        Map<String ,Object> newUserInfo = new HashMap<>();
        newUserInfo.put("email",email);
        newUserInfo.put("password",password);
        newUserInfo.put("name",name);
        newUserInfo.put("google",google);
        newUserInfo.put("facebook",facebook);
        newUserInfo.put("github",github);

        return newUserInfo;

    }
    public static Map<String,Object> saveProfileBody(String company, String website, String location, String status, String skills, String githubusername,String youtube,String twitter,String facebook , String linkedin,String instagram){
        Map<String,Object> profileBody=new HashMap<>();

        profileBody.put("company",company);
        profileBody.put("website",website);
        profileBody.put("location",location);
        profileBody.put("status",status);
        profileBody.put("skills",skills);
        profileBody.put("youtube",youtube);
        profileBody.put("twitter",twitter);
        profileBody.put("facebook",facebook);
        profileBody.put("linkedin",linkedin);
        profileBody.put("instagram",instagram);

        return profileBody;

        /*
        {
  "company": "string",
  "website": "string",
  "location": "string",
  "status": "string",
  "skills": "HTML,CSS,Javascript",
  "githubusername": "string",
  "youtube": "string",
  "twitter": "string",
  "facebook": "string",
  "linkedin": "string",
  "instagram": "string"
  {
  "title": "string",
  "company": "string",
  "location": "string",
  "from": "YYYY-MM-DD",
  "to": "YYYY-MM-DD",
  "current": false,
  "description": "string"
}
}
         */

    }
    public static Map<String,Object> addExperienceBody(String title,String company,String location,String from,String to,String current,String description){

        Map<String,Object> addNewExperience = new HashMap<>();
        addNewExperience.put("title",title);
        addNewExperience.put("company",company);
        addNewExperience.put("location",location);
        addNewExperience.put("from",from);
        addNewExperience.put("to",to);
        addNewExperience.put("current",current);
        addNewExperience.put("description",description);

        return addNewExperience;

    }

}
