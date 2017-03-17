package com.porowebapp;

import java.util.Random;

public class Battle {
    private String username;
    private String targetname;
    private int userLv;
    private int targetLv;
    private int randSeedDuel;
    private int randSeedSteal;
    private String command;
    private String text;
    public Battle(String username, String targetname, int userLv, int targetLv, int randSeedDuel, int randSeedSteal){
        this.username=username;
        this.targetname=targetname;
        this.userLv=userLv;
        this.targetLv=targetLv;
        this.randSeedDuel=randSeedDuel;
        this.randSeedSteal=randSeedSteal;
        this.command=this.command();
        this.text=this.text();
    }
    
    private String[] battle(){
        Random r1=new Random((long) Math.pow(this.randSeedDuel,3));
        String[] res=new String[3];
        int i1=r1.nextInt(5);
        int i2=r1.nextInt(5);
        if(this.username.equals(this.targetname)){
            return new String[]{"practice","false"};
        }
        if(this.userLv+i1>this.targetLv+i2){
            res[0]=this.username+" "+this.targetname+" win";
        }else if(this.userLv+i1>this.targetLv+i2){
            res[0]=this.username+" "+this.targetname+" tie";
        }else{
            res[0]=this.username+" "+this.targetname+" lose";
        }
        if(this.randSeedSteal==99&&this.userLv+i1>this.targetLv+i2){
            res[1]="true";
        }else{
            res[1]="false";
        }
        res[2]=""+((this.userLv+i1)-(this.targetLv+i2));
        return res;
    }
    
    public String command(){
        String[] res=this.battle();
        return "battle "+res[0]+" "+res[1];
    }
    
    public String text(){
        String[] res=this.battle();
        if(this.username.equals(this.targetname)){
            return this.username+" didn't manage to find anyone to challenge, and ended up practicing alone gaining 3 exp for their weapon.";
        }
        String ret=this.username+" challenged "+this.targetname+". ";
        String winner="";
        String loser="";
        if(Integer.parseInt(res[2])==0){
            return ret+"Both of them appeared to be evenly matched. After a long battle, the result was a tie, rewarding "+this.username+" with 2 exp for their weapon.";
        }else if(Integer.parseInt(res[2])>0){
            winner=this.username;
            loser=this.targetname;
        }else{
            winner=this.targetname;
            loser=this.username;
        }
        if(Integer.parseInt(res[2])>10){
            ret+="From the very beginning one could see that "+loser+" was not even close to being "+winner+"'s match and the, and thus the result was unsurprisingly "+loser+"'s loss. ";
            ret+=winner+" gained 5 experience points for their weapon. ";
        }else if(Integer.parseInt(res[2])>4){
            ret+="After a short time, it became obvious that it was going to be an uphill battle for "+loser+". In the end, "+loser+"'s valiant efforts were for naught, and "+winner+" ended up getting a relatively easy win. ";
            ret+=winner+" gained 5 experience points for their weapon. ";
        }else if(Integer.parseInt(res[2])>0){
            ret+="The participants were nearly equally matched, but in the end, "+winner+" managed to gain the upper hand and grab the victory. ";
            ret+=winner+" gained 5 experience points for their weapon. ";
        }else if(Integer.parseInt(res[2])<-10){
            ret+="From the very beginning one could see that "+loser+" was not even close to being "+winner+"'s match and the, and thus the result was unsurprisingly "+loser+"'s loss. ";
            if(new Random().nextInt(3)==0){
                ret+="While walking away, "+loser+"could faintly hear "+winner+" mutter: 'what a scrub'. ";
            }
            ret+=winner+" gained 3 experience points for their weapon. ";
        }else if(Integer.parseInt(res[2])<-4){
            ret+="After a short time, it became obvious that it was going to be an uphill battle for "+loser+". In the end, "+loser+"'s valiant efforts were for naught, and "+winner+" ended up getting a relatively easy win. ";
            ret+=winner+" gained 3 experience points for their weapon. ";
        }else{
            ret+="The participants were nearly equally matched, but in the end, "+winner+" managed to gain the upper hand and grab the victory. ";
            ret+=winner+" gained 3 experience points for their weapon. ";
        }
        if(res[1].equals("true")){
            ret+=" "+this.username+" managed to steal one miscallaneous item from "+this.targetname;
        }
        return ret;
    }
    
    public String getCommand(){
        return this.command;
    }
    
    public String getText(){
        return this.text;
    }
}
