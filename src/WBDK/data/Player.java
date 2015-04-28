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
public class Player {
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
        
        fantasyTeam = new SimpleStringProperty();
        team = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        firstName = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        lastName = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        qp = new SimpleStringProperty(DEFAULT_QP);
        yearOfBirth = new SimpleIntegerProperty();
        notes = new SimpleStringProperty();
        placeOfBirth = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        r_w = new SimpleIntegerProperty();
        hr_sv = new SimpleIntegerProperty();
        rbi_k = new SimpleIntegerProperty();;
        sb_era = new SimpleDoubleProperty();;
        ba_whip = new SimpleDoubleProperty();
        
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
         System.out.println("qp =:  "+qp);
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
    
    public void setYearOfBirth(String yearOfBirth ){
        this.yearOfBirth.set(Integer.parseInt(yearOfBirth)); 
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
    
    public void setSalary(double salary ){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
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
    public void setR_W(String r_w){
        this.r_w.set(Integer.parseInt(r_w));
    }
    public int getR_W(){
        return r_w.get();
    }
    public void setHr_sv(String hr_sv){
        this.hr_sv.set(Integer.parseInt(hr_sv));
    }
    public int getHR_SV(){
        return hr_sv.get();
    }
    
    public void setRbi_k(String rbi_k){
        this.rbi_k.set(Integer.parseInt(rbi_k));
    }
    public int getRBI_K(){
        return rbi_k.get();
    }
    public void setSb_era(Double sb_era){
        this.sb_era.set(sb_era);
    }
    public double getSB_ERA(){
        return sb_era.get();
    }
    public void setBa_whip(double ba_whip){
        this.ba_whip.set(ba_whip);
    }
    public double getBA_WHIP(){
        return ba_whip.get();
    }
    
    public void setIP(String ip){
        this.ip = Double.parseDouble(ip);
    }
    public Double getIP(){
        return ip;
    }
    public void setER(String er){
        this.er = Integer.parseInt(er);
    }
    public int getER(){
        return er;
    }
    public int getBB(){
        return bb;
    }
    public void setH(String h){
        this.h = Integer.parseInt(h);
    }
    public int getH(){
        return h;
    }
    public void setBB(String bb){
        this.bb = Integer.parseInt(bb);
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
    
}

