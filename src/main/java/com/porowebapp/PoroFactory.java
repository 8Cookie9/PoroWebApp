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
        }else if(r<=4000){
            return 2;
        }else{
            return 1;
        }
    }
    
    public Poro getPoro(){
        Random r=new Random(this.randSeed);
        if(this.type.equals("firstporo")){
            if(this.username.toLowerCase().equals("racetogold")){
                return new Poro("Golden Poro",9,9,9,9,9,9,9,"special","src/main/resources/templates/Poros/porobase.png",999);
            }else if(this.username.toLowerCase().equals("sebbibastian")){
                return new Poro("Crocoro",8,8,8,5,9,9,9,"bald","src/main/resources/templates/Poros/porobase.png",999);
            }else if(this.username.toLowerCase().equals("c0ok13")){
                return new Poro("Poro with a Teemo hat",6,6,6,6,6,6,6,"toxic","src/main/resources/templates/Poros/porobase.png",999);
            }else if(this.username.toLowerCase().equals("hime_riri")){
                return new Poro("Tea addict Poro",10,10,10,10,10,10,10,"special","src/main/resources/templates/Poros/porobase.png",999);
            }else if(this.username.toLowerCase().equals("riripumpkin")){
                return new Poro("Tea addict Poro",10,10,10,10,10,10,10,"special","src/main/resources/templates/Poros/porobase.png",999);
            }else if(this.username.toLowerCase().equals("psychoshizu")){
                return new Poro("Psycho Poro",r.nextInt(11),r.nextInt(11),r.nextInt(11),3,3,8,5,"special","src/main/resources/templates/Poros/porobase.png",999);
            }
        }
        int rarity=this.randomRarity();
        Random random=new Random((long) Math.pow(this.randSeed, 2));
        List<String[]> porolist=this.poroes.get(rarity);
        if(porolist.isEmpty()){
            return new Poro("Regular Poro",r.nextInt(11),r.nextInt(11),r.nextInt(11),1,1,1,1,getRarity(rarity),"src/main/resources/templates/Poros/porobase.png",0);
        }
        String[] poroInfo=porolist.get(random.nextInt(porolist.size()));
        Poro poro=new Poro(poroInfo[0],r.nextInt(11),r.nextInt(11),r.nextInt(11),Integer.parseInt(poroInfo[3]),Integer.parseInt(poroInfo[4]),Integer.parseInt(poroInfo[5]),Integer.parseInt(poroInfo[2]),getRarity(rarity),poroInfo[6],Integer.parseInt(poroInfo[7]));
        return poro;
    }
    
    public String getRarity(int i){
        if(i==1){
            return "common";
        }else if(i==2){
            return "uncommon";
        }else if(i==3){
            return "rare";
        }else if(i==4){
            return "ultra rare";
        }else if(i==5){
            return "secret rare";
        }else{
            return "";
        }
    }
    
    public List<Poro> getAllPoros(){
        List<Poro> porolist = new ArrayList<>();
        GetData get = new GetData(this.filepath);
        for(String args:get.data()){
            String[] poroInfo=args.split(";");
            porolist.add(new Poro(poroInfo[0],0,0,0,Integer.parseInt(poroInfo[3]),Integer.parseInt(poroInfo[4]),Integer.parseInt(poroInfo[5]),Integer.parseInt(poroInfo[2]),poroInfo[1],poroInfo[6],Integer.parseInt(poroInfo[7])));
        }
        return porolist;
    }
    
    public List<List<Poro>> poroTable(){
        List<List<Poro>> porotable = new ArrayList<>();
        List<Poro> porolist = this.getAllPoros();
        int size = (int) Math.ceil(Math.sqrt(porolist.size()));
        for(int x=0;x<size;x++){
            List<Poro> list=new ArrayList<>();
            for(int y=0;y<size;y++){
                if(((x*y)+y)>=porolist.size()){
                    break;
                }
                list.add(porolist.get((x*y)+y));
            }
            porotable.add(list);
        }
        return porotable;
    }
}
