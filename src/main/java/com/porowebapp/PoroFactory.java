package com.porowebapp;

import com.datahandling.GetData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PoroFactory {
    private final String filepath="src/main/resources/templates/poro.txt";
    private HashMap<Integer, List<String[]>> poroes;
    private int randSeed;
    private String type;
    private String username;
    
    public PoroFactory(int randSeed, String type, String username){
        this.poroes=new HashMap<>();
        this.getPoroes();
        this.randSeed=randSeed;
        this.type=type;
        this.username=username;
    }
    
    private void getPoroes(){
        GetData get=new GetData(this.filepath);
        for(String s:get.data()){
            String args[]=s.split(";");
            int rarity=Integer.parseInt(args[1]);
            if(!this.poroes.containsKey(rarity)){
                this.poroes.put(rarity, new ArrayList<>());
            }
            this.poroes.get(rarity).add(args);
        }
    }
    
    public int randomRarity(){
        int r=this.randSeed;
        if(r<=10){
            return 5;
        }else if(r<=100){
            return 4;
        }else if(r<=1000){
            return 3;
        }else if(r<=5000){
            return 2;
        }else{
            return 1;
        }
    }
    
    public Poro getPoro(){
        Random r=new Random(this.randSeed);
        if(this.type.equals("firstporo")){
            if(this.username.toLowerCase().equals("racetogold")){
                return new Poro("Golden Poro",9,9,9,9,9,9,9,"special");
            }else if(this.username.toLowerCase().equals("sebbibastian")){
                return new Poro("Crocoro",8,8,8,5,9,9,9,"special");
            }else if(this.username.toLowerCase().equals("c0ok13")){
                return new Poro("Poro with a Teemo hat",6,6,6,6,6,6,6,"special");
            }else if(this.username.toLowerCase().equals("hime_riri")){
                return new Poro("Tea addict Poro",10,10,10,10,10,10,10,"special");
            }else if(this.username.toLowerCase().equals("psychoshizu")){
                return new Poro("Psycho Poro",r.nextInt(11),r.nextInt(11),r.nextInt(11),3,3,8,5,"special");
            }
        }
        int rarity=this.randomRarity();
        Random random=new Random((long) Math.pow(this.randSeed, 2));
        List<String[]> porolist=this.poroes.get(rarity);
        if(porolist.isEmpty()){
            return new Poro("Regular Poro",r.nextInt(11),r.nextInt(11),r.nextInt(11),1,1,1,1,getRarity(rarity));
        }
        String[] poroInfo=porolist.get(random.nextInt(porolist.size()));
        Poro poro=new Poro(poroInfo[0],r.nextInt(11),r.nextInt(11),r.nextInt(11),Integer.parseInt(poroInfo[3]),Integer.parseInt(poroInfo[4]),Integer.parseInt(poroInfo[5]),Integer.parseInt(poroInfo[2]),getRarity(rarity));
        return poro;
    }
    
    public String getRarity(int i){
        if(i==1){
            return "very common";
        }else if(i==2){
            return "common";
        }else if(i==3){
            return "uncommon";
        }else if(i==4){
            return "rare";
        }else if(i==5){
            return "ultra rare";
        }else{
            return "";
        }
    }
}
