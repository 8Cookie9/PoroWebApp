package com.porowebapp;

import java.util.Random;

public class Items {
    private String headgear;
    private String misc;
    
    public Items(){
        this.headgear="src/main/resources/templates/headgear.txt";
        this.misc="src/main/resources/templates/misc.txt";
    }
    
    public String getMisc(String m, int randseed){
        String[] miscellaneous=m.split(";");
                String result="misc "+miscellaneous[1];
        if(Integer.parseInt(miscellaneous[0])==1){
            result+=" "+1;
        }else if(Integer.parseInt(miscellaneous[0])==2){
            result+=" "+2;
        }if(Integer.parseInt(miscellaneous[0])==3){
            result+=" "+(new Random(randseed).nextInt(2)+3);
        }else{
            result+=" "+(new Random(randseed).nextInt(2)+5);
        }
        return result;
    }
}
