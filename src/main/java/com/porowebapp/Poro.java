package com.porowebapp;

public class Poro extends Level{
    private final String type;
    private String command;
    private String text;
    private String img;
    private int id;
    public Poro(String type, int hp, int atk, int def, int hpmod, int defmod, int atkmod, int levelgain, String rarity, String img, int id){
        super(hp,def,atk,hpmod,defmod,atkmod,levelgain);
        this.type=type;
        this.command=":"+this.type+":;"+super.getHpIV()+";"+super.getAttackIV()+";"+super.getDefenseIV()+";"+super.getHpModifier()+";"+super.getAttackModifier()+";"+super.getDefenseModifier()+";"+levelgain;
        this.text=" has received "+this.type+" ("+rarity+").";
        this.img=img;
        this.id=id;
    }

    public String getImg() {
        return img;
    }

    public int getId() {
        return id;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void gainExp(int exp){        super.addExp(exp);

    }
    
    public String getCommand(){
        return this.command;
    }
    
    public String getText(){
        return this.text;
    }
}
