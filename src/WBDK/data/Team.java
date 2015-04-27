/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MatthewLuce
 */
public class Team {
    //ObservableList<String> availablePositions;
    ObservableList<Player> startingLineup;
    ObservableList<Player> taxiSquad;
    String name;
    String owner;
    int p_Needed = 9;
    int c_Needed = 2;
    int f_BaseNeeded = 1;
    int s_BaseNeeded = 1;
    int t_BaseNeeded = 1;
    int ci_Needed = 1;
    int mi_Needed = 1;
    int u_Needed = 1;
    int ss_Needed = 1;
    int of_Needed = 5;
    
    public Team(String name, String owner){
        this.name = name;
        this.owner = owner;
    }

    public Team() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setOF_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getOF_Needed(){
        return of_Needed;
    }    
    public void setF_BaseNeeded(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getF_BaseNeeded(){
        return of_Needed;
    }
    public void setS_BaseNeeded(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getS_BaseNeeded(){
        return of_Needed;
    }
    public void setT_BaseNeeded(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getT_BaseNeeded(){
        return of_Needed;
    }
    public void setP_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getP_Needed(){
        return of_Needed;
    }
    public void setC_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getC_Needed(){
        return of_Needed;
    }
    public void setMI_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getMI_Needed(){
        return of_Needed;
    }
    public void setCI_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getCI_Needed(){
        return of_Needed;
    }
    public void setU_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getU_Needed(){
        return of_Needed;
    }
    public void setSS_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getSS_Needed(){
        return of_Needed;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    public ObservableList<Player> getStartingLineup(){
        return startingLineup;
    }
    public ObservableList<Player> getTaxiSquad(){
        return taxiSquad;
    }
    
    
    
    
    
    public void addStartingLineupPlayer(Player player){
        if(player.getCurrentPosition().equalsIgnoreCase("c")){
            c_Needed-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("1b")){
            f_BaseNeeded-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("ci")){
            ci_Needed-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("3b")){
            t_BaseNeeded-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("2b")){
            s_BaseNeeded-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("mi")){
            mi_Needed-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("ss")){
            ss_Needed-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("of")){
            of_Needed-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("u")){
            u_Needed-=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("p")){
            p_Needed-=1;
        }
        startingLineup.add(player);
        sortStartingLineup();
    }
    public void removeStartingLineupPlayer(Player player){
        
        if(player.getCurrentPosition().equalsIgnoreCase("c")){
            c_Needed+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("1b")){
            f_BaseNeeded+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("ci")){
            ci_Needed+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("3b")){
            t_BaseNeeded+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("2b")){
            s_BaseNeeded+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("mi")){
            mi_Needed+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("ss")){
            ss_Needed+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("of")){
            of_Needed+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("u")){
            u_Needed+=1;
        }
        else if(player.getCurrentPosition().equalsIgnoreCase("p")){
            p_Needed+=1;
        }
        startingLineup.remove(player);
    }
    
    public void sortStartingLineup(){
        ObservableList<Player> temp = FXCollections.observableArrayList();
        boolean changed;
        boolean sortOver = false;
        Player tempPlayer;
        if(startingLineup.size()>1){
            while(sortOver == false){
                changed = false;
                for(int i=0; i<startingLineup.size()-1;i++){
                    if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("p") &&
                    !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("p"))
                    {
                        tempPlayer = startingLineup.get(i+1);
                        startingLineup.set(i, startingLineup.get(i+1));
                        startingLineup.set(i+1, tempPlayer);
                        changed = true;
                    }
                    
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("u") &&
                            ( !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("p")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("u") )
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("of") &&
                            ( !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("p")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("u")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("of"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("ss") &&
                            ( !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("p")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("u")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("of")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ss"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("mi") &&
                            ( !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("p")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("u")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("of")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ss")
                            ||
                            !startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("mi"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("2b") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("3b")
                            ||
                              startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||
                              startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||
                              startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("3b") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||
                              startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||
                              startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("ci") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||
                              startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("1b") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c"))
                            )
                            {
                                tempPlayer = startingLineup.get(i+1);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                }
                if(changed == false)
                    sortOver = true;
            }
            
        }
        }
    
       public void setStartingLineup(ObservableList<Player> temp){
           startingLineup = temp;
       }
       public void setTaxiSquad(ObservableList<Player> temp){
           taxiSquad = temp;
       }
    }
    

