/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author MatthewLuce
 */
public class Player implements Comparable<Player>{
    final StringProperty fantasyTeam;
    String[] positions;
    String contractStatus;
    String possiblePositions;
    final StringProperty team;
    public static final String DEFAULT_TEAM_NAME = "<ENTER TEAM NAME>";
    
    final StringProperty firstName;
    public static final String DEFAULT_FIRST_NAME = "<ENTER FIRST NAME>";
    final StringProperty lastName;
    public static final String DEFAULT_LAST_NAME = "<ENTER LAST NAME>";
    
     StringProperty notes;
    final StringProperty placeOfBirth;
    public static final String DEFAULT_PLACE_OF_BIRTH = "<ENTER PLACE OF BIRTH>";
    final StringProperty qp;
    public static final String DEFAULT_QP= "<ENTER QP>";
    final IntegerProperty r_w;
    final IntegerProperty hr_sv;
    final IntegerProperty rbi_k;
    final DoubleProperty sb_era;
    final DoubleProperty ba_whip;
    final IntegerProperty yearOfBirth;
    double salary;
    boolean availability = true;
    boolean taken = false;
    String playerType;
    String currentPosition;
    //////////// Pitcher //////////// 
    
    double ip;
    int er;
    int bb;

    //////////// Hitter /////////////
    int ab;
    int h;

    public Player(){
        
        fantasyTeam = new SimpleStringProperty("Default");
        team = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        firstName = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        lastName = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        qp = new SimpleStringProperty(DEFAULT_QP);
        yearOfBirth = new SimpleIntegerProperty();
        notes = new SimpleStringProperty("default");
        placeOfBirth = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        r_w = new SimpleIntegerProperty();
        hr_sv = new SimpleIntegerProperty();
        rbi_k = new SimpleIntegerProperty();
        sb_era = new SimpleDoubleProperty();
        ba_whip = new SimpleDoubleProperty();
        currentPosition = "default";
        salary = 0.0;
        
    }
    /////////////////////////////////////////////_Both_/////////////////////////
    public void setFirstName(String firstName){
        
        this.firstName.set(firstName);
    }
    public String getNotes(){
        return notes.get();
    }
    public String getFirstName(){        
        return firstName.get();
    }
    public void setQp(String qp){
        //System.out.println("qp =:  "+qp);
        this.qp.set(qp);
    }
    public String getQP(){
        // System.out.println("qp =:  "+qp);
        return qp.get();
    }
    
    
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
    public String getLastName(){
        return lastName.get();
    }
    
    public void setContractStatus(String contractStatus){
        this.contractStatus = contractStatus;
    }
    public String getContractStatus(){
        return contractStatus;
    }
    
    public void setPlayerType(String playerType){
        this.playerType = playerType;
    }
    public String getPlayerType(){
        return playerType;
    }
    
    public void setYearOfBirth(int yearOfBirth ){
        this.yearOfBirth.set(yearOfBirth); 
    }
    public int getYearOfBirth(){
        return yearOfBirth.get();
    }
    
    public void setPlaceOfBirth(String placeOfBirth ){
        this.placeOfBirth.set(placeOfBirth);
    }
    public String getPlaceOfBirth(){
        return placeOfBirth.get();
    }
    
    public void setNotes(String notes ){
        this.notes.set(notes); 
    }
    
    public void setSalary(String salary ){
        this.salary = Double.parseDouble(salary);
    }
    public String getSalary(){
        return ""+salary;
    }
    
    public void setAvailability(boolean availability ){
        this.availability = availability;
    }
    public boolean getAvailability(){
        return availability;
    }
    public void setCurrentPosition(String pos){
        currentPosition = pos;
    }
    public String getCurrentPosition(){
        return currentPosition;
    }
    public void setTeam(String initTeam){
        team.set(initTeam);
    }
    public String getTeam(){
        return team.get();
    }
    public void setR_W(int r_w){
        this.r_w.set(r_w);
    }
    public int getR_W(){
        return r_w.get();
    }
    public void setHr_sv(int hr_sv){
        this.hr_sv.set(hr_sv);
    }
    public int getHR_SV(){
        return hr_sv.get();
    }
    
    public void setRbi_k(int rbi_k){
        this.rbi_k.set(rbi_k);
    }
    public int getRBI_K(){
        return rbi_k.get();
    }
    public void setSb_era(String sb_era){
        this.sb_era.set(Double.parseDouble(sb_era));
    }
    public String getSB_ERA(){
        return ""+sb_era.get();
    }
    public void setBa_whip(String ba_whip){
        this.ba_whip.set(Double.parseDouble(ba_whip));
    }
    public double getBA_WHIP(){
        return ba_whip.get();
    }
    
    public void setIP(String ip){
        this.ip = Double.parseDouble(ip);
    }
    public String getIP(){
        return ""+ip;
    }
    public void setER(int er){
        this.er = er;
    }
    public int getER(){
        return er;
    }
    public int getBB(){
        return bb;
    }
    public void setH(int h){
        this.h = h;
    }
    public int getH(){
        return h;
    }
    public void setBB(int bb){
        this.bb = bb;
    }
    public void setAB(String ab){
        this.ab = Integer.parseInt(ab);
    }
    public int getAB(){
        return ab;
    }
  
    public void setPositions(String[] array){
        positions = array;
    }
    public String[] getPositions(){
        return positions;
    }
    public String getPossiblePositions() {
        return possiblePositions;
    }
    public void setPossiblePositions(String possiblePositions){
        this.possiblePositions = possiblePositions;
    }
    public boolean getTaken(){
        return taken;
    }
    public void setTaken(boolean taken){
        this.taken = taken;
    }
    public String getFantasyTeam(){
        return fantasyTeam.get();
    }
    public void setFantasyTeam(String fantasyTeam){
        this.fantasyTeam.set(fantasyTeam);
    }
    // Helping the table out
    public StringProperty qpProperty(){

         return qp;

     }
    public IntegerProperty r_wProperty(){

         return r_w;

     }
    public IntegerProperty hr_svProperty(){

         return hr_sv;

     }
    public IntegerProperty rbi_kProperty(){

         return rbi_k;

     }
    public DoubleProperty sb_eraProperty(){

         return sb_era;

     }
    public DoubleProperty ba_whipProperty(){

         return ba_whip;

     }

    public void setERA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Player clone(Player op){
        Player tc = new Player();
        tc.setContractStatus(op.getContractStatus());
        tc.setCurrentPosition(op.getCurrentPosition());
        tc.setAvailability(op.getAvailability());
        tc.setFantasyTeam(op.getFantasyTeam());
        tc.setFirstName(op.getFirstName());
        tc.setLastName(op.getLastName());
        tc.setAB(""+op.getAB());
        tc.setBB(op.getBB());
        tc.setER(op.getER());
        tc.setH(op.getH());
        tc.setQp(op.getQP());
        tc.setPositions(op.getPositions());
        tc.setTeam(op.getTeam());
        tc.setPossiblePositions(op.getPossiblePositions());
        tc.setNotes(op.getNotes());
        tc.setPlaceOfBirth(op.getPlaceOfBirth());
        tc.setR_W(op.getR_W());
        tc.setHr_sv(op.getHR_SV());
        tc.setRbi_k(op.getRBI_K());
        tc.setSb_era(op.getSB_ERA());
        tc.setBa_whip(""+op.getBA_WHIP());
        tc.setYearOfBirth(op.getYearOfBirth());
        tc.setSalary(""+op.getSalary());
        tc.setTaken(op.getTaken());
        tc.setPlayerType(op.getPlayerType());
        tc.setIP(""+op.getIP());
        
        return tc;
    }
    public void calculateValues(){
        if(playerType.equalsIgnoreCase("hitter")){
            if(h != 0){
                double broke = (((double)h)/ ((double)ab));
                String fixing = String.format("%.3f", broke);
                Double fixed = Double.parseDouble(fixing);
                ba_whip.set(fixed);
                
            }
            else
                ba_whip.set(0);
            
        }
        else{
            if(ip != 0 && (bb+h) !=0){
                double broke = ((double)(bb+h)/ip);
                String fixing = String.format("%.3f", broke);
                Double fixed = Double.parseDouble(fixing);
                ba_whip.set(fixed);
                
            }
            else
                ba_whip.set(0);
           
            if(ip != 0 && er !=0){
                double broke = (((double)er)*9)/ip;
                String fixing = String.format("%.3f", broke);
                Double fixed = Double.parseDouble(fixing);
                sb_era.set(fixed);
                
            }
            else
                sb_era.set(0);
            
           // ba_whip.set( ((double)(bb+h)/ip));
            //sb_era.set((((double)er)*9)/ip);
        }
    }
    @Override
    public int compareTo(Player other) {
        if(this.lastName.get().equalsIgnoreCase(other.lastName.get())) {
            return this.getFirstName().toLowerCase().compareTo(other.getFirstName().toLowerCase());
        } 
        else {
            return this.getLastName().toLowerCase().compareTo(other.getLastName().toLowerCase());
        }
    }
}

