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
//import static WBDK.file.WBDK_SiteExporter.SLASH;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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
    String SLASH = "/";
    String JSON_PLAYERS_FANTASY_TEAM = "fantasy_team";
    String DEFAULT_TEAM = "default_team";
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
    String JSON_TEAM ="TEAM";
    String JSON_FIRST_NAME ="FIRST_NAME";
    String JSON_LAST_NAME ="LAST_NAME";
    String JSON_NOTES ="NOTES";
    String JSON_YEAR_OF_BIRTH ="YEAR_OF_BIRTH";
    String JSON_PLACE_OF_BIRTH ="PLACE_OF_BIRTH";
    String JSON_QP ="QP";
    String JSON_R ="R";
    String JSON_W ="W";
    String JSON_HR ="HR";
    String JSON_SV ="SV";
    String JSON_RBI ="RBI";
    String JSON_K ="K";
    String JSON_SB ="SB";
    String JSON_ERA ="ERA";
    String JSON_BA ="BA";
    String JSON_WHIP ="WHIP";
    String JSON_BB ="BB";
    String JSON_ER ="ER";
    String JSON_IP ="IP";
    String JSON_AB ="AB";
    String JSON_H ="H";
    String JSON_SALARY ="SALARY";
    String JSON_AVAILABILITY ="AVAILABILITY";
    String JSON_PLAYER_TYPE ="PLAYER_TYPE";
    String JSON_CURRENT_POSITION ="CURRENT_POSITION";
    String JSON_TAKEN ="TAKEN";
    
    String JSON_R_RANK = "r_Rank";
    String JSON_HR_RANK = "hr_Rank";
    String JSON_RBI_RANK = "rbi_Rank";
    String JSON_SB_RANK = "sb_Rank";
    String JSON_SV_RANK = "sv_Rank";
    String JSON_K_RANK = "k_Rank";
    String JSON_BA_RANK = "ba_Rank";
    String JSON_W_RANK = "w_Rank";
    String JSON_ERA_RANK = "era_Rank";
    String JSON_WHIP_RANK = "whip_Rank";
    String JSON_FINAL_RANK = "finalRank";
    String JSON_PICK_NUM = "pickNum";
    String JSON_FANTASY_TEAM = "fantasyTeam";
    String JSON_CONTRACT_STATUS = "contractStatus";
    String JSON_EST_VALUE = "estValue";
    
    String JSON_TOTAL_POINTS = "totalPoints";
    String JSON_MONEY_LEFT = "moneyLeft";
    String JSON_COST_PP = "costPP";
    String JSON_NUM_P_NEEDED = "numPlayersNeeded";
    String JSON_TOTAL_R = "total_R";
    String JSON_TOTAL_HR = "total_HR";
    String JSON_TOTAL_RBI = "total_RBI";
    String JSON_TOTAL_SB = "total_SB";
    String JSON_TOTAL_SV = "total_SV";
    String JSON_TOTAL_K = "total_K";
    String JSON_TOTAL_BA = "total_BA";
    String JSON_TOTAL_W = "total_W";
    String JSON_TOTAL_ERA = "total_ERA";
    String JSON_TOTAL_WHIP = "total_WHIP";
    String JSON_VIABLE_POS = "viablePositions";
    String JSON_POS_NEEDED = "positionsNeeded";
    String JSON_TEAM_POS = "teamPositions";
    String JSON_TAXI_TIME = "taxiTime";
            
    // DRAFT VARIABLES TO BE SAVED
    String JSON_DRAFT_TABLE_ARRAY = "draftTablePlayers";
    String JSON_HITTERS_ARRAY ="hitters";
    String JSON_PITCHERS_ARRAY ="pitchers";
    String JSON_PLAYERS_ARRAY ="players";
    String JSON_AVAILABLE_PLAYERS_ARRAY ="availablePlayers";
    String JSON_TEAMS_ARRAY ="teams";
    String JSON_DRAFT_TITLE = "title";
    
    public void saveTeam(Team TeamToSave) throws IOException {
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
        
        si.setAB(jso.getString("AB"));
        si.setH(Integer.parseInt(jso.getString("H")));
        si.setR_W(Integer.parseInt(jso.getString("R")));
        si.setHr_sv(Integer.parseInt(jso.getString("HR")));
        si.setRbi_k(Integer.parseInt(jso.getString("RBI")));
        si.setSb_era(jso.getString("SB"));
        //si.setBa_whip(jso.getString("BA"));
        si.setPlayerType("hitter");
        /*
        double tempH = Double.parseDouble(jso.getString("H"));
        double tempAB = Double.parseDouble(jso.getString("AB"));
        if(tempH <=0 ||tempAB <=0){
            tempH = 0;
        }
        else{
            tempH/=tempAB;
        }
        String s = String.format("%.2f", tempH);
        //Double tempDone = Double.parseDouble(s);
        si.setBa_whip(s);*/
        if(jso.getString("QP").contains("1B") || jso.getString("QP").contains("3B")){
            if(jso.getString("QP").contains("2B") || jso.getString("QP").contains("SS"))
                si.setPossiblePositions((jso.getString("QP")+"_MI_CI_U"));
            else
               si.setPossiblePositions((jso.getString("QP")+"_CI_U")); 
        }
        else if(jso.getString("QP").contains("2B") || jso.getString("QP").contains("SS")){
                si.setPossiblePositions((jso.getString("QP")+"_MI_U"));
        }
        else
                si.setPossiblePositions((jso.getString("QP")+"_U"));
            
        /*if(jso.getString("QP").contains("_")){
            si.setPositions(jso.getString("QP").split("_"));
        }
        else{si.setPositions(new String[]{jso.getString("QP")});}
        */
        
        
        if(si.getPossiblePositions().contains("_")){
            si.setPositions(si.getPossiblePositions().split("_"));
        }
        else{si.setPositions(new String[]{jso.getString("QP")});}
        si.setQp(si.getPossiblePositions());
        
        
        //si.setPositions(jso.getString("QP").split("_"));
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(Integer.parseInt(jso.getString("YEAR_OF_BIRTH")));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));
        si.calculateValues();
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
        si.setER(Integer.parseInt(jso.getString("ER")));
        /*
        double tempER = Double.parseDouble(jso.getString("ER"));
        double tempIP = Double.parseDouble(jso.getString("IP"));
        tempER*=9;
        if(tempER <=0 ||tempIP<=0){
            tempER = 0.0;
        }
        else{
            tempER/=tempIP;
        }
        String s = String.format("%.2f", tempER);
        //Double tempDone = Double.parseDouble(s);*/
        //si.setBa_whip(jso.getString("WHIP"));
        //si.setSb_era(jso.getString("ERA"));
        si.setBB(Integer.parseInt(jso.getString("BB")));
        si.setPlayerType("pitcher");
        si.setR_W(Integer.parseInt(jso.getString("W")));
        si.setH(Integer.parseInt(jso.getString("H")));
        si.setHr_sv(Integer.parseInt(jso.getString("SV")));
        si.setRbi_k(Integer.parseInt(jso.getString("K")));
        si.setQp("P");
        si.setPositions(new String[]{"P"});
        si.setPossiblePositions("P");
        /*
        Double tempW = Double.parseDouble(jso.getString("W"));
        Double tempH = Double.parseDouble(jso.getString("H"));
        
        tempW+=tempH;
        
        if(tempW <=0 ||tempIP<=0){
            tempW = 0.0;
        }
        else{
            tempW/=tempIP;
        }
         s = String.format("%.2f", tempW);
         //tempDone = Double.parseDouble(s);
        
        //si.setPositions(null);
        */
        //si.setSb_era(jso.getString("SB"));
        
        si.setNotes(jso.getString("NOTES"));
        si.setYearOfBirth(Integer.parseInt(jso.getString("YEAR_OF_BIRTH")));
        si.setPlaceOfBirth(jso.getString("NATION_OF_BIRTH"));

            // ADD IT TO THE COURSE
            si.calculateValues();
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
       
   
    
    /**
     * This method saves all the data associated with a course to
     * a JSON file.
     * 
     * @param draftToSave
     * 
     * @throws IOException Thrown when there are issues writing
     * to the JSON file.
     */
    //@Override
    @Override
    public void saveDraft(Draft draftToSave) throws IOException {
        System.out.println(" THE RIGHT STUFF");
        // BUILD THE FILE PATH
        String draftListing = "" + draftToSave.getTitle();
        String jsonFilePath = PATH_DRAFTS + SLASH + draftListing + JSON_EXT;
        
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
        JsonArray playersJsonArray = makePlayerJsonArray(draftToSave.getPlayers());
        
        // THE LECTURES ARRAY
        JsonArray teamsJsonArray = makeTeamJsonArray(draftToSave.getTeams());
        
        JsonArray draftTableJsonArray = makePlayerJsonArray(draftToSave.getDraftTablePlayers());
        
        
        // THE HWS ARRAY
        JsonArray availablePlayersJsonArray = makePlayerJsonArray(draftToSave.getAvailablePlayers());
        
        // NOW BUILD THE COURSE USING EVERYTHING WE'VE ALREADY MADE
        JsonObject draftJsonObject = Json.createObjectBuilder()
                                    // DRAFT ITEMS
                                    .add(JSON_DRAFT_TITLE, draftToSave.getTitle())
                                    .add(JSON_HITTERS_ARRAY, hittersJsonArray)
                                    .add(JSON_PITCHERS_ARRAY,pitchersJsonArray)
                                    .add(JSON_PLAYERS_ARRAY, playersJsonArray)
                                    .add(JSON_AVAILABLE_PLAYERS_ARRAY, availablePlayersJsonArray)
                                    .add(JSON_TEAMS_ARRAY, teamsJsonArray)
                                    .add(DEFAULT_TEAM, makeTeamJsonObject(draftToSave.getDefaultTeam()))
                                    .add(JSON_DRAFT_TABLE_ARRAY, draftTableJsonArray)
                .build();
        System.out.println(" THE RIGHT STUFF BUILT");
        // AND SAVE EVERYTHING AT ONCE
        jsonWriter.writeObject(draftJsonObject);
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
                .add(JSON_C_NEEDED, team.getC_Needed())
                .add(JSON_FIRSTBASE_NEEDED, team.getF_BaseNeeded())
                .add(JSON_SECONDBASE_NEEDED, team.getS_BaseNeeded())
                .add(JSON_THIRDBASE_NEEDED, team.getP_Needed())
                .add(JSON_CI_NEEDED, team.getCI_Needed())
                .add(JSON_MI_NEEDED, team.getMI_Needed())
                .add(JSON_U_NEEDED, team.getU_Needed())
                .add(JSON_SS_NEEDED, team.getSS_Needed())
                .add(JSON_OF_NEEDED, team.getOF_Needed())
                .add(JSON_TOTAL_POINTS,team.getTotalPoints())
                .add(JSON_MONEY_LEFT,team.getMoneyLeft())
                .add(JSON_COST_PP,team.getCostPP())
                .add(JSON_NUM_P_NEEDED,team.getNumPlayersNeeded())
                .add(JSON_TOTAL_R,team.getTotal_R())
                .add(JSON_TOTAL_HR,team.getTotal_HR())
                .add(JSON_TOTAL_RBI,team.getTotal_RBI())
                .add(JSON_TOTAL_SB,team.getTotal_SB())
                .add(JSON_TOTAL_SV,team.getTotal_SV())
                .add(JSON_TOTAL_K,team.getTotal_K())
                .add(JSON_TOTAL_BA,""+team.getTotal_BA())
                .add(JSON_TOTAL_W,team.getTotal_W())
                .add(JSON_TOTAL_ERA,""+team.getTotal_ERA())
                .add(JSON_TOTAL_WHIP,""+team.getTotal_WHIP())
                //.add(JSON_VIABLE_POS,team.getViablePositions())
                //.add(JSON_TEAM_POS,team.getPositions())
                .add(JSON_TAXI_TIME,team.getTaxiTime())
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
                        .add(JSON_PLAYERS_FANTASY_TEAM, player.getFantasyTeam())
                        .add(JSON_POSSIBLE_POSITIONS, player.getPossiblePositions())
                        .add(JSON_TAKEN, player.getTaken())
                        .add(JSON_CURRENT_POSITION, player.getCurrentPosition())
                        .add(JSON_PLAYER_TYPE, player.getPlayerType())
                        .add(JSON_AVAILABILITY, player.getAvailability())
                        .add(JSON_SALARY, player.getSalary())
                        .add(JSON_H, player.getH())
                        .add(JSON_IP, player.getIP())
                        .add(JSON_ERA, ""+player.getSB_ERA())
                        .add(JSON_WHIP, ""+player.getBA_WHIP())
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
                        .add(JSON_R_RANK,player.getRank_r())
                        .add(JSON_HR_RANK,player.getRank_hr())
                        .add(JSON_RBI_RANK,player.getRank_rbi())
                        .add(JSON_SB_RANK,player.getRank_sb())
                        .add(JSON_SV_RANK,player.getRank_sv())
                        .add(JSON_K_RANK,player.getRank_k())
                        .add(JSON_BA_RANK,player.getRank_ba())
                        .add(JSON_W_RANK,player.getRank_w())
                        .add(JSON_ERA_RANK,player.getRank_era())
                        .add(JSON_WHIP_RANK,player.getRank_whip())
                        .add(JSON_FINAL_RANK,player.getFinalRank())
                        .add(JSON_PICK_NUM,player.getPickNum())
                        .add(JSON_FANTASY_TEAM,player.getFantasyTeam())
                        .add(JSON_CONTRACT_STATUS,player.getContractStatus())
                        .add(JSON_EST_VALUE,""+player.getEstValue())
                    
                        .build();
                    return jso;
        }
        else{
                JsonObject jso = Json.createObjectBuilder()
                        .add(JSON_PLAYERS_FANTASY_TEAM, player.getFantasyTeam())
                        .add(JSON_POSSIBLE_POSITIONS, player.getPossiblePositions())
                        .add(JSON_TAKEN, player.getTaken())
                        .add(JSON_CURRENT_POSITION, player.getCurrentPosition())
                        .add(JSON_PLAYER_TYPE, player.getPlayerType())
                        .add(JSON_AVAILABILITY, player.getAvailability())
                        .add(JSON_SALARY, player.getSalary())
                        .add(JSON_H, player.getH())
                        .add(JSON_SB, ""+player.getSB_ERA())
                        .add(JSON_BA, ""+player.getBA_WHIP())
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
                        .add(JSON_R_RANK,player.getRank_r())
                        .add(JSON_HR_RANK,player.getRank_hr())
                        .add(JSON_RBI_RANK,player.getRank_rbi())
                        .add(JSON_SB_RANK,player.getRank_sb())
                        .add(JSON_SV_RANK,player.getRank_sv())
                        .add(JSON_K_RANK,player.getRank_k())
                        .add(JSON_BA_RANK,player.getRank_ba())
                        .add(JSON_W_RANK,player.getRank_w())
                        .add(JSON_ERA_RANK,player.getRank_era())
                        .add(JSON_WHIP_RANK,player.getRank_whip())
                        .add(JSON_FINAL_RANK,player.getFinalRank())
                        .add(JSON_PICK_NUM,player.getPickNum())
                        .add(JSON_FANTASY_TEAM,player.getFantasyTeam())
                        .add(JSON_CONTRACT_STATUS,player.getContractStatus())
                        .add(JSON_EST_VALUE,""+player.getEstValue())
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

    
    
    
    /**
     * Loads the courseToLoad argument using the data found in the json file.
     * 
     * @param draftToLoad
     * @param DraftToLoad
     * @param jsonFilePath File containing the data to load.
     * 
     * @throws IOException Thrown when IO fails.
     */
    @Override
     public void loadDraft(Draft draftToLoad, String jsonFilePath) throws IOException{
            System.out.println(jsonFilePath+" Is the FilePath" );
            // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
        draftToLoad.setTitle(json.getString("title"));
        draftToLoad.getPlayers().clear();
        draftToLoad.setPlayers(loadPlayerArrayFromJSONFile(jsonFilePath, "players"));
        draftToLoad.getPitchers().clear();
        draftToLoad.setPlayers(loadPlayerArrayFromJSONFile(jsonFilePath, "pitchers"));
        draftToLoad.getHitters().clear();
        draftToLoad.setPlayers(loadPlayerArrayFromJSONFile(jsonFilePath, "hitters"));
        draftToLoad.getDraftTablePlayers().clear();
        draftToLoad.setDraftTablePlayers(loadPlayerArrayFromJSONFile(jsonFilePath, "draftTablePlayers"));
        draftToLoad.getTeams().clear();
        draftToLoad.setTeams(loadTeamArrayFromJSONFile(jsonFilePath, "teams"));
        draftToLoad.getAvailablePlayers().clear();
        draftToLoad.setAvailablePlayers(loadPlayerArrayFromJSONFile(jsonFilePath,"availablePlayers"));
        draftToLoad.setDefaultTeam(loadJsonTeam(jsonFilePath,DEFAULT_TEAM));
        System.out.println("MADE it TO THE END");
           
        }

     // LOADS AN ARRAY OF A SPECIFIC NAME FROM A JSON FILE AND
    // RETURNS IT AS AN ArrayList FULL OF THE DATA FOUND
    private ObservableList<Player> loadPlayerArrayFromJSONFile(String jsonFilePath, String arrayName) throws IOException {
       // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            ObservableList<Player> playerList = FXCollections.observableArrayList();
        JsonArray jsonHittersArray = json.getJsonArray(arrayName);
        for (int i = 0; i < jsonHittersArray.size(); i++) {
            JsonObject jso = jsonHittersArray.getJsonObject(i);
            Player si = new Player();
           // si.setNotes("test");
            // IF IT IS A HITTER
            if(jso.getString("PLAYER_TYPE").equalsIgnoreCase("hitter")){
                si.setTeam(jso.getString("TEAM"));
        //System.out.println(si.getTeam()+" team name");
                si.setFantasyTeam(jso.getString(JSON_PLAYERS_FANTASY_TEAM));
                si.setLastName(jso.getString("LAST_NAME"));
                si.setFirstName(jso.getString("FIRST_NAME"));
                si.setQp(jso.getString("QP"));
                //System.out.println(jso.getString("QP"));
                si.setAB((""+jso.getInt("AB")));
                //System.out.println(jso.getString("AB"));
                si.setH(jso.getInt("H"));
                si.setR_W(jso.getInt("R"));
                si.setHr_sv(jso.getInt("HR"));
                si.setRbi_k(jso.getInt("RBI"));
                si.setSb_era(jso.getString("SB"));
                si.setBa_whip(jso.getString("BA"));
                si.setPlayerType("hitter");
                si.setPossiblePositions(jso.getString("QP"));
                if(jso.getString("QP").contains("_")){
                    si.setPositions(jso.getString("QP").split("_"));
                }
                else{si.setPositions(new String[]{jso.getString("QP")});}
                //si.setPositions(jso.getString("QP").split("_"));
                si.setNotes(jso.getString("NOTES"));
                si.setYearOfBirth(jso.getInt("YEAR_OF_BIRTH"));
                si.setPlaceOfBirth(jso.getString("PLACE_OF_BIRTH"));
                si.setAvailability(jso.getBoolean("AVAILABILITY"));
                si.setCurrentPosition(jso.getString("CURRENT_POSITION"));
                si.setTaken(jso.getBoolean("TAKEN"));
                si.setPlayerType(jso.getString("PLAYER_TYPE"));
                si.setSalary(jso.getString("SALARY"));
                ///////////////////////////////////////
                si.setRank_r(jso.getInt("r_Rank"));
                si.setRank_hr(jso.getInt("hr_Rank"));
                si.setRank_rbi(jso.getInt("rbi_Rank"));
                si.setRank_sb(jso.getInt("sb_Rank"));
                si.setRank_sv(jso.getInt("sv_Rank"));
                si.setRank_k(jso.getInt("k_Rank"));
                si.setRank_ba(jso.getInt("ba_Rank"));
                si.setRank_w(jso.getInt("w_Rank"));
                si.setRank_era(jso.getInt("era_Rank"));
                si.setRank_whip(jso.getInt("whip_Rank"));
                si.setFinalRank(jso.getInt("finalRank"));
                si.setPickNum(jso.getInt("pickNum"));
                si.setFantasyTeam(jso.getString("fantasyTeam"));
                si.setContractStatus(jso.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jso.getString("estValue")));
                ///////////////////////////////////////
            // ADD IT TO THE COURSE
                si.calculateValues();
                playerList.add(si); 
                }
            else{
                si.setTeam(jso.getString("TEAM"));
                //System.out.println(si.getTeam()+" team name");
                si.setFantasyTeam(jso.getString(JSON_PLAYERS_FANTASY_TEAM));
                si.setLastName(jso.getString("LAST_NAME"));
                si.setFirstName(jso.getString("FIRST_NAME"));
                si.setIP(jso.getString("IP"));
                si.setER(jso.getInt("ER"));
                si.setBB(jso.getInt("BB"));
                si.setPlayerType("pitcher");
                si.setR_W(jso.getInt("W"));
                si.setH(jso.getInt("H"));
                si.setHr_sv(jso.getInt("SV"));
                si.setRbi_k(jso.getInt("K"));
                si.setQp("P");
                si.setPossiblePositions("P");
                //si.setPositions(null);
                si.setSb_era(jso.getString("ERA"));
                si.setBa_whip(jso.getString("WHIP"));
                si.setNotes(jso.getString("NOTES"));
                si.setYearOfBirth(jso.getInt("YEAR_OF_BIRTH"));
                si.setPlaceOfBirth(jso.getString("PLACE_OF_BIRTH"));
                si.setAvailability(jso.getBoolean("AVAILABILITY"));
                si.setCurrentPosition(jso.getString("CURRENT_POSITION"));
                si.setTaken(jso.getBoolean("TAKEN"));
                si.setPlayerType(jso.getString("PLAYER_TYPE"));
                si.setSalary(jso.getString("SALARY"));
                si.setRank_r(jso.getInt("r_Rank"));
                si.setRank_hr(jso.getInt("hr_Rank"));
                si.setRank_rbi(jso.getInt("rbi_Rank"));
                si.setRank_sb(jso.getInt("sb_Rank"));
                si.setRank_sv(jso.getInt("sv_Rank"));
                si.setRank_k(jso.getInt("k_Rank"));
                si.setRank_ba(jso.getInt("ba_Rank"));
                si.setRank_w(jso.getInt("w_Rank"));
                si.setRank_era(jso.getInt("era_Rank"));
                si.setRank_whip(jso.getInt("whip_Rank"));
                si.setFinalRank(jso.getInt("finalRank"));
                si.setPickNum(jso.getInt("pickNum"));
                si.setFantasyTeam(jso.getString("fantasyTeam"));
                si.setContractStatus(jso.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jso.getString("estValue")));
                // ADD IT TO THE COURSE
                si.calculateValues();
                playerList.add(si);}
            
        }
         
        return playerList;   
        
    }
     // LOADS AN ARRAY OF A SPECIFIC NAME FROM A JSON FILE AND
    // RETURNS IT AS AN ArrayList FULL OF THE DATA FOUND
    private ObservableList<Team> loadTeamArrayFromJSONFile(String jsonFilePath, String arrayName) throws IOException {
       // LOAD THE JSON FILE WITH ALL THE DATA
            JsonObject json = loadJSONFile(jsonFilePath);
            ObservableList<Team> teamList = FXCollections.observableArrayList();
            JsonArray jsonHittersArray = json.getJsonArray(arrayName);
            
            
            
            
            for (int i = 0; i < jsonHittersArray.size(); i++) {
                JsonObject jso = jsonHittersArray.getJsonObject(i);
                JsonArray jsonSLArray = jso.getJsonArray("starting_lineup");
                JsonArray jsonTSArray = jso.getJsonArray("taxi_squad");
                ObservableList<Player> tSL = FXCollections.observableArrayList();
                ObservableList<Player> tTS = FXCollections.observableArrayList();
                Team to = new Team();
            
                to.setName(jso.getString("team_name"));
                to.setCI_Needed(jso.getInt("ci_Needed"));
                to.setMI_Needed(jso.getInt("mi_Needed"));
                to.setP_Needed(jso.getInt("p_Needed"));
                to.setC_Needed(jso.getInt("c_Needed"));
                to.setF_BaseNeeded(jso.getInt("f_BaseNeeded"));
                to.setS_BaseNeeded(jso.getInt("s_BaseNeeded"));
                to.setT_BaseNeeded(jso.getInt("t_BaseNeeded"));
                to.setU_Needed(jso.getInt("u_Needed"));
                to.setSS_Needed(jso.getInt("ss_Needed"));
                to.setOF_Needed(jso.getInt("of_Needed"));
                to.setOwner(jso.getString("owner"));
                to.setTotalPoints(jso.getInt("totalPoints"));
                to.setMoneyLeft(jso.getInt("moneyLeft"));
                to.setCostPP(jso.getInt("costPP"));
                to.setNumPlayersNeeded(jso.getInt("numPlayersNeeded"));
                to.setTotal_R(jso.getInt("total_R"));
                to.setTotal_HR(jso.getInt("total_HR"));
                to.setTotal_RBI(jso.getInt("total_RBI"));
                to.setTotal_SB(jso.getInt("total_SB"));
                to.setTotal_SV(jso.getInt("total_SV"));
                to.setTotal_K(jso.getInt("total_K"));
                to.setTotal_BA(jso.getString("total_BA"));
                to.setTotal_W(jso.getInt("total_W"));
                to.setTotal_ERA(jso.getString("total_ERA"));
                to.setTotal_WHIP(jso.getString("total_WHIP"));
                to.setTaxiTime(jso.getBoolean("taxiTime"));
                
                for(int j=0;j<jsonSLArray.size();j++){
                    JsonObject jSL = jsonSLArray.getJsonObject(j);
                    Player si = new Player();
                    // si.setNotes("test");
                    // IF IT IS A HITTER
                    if(jSL.getString("PLAYER_TYPE").equalsIgnoreCase("hitter")){
                        si.setTeam(jSL.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jSL.getString("LAST_NAME"));
                        si.setFirstName(jSL.getString("FIRST_NAME"));
                        si.setQp(jSL.getString("QP"));
                        //System.out.println(jso.getString("QP"));
                        si.setAB((""+jSL.getInt("AB")));
                        //System.out.println(jso.getString("AB"));
                        si.setH(jSL.getInt("H"));
                        si.setR_W(jSL.getInt("R"));
                        si.setHr_sv(jSL.getInt("HR"));
                        si.setRbi_k(jSL.getInt("RBI"));
                        si.setSb_era(jSL.getString("SB"));
                        si.setBa_whip(jSL.getString("BA"));
                        si.setPlayerType("hitter");
                        //si.setPossiblePositions(jso.getString("QP"));
                        if(jSL.getString("QP").contains("_")){
                            si.setPositions(jSL.getString("QP").split("_"));
                        }
                        else{si.setPositions(new String[]{jSL.getString("QP")});}
                            //si.setPositions(jso.getString("QP").split("_"));
                            si.setNotes(jSL.getString("NOTES"));
                            si.setYearOfBirth(jSL.getInt("YEAR_OF_BIRTH"));
                            si.setPlaceOfBirth(jSL.getString("PLACE_OF_BIRTH"));
                            si.setAvailability(jSL.getBoolean("AVAILABILITY"));
                            si.setCurrentPosition(jSL.getString("CURRENT_POSITION"));
                            si.setTaken(jSL.getBoolean("TAKEN"));
                            si.setPlayerType(jSL.getString("PLAYER_TYPE"));
                            si.setSalary(jSL.getString("SALARY"));
                            si.setRank_r(jSL.getInt("r_Rank"));
                si.setRank_hr(jSL.getInt("hr_Rank"));
                si.setRank_rbi(jSL.getInt("rbi_Rank"));
                si.setRank_sb(jSL.getInt("sb_Rank"));
                si.setRank_sv(jSL.getInt("sv_Rank"));
                si.setRank_k(jSL.getInt("k_Rank"));
                si.setRank_ba(jSL.getInt("ba_Rank"));
                si.setRank_w(jSL.getInt("w_Rank"));
                si.setRank_era(jSL.getInt("era_Rank"));
                si.setRank_whip(jSL.getInt("whip_Rank"));
                si.setFinalRank(jSL.getInt("finalRank"));
                si.setPickNum(jSL.getInt("pickNum"));
                si.setFantasyTeam(jSL.getString("fantasyTeam"));
                si.setContractStatus(jSL.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jSL.getString("estValue")));
                            // ADD IT TO THE COURSE
                            //playerList.add(si); 
                    }
                    else{
                        si.setTeam(jSL.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jSL.getString("LAST_NAME"));
                        si.setFirstName(jSL.getString("FIRST_NAME"));
                        si.setIP(jSL.getString("IP"));
                        si.setER(jSL.getInt("ER"));
                        si.setBB(jSL.getInt("BB"));
                        si.setPlayerType("pitcher");
                        si.setR_W(jSL.getInt("W"));
                        si.setH(jSL.getInt("H"));
                        si.setHr_sv(jSL.getInt("SV"));
                        si.setRbi_k(jSL.getInt("K"));
                        si.setQp("P");
                        si.setPossiblePositions("P");
                        //si.setPositions(null);
                        si.setSb_era(jSL.getString("ERA"));
                        si.setBa_whip(jSL.getString("WHIP"));
                        si.setNotes(jSL.getString("NOTES"));
                        si.setYearOfBirth(jSL.getInt("YEAR_OF_BIRTH"));
                        si.setPlaceOfBirth(jSL.getString("PLACE_OF_BIRTH"));
                        si.setAvailability(jSL.getBoolean("AVAILABILITY"));
                        si.setCurrentPosition(jSL.getString("CURRENT_POSITION"));
                        si.setTaken(jSL.getBoolean("TAKEN"));
                        si.setPlayerType(jSL.getString("PLAYER_TYPE"));
                        si.setSalary(jSL.getString("SALARY"));
                        si.setRank_r(jSL.getInt("r_Rank"));
                si.setRank_hr(jSL.getInt("hr_Rank"));
                si.setRank_rbi(jSL.getInt("rbi_Rank"));
                si.setRank_sb(jSL.getInt("sb_Rank"));
                si.setRank_sv(jSL.getInt("sv_Rank"));
                si.setRank_k(jSL.getInt("k_Rank"));
                si.setRank_ba(jSL.getInt("ba_Rank"));
                si.setRank_w(jSL.getInt("w_Rank"));
                si.setRank_era(jSL.getInt("era_Rank"));
                si.setRank_whip(jSL.getInt("whip_Rank"));
                si.setFinalRank(jSL.getInt("finalRank"));
                si.setPickNum(jSL.getInt("pickNum"));
                si.setFantasyTeam(jSL.getString("fantasyTeam"));
                si.setContractStatus(jSL.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jSL.getString("estValue")));
                        // ADD IT TO THE COURSE
                        //playerList.add(si);}
            
        
                    }
                //to.setTaxiSquad(loadPlayerArrayFromJSONFile(jsonFilePath,"taxi_squad"));
                //to.setStartingLineup(loadPlayerArrayFromJSONFile(jsonFilePath,"starting_lineup"));
                tSL.add(si);
            }
                ///////////////////////////////////////////////////////////////////////////////
                for(int j=0;j<jsonTSArray.size();j++){
                    JsonObject jTS = jsonSLArray.getJsonObject(j);
                    Player si = new Player();
                    // si.setNotes("test");
                    // IF IT IS A HITTER
                    if(jTS.getString("PLAYER_TYPE").equalsIgnoreCase("hitter")){
                        si.setTeam(jTS.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jTS.getString("LAST_NAME"));
                        si.setFirstName(jTS.getString("FIRST_NAME"));
                        si.setQp(jTS.getString("QP"));
                        //System.out.println(jso.getString("QP"));
                        si.setAB((""+jTS.getInt("AB")));
                        //System.out.println(jso.getString("AB"));
                        si.setH(jTS.getInt("H"));
                        si.setR_W(jTS.getInt("R"));
                        si.setHr_sv(jTS.getInt("HR"));
                        si.setRbi_k(jTS.getInt("RBI"));
                        si.setSb_era(jTS.getString("SB"));
                        si.setBa_whip(jTS.getString("BA"));
                        si.setPlayerType("hitter");
                        //si.setPossiblePositions(jso.getString("QP"));
                        if(jTS.getString("QP").contains("_")){
                            si.setPositions(jTS.getString("QP").split("_"));
                        }
                        else{si.setPositions(new String[]{jTS.getString("QP")});}
                            //si.setPositions(jso.getString("QP").split("_"));
                            si.setNotes(jTS.getString("NOTES"));
                            si.setYearOfBirth(jTS.getInt("YEAR_OF_BIRTH"));
                            si.setPlaceOfBirth(jTS.getString("PLACE_OF_BIRTH"));
                            si.setAvailability(jTS.getBoolean("AVAILABILITY"));
                            si.setCurrentPosition(jTS.getString("CURRENT_POSITION"));
                            si.setTaken(jTS.getBoolean("TAKEN"));
                            si.setPlayerType(jTS.getString("PLAYER_TYPE"));
                            si.setSalary(jTS.getString("SALARY"));
                            si.setRank_r(jTS.getInt("r_Rank"));
                si.setRank_hr(jTS.getInt("hr_Rank"));
                si.setRank_rbi(jTS.getInt("rbi_Rank"));
                si.setRank_sb(jTS.getInt("sb_Rank"));
                si.setRank_sv(jTS.getInt("sv_Rank"));
                si.setRank_k(jTS.getInt("k_Rank"));
                si.setRank_ba(jTS.getInt("ba_Rank"));
                si.setRank_w(jTS.getInt("w_Rank"));
                si.setRank_era(jTS.getInt("era_Rank"));
                si.setRank_whip(jTS.getInt("whip_Rank"));
                si.setFinalRank(jTS.getInt("finalRank"));
                si.setPickNum(jTS.getInt("pickNum"));
                si.setFantasyTeam(jTS.getString("fantasyTeam"));
                si.setContractStatus(jTS.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jTS.getString("estValue")));
                            // ADD IT TO THE COURSE
                            //playerList.add(si); 
                    }
                    else{
                        si.setTeam(jTS.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jTS.getString("LAST_NAME"));
                        si.setFirstName(jTS.getString("FIRST_NAME"));
                        si.setIP(jTS.getString("IP"));
                        si.setER(jTS.getInt("ER"));
                        si.setBB(jTS.getInt("BB"));
                        si.setPlayerType("pitcher");
                        si.setR_W(jTS.getInt("W"));
                        si.setH(jTS.getInt("H"));
                        si.setHr_sv(jTS.getInt("SV"));
                        si.setRbi_k(jTS.getInt("K"));
                        si.setQp("P");
                        si.setPossiblePositions("P");
                        //si.setPositions(null);
                        si.setSb_era(jTS.getString("ERA"));
                        si.setBa_whip(jTS.getString("WHIP"));
                        si.setNotes(jTS.getString("NOTES"));
                        si.setYearOfBirth(jTS.getInt("YEAR_OF_BIRTH"));
                        si.setPlaceOfBirth(jTS.getString("PLACE_OF_BIRTH"));
                        si.setAvailability(jTS.getBoolean("AVAILABILITY"));
                        si.setCurrentPosition(jTS.getString("CURRENT_POSITION"));
                        si.setTaken(jTS.getBoolean("TAKEN"));
                        si.setPlayerType(jTS.getString("PLAYER_TYPE"));
                        si.setSalary(jTS.getString("SALARY"));
                        si.setRank_r(jso.getInt("r_Rank"));
                si.setRank_hr(jTS.getInt("hr_Rank"));
                si.setRank_rbi(jTS.getInt("rbi_Rank"));
                si.setRank_sb(jTS.getInt("sb_Rank"));
                si.setRank_sv(jTS.getInt("sv_Rank"));
                si.setRank_k(jTS.getInt("k_Rank"));
                si.setRank_ba(jTS.getInt("ba_Rank"));
                si.setRank_w(jTS.getInt("w_Rank"));
                si.setRank_era(jTS.getInt("era_Rank"));
                si.setRank_whip(jTS.getInt("whip_Rank"));
                si.setFinalRank(jTS.getInt("finalRank"));
                si.setPickNum(jTS.getInt("pickNum"));
                si.setFantasyTeam(jTS.getString("fantasyTeam"));
                si.setContractStatus(jTS.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jTS.getString("estValue")));
                        // ADD IT TO THE COURSE
                        //playerList.add(si);}
            
        
                    }
                //to.setTaxiSquad(loadPlayerArrayFromJSONFile(jsonFilePath,"taxi_squad"));
                //to.setStartingLineup(loadPlayerArrayFromJSONFile(jsonFilePath,"starting_lineup"));
                tTS.add(si);
            }
                //////////////////////////////////////////////////////////////////////////////
                to.setStartingLineup(tSL);
                to.setTaxiSquad(tTS);
                teamList.add(to);
    }
        return teamList;
    }

    public Team loadJsonTeam(String jsonFilePath, String arrayName) throws IOException {
                JsonObject jso = loadJSONFile(jsonFilePath);
                jso = jso.getJsonObject(arrayName);
                JsonArray jsonSLArray = jso.getJsonArray("starting_lineup");
                JsonArray jsonTSArray = jso.getJsonArray("taxi_squad");
                ObservableList<Player> tSL = FXCollections.observableArrayList();
                ObservableList<Player> tTS = FXCollections.observableArrayList();
                Team to = new Team();
            
                to.setName(jso.getString("team_name"));
                to.setCI_Needed(jso.getInt("ci_Needed"));
                to.setMI_Needed(jso.getInt("mi_Needed"));
                to.setP_Needed(jso.getInt("p_Needed"));
                to.setC_Needed(jso.getInt("c_Needed"));
                to.setF_BaseNeeded(jso.getInt("f_BaseNeeded"));
                to.setS_BaseNeeded(jso.getInt("s_BaseNeeded"));
                to.setT_BaseNeeded(jso.getInt("t_BaseNeeded"));
                to.setU_Needed(jso.getInt("u_Needed"));
                to.setSS_Needed(jso.getInt("ss_Needed"));
                to.setOF_Needed(jso.getInt("of_Needed"));
                to.setOwner(jso.getString("owner"));
                to.setTotalPoints(jso.getInt("totalPoints"));
                to.setMoneyLeft(jso.getInt("moneyLeft"));
                to.setCostPP(jso.getInt("costPP"));
                to.setNumPlayersNeeded(jso.getInt("numPlayersNeeded"));
                to.setTotal_R(jso.getInt("total_R"));
                to.setTotal_HR(jso.getInt("total_HR"));
                to.setTotal_RBI(jso.getInt("total_RBI"));
                to.setTotal_SB(jso.getInt("total_SB"));
                to.setTotal_SV(jso.getInt("total_SV"));
                to.setTotal_K(jso.getInt("total_K"));
                to.setTotal_BA(jso.getString("total_BA"));
                to.setTotal_W(jso.getInt("total_W"));
                to.setTotal_ERA(jso.getString("total_ERA"));
                to.setTotal_WHIP(jso.getString("total_WHIP"));
                to.setTaxiTime(jso.getBoolean("taxiTime"));
                
                for(int j=0;j<jsonSLArray.size();j++){
                    JsonObject jSL = jsonSLArray.getJsonObject(j);
                    Player si = new Player();
                    // si.setNotes("test");
                    // IF IT IS A HITTER
                    if(jSL.getString("PLAYER_TYPE").equalsIgnoreCase("hitter")){
                        si.setTeam(jSL.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jSL.getString("LAST_NAME"));
                        si.setFirstName(jSL.getString("FIRST_NAME"));
                        si.setQp(jSL.getString("QP"));
                        //System.out.println(jso.getString("QP"));
                        si.setAB((""+jSL.getInt("AB")));
                        //System.out.println(jso.getString("AB"));
                        si.setH(jSL.getInt("H"));
                        si.setR_W(jSL.getInt("R"));
                        si.setHr_sv(jSL.getInt("HR"));
                        si.setRbi_k(jSL.getInt("RBI"));
                        si.setSb_era(jSL.getString("SB"));
                        si.setBa_whip(jSL.getString("BA"));
                        si.setPlayerType("hitter");
                        //si.setPossiblePositions(jso.getString("QP"));
                        if(jSL.getString("QP").contains("_")){
                            si.setPositions(jSL.getString("QP").split("_"));
                        }
                        else{si.setPositions(new String[]{jSL.getString("QP")});}
                            //si.setPositions(jso.getString("QP").split("_"));
                            si.setNotes(jSL.getString("NOTES"));
                            si.setYearOfBirth(jSL.getInt("YEAR_OF_BIRTH"));
                            si.setPlaceOfBirth(jSL.getString("PLACE_OF_BIRTH"));
                            si.setAvailability(jSL.getBoolean("AVAILABILITY"));
                            si.setCurrentPosition(jSL.getString("CURRENT_POSITION"));
                            si.setTaken(jSL.getBoolean("TAKEN"));
                            si.setPlayerType(jSL.getString("PLAYER_TYPE"));
                            si.setSalary(jSL.getString("SALARY"));
                            si.setRank_r(jSL.getInt("r_Rank"));
                si.setRank_hr(jSL.getInt("hr_Rank"));
                si.setRank_rbi(jSL.getInt("rbi_Rank"));
                si.setRank_sb(jSL.getInt("sb_Rank"));
                si.setRank_sv(jSL.getInt("sv_Rank"));
                si.setRank_k(jSL.getInt("k_Rank"));
                si.setRank_ba(jSL.getInt("ba_Rank"));
                si.setRank_w(jSL.getInt("w_Rank"));
                si.setRank_era(jSL.getInt("era_Rank"));
                si.setRank_whip(jSL.getInt("whip_Rank"));
                si.setFinalRank(jSL.getInt("finalRank"));
                si.setPickNum(jSL.getInt("pickNum"));
                si.setFantasyTeam(jSL.getString("fantasyTeam"));
                si.setContractStatus(jSL.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jSL.getString("estValue")));
                            // ADD IT TO THE COURSE
                            //playerList.add(si); 
                    }
                    else{
                        si.setTeam(jSL.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jSL.getString("LAST_NAME"));
                        si.setFirstName(jSL.getString("FIRST_NAME"));
                        si.setIP(jSL.getString("IP"));
                        si.setER(jSL.getInt("ER"));
                        si.setBB(jSL.getInt("BB"));
                        si.setPlayerType("pitcher");
                        si.setR_W(jSL.getInt("W"));
                        si.setH(jSL.getInt("H"));
                        si.setHr_sv(jSL.getInt("SV"));
                        si.setRbi_k(jSL.getInt("K"));
                        si.setQp("P");
                        si.setPossiblePositions("P");
                        //si.setPositions(null);
                        si.setSb_era(jSL.getString("ERA"));
                        si.setBa_whip(jSL.getString("WHIP"));
                        si.setNotes(jSL.getString("NOTES"));
                        si.setYearOfBirth(jSL.getInt("YEAR_OF_BIRTH"));
                        si.setPlaceOfBirth(jSL.getString("PLACE_OF_BIRTH"));
                        si.setAvailability(jSL.getBoolean("AVAILABILITY"));
                        si.setCurrentPosition(jSL.getString("CURRENT_POSITION"));
                        si.setTaken(jSL.getBoolean("TAKEN"));
                        si.setPlayerType(jSL.getString("PLAYER_TYPE"));
                        si.setSalary(jSL.getString("SALARY"));
                        si.setRank_r(jSL.getInt("r_Rank"));
                si.setRank_hr(jSL.getInt("hr_Rank"));
                si.setRank_rbi(jSL.getInt("rbi_Rank"));
                si.setRank_sb(jSL.getInt("sb_Rank"));
                si.setRank_sv(jSL.getInt("sv_Rank"));
                si.setRank_k(jSL.getInt("k_Rank"));
                si.setRank_ba(jSL.getInt("ba_Rank"));
                si.setRank_w(jSL.getInt("w_Rank"));
                si.setRank_era(jSL.getInt("era_Rank"));
                si.setRank_whip(jSL.getInt("whip_Rank"));
                si.setFinalRank(jSL.getInt("finalRank"));
                si.setPickNum(jSL.getInt("pickNum"));
                si.setFantasyTeam(jSL.getString("fantasyTeam"));
                si.setContractStatus(jSL.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jSL.getString("estValue")));
                        // ADD IT TO THE COURSE
                        //playerList.add(si);}
            
        
                    }
                //to.setTaxiSquad(loadPlayerArrayFromJSONFile(jsonFilePath,"taxi_squad"));
                //to.setStartingLineup(loadPlayerArrayFromJSONFile(jsonFilePath,"starting_lineup"));
                tSL.add(si);
            }
                ///////////////////////////////////////////////////////////////////////////////
                for(int j=0;j<jsonTSArray.size();j++){
                    JsonObject jTS = jsonSLArray.getJsonObject(j);
                    Player si = new Player();
                    // si.setNotes("test");
                    // IF IT IS A HITTER
                    if(jTS.getString("PLAYER_TYPE").equalsIgnoreCase("hitter")){
                        si.setTeam(jTS.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jTS.getString("LAST_NAME"));
                        si.setFirstName(jTS.getString("FIRST_NAME"));
                        si.setQp(jTS.getString("QP"));
                        //System.out.println(jso.getString("QP"));
                        si.setAB((""+jTS.getInt("AB")));
                        //System.out.println(jso.getString("AB"));
                        si.setH(jTS.getInt("H"));
                        si.setR_W(jTS.getInt("R"));
                        si.setHr_sv(jTS.getInt("HR"));
                        si.setRbi_k(jTS.getInt("RBI"));
                        si.setSb_era(jTS.getString("SB"));
                        si.setBa_whip(jTS.getString("BA"));
                        si.setPlayerType("hitter");
                        //si.setPossiblePositions(jso.getString("QP"));
                        if(jTS.getString("QP").contains("_")){
                            si.setPositions(jTS.getString("QP").split("_"));
                        }
                        else{si.setPositions(new String[]{jTS.getString("QP")});}
                            //si.setPositions(jso.getString("QP").split("_"));
                            si.setNotes(jTS.getString("NOTES"));
                            si.setYearOfBirth(jTS.getInt("YEAR_OF_BIRTH"));
                            si.setPlaceOfBirth(jTS.getString("PLACE_OF_BIRTH"));
                            si.setAvailability(jTS.getBoolean("AVAILABILITY"));
                            si.setCurrentPosition(jTS.getString("CURRENT_POSITION"));
                            si.setTaken(jTS.getBoolean("TAKEN"));
                            si.setPlayerType(jTS.getString("PLAYER_TYPE"));
                            si.setSalary(jTS.getString("SALARY"));
                            si.setRank_r(jTS.getInt("r_Rank"));
                si.setRank_hr(jTS.getInt("hr_Rank"));
                si.setRank_rbi(jTS.getInt("rbi_Rank"));
                si.setRank_sb(jTS.getInt("sb_Rank"));
                si.setRank_sv(jTS.getInt("sv_Rank"));
                si.setRank_k(jTS.getInt("k_Rank"));
                si.setRank_ba(jTS.getInt("ba_Rank"));
                si.setRank_w(jTS.getInt("w_Rank"));
                si.setRank_era(jTS.getInt("era_Rank"));
                si.setRank_whip(jTS.getInt("whip_Rank"));
                si.setFinalRank(jTS.getInt("finalRank"));
                si.setPickNum(jTS.getInt("pickNum"));
                si.setFantasyTeam(jTS.getString("fantasyTeam"));
                si.setContractStatus(jTS.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jTS.getString("estValue")));
                            // ADD IT TO THE COURSE
                            //playerList.add(si); 
                    }
                    else{
                        si.setTeam(jTS.getString("TEAM"));
                        //System.out.println(si.getTeam()+" team name");
        
                        si.setLastName(jTS.getString("LAST_NAME"));
                        si.setFirstName(jTS.getString("FIRST_NAME"));
                        si.setIP(jTS.getString("IP"));
                        si.setER(jTS.getInt("ER"));
                        si.setBB(jTS.getInt("BB"));
                        si.setPlayerType("pitcher");
                        si.setR_W(jTS.getInt("W"));
                        si.setH(jTS.getInt("H"));
                        si.setHr_sv(jTS.getInt("SV"));
                        si.setRbi_k(jTS.getInt("K"));
                        si.setQp("P");
                        si.setPossiblePositions("P");
                        //si.setPositions(null);
                        si.setSb_era(jTS.getString("ERA"));
                        si.setBa_whip(jTS.getString("WHIP"));
                        si.setNotes(jTS.getString("NOTES"));
                        si.setYearOfBirth(jTS.getInt("YEAR_OF_BIRTH"));
                        si.setPlaceOfBirth(jTS.getString("PLACE_OF_BIRTH"));
                        si.setAvailability(jTS.getBoolean("AVAILABILITY"));
                        si.setCurrentPosition(jTS.getString("CURRENT_POSITION"));
                        si.setTaken(jTS.getBoolean("TAKEN"));
                        si.setPlayerType(jTS.getString("PLAYER_TYPE"));
                        si.setSalary(jTS.getString("SALARY"));
                        si.setRank_r(jso.getInt("r_Rank"));
                si.setRank_hr(jTS.getInt("hr_Rank"));
                si.setRank_rbi(jTS.getInt("rbi_Rank"));
                si.setRank_sb(jTS.getInt("sb_Rank"));
                si.setRank_sv(jTS.getInt("sv_Rank"));
                si.setRank_k(jTS.getInt("k_Rank"));
                si.setRank_ba(jTS.getInt("ba_Rank"));
                si.setRank_w(jTS.getInt("w_Rank"));
                si.setRank_era(jTS.getInt("era_Rank"));
                si.setRank_whip(jTS.getInt("whip_Rank"));
                si.setFinalRank(jTS.getInt("finalRank"));
                si.setPickNum(jTS.getInt("pickNum"));
                si.setFantasyTeam(jTS.getString("fantasyTeam"));
                si.setContractStatus(jTS.getString("contractStatus"));
                si.setEstimatedValue(Double.parseDouble(jTS.getString("estValue")));
                        // ADD IT TO THE COURSE
                        //playerList.add(si);}
            
        
                    }
                //to.setTaxiSquad(loadPlayerArrayFromJSONFile(jsonFilePath,"taxi_squad"));
                //to.setStartingLineup(loadPlayerArrayFromJSONFile(jsonFilePath,"starting_lineup"));
                tTS.add(si);
            }
                //////////////////////////////////////////////////////////////////////////////
                to.setStartingLineup(tSL);
                to.setTaxiSquad(tTS);
                return to;
    }
    
    
    @Override
    public ArrayList<String> loadHitters(String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
