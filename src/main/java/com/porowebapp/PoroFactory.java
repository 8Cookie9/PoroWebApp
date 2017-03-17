package com.porowebapp;

import com.datahandling.GetData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PoroFactory {
    private final String filepath="C:/Users/Jaakko/Documents/NetBeansProjects/PoroWebApp/src/main/resources/templates/poro.txt";
    private HashMap<Integer, List<String[]>> poroes;
    private int randSeed;
    
    public PoroFactory(int randSeed){
        this.poroes=new HashMap<>();
        this.getPoroes();
        this.randSeed=randSeed;
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
        int rarity=this.randomRarity();
        Random random=new Random(this.randSeed);
        List<String[]> porolist=this.poroes.get(rarity);
        Random r=new Random(this.randSeed);
        if(porolist.isEmpty()){
            return new Poro("Regular Poro",r.nextInt(11),r.nextInt(11),r.nextInt(11),1,1,1,1);
        }
        String[] poroInfo=porolist.get(random.nextInt(porolist.size()));
        Poro poro=new Poro(poroInfo[0],r.nextInt(11),r.nextInt(11),r.nextInt(11),Integer.parseInt(poroInfo[3]),Integer.parseInt(poroInfo[4]),Integer.parseInt(poroInfo[5]),Integer.parseInt(poroInfo[2]));
        return poro;
    }
}
