/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.divitech.invionotifica;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fangeli
 */
public class Main {
    
    static public void main(String args[])
    {
        try {
            com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.post("http://fcm.googleapis.com/fcm/send")
                    .header("content-type", "application/json")
                    .header("authorization", "key=AAAA...")
                    .body("{\"notification\":{\"title\":\"title Notification new\","
                            + "\"body\":\"body Notification2\",\"sound\":\"default\","
                            + "\"click_action\":\"FCM_PLUGIN_ACTIVITY\",\"icon\":\"fcm_push_icon\"},"
                            + "\"to\":\"/topics/topic2\",\"priority\":\"high\"," 
                            + "\"restricted_package_name\":\"\"}")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
