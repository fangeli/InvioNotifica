# Invio notifica con unirest for Java
Unirest is a set of lightweight HTTP libraries<br>
http://unirest.io/java.html<br>
Creiamo un'app java per l'invio di una notifica con FCM<br><br>
![](https://github.com/fangeli/Push-notification-per-app-Cordova-with-Firebase-Cloud-Messaging-and-node.js/blob/master/Invio%20Notifica.png?raw=true)<br>
Per farlo occorre:
1. Creare server app invio notifica, un Maven Project con Visual Studio
2. Installing unirest for Java library:
```xml
<dependency>
    <groupId>com.mashape.unirest</groupId>
    <artifactId>unirest-java</artifactId>
    <version>1.4.9</version>
</dependency>
```
3. Recuperare la KEY dell'app a cui si vuole mandare la notifica. Si presuppone che l'app sia stata già associata a Firebase
   - Aprire firebase https://console.firebase.google.com
   - Selezionare l'app
   - In alto a sinistra cliccare sulla rotellina Settings > Impostazioni Progetto > Cloude Messaging e copiare il valore di Chiave Server AAAA...
3. Creating Request:<br>
```java
com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = Unirest.post("http://fcm.googleapis.com/fcm/send")
                    .header("content-type", "application/json")
                    .header("authorization", "key=AAAA...")
                    .body("{\"notification\":{\"title\":\"titleNotification\"," 
                            + "\"body\":\"bodyNotification\",\"sound\":\"default\"," 
                            + "\"click_action\":\"FCM_PLUGIN_ACTIVITY\",\"icon\":\"fcm_push_icon\"}," 
                            + "\"to\":\"/topics/topic1\",\"priority\":\"high\"," 
                            + "\"restricted_package_name\":\"\"}")
                    .asJson();
```
dove notiamo
* url: http://fcm.googleapis.com/fcm/send
* header: key=AAAA...
* body: title, body, to= /topics/topic1

L'esecuzione del progetto invia a tutti i dispositivi che hanno installato l'app identificata da AAAA... e che hanno sottoscritto il topic divitech la seguente notifica
* title = titleNotification
* body = bodyNotification
