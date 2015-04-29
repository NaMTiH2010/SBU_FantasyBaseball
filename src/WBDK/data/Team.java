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
    ObservableList<String> positionsNeeded;
    ObservableList<String> viablePositions;
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
        positionsNeeded = FXCollections.observableArrayList();
        startingLineup = FXCollections.observableArrayList();
        taxiSquad = FXCollections.observableArrayList();
        
        positionsNeeded.add("P");
        positionsNeeded.add("C");
        positionsNeeded.add("1B");
        positionsNeeded.add("2B");
        positionsNeeded.add("3B");
        positionsNeeded.add("CI");
        positionsNeeded.add("MI");
        positionsNeeded.add("U");
        positionsNeeded.add("SS");
        positionsNeeded.add("OF");
        
    }

    public Team() {
        name = "";
        owner = "";
        positionsNeeded = FXCollections.observableArrayList();
        startingLineup = FXCollections.observableArrayList();
        taxiSquad = FXCollections.observableArrayList();
        positionsNeeded.add("P");
        positionsNeeded.add("C");
        positionsNeeded.add("1B");
        positionsNeeded.add("2B");
        positionsNeeded.add("3B");
        positionsNeeded.add("CI");
        positionsNeeded.add("MI");
        positionsNeeded.add("U");
        positionsNeeded.add("SS");
        positionsNeeded.add("OF");
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
        if(player.getCurrentPosition().equalsIgnoreCase("c"))
            c_Needed-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("1b"))
            f_BaseNeeded-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("ci"))
            ci_Needed-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("3b"))
            t_BaseNeeded-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("2b"))
            s_BaseNeeded-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("mi"))
            mi_Needed-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("ss"))
            ss_Needed-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("of"))
            of_Needed-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("u"))
            u_Needed-=1;
        else if(player.getCurrentPosition().equalsIgnoreCase("p"))
            p_Needed-=1;
        
        
        startingLineup.add(player);
        //player.setAvailability(false);
        //player.setTaken(true);
        updatePositionsNeeded();
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
        Player tempPlayer;// = new Player();
        if(startingLineup.size()>1){
            while(sortOver == false){
                changed = false;
                for(int i=0; i<startingLineup.size()-1;i++){
                    if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("p") && (
                            startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("u")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("of")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ss")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("mi")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("2b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("3b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c")
                            ))
                    {
                        System.out.println("Round p Player "+i+" = "+startingLineup.get(i).getFirstName());
                        System.out.println(" Round p Player "+(i+1)+" = "+startingLineup.get(i+1).getFirstName());
                        tempPlayer = startingLineup.get(i);
                        startingLineup.set(i, startingLineup.get(i+1));
                        startingLineup.set(i+1, tempPlayer);
                        System.out.println("Round p Player "+i+" = "+startingLineup.get(i).getFirstName());
                        System.out.println(" Round p Player "+(i+1)+" = "+startingLineup.get(i+1).getFirstName());
                        changed = true;
                    }
                    
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("u") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("of")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ss")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("mi")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("2b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("3b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c")
                            ))
                            {
                                System.out.println("Round u Player "+i+" = "+startingLineup.get(i).getFirstName());
                                System.out.println(" Round u Player "+(i+1)+" = "+startingLineup.get(i+1).getFirstName());
                                tempPlayer = startingLineup.get(i);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                                System.out.println("Round u Player "+i+" = "+startingLineup.get(i).getFirstName());
                                System.out.println(" Round u Player "+(i+1)+" = "+startingLineup.get(i+1).getFirstName());
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("of") &&
                            (   startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ss")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("mi")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("2b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("3b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c")
                            ))
                            {
                                tempPlayer = startingLineup.get(i);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("ss") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("mi")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("2b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("3b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c")
                            ))
                            {
                                System.out.println("Round ss Player "+i+" = "+startingLineup.get(i).getFirstName());
                                System.out.println(" Round ss Player "+(i+1)+" = "+startingLineup.get(i+1).getFirstName());
                                tempPlayer = startingLineup.get(i);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                                System.out.println("Round ss Player "+i+" = "+startingLineup.get(i).getFirstName());
                                System.out.println(" Round ss Player "+(i+1)+" = "+startingLineup.get(i+1).getFirstName());
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("mi") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("2b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("3b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("ci")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("1b")
                            ||  startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c")
                            ))
                            {
                                tempPlayer = startingLineup.get(i);
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
                                tempPlayer = startingLineup.get(i);
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
                                tempPlayer = startingLineup.get(i);
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
                                tempPlayer = startingLineup.get(i);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                    else if(startingLineup.get(i).getCurrentPosition().equalsIgnoreCase("1b") &&
                            ( startingLineup.get(i+1).getCurrentPosition().equalsIgnoreCase("c"))
                            )
                            {
                                tempPlayer = startingLineup.get(i);
                                startingLineup.set(i, startingLineup.get(i+1));
                                startingLineup.set(i+1, tempPlayer);
                                changed = true;
                            }
                   // else{System.out.println(""startingLineup.get(i).getFirstName());}
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
    @Override
       public String toString(){
           String teamString = name;
           return teamString;
       }
       
       public void setPositionsNeeded(ObservableList<String> positionsNeeded){
           this.positionsNeeded = positionsNeeded;
       }

    private void updatePositionsNeeded() {
        for(int i =0; i < positionsNeeded.size();i++){
            if(positionsNeeded.get(i).toString().equalsIgnoreCase("p") && p_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("c") && c_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("u") && u_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("ci") && ci_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("mi") && mi_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("ss") && ss_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("of") && of_Needed<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("1B") && f_BaseNeeded<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("2B") && s_BaseNeeded<=0)
                positionsNeeded.remove(i);
            else if(positionsNeeded.get(i).toString().equalsIgnoreCase("3B") && t_BaseNeeded<=0)
                positionsNeeded.remove(i);
            else
                System.out.println("ughhhhhHHHHHHH  posNeeded= "+positionsNeeded.get(i).toString());
        }    
    }
    public ObservableList<String> getPositionsNeeded(String[] playerOptions){
        viablePositions = FXCollections.observableArrayList();
           for(int i =0;i<playerOptions.length;i++){
               for(int j =0;j<positionsNeeded.size();j++){
                   if(positionsNeeded.get(j).equalsIgnoreCase(playerOptions[i]))
                       viablePositions.add(playerOptions[i]);
               }
           }
           return viablePositions;
       }
    }
    

