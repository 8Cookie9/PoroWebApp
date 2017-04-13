package com.porowebapp;

import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.Spark;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class App {
    public static void main( String[] args ) {
        if (System.getenv("PORT") != null) {
            port(Integer.valueOf(System.getenv("PORT")));
        }
        
        Spark.staticFileLocation("/templates");

        Spark.get("/", (req, res) -> {
            HashMap data = new HashMap<>();
            return new ModelAndView(data, "index");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/newporo/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(Integer.parseInt(req.params(":seed")),"newporo","$user");
            Poro poro = p.getPoro();
            
            data.put("command", "newporo "+poro.getCommand());
            data.put("text", "$user "+poro.getText());


            return new ModelAndView(data, "com_2");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/pastry/:pastry/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            data.put("command", items.pastryC(req.params(":pastry"), Integer.parseInt(req.params(":seed"))));
            data.put("text", items.pastryT(req.params(":pastry"), Integer.parseInt(req.params(":seed"))));

            return new ModelAndView(data, "com");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/tea/:tea/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            data.put("command", items.teaC(req.params(":tea"), Integer.parseInt(req.params(":seed"))));
            data.put("text", items.teaT(req.params(":tea"), Integer.parseInt(req.params(":seed"))));
            
            return new ModelAndView(data, "com");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/headgear/:headgear/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            data.put("command", items.getHeadgearC(req.params(":headgear"), Integer.parseInt(req.params(":seed"))));
            data.put("text", items.getHeadgearT(req.params(":headgear"), Integer.parseInt(req.params(":seed"))));

            return new ModelAndView(data, "com");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/misc/:misc/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            data.put("command", items.getMiscC(req.params(":misc"), Integer.parseInt(req.params(":seed"))));
            data.put("text", items.getMiscT(req.params(":misc"), Integer.parseInt(req.params(":seed"))));

            return new ModelAndView(data, "com");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/battle/command/:username/:targetname/:userlv/:targetlv/:randseedduel/:randseedsteal", (req, res) -> {
            HashMap data = new HashMap<>();
            Battle battle=new Battle(req.params(":username"),req.params(":targetname"),Integer.parseInt(req.params(":userlv")),Integer.parseInt(req.params(":targetlv")),Integer.parseInt(req.params(":randseedduel")),Integer.parseInt(req.params(":randseedsteal")));
            data.put("battle", battle);

            return new ModelAndView(data, "command");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/battle/text/:username/:targetname/:userlv/:targetlv/:randseedduel/:randseedsteal", (req, res) -> {
            HashMap data = new HashMap<>();
            Battle battle=new Battle(req.params(":username"),req.params(":targetname"),Integer.parseInt(req.params(":userlv")),Integer.parseInt(req.params(":targetlv")),Integer.parseInt(req.params(":randseedduel")),Integer.parseInt(req.params(":randseedsteal")));
            data.put("battle", battle);

            return new ModelAndView(data, "text");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/newporo/text/:username/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(Integer.parseInt(req.params(":seed")),"newporo",req.params(":username"));
            
            data.put("command", "newporo");
            data.put("poro", p.getPoro());
            data.put("username", req.params(":username"));


            return new ModelAndView(data, "PoroText");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/newporo/command/:username/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(Integer.parseInt(req.params(":seed")),"newporo",req.params(":username"));
            
            data.put("command", "newporo");
            data.put("poro", p.getPoro());
            data.put("username", req.params(":username"));

            return new ModelAndView(data, "PoroCommand");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/firstporo/text/:username/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(Integer.parseInt(req.params(":seed")),"firstporo",req.params(":username"));
            
            data.put("command", "firstporo");
            data.put("poro", p.getPoro());
            data.put("username", req.params(":username"));


            return new ModelAndView(data, "PoroText");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/firstporo/command/:username/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(Integer.parseInt(req.params(":seed")),"firstporo",req.params(":username"));
            
            data.put("command", "firstporo");
            data.put("poro", p.getPoro());
            data.put("username", req.params(":username"));

            return new ModelAndView(data, "PoroCommand");
        }, new ThymeleafTemplateEngine());
        
        
        Spark.get("/misc/command/:username/:misc/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.getMiscC(req.params(":misc"), Integer.parseInt(req.params(":seed")));
            data.put("command", items.getCom());
            data.put("username", req.params(":username"));

            return new ModelAndView(data, "headgearC");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/misc/text/:username/:misc/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.getMiscT(req.params(":misc"), Integer.parseInt(req.params(":seed")));
            data.put("text", items.getTxt());
            data.put("username", req.params(":username"));
            
            return new ModelAndView(data, "headgearT");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/headgear/command/:username/:head/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.getHeadgearC(req.params(":head"), Integer.parseInt(req.params(":seed")));
            data.put("command", items.getCom());
            data.put("username", req.params(":username"));

            return new ModelAndView(data, "headgearC");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/headgear/text/:username/:head/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.getHeadgearT(req.params(":head"), Integer.parseInt(req.params(":seed")));
            data.put("text", items.getTxt());
            data.put("username", req.params(":username"));
            
            return new ModelAndView(data, "headgearT");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/tea/command/:username/:tea/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.teaC(req.params(":tea"), Integer.parseInt(req.params(":seed")));
            data.put("command", items.getCom());
            data.put("username", req.params(":username"));

            return new ModelAndView(data, "headgearC");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/tea/text/:username/:tea/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.teaT(req.params(":tea"), Integer.parseInt(req.params(":seed")));
            data.put("text", items.getTxt());
            data.put("username", req.params(":username"));
            
            return new ModelAndView(data, "headgearT");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/pastry/command/:username/:pastry/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.pastryC(req.params(":pastry"), Integer.parseInt(req.params(":seed")));
            data.put("command", items.getCom());
            data.put("username", req.params(":username"));

            return new ModelAndView(data, "headgearC");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/pastry/text/:username/:pastry/:seed", (req, res) -> {
            HashMap data = new HashMap<>();
            Items items=new Items();
            items.pastryT(req.params(":pastry"), Integer.parseInt(req.params(":seed")));
            data.put("text", items.getTxt());
            data.put("username", req.params(":username"));
            
            return new ModelAndView(data, "headgearT");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/challenge/:username1/:username2/:poro1/:poro2/:hp1/:hp2/:atk1/:atk2/:def1/:def2/:randseed", (req, res) -> {
            HashMap data = new HashMap<>();
            Challenge challenge = new Challenge(req.params(":poro1"),req.params(":poro2"),req.params(":username1"),req.params(":username2"),Integer.parseInt(req.params(":hp1")),Integer.parseInt(req.params(":hp2")),Integer.parseInt(req.params(":atk1")),Integer.parseInt(req.params(":atk2")),Integer.parseInt(req.params(":def1")),Integer.parseInt(req.params(":def2")),Integer.parseInt(req.params(":randseed")));
            challenge.battle();
            
            data.put("text", challenge.getLog());
            return new ModelAndView(data, "challenge");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/challenge/text/:username1/:username2/:poro1/:poro2/:args1/:args2/:randseed", (req, res) -> {
            HashMap data = new HashMap<>();
            Challenge challenge = new Challenge(req.params(":args1"),req.params(":args2"),req.params(":poro1"),req.params(":poro2"),req.params(":username1"),req.params(":username2"),Integer.parseInt(req.params(":randseed")));
            challenge.battle();
            
            data.put("command", challenge.getText());
            return new ModelAndView(data, "comm");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/challenge/command/:username1/:username2/:poro1/:poro2/:args1/:args2/:randseed", (req, res) -> {
            HashMap data = new HashMap<>();
            Challenge challenge = new Challenge(req.params(":args1"),req.params(":args2"),req.params(":poro1"),req.params(":poro2"),req.params(":username1"),req.params(":username2"),Integer.parseInt(req.params(":randseed")));
            challenge.battle();
            
            data.put("command", challenge.getCommand());
            return new ModelAndView(data, "comm");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/porolist", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(0,"porolist","username");
            
            data.put("porolist", p.poroTable());


            return new ModelAndView(data, "porolist");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/poro/:id", (req, res) -> {
            HashMap data = new HashMap<>();
            PoroFactory p = new PoroFactory(0,"porolist","username");
            List<Poro> list=p.getAllPoros();
            Poro poro=p.getPoro();
            int id=999;
            try{
                id=Integer.parseInt(req.params(":id"));
            }catch(Exception e){}
            for(Poro po:list){
                if(po.getId()==id){
                    poro=po;
                    break;
                }
            }
            data.put("poro", poro);
            data.put("hp", poro.getHpModifier());
            data.put("atk", poro.getAttackModifier());
            data.put("def", poro.getDefenseModifier());
            return new ModelAndView(data, "poro");
        }, new ThymeleafTemplateEngine());
        
    }
}
