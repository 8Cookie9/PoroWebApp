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
        String[] res=new String[2];
        int i1=r1.nextInt(5);
        int i2=r1.nextInt(5);
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
        return res;
    }
    
    public String command(){
        String[] res=this.battle();
        return "battle "+res[0]+" "+res[1];
    }
    
    public String text(){
        String[] res=this.battle();
        String ret=this.username+" fought bravely with "+this.targetname+". After a long time the battle concluded as a ";
        if(res[0].contains("win")){
            ret+=this.username+"'s win, rewarding "+this.username+" with 5 exp for their weapon.";
        }else if(res[0].contains("tie")){
            ret+="tie, rewarding "+this.username+" with 2 exp for their weapon.";
        }else{
            ret+=this.targetname+"'s win, rewarding "+this.targetname+" with 3 exp for their weapon.";
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
