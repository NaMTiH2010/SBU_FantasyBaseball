/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.file;

import static WBDK.WBDK_StartupConstants.PATH_DRAFTS;
import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Players;
import WBDK.data.Team;
import static WBDK.file.WBDK_SiteExporter.SLASH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
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
    String JSON_EXT = ".json";
    // TEAM VARIABLES TO SAVE
    String JSON_TEAM_NAME = "team_name";
    String JSON_TEAM_STARTING_LINEUP_ARRAY = "starting_lineup";
    String JSON_TEAM_TAXI_SQUAD_ARRAY = "taxi_squad";
    String JSON_TEAM_OWNER = "owner";
    String JSON_P_NEEDED = "p_Needed";
    String JSON_C_NEEDED = "c_Needed";
    String JSON_FIRSTBASE_NEEDED = "f_BaseNeeded";
    String JSON_SECONDBASE_NEEDED = "s_BaseNeeded";
    String JSON_THIRDBASE_NEEDED = "t_BaseNeeded";
    String JSON_CI_NEEDED = "ci_Needed";
    String JSON_MI_NEEDED = "mi_Needed";
    String JSON_U_NEEDED = "u_Needed";
    String JSON_SS_NEEDED = "ss_Needed";
    String JSON_OF_NEEDED = "of_Needed";
    // PLAYER VARIABLES TO BE SAVED
    String JSON_POSITIONS_ARRAY = "positions_array";
    String JSON_POSSIBLE_POSITIONS ="possiblePositions";
    String JSON_TEAM ="team";
    String JSON_FIRST_NAME ="firstName";
    String JSON_LAST_NAME ="lastName";
    String JSON_NOTES ="notes";
    String JSON_YEAR_OF_BIRTH ="yearOfBirth";
    String JSON_PLACE_OF_BIRTH ="placeOfBirth";
    String JSON_QP ="qp";
    String JSON_R ="r";
    String JSON_W ="w";
    String JSON_HR ="hr";
    String JSON_SV ="sv";
    String JSON_RBI ="rbi";
    String JSON_K ="k";
    String JSON_SB ="sb";
    String JSON_ERA ="era";
    String JSON_BA ="ba";
    //String JSON_WHIP ="whip";
    String JSON_BB ="bb";
    String JSON_ER ="er";
    String JSON_IP ="ip";
    String JSON_AB ="ab";
    String JSON_H ="h";
    String JSON_SALARY ="salary";
    String JSON_AVAILABILITY ="availability";
    String JSON_PLAYER_TYPE ="playerType";
    String JSON_CURRENT_POSITION ="currentPosition";
    String JSON_TAKEN ="taken";
    
    // DRAFT VARIABLES TO BE SAVED
    String JSON_HITTERS_ARRAY ="hitters";
    String JSON_PITCHERS_ARRAY ="pitchers";
    String JSON_PLAYERS_ARRAY ="players";
    String JSON_AVAILABLE_PLAYERS_ARRAY ="availablePlayers";
    String JSON_TEAMS_ARRAY ="teams";
    String JSON_DRAFT_TITLE = "title";
    
    public void saveTeam(Team TeamToSave) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    
    
    public ObservableList<Player> loadTheHitters(String jsonFilePath) throws IOException {
        // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            ObservableList<Player> playerList = FXCollections.observableArrayList();
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
        si.setQp(jso.getString("QP"));
        si.setAB(jso.getString("AB"));
        si.setH(jso.getString("H"));
        si.setR_W(jso.getString("R"));
        si.setHr_sv(jso.getString("HR"));
        si.setRbi_k(jso.getString("RBI"));
        si.setSb_era(jso.getString("SB"));
        si.setPlayerType("hitter");
        si.setPossiblePositions(jso.getString("QP"));
        if(jso.getString("QP").contains("_")){
            si.setPositions(jso.getString("QP").split("_"));
        }
        else{si.setPositions(new String[]{jso.getString("QP")});}
        si.setPositions(jso.getString("QP").split("_"));
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(jso.getString("YEAR_OF_BIRTH"));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            playerList.add(si);
        }
         return playerList;   
        
    }
    
    public ObservableList<Player> loadThePitchers(String jsonFilePath) throws IOException {
        // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            ObservableList<Player> playerList = FXCollections.observableArrayList();
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
        si.setBB(jso.getString("BB"));
        si.setPlayerType("pitcher");
        si.setR_W(jso.getString("W"));
        si.setH(jso.getString("H"));
        si.setHr_sv(jso.getString("SV"));
        si.setRbi_k(jso.getString("K"));
        si.setQp("P");
        si.setPossiblePositions("P");
        //si.setPositions(null);
        //si.setSb_era(jso.getString("SB"));
        
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(jso.getString("YEAR_OF_BIRTH"));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            playerList.add(si);
        }
         return playerList;   
        
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
            //System.out.println(si.getNotes()+" notes are thisSSSSSS");
            
        si.setTeam(jso.getString("TEAM"));
        //System.out.println(si.getTeam()+" team name");
        
        si.setLastName(jso.getString("LAST_NAME"));
        si.setFirstName(jso.getString("FIRST_NAME"));
        si.setQp(jso.getString("QP"));
        si.setAB(jso.getString("AB"));
        si.setR_W(jso.getString("R"));
        si.setH(jso.getString("H"));
        si.setHr_sv(jso.getString("HR"));
        si.setRbi_k(jso.getString("RBI"));
        si.setSb_era(jso.getString("SB"));
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(jso.getString("YEAR_OF_BIRTH"));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            //draftToLoad.getPlayers().add(si);
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

    public Draft loadDraft(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> loadHitters(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * This method saves all the data associated with a course to
     * a JSON file.
     * 
     * @param courseToSave The course whose data we are saving.
     * 
     * @throws IOException Thrown when there are issues writing
     * to the JSON file.
     */
    //@Override
    public void saveDraft(Draft draftToSave) throws IOException {
        // BUILD THE FILE PATH
        String courseListing = "" + draftToSave.getTitle();
        String jsonFilePath = PATH_DRAFTS + SLASH + courseListing + JSON_EXT;
        
        // INIT THE WRITER
        OutputStream os = new FileOutputStream(jsonFilePath);
        JsonWriter jsonWriter = Json.createWriter(os);  
        
        // MAKE A JSON ARRAY FOR THE PAGES ARRAY
        JsonArray hittersJsonArray = makePlayerJsonArray(draftToSave.getHitters());
        
        // AND AN OBJECT FOR THE INSTRUCTOR
        //JsonObject instructorJsonObject = makeInstructorJsonObject(draftToSave.getInstructor());
        
        
        // THE LECTURE DAYS ARRAY
        JsonArray pitchersJsonArray = makePlayerJsonArray(draftToSave.getPitchers());
        
        // THE SCHEDULE ITEMS ARRAY
        //JsonArray playersJsonArray = makeScheduleItemsJsonArray(courseToSave.getScheduleItems());
        
        // THE LECTURES ARRAY
        JsonArray teamsJsonArray = makeTeamJsonArray(draftToSave.getTeams());
        
        // THE HWS ARRAY
        JsonArray availablePlayersJsonArray = makePlayerJsonArray(draftToSave.getAvailablePlayers());
        
        // NOW BUILD THE COURSE USING EVERYTHING WE'VE ALREADY MADE
        JsonObject courseJsonObject = Json.createObjectBuilder()
                                    // DRAFT ITEMS
                                    .add(JSON_DRAFT_TITLE, draftToSave.getTitle())
                                    .add(JSON_HITTERS_ARRAY, draftToSave.getTitle())
                                    .add(JSON_PITCHERS_ARRAY, draftToSave.getTitle())
                                    .add(JSON_PLAYERS_ARRAY, draftToSave.getTitle())
                                    .add(JSON_AVAILABLE_PLAYERS_ARRAY, draftToSave.getTitle())
                                    .add(JSON_TEAMS_ARRAY, draftToSave.getTitle())

                .build();
        
        // AND SAVE EVERYTHING AT ONCE
        jsonWriter.writeObject(courseJsonObject);
    }
    
    /**
     * Saves the subjects list to a json file.
     * @param subjects List of Subjects to save.
     * @param jsonFilePath Path of json file.
     * @throws IOException Thrown when I/O fails.
     */
    /*
    @Override
    public void saveSubjects(List<Object> subjects, String jsonFilePath) throws IOException {
        JsonObject arrayObject = buildJsonArrayObject(subjects);
        OutputStream os = new FileOutputStream(jsonFilePath);
        JsonWriter jsonWriter = Json.createWriter(os);  
        jsonWriter.writeObject(arrayObject);        
    }*/
    
    // MAKE AN ARRAY OF ASSIGNMENTS
    public JsonArray makeTeamJsonArray(ObservableList<Team> data) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for (Team a : data) {
            jsb.add(this.makeTeamJsonObject(a));
        }
        JsonArray jA = jsb.build();
        return jA;
    }
    // MAKES AND RETURNS A JSON OBJECT FOR THE PROVIDED ASSIGNMENT
    private JsonObject makeTeamJsonObject(Team team) {
        
        JsonArray startingLineupJsonArray = makePlayerJsonArray(team.getStartingLineup());
        JsonArray taxiSquadJsonArray = makePlayerJsonArray(team.getTaxiSquad());
        
        JsonObject jso = Json.createObjectBuilder()
                .add(JSON_TEAM_NAME, team.getName())
                .add(JSON_TEAM_OWNER, team.getOwner())
                .add(JSON_P_NEEDED, team.getP_Needed())
                .add(JSON_C_NEEDED, team.getP_Needed())
                .add(JSON_FIRSTBASE_NEEDED, team.getP_Needed())
                .add(JSON_SECONDBASE_NEEDED, team.getP_Needed())
                .add(JSON_THIRDBASE_NEEDED, team.getP_Needed())
                .add(JSON_CI_NEEDED, team.getP_Needed())
                .add(JSON_MI_NEEDED, team.getP_Needed())
                .add(JSON_U_NEEDED, team.getP_Needed())
                .add(JSON_SS_NEEDED, team.getP_Needed())
                .add(JSON_OF_NEEDED, team.getP_Needed())
                .add(JSON_TEAM_STARTING_LINEUP_ARRAY, startingLineupJsonArray)
                .add(JSON_TEAM_TAXI_SQUAD_ARRAY, taxiSquadJsonArray)
                  .build();
        return jso;
    }      
     // MAKE AN ARRAY OF Players
    public JsonArray makePlayerJsonArray(ObservableList<Player> data) {
        JsonArrayBuilder jsb = Json.createArrayBuilder();
        for (Player a : data) {
            jsb.add(this.makePlayerJsonObject(a));
        }
        JsonArray jA = jsb.build();
        return jA;
    }
    // MAKES AND RETURNS A JSON OBJECT FOR THE PROVIDED ASSIGNMENT
    private JsonObject makePlayerJsonObject(Player player) {
        if(player.getPlayerType().equalsIgnoreCase("pitcher")){
            JsonObject jso = Json.createObjectBuilder()
                        .add(JSON_POSSIBLE_POSITIONS, player.getPossiblePositions())
                        .add(JSON_TAKEN, player.getTaken())
                        .add(JSON_CURRENT_POSITION, player.getCurrentPosition())
                        .add(JSON_PLAYER_TYPE, player.getPlayerType())
                        .add(JSON_AVAILABILITY, player.getAvailability())
                        .add(JSON_SALARY, player.getSalary())
                        .add(JSON_H, player.getH())
                        .add(JSON_IP, player.getIP())
                        .add(JSON_ER, player.getER())
                        .add(JSON_BB, player.getBB())
                        .add(JSON_K, player.getRBI_K())
                        .add(JSON_SV, player.getHR_SV())
                        .add(JSON_W, player.getR_W())
                        .add(JSON_QP, player.getQP())
                        .add(JSON_PLACE_OF_BIRTH, player.getPlaceOfBirth())
                        .add(JSON_YEAR_OF_BIRTH, player.getYearOfBirth())
                        .add(JSON_NOTES, player.getNotes())
                        .add(JSON_LAST_NAME, player.getLastName())
                        .add(JSON_FIRST_NAME, player.getFirstName())
                        .add(JSON_TEAM, player.getTeam())
                        .build();
                    return jso;
        }
        else{
                JsonObject jso = Json.createObjectBuilder()
                        .add(JSON_POSSIBLE_POSITIONS, player.getPossiblePositions())
                        .add(JSON_TAKEN, player.getTaken())
                        .add(JSON_CURRENT_POSITION, player.getCurrentPosition())
                        .add(JSON_PLAYER_TYPE, player.getPlayerType())
                        .add(JSON_AVAILABILITY, player.getAvailability())
                        .add(JSON_SALARY, player.getSalary())
                        .add(JSON_H, player.getH())
                        .add(JSON_AB, player.getAB())
                        .add(JSON_SB, player.getSB_ERA())
                        .add(JSON_RBI, player.getRBI_K())
                        .add(JSON_HR, player.getHR_SV())
                        .add(JSON_R, player.getR_W())
                        .add(JSON_QP, player.getQP())
                        .add(JSON_PLACE_OF_BIRTH, player.getPlaceOfBirth())
                        .add(JSON_YEAR_OF_BIRTH, player.getYearOfBirth())
                        .add(JSON_NOTES, player.getNotes())
                        .add(JSON_LAST_NAME, player.getLastName())
                        .add(JSON_FIRST_NAME, player.getFirstName())
                        .add(JSON_TEAM, player.getTeam())
                        .build();
                    return jso;
        }
        
    }


    @Override
    public void saveTeam(Team TeamToSave, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Draft loadTeam(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JsonArray makeHittersJsonArray(ObservableList<Player> hitters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JsonArray makePitchersJsonArray(ObservableList<Player> pitchers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JsonArray makeTeamsJsonArray(ObservableList<Team> teams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private JsonArray makeAvailablePlayersArray(ObservableList<Player> availablePlayers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
