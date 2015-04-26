/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author MatthewLuce
 */
public class Player {
    String[] positions;
    String contractStatus;
    String possiblePositions;
    //String firstName;
    //String lastName;
    final StringProperty team;
    public static final String DEFAULT_TEAM_NAME = "<ENTER TEAM NAME>";
    
    
    final StringProperty firstName;
    public static final String DEFAULT_FIRST_NAME = "<ENTER FIRST NAME>";
    final StringProperty lastName;
    public static final String DEFAULT_LAST_NAME = "<ENTER LAST NAME>";
    final IntegerProperty yearOfBirth;
    //public static final String DEFAULT_YEAR_OF_BIRTH = "<ENTER YEAR OF BIRTH>";
     StringProperty notes;
     //public static String default_notes = "ENTER NOTES";
   // public static final String DEFAULT_NOTES = "<ENTER NOTES>";
    final StringProperty placeOfBirth;
    public static final String DEFAULT_PLACE_OF_BIRTH = "<ENTER PLACE OF BIRTH>";
    final StringProperty qp;
    public static final String DEFAULT_QP= "<ENTER QP>";
    final IntegerProperty r_w;
   // public static final String DEFAULT_R_W = "<ENTER R_W>";
    final IntegerProperty hr_sv;
    //public static final String DEFAULT_HR_SV = "<ENTER HR_SV>";
    final IntegerProperty rbi_k;
    //public static final String DEFAULT_RBI_K = "<ENTER RBI_K>";
    final IntegerProperty sb_era;
    //public static final String DEFAULT_SB_ERA = "<ENTER SB_ERA>";
    final IntegerProperty ba_whip;
   // public static final String DEFAULT_BA_WHIP = "<ENTER BA_WHIP>";
    
    
    //String yearOfBirth;
    //String placeOfBirth;
    //String notes;
    double salary;
    boolean availability = true;
    String playerType;
    String currentPosition;
    
    //Statistics stats;
    //////////// Pitcher //////////// 
    
    String ip;
    String er;
    String bb;
    /*
    String w;
    String sv;
    
    
    String k;
    */
    //////////// Hitter /////////////
    //String qp;
    String ab;
    String h;
    /*
    String r;
    //String h;
    
    String hr;
    String rbi;
    String sb;
    */
    public Player(){
        
        
        team = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        firstName = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        lastName = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        qp = new SimpleStringProperty(DEFAULT_QP);
        yearOfBirth = new SimpleIntegerProperty();;
        notes = new SimpleStringProperty();
        placeOfBirth = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        r_w = new SimpleIntegerProperty();
        hr_sv = new SimpleIntegerProperty();;
        rbi_k = new SimpleIntegerProperty();;
        sb_era = new SimpleIntegerProperty();;
        ba_whip = new SimpleIntegerProperty();;
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
    public IntegerProperty yearOfBirthProperty(){
        return yearOfBirth;
    }
    
    public void setPlaceOfBirth(String placeOfBirth ){
        this.placeOfBirth.set(placeOfBirth);
    }
    public StringProperty placeOfBirthProperty(){
        return placeOfBirth;
    }
    
    public void setNotes(String notes ){
        this.notes.set(notes); 
    }
    public StringProperty notesProperty(){
        return notes;
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
    public StringProperty teamProperty(){
        return team;
    }
    public void setR_W(String r_w){
        this.r_w.set(Integer.parseInt(r_w));
    }
    public IntegerProperty r_wProperty(){
        return r_w;
    }
    public void setHr_sv(String hr_sv){
        this.hr_sv.set(Integer.parseInt(hr_sv));
    }
    public IntegerProperty hr_svProperty(){
        return hr_sv;
    }
    public void setQp(String qp){
        this.qp.set(qp);
    }
    public StringProperty qpProperty(){
        return qp;
    }
    public void setRbi_k(String rbi_k){
        this.rbi_k.set(Integer.parseInt(rbi_k));
    }
    public IntegerProperty rbi_kProperty(){
        return rbi_k;
    }
    public void setSb_era(String sb_era){
        this.sb_era.set(Integer.parseInt(sb_era));
    }
    public IntegerProperty sb_eraProperty(){
        return sb_era;
    }
    public void setBa_whip(String ba_whip){
        this.ba_whip.set(Integer.parseInt(ba_whip));
    }
    public IntegerProperty ba_WhipProperty(){
        return ba_whip;
    }
    
    public void setIP(String ip){
        this.ip = ip;
    }
    public void setER(String er){
        this.er = er;
    }
    /*
    public void setW(String w){
        this.w=w;
    }
    public void setSV(String sv){
        this.sv=sv;
    }*/
    public void setH(String h){
        this.h=h;
    }
    public void setBB(String bb){
        this.bb=bb;
    }/*
    public void setK(String k){
        this.k=k;
    }
    
    public String getIP(){
        return ip;
    }
    public String getER(){
        return er;
    }
    public String getW(){
        return w;
    }
    public String getSV(){
        return sv;
    }
    public String getH(){
        return h;
    }
    public String getBB(){
        return bb;
    }
    public String getK(){
        return k;
    }
    //////////////////////////////////////////_Hitter_////////////////////////
    public void setQP(String qp){
        this.qp=qp;
    }
    */
    public void setAB(String ab){
        this.ab=ab;
    }/*
    public void setR(String r){
        this.r=r;
    }
    public void setHR(String hr){
        this.hr=hr;
    }
    public void setRBI(String rbi){
        this.rbi=rbi;
    }
    public void setSB(String sb){
        this.sb=sb;
    }
    
    public String getQP(){
        return qp;
    }
    public String getAB(){
        return ab;
    }
    public String getR(){
        return r;
    }
    public String getHR(){
        return hr;
    }
    public String getRBI(){
        return rbi;
    }
    public String getSB(){
        return sb;
    }*/
    public void setPositions(String[] array){
        positions = array;
    }
    public String[] getPositions(){
        return positions;
    }
    public String getPlaceOfBirth(){
        return placeOfBirth.get();
    }

    public String getPossiblePositions() {
        return possiblePositions;
    }
    public void setPossiblePositions(String possiblePositions){
        this.possiblePositions = possiblePositions;
    }
}

