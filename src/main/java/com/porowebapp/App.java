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
        
        Spark.get("/command/:username/:targetname/:userlv/:targetlv/:randseedduel/:randseedsteal", (req, res) -> {
            HashMap data = new HashMap<>();
            Battle battle=new Battle(req.params(":username"),req.params(":targetname"),Integer.parseInt(req.params(":userlv")),Integer.parseInt(req.params(":targetlv")),Integer.parseInt(req.params(":randseedduel")),Integer.parseInt(req.params(":randseedsteal")));
            data.put("battle", battle);

            return new ModelAndView(data, "command");
        }, new ThymeleafTemplateEngine());
        
        Spark.get("/text/:username/:targetname/:userlv/:targetlv/:randseedduel/:randseedsteal", (req, res) -> {
            HashMap data = new HashMap<>();
            Battle battle=new Battle(req.params(":username"),req.params(":targetname"),Integer.parseInt(req.params(":userlv")),Integer.parseInt(req.params(":targetlv")),Integer.parseInt(req.params(":randseedduel")),Integer.parseInt(req.params(":randseedsteal")));
            data.put("battle", battle);

            return new ModelAndView(data, "text");
        }, new ThymeleafTemplateEngine());
    }
}
