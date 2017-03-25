package com.porowebapp;

import java.util.HashMap;
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
    }
}
