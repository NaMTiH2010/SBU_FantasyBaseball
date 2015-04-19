/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author MatthewLuce
 */
public class Player {
    String contractStatus;
    //String firstName;
    //String lastName;
    final StringProperty team;
    public static final String DEFAULT_TEAM_NAME = "<ENTER TEAM NAME>";
    
    
    final StringProperty firstName;
    public static final String DEFAULT_FIRST_NAME = "<ENTER FIRST NAME>";
    final StringProperty lastName;
    public static final String DEFAULT_LAST_NAME = "<ENTER LAST NAME>";
    final StringProperty yearOfBirth;
    public static final String DEFAULT_YEAR_OF_BIRTH = "<ENTER YEAR OF BIRTH>";
    final StringProperty notes;
    public static final String DEFAULT_NOTES = "<ENTER NOTES>";
    final StringProperty placeOfBirth;
    public static final String DEFAULT_PLACE_OF_BIRTH = "<ENTER PLACE OF BIRTH>";
    
    final StringProperty r_w;
    public static final String DEFAULT_R_W = "<ENTER R_W>";
    final StringProperty hr_sv;
    public static final String DEFAULT_HR_SV = "<ENTER HR_SV>";
    final StringProperty rbi_k;
    public static final String DEFAULT_RBI_K = "<ENTER RBI_K>";
    final StringProperty sb_era;
    public static final String DEFAULT_SB_ERA = "<ENTER SB_ERA>";
    final StringProperty ba_whip;
    public static final String DEFAULT_BA_WHIP = "<ENTER BA_WHIP>";
    
    String playerType;
    //String yearOfBirth;
    //String placeOfBirth;
    //String notes;
    double salary;
    boolean availability;
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
    String qp;
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
        yearOfBirth = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        notes = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        placeOfBirth = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        r_w = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        hr_sv = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        rbi_k = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        sb_era = new SimpleStringProperty(DEFAULT_TEAM_NAME);
        ba_whip = new SimpleStringProperty(DEFAULT_TEAM_NAME);
    }
    /////////////////////////////////////////////_Both_/////////////////////////
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    public StringProperty firstNameProperty(){
        return firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
    public StringProperty lastNameProperty(){
        return lastName;
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
        this.yearOfBirth.set(yearOfBirth); 
    }
    public StringProperty yearOfBirthProperty(){
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
    public void setTeam(String initTeam){
        team.set(initTeam);
    }
    public StringProperty teamProperty(){
        return team;
    }
    public void setR_W(String r_w){
        this.r_w.set(r_w);
    }
    public StringProperty r_wProperty(){
        return r_w;
    }
    public void setHr_sv(String hr_sv){
        this.hr_sv.set(hr_sv);
    }
    public StringProperty hr_svProperty(){
        return hr_sv;
    }
    public void setRbi_k(String rbi_k){
        this.rbi_k.set(rbi_k);
    }
    public StringProperty rbi_kProperty(){
        return rbi_k;
    }
    public void setSb_era(String sb_era){
        this.sb_era.set(sb_era);
    }
    public StringProperty sb_eraProperty(){
        return sb_era;
    }
    public void setBa_whip(String ba_whip){
        this.ba_whip.set(ba_whip);
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
    */public void setQP(String qp){
        this.qp=qp;
    }
    
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
}

