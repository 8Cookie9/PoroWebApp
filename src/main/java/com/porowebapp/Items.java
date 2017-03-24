package com.porowebapp;

import java.util.Random;

public class Items {
    private String miscCom;
    private String miscTxt;
    private String headCom;
    private String headTxt;
    
    public Items(){
    }
    
    public void getMiscC(String m, int randseed){
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
        this.miscCom=result;
    }
    
    public void getMiscT(String m, int randseed){
        String[] miscellaneous=m.split(";");
                String result=" received "+miscellaneous[1];
        if(Integer.parseInt(miscellaneous[0])==1){
            result+=" (+"+1+" hp).";
        }else if(Integer.parseInt(miscellaneous[0])==2){
            result+=" (+"+2+" hp).";
     
       }if(Integer.parseInt(miscellaneous[0])==3){
            result+=" (+"+(new Random(randseed).nextInt(2)+3)+" hp).";
        }else{
            result+=" (+"+(new Random(randseed).nextInt(2)+5)+" hp).";
        }
        this.miscTxt=result;
    }
    
    public void getHeadgearC(String h, int randseed){
        String[] miscellaneous=h.split(";");
                String result="headgear "+miscellaneous[1];
        if(Integer.parseInt(miscellaneous[0])==1){
            result+=" "+1;
        }else if(Integer.parseInt(miscellaneous[0])==2){
            result+=" "+2;
        }if(Integer.parseInt(miscellaneous[0])==3){
            result+=" "+(new Random(randseed).nextInt(2)+3);
        }else{
            result+=" "+(new Random(randseed).nextInt(2)+5);
        }
        this.headCom=result;
    }
    
    public void getHeadgearT(String h, int randseed){
        String[] miscellaneous=h.split(";");
                String result=" received "+miscellaneous[1];
        if(Integer.parseInt(miscellaneous[0])==1){
            result+=" (+"+1+" defense).";
        }else if(Integer.parseInt(miscellaneous[0])==2){
            result+=" (+"+2+" defense).";
     
       }if(Integer.parseInt(miscellaneous[0])==3){
            result+=" (+"+(new Random(randseed).nextInt(2)+3)+" defense).";
        }else{
            result+=" (+"+(new Random(randseed).nextInt(2)+5)+" defense).";
        }
        this.miscTxt=result;
    }

    public String getMiscCom() {
        return miscCom;
    }

    public String getMiscTxt() {
        return miscTxt;
    }

    public String getHeadCom() {
        return headCom;
    }

    public String getHeadTxt() {
        return headTxt;
    }
    
    
}
