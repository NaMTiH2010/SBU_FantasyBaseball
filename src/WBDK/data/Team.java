/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.data;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MatthewLuce
 */
public class Team {
    //ObservableList<String> availablePositions;
   private ObservableList<Player> startingLineup;
   private ObservableList<Player> taxiSquad;
   private ObservableList<String> emptyList;
   private ObservableList<String> positionsNeeded;
   private ObservableList<String> viablePositions;
   private ObservableList<String> positions;
   private StringProperty name;
   private String owner;
    // variables for fantasy standings screen
   private final IntegerProperty moneyLeft;
   private final IntegerProperty costPP;
   private final IntegerProperty numPlayersNeeded;
   private final IntegerProperty total_R;
   private final IntegerProperty total_HR;
   private final IntegerProperty total_RBI;
   private final IntegerProperty total_SB;
   private final IntegerProperty total_SV;
   private final IntegerProperty total_K;
   private final DoubleProperty total_BA;
   private final DoubleProperty total_W;
   private final DoubleProperty total_ERA;
   private final DoubleProperty total_WHIP;
    
    private int i;
    private int j;
    private int total;
    private int p_Needed = 9;
    private int c_Needed = 2;
    private int f_BaseNeeded = 1;
    private int s_BaseNeeded = 1;
    private int t_BaseNeeded = 1;
    private int ci_Needed = 1;
    private int mi_Needed = 1;
    private int u_Needed = 1;
    private int ss_Needed = 1;
    private int of_Needed = 5;
    
    private boolean taxiTime = false;
    
    
    public Team(String name, String owner){
        
        //this.name = name;
        this.owner = owner;
        positionsNeeded = FXCollections.observableArrayList();
        startingLineup = FXCollections.observableArrayList();
        taxiSquad = FXCollections.observableArrayList();
        positions = FXCollections.observableArrayList();
        emptyList = FXCollections.observableArrayList();
        emptyList.add("(empty)");
        
        positions.add("P");
        positions.add("C");
        positions.add("1B");
        positions.add("2B");
        positions.add("3B");
        positions.add("CI");
        positions.add("MI");
        positions.add("U");
        positions.add("SS");
        positions.add("OF");
        
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
         
        this.name = new SimpleStringProperty();
        this.name.set(name);
        moneyLeft = new SimpleIntegerProperty(260);
        costPP = new SimpleIntegerProperty(0);
        numPlayersNeeded = new SimpleIntegerProperty(23);
        total_R = new SimpleIntegerProperty(0);
        total_HR = new SimpleIntegerProperty(0);
        total_RBI = new SimpleIntegerProperty(0);
        total_SB = new SimpleIntegerProperty(0);
        total_SV = new SimpleIntegerProperty(0);
        total_K = new SimpleIntegerProperty(0);
        total_BA = new SimpleDoubleProperty(0);
        total_W = new SimpleDoubleProperty(0);
        total_ERA = new SimpleDoubleProperty(0);
        total_WHIP = new SimpleDoubleProperty(0);
    }

    public Team() {
        //name = "";
        owner = "";
        positionsNeeded = FXCollections.observableArrayList();
        startingLineup = FXCollections.observableArrayList();
        taxiSquad = FXCollections.observableArrayList();
        
        positions = FXCollections.observableArrayList();
        
        positions.add("P");
        positions.add("C");
        positions.add("1B");
        positions.add("2B");
        positions.add("3B");
        positions.add("CI");
        positions.add("MI");
        positions.add("U");
        positions.add("SS");
        positions.add("OF");
        
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
         
        name = new SimpleStringProperty("");
        moneyLeft = new SimpleIntegerProperty(260);
        costPP = new SimpleIntegerProperty(0);
        numPlayersNeeded = new SimpleIntegerProperty(23);
        total_R = new SimpleIntegerProperty(0);
        total_HR = new SimpleIntegerProperty(0);
        total_RBI = new SimpleIntegerProperty(0);
        total_SB = new SimpleIntegerProperty(0);
        total_SV = new SimpleIntegerProperty(0);
        total_K = new SimpleIntegerProperty(0);
        total_BA = new SimpleDoubleProperty(0);
        total_W = new SimpleDoubleProperty(0);
        total_ERA = new SimpleDoubleProperty(0);
        total_WHIP = new SimpleDoubleProperty(0);
    }
    public void setOF_Needed(int of_Needed){
        this.of_Needed = of_Needed;
    }
    public int getOF_Needed(){
        return of_Needed;
    }    
    public void setF_BaseNeeded(int of_Needed){
        this.f_BaseNeeded = of_Needed;
    }
    public int getF_BaseNeeded(){
        return f_BaseNeeded;
    }
    public void setS_BaseNeeded(int of_Needed){
        this.s_BaseNeeded = of_Needed;
    }
    public int getS_BaseNeeded(){
        return s_BaseNeeded;
    }
    public void setT_BaseNeeded(int of_Needed){
        this.t_BaseNeeded = of_Needed;
    }
    public int getT_BaseNeeded(){
        return t_BaseNeeded;
    }
    public void setP_Needed(int of_Needed){
        this.p_Needed = of_Needed;
    }
    public int getP_Needed(){
        return p_Needed;
    }
    public void setC_Needed(int of_Needed){
        this.c_Needed = of_Needed;
    }
    public int getC_Needed(){
        return c_Needed;
    }
    public void setMI_Needed(int of_Needed){
        this.mi_Needed = of_Needed;
    }
    public int getMI_Needed(){
        return mi_Needed;
    }
    public void setCI_Needed(int of_Needed){
        this.ci_Needed = of_Needed;
    }
    public int getCI_Needed(){
        return ci_Needed;
    }
    public void setU_Needed(int of_Needed){
        this.u_Needed = of_Needed;
    }
    public int getU_Needed(){
        return u_Needed;
    }
    public void setSS_Needed(int of_Needed){
        this.ss_Needed = of_Needed;
    }
    public int getSS_Needed(){
        return ss_Needed;
    }
    public String getName(){
        return name.get();
    }
    public void setName(String name){
        this.name.set(name); 
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
        if(numPlayersNeeded.get() > 0){
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

        moneyLeft.set((int) (moneyLeft.get()-Double.parseDouble(player.getSalary())));
        numPlayersNeeded.set(numPlayersNeeded.get()-1);
        
        if(numPlayersNeeded.get() <= 0){
            taxiTime = true;
        }
        
            startingLineup.add(player);
    }
        else if(taxiSquad.size() < 8){
            
            moneyLeft.set((int) (moneyLeft.get()-Double.parseDouble(player.getSalary())));
            if(moneyLeft.get() > 0)
                taxiSquad.add(player);
            //else{messageDialog.}
        }
        else
            System.out.println("roster is full");
        //computeTotals();
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
        
        moneyLeft.set(moneyLeft.get()+Integer.parseInt(player.getSalary()));
        numPlayersNeeded.set(numPlayersNeeded.get()+1);       
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
                for(i=0; i<startingLineup.size()-1;i++){
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
           String teamString = name.get();
           return teamString;
       }
       
       public void setPositionsNeeded(ObservableList<String> positionsNeeded){
           this.positionsNeeded = positionsNeeded;
       }

    private void updatePositionsNeeded() {
        for(i =0; i < positionsNeeded.size();i++){
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
           for(i =0;i<playerOptions.length;i++){
               for(j =0;j<positionsNeeded.size();j++){
                   if(positionsNeeded.get(j).equalsIgnoreCase(playerOptions[i]))
                       viablePositions.add(playerOptions[i]);
               }
           }
           return viablePositions;
       }
    public ObservableList<String> getPositions(){
        return positions;
    }
        //public void setNumPlayersNeeded(int num){
        //    this.numPlayersNeeded = num;
        //}
    /*
        public IntegerProperty getnumPlayersNeeded(){
            return numPlayersNeeded;
        }
        public void setMoneyLeft(int num){
            this.moneyLeft.set(num);
        }*/
        public int getNumPlayersNeeded(){
            return numPlayersNeeded.get();
        }
        public int getMoneyLeft(){
            return moneyLeft.get();
        }
        //public IntegerProperty getMoneyLeft(){
        //    return moneyLeft;
        //}
        private int estimateCostPP(){
            if(numPlayersNeeded.get() == 0 || moneyLeft.get() == 0)
                return -1;
            else
                return moneyLeft.get()/numPlayersNeeded.get();
        }
        public int getCostPP(){
            
            return estimateCostPP();
        }
        public int getTotal_R(){
             total = 0;
             if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("hitter"))
                        total += startingLineup.get(i).getR_W();
            }
             }
            return total;
        }
        public int getTotal_HR(){
            total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("hitter"))
                    total += startingLineup.get(i).getHR_SV();
            }
            }
            return total;
        }
        public int getTotal_RBI(){
            total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("hitter"))
                    total += startingLineup.get(i).getRBI_K();
            }
            }
            return total;
        }
        public int getTotal_SB(){
            total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
               if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("hitter"))
                   total += Double.parseDouble(startingLineup.get(i).getSB_ERA());
            }
            }
            return total;
        }
        public double getTotal_BA(){
            double total = 0;
            if(startingLineup.size() != 0){
                for(i = 0; i < startingLineup.size();i++){
                    if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("hitter"))
                        total += startingLineup.get(i).getBA_WHIP();
                }
                if( total !=0 && numOfHitters() !=0)
                    return formatDouble(((double)total)/numOfHitters(),3);
            }
            return 0;
        }
        public int getTotal_W(){
            total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("pitcher"))
                    total += startingLineup.get(i).getR_W();
            }
            }
            return total;
        }
        public int getTotal_SV(){
            total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("pitcher"))
                    total += startingLineup.get(i).getHR_SV();
            }
            }
            return total;
        }
        public int getTotal_K(){
            total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("pitcher"))
                    total += startingLineup.get(i).getRBI_K();
            }
            }
            return total;
        }
        public double getTotal_ERA(){
            double total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("pitcher"))
                    total += Double.parseDouble(startingLineup.get(i).getSB_ERA());
            }
            if( total !=0 && numOfPitchers() !=0)
                return formatDouble(total / numOfPitchers(),2) ;
        }
          return 0;  
        }
        public double getTotal_WHIP(){
            double total = 0;
            if(startingLineup.size() != 0){
            for(i = 0; i < startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("pitcher"))
                    total+= startingLineup.get(i).getBA_WHIP();
            }
            if( total !=0 && numOfPitchers() !=0)
                return formatDouble(total/numOfPitchers(),2);
        }
            return 0;
        }
        public void computeTotals(){
            //moneyLeft.set(i);
            costPP.set(getCostPP());
           // numPlayersNeeded.set(this.getto);
            total_R.set(getTotal_R());
            total_HR.set(getTotal_HR());
            total_RBI.set(getTotal_RBI());
            total_SB.set(getTotal_SB());
            total_SV.set(getTotal_SV());
            total_K.set(getTotal_K());
            total_BA.set(formatDouble(getTotal_BA(),3));
            total_W.set(formatDouble(getTotal_W(),2));
            total_ERA.set(formatDouble(getTotal_ERA(),2));
            total_WHIP.set(formatDouble(getTotal_WHIP(),2));
            System.out.println(" format double should be working but it is: "+ formatDouble(getTotal_WHIP(),2));
        }
        private double formatDouble(double d,int num){
            //String broke = ""+d;
            if(num == 3){
                String fixing = String.format("%.3f", d);
            Double fixed = Double.parseDouble(fixing);
                return fixed;
            }
            else{
            String fixing = String.format("%.2f", d);
            Double fixed = Double.parseDouble(fixing);
                return fixed;
            }
            
        }
            
        
        private double numOfHitters(){
            double total = 0;
            for(i=0; i< startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("hitter"))
                    total+=1;
            }
            return total;
        }
        private double numOfPitchers(){
            double total = 0;
            for(i=0; i< startingLineup.size();i++){
                if(startingLineup.get(i).getPlayerType().equalsIgnoreCase("pitcher"))
                    total+=1;
            }
            return total;
        }
        public ObservableList<String> getEmptyList(){
            return emptyList;
        }
        public boolean getTaxiTime(){
            return taxiTime;
        }
        public int getHittersNeeded(){
            int totalNeeded = 0;
           totalNeeded+= (c_Needed +f_BaseNeeded +
            s_BaseNeeded + t_BaseNeeded + ci_Needed +
            mi_Needed + u_Needed +ss_Needed + of_Needed) ;
           return totalNeeded;
        }       
    }
    

