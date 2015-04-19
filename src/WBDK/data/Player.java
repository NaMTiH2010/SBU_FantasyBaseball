/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

/**
 *
 * @author MatthewLuce
 */
public class Player {
    String contractStatus;
    String firstName;
    String lastName;
    String team;
    String playerType;
    String yearOfBirth;
    String placeOfBirth;
    String notes;
    double salary;
    boolean availability;
    Statistics stats;
    //////////// Pitcher /////////////
    String ip;
    String er;
    String w;
    String sv;
    String h;
    String bb;
    String k;
    
    //////////// Hitter /////////////
    String qp;
    String ab;
    String r;
    //String h;
    String hr;
    String rbi;
    String sb;
    
    public Player(){
        
    }
    /////////////////////////////////////////////_Both_/////////////////////////
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
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
        this.yearOfBirth = yearOfBirth;
    }
    public String getYearOfBirth(){
        return yearOfBirth;
    }
    
    public void setPlaceOfBirth(String placeOfBirth ){
        this.placeOfBirth = placeOfBirth;
    }
    public String getPlaceOfBirth(){
        return placeOfBirth;
    }
    
    public void setNotes(String notes ){
        this.notes = notes;
    }
    public String getNotes(){
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
    public void setTeam(String team){
        this.team=team;
    }
    public String getTeam(){
        return team;
    }
    ///////////////////////////////////////////_Pitcher_////////////////////////
    public void setIP(String ip){
        this.ip = ip;
    }
    public void setER(String er){
        this.er = er;
    }
    public void setW(String w){
        this.w=w;
    }
    public void setSV(String sv){
        this.sv=sv;
    }
    public void setH(String h){
        this.h=h;
    }
    public void setBB(String bb){
        this.bb=bb;
    }
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
    public void setAB(String ab){
        this.ab=ab;
    }
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
    }
}

