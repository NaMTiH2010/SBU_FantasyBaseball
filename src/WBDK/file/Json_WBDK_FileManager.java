/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.file;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Players;
import WBDK.data.Team;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonValue;
/**
 *
 * @author MatthewLuce
 */
public class Json_WBDK_FileManager implements WBDK_FileManager{

    @Override
    public void saveTeam(Team TeamToSave) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadTeam(Team TeamToLoad, String coursePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*public void saveDraft(Draft draftToSave) throws IOException {
        // BUILD THE FILE PATH
        String draftListing = "" + draftToSave.getSubject() + draftToSave.getNumber();
        String jsonFilePath = PATH_COURSES + SLASH + courseListing + JSON_EXT;
        
        // INIT THE WRITER
        OutputStream os = new FileOutputStream(jsonFilePath);
        JsonWriter jsonWriter = Json.createWriter(os);  
        
        // MAKE A JSON ARRAY FOR THE PAGES ARRAY
        JsonArray pagesJsonArray = makePagesJsonArray(courseToSave.getPages());
        
        // AND AN OBJECT FOR THE INSTRUCTOR
        JsonObject instructorJsonObject = makeInstructorJsonObject(courseToSave.getInstructor());
        
        // ONE FOR EACH OF OUR DATES
        JsonObject startingMondayJsonObject = makeLocalDateJsonObject(courseToSave.getStartingMonday());
        JsonObject endingFridayJsonObject = makeLocalDateJsonObject(courseToSave.getEndingFriday());
        
        // THE LECTURE DAYS ARRAY
        JsonArray lectureDaysJsonArray = makeLectureDaysJsonArray(courseToSave.getLectureDays());
        
        // THE SCHEDULE ITEMS ARRAY
        JsonArray scheduleItemsJsonArray = makeScheduleItemsJsonArray(courseToSave.getScheduleItems());
        
        // THE LECTURES ARRAY
        JsonArray lecturesJsonArray = makeLecturesJsonArray(courseToSave.getLectures());
        
        // THE HWS ARRAY
        JsonArray hwsJsonArray = makeHWsJsonArray(courseToSave.getAssignments());
        
        // NOW BUILD THE COURSE USING EVERYTHING WE'VE ALREADY MADE
        JsonObject courseJsonObject = Json.createObjectBuilder()
                                    .add(JSON_SUBJECT, courseToSave.getSubject().toString())
                                    .add(JSON_NUMBER, courseToSave.getNumber())
                                    .add(JSON_TITLE, courseToSave.getTitle())
                                    .add(JSON_SEMESTER, courseToSave.getSemester().toString())
                                    .add(JSON_YEAR, courseToSave.getYear())
                                    .add(JSON_PAGES, pagesJsonArray)
                                    .add(JSON_INSTRUCTOR, instructorJsonObject)
                                    .add(JSON_STARTING_MONDAY, startingMondayJsonObject)
                                    .add(JSON_ENDING_FRIDAY, endingFridayJsonObject)
                                    .add(JSON_LECTURE_DAYS, lectureDaysJsonArray)
                                    .add(JSON_SCHEDULE_ITEMS, scheduleItemsJsonArray)
                                    .add(JSON_LECTURES, lecturesJsonArray)
                                    .add(JSON_HWS, hwsJsonArray)
                .build();
        
        // AND SAVE EVERYTHING AT ONCE
        jsonWriter.writeObject(courseJsonObject);
    }*/

   

    @Override
    public void savePitchers(List<Object> pitchers, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> loadPitchers(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveHitters(List<Object> subjects, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public ArrayList<Player> loadTheHitters(String jsonFilePath) throws IOException {
        // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            ArrayList<Player> playerList = new ArrayList();
            // GET THE SCHEDULE ITEMS
        //draftToLoad.clearScheduleItems();
        JsonArray jsonHittersArray = json.getJsonArray("Hitters");
        for (int i = 0; i < jsonHittersArray.size(); i++) {
            JsonObject jso = jsonHittersArray.getJsonObject(i);
            Player si = new Player();
            si.setNotes("test");
            
        si.setTeam(jso.getString("TEAM"));
        //System.out.println(si.getTeam()+" team name");
        
        si.setLastName(jso.getString("LAST_NAME"));
        si.setFirstName(jso.getString("FIRST_NAME"));
        si.setQP(jso.getString("QP"));
        si.setAB(jso.getString("AB"));
        si.setR(jso.getString("R"));
        si.setH(jso.getString("H"));
        si.setHR(jso.getString("HR"));
        si.setRBI(jso.getString("RBI"));
        si.setSB(jso.getString("SB"));
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(jso.getString("YEAR_OF_BIRTH"));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            playerList.add(si);
        }
         return playerList;   
        
    }
    
    public ArrayList<Player> loadThePitchers(String jsonFilePath) throws IOException {
        // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            ArrayList<Player> playerList = new ArrayList();
            // GET THE SCHEDULE ITEMS
        //draftToLoad.clearScheduleItems();
        JsonArray jsonHittersArray = json.getJsonArray("Pitchers");
        for (int i = 0; i < jsonHittersArray.size(); i++) {
            JsonObject jso = jsonHittersArray.getJsonObject(i);
            Player si = new Player();
            si.setNotes("test");
            
        si.setTeam(jso.getString("TEAM"));
        //System.out.println(si.getTeam()+" team name");
        
        si.setLastName(jso.getString("LAST_NAME"));
        si.setFirstName(jso.getString("FIRST_NAME"));
        si.setIP(jso.getString("IP"));
        si.setER(jso.getString("ER"));
        si.setW(jso.getString("W"));
        si.setSV(jso.getString("SV"));
        si.setH(jso.getString("H"));
        si.setBB(jso.getString("BB"));
        si.setK(jso.getString("K"));
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(jso.getString("YEAR_OF_BIRTH"));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            playerList.add(si);
        }
         return playerList;   
        
    }

    @Override
    public void saveDraft(Draft draft, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDraft(Draft draftToSave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    // LOADS A JSON FILE AS A SINGLE OBJECT AND RETURNS IT
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
        InputStream is = new FileInputStream(jsonFilePath);
        JsonReader jsonReader = Json.createReader(is);
        JsonObject json = jsonReader.readObject();
        jsonReader.close();
        is.close();
        return json;
    }
    
    /*
    public ArrayList<String> loadPlayers(String jsonFilePath) throws IOException {
        ArrayList<String> playersArray = loadArrayFromJSONFile(jsonFilePath, JSON_SUBJECTS);
        ArrayList<String> cleanedArray = new ArrayList();
        for (String s : subjectsArray) {
            // GET RID OF ALL THE QUOTE CHARACTERS
            s = s.replaceAll("\"", "");
            cleanedArray.add(s);
        }
        return cleanedArray;
    }*/
    /*
    public Player loadPlayer(String filePath) throws IOException {
        System.out.println(filePath+" Is the FilePath" );
        JsonObject json = loadJSONFile(filePath);
        return buildPlayerJsonObject(json);
    }
     // BUILDS AND RETURNS THE INSTRUCTOR FOUND IN THE JSON OBJECT
    public Player buildPlayerJsonObject(JsonObject json) {
        Player instructor = new Player( json.getString("FIRST_NAME"),
                                                    json.getString("LAST_NAME"));
        return instructor;
    }
    
    
    // MAKE AN ARRAY OF SCHEDULE ITEMS
    private JsonArray makeScheduleItemsJsonArray(ObservableList<ScheduleItem> data) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for (ScheduleItem si : data) {
            jsb.add(makeScheduleItemJsonObject(si));
        }
        JsonArray jA = jsb.build();
        return jA;
    }
    
    // THE SCHEDULE ITEMS ARRAY
        JsonArray scheduleItemsJsonArray = makeScheduleItemsJsonArray(courseToSave.getScheduleItems());
        
        // MAKES AND RETURNS A JSON OBJECT FOR THE PROVIDED SCHEDULE ITEM
    private JsonObject makeScheduleItemJsonObject(ScheduleItem scheduleItem) {
        JsonObject date = makeLocalDateJsonObject(scheduleItem.getDate());
        JsonObject jso = Json.createObjectBuilder().add(JSON_SCHEDULE_ITEM_DESCRIPTION, scheduleItem.getDescription())
                                                    .add(JSON_SCHEDULE_ITEM_DATE, date)
                                                    .add(JSON_SCHEDULE_ITEM_LINK, scheduleItem.getLink())
                                                    .build();
        return jso;
    }
    */
        public void loadDraft(Draft draftToLoad, String jsonFilePath) throws IOException{
            System.out.println(jsonFilePath+" Is the FilePath" );
            // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            
            // GET THE SCHEDULE ITEMS
        //draftToLoad.clearScheduleItems();
        JsonArray jsonHittersArray = json.getJsonArray("Hitters");
        for (int i = 0; i < jsonHittersArray.size(); i++) {
            JsonObject jso = jsonHittersArray.getJsonObject(i);
            Player si = new Player();
            si.setNotes("test");
            System.out.println(si.getNotes()+" notes are thisSSSSSS");
            
        si.setTeam(jso.getString("TEAM"));
        System.out.println(si.getTeam()+" team name");
        
        si.setLastName(jso.getString("LAST_NAME"));
        si.setFirstName(jso.getString("FIRST_NAME"));
        si.setQP(jso.getString("QP"));
        si.setAB(jso.getString("AB"));
        si.setR(jso.getString("R"));
        si.setH(jso.getString("H"));
        si.setHR(jso.getString("HR"));
        si.setRBI(jso.getString("RBI"));
        si.setSB(jso.getString("SB"));
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(jso.getString("YEAR_OF_BIRTH"));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            draftToLoad.getPlayers().add(si);
        }
            
        }
    
    /*
        public void loadCourse(Course courseToLoad, String jsonFilePath) throws IOException {
        // LOAD THE JSON FILE WITH ALL THE DATA
        JsonObject json = loadJSONFile(jsonFilePath);
        }
        
    // GET THE SCHEDULE ITEMS
        courseToLoad.clearScheduleItems();
        JsonArray jsonScheduleItemsArray = json.getJsonArray(JSON_SCHEDULE_ITEMS);
        for (int i = 0; i < jsonScheduleItemsArray.size(); i++) {
            JsonObject jso = jsonScheduleItemsArray.getJsonObject(i);
            ScheduleItem si = new ScheduleItem();
            si.setDescription(jso.getString(JSON_SCHEDULE_ITEM_DESCRIPTION));
            JsonObject jsoDate = jso.getJsonObject(JSON_SCHEDULE_ITEM_DATE);
            year = jsoDate.getInt(JSON_YEAR);
            month = jsoDate.getInt(JSON_MONTH);
            day = jsoDate.getInt(JSON_DAY);            
            si.setDate(LocalDate.of(year, month, day));
            si.setLink(jso.getString(JSON_SCHEDULE_ITEM_LINK));
            
            // ADD IT TO THE COURSE
            courseToLoad.addScheduleItem(si);
        }*/

    @Override
    public Draft loadDraft(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> loadHitters(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
