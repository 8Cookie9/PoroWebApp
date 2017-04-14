package com.porowebapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Challenge {
    
    private int hp1;
    private int hp2;
    private int curhp1;
    private int curhp2;
    private int atk1;
    private int atk2;
    private int def1;
    private int def2;
    private String poro1;
    private String poro2;
    private String user1;
    private String user2;
    private Random random;
    private int randseed;
    private List<String> log;
    private int curturn;
    private String command;
    private String text;
    public Challenge(String args1, String args2, String poro1, String poro2, String user1, String user2, int randseed){
        args1=args1.substring(1, args1.length()-1);
        args2=args2.substring(1, args2.length()-1);
        hp1=Integer.parseInt(args1.split(", ")[0]);
        atk1=Integer.parseInt(args1.split(", ")[1]);
        def1=Integer.parseInt(args1.split(", ")[2]);
        hp2=Integer.parseInt(args2.split(", ")[0]);
        atk2=Integer.parseInt(args2.split(", ")[1]);
        def2=Integer.parseInt(args2.split(", ")[2]);
        this.random=new Random((long) Math.pow(randseed, 3));
        this.curhp1=this.hp1;
        this.curhp2=this.hp2;
        this.log=new ArrayList<>();
        this.curturn=this.random.nextInt(2);
        this.command="";
        this.user1=user1;
        this.user2=user2;
        this.poro1=poro1;
        this.poro2=poro2;
        this.randseed=randseed;
    }
    
    public Challenge(String poro1, String poro2, String user1, String user2, int hp1, int hp2, int atk1, int atk2, int def1, int def2, int randseed){
        this.hp1=hp1;
        this.atk1=atk1;
        this.def1=def1;
        this.hp2=hp2;
        this.atk2=atk2;
        this.def2=def2;
        this.random=new Random((long) Math.pow(randseed, 3));
        this.curhp1=this.hp1;
        this.curhp2=this.hp2;
        this.log=new ArrayList<>();
        this.curturn=this.random.nextInt(2);
        this.command="";
        this.user1=user1;
        this.user2=user2;
        this.poro1=poro1;
        this.poro2=poro2;
        this.randseed=randseed;
    }
    
    private void attack(){
        if(this.curturn==0){
            int attack=(int) (5.0 * (this.random.nextGaussian() / 4 + 1));
            attack=(int) (((double) attack)*((20.0+(double) atk1)/20.0));
            int luck=this.random.nextInt(100);
            double atkmod=20.0/(20.0+(double) def2);
            if(luck<10){
                this.log.add(this.poro1+"["+this.user1+"] missed.");
                this.log.add(this.poro1+"["+this.user1+"] ("+this.curhp1+"/"+this.hp1+") | "+this.poro2+"["+this.user2+"] ("+this.curhp2+"/"+this.hp2+")");
            }else if(luck>=90){
                attack*=2;
                attack=(int) (((double) attack)*atkmod);
                this.curhp2=Math.max(0,this.curhp2-attack);
                this.log.add(this.poro1+"["+this.user1+"] managed to land a critical strike dealing "+attack+" damage. ");
                this.log.add(this.poro1+"["+this.user1+"] ("+this.curhp1+"/"+this.hp1+") | "+this.poro2+"["+this.user2+"] ("+this.curhp2+"/"+this.hp2+")");
            }else{
                attack=(int) (((double) attack)*atkmod);
                this.curhp2=Math.max(0,this.curhp2-attack);
                this.log.add(this.poro1+"["+this.user1+"] attacked dealing "+attack+" damage.");
                this.log.add(this.poro1+"["+this.user1+"] ("+this.curhp1+"/"+this.hp1+") | "+this.poro2+"["+this.user2+"] ("+this.curhp2+"/"+this.hp2+")");
            }
            this.curturn=1;
        }else{
            double atkmod=20.0/(20.0+(double) def1);
            int attack=(int) (5.0 * (this.random.nextGaussian() / 4 + 1));
            attack=(int) (((double) attack)*((20.0+(double) atk2)/20.0));
            int luck=this.random.nextInt(100);
            if(luck<10){
                this.log.add(this.poro2+"["+this.user2+"] missed.");
                this.log.add(this.poro1+"["+this.user1+"] ("+this.curhp1+"/"+this.hp1+") | "+this.poro2+"["+this.user2+"] ("+this.curhp2+"/"+this.hp2+")");
            }else if(luck>=90){
                attack*=2;
                attack=(int) (((double) attack)*atkmod);
                this.curhp1=Math.max(0,this.curhp1-attack);
                this.log.add(this.poro2+"["+this.user2+"] managed to land a critical strike dealing "+attack+" damage.");
                this.log.add(this.poro1+"["+this.user1+"] ("+this.curhp1+"/"+this.hp1+") | "+this.poro2+"["+this.user2+"] ("+this.curhp2+"/"+this.hp2+")");
            }else{
                attack=(int) (((double) attack)*atkmod);
                this.curhp1=Math.max(0,this.curhp1-attack);
                this.log.add(this.poro2+"["+this.user2+"] attacked dealing "+attack+" damage.");
                this.log.add(this.poro1+"["+this.user1+"] ("+this.curhp1+"/"+this.hp1+") | "+this.poro2+"["+this.user2+"] ("+this.curhp2+"/"+this.hp2+")");
            }
            this.curturn=0;
        }
    }
    
    public void battle(){
        if(this.user1.equals(this.user2)){
            this.command=this.user1+" practice";
            this.text="You didn't find anone to challenge, but practicing hard gained 3 exp for your equipment.";
        }else{
            while(this.curhp1!=0&&this.curhp2!=0){
                this.attack();
                this.def1=Math.max(0, this.def1-1);
                this.def2=Math.max(0, this.def2-1);
            }
            if(this.curhp1==0){
                this.log.add(this.poro2+"["+this.user2+"] won the challenge.");
                this.command=this.user1+" battle "+this.user2+" lose";
                String p1=this.poro1.replaceAll(" ", "%20");
                String p2=this.poro2.replaceAll(" ", "%20");
                this.text=this.user1+" challenged "+this.user2+". "+this.user2+" won the challenge gaining 3 exp for their equipment. http://porostuff.herokuapp.com/challenge/"+this.user1+"/"+this.user2+"/"+p1+"/"+p2+"/"+this.hp1+"/"+this.hp2+"/"+this.atk1+"/"+this.atk2+"/"+this.def1+"/"+this.def2+"/"+this.randseed;
            }else{
                this.log.add(this.poro1+"["+this.user1+"] won the challenge.");
                this.command=this.user1+" battle "+this.user2+" win";
                String p1=this.poro1.replaceAll(" ", "%20");
                String p2=this.poro2.replaceAll(" ", "%20");
                this.text=this.user1+" challenged "+this.user2+". "+this.user1+" won the challenge gaining 5 exp for their equipment. http://porostuff.herokuapp.com/challenge/"+this.user1+"/"+this.user2+"/"+p1+"/"+p2+"/"+this.hp1+"/"+this.hp2+"/"+this.atk1+"/"+this.atk2+"/"+this.def1+"/"+this.def2+"/"+this.randseed;
            }
        }
    }
    
    public List<String> getLog(){
        return this.log;
    }
    
    public String getCommand(){
        return this.command;
    }
    
    public String getText(){
        return this.text;
    }
}
