package com.porowebapp;

import java.util.Random;

public class Items {

    private String miscCom;
    private String miscTxt;
    private String headCom;
    private String headTxt;

    public Items() {
    }

    public void getMiscC(String m, int randseed) {
        String[] miscellaneous = m.split("-");
        String result = "misc " + miscellaneous[1];
        if (Integer.parseInt(miscellaneous[0]) == 1) {
            result += " " + 1;
        } else if (Integer.parseInt(miscellaneous[0]) == 2) {
            result += " " + 2;
        } else if (Integer.parseInt(miscellaneous[0]) == 3) {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 3);
        } else {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 5);
        }
        this.miscCom = result;
    }

    public void getMiscT(String m, int randseed) {
        String[] miscellaneous = m.split("-");
        String result = " received " + miscellaneous[1];
        if (Integer.parseInt(miscellaneous[0]) == 1) {
            result += " (+" + 1 + " hp).";
        } else if (Integer.parseInt(miscellaneous[0]) == 2) {
            result += " (+" + 2 + " hp).";

        } else if (Integer.parseInt(miscellaneous[0]) == 3) {
            result += " (+" + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 3) + " hp).";
        } else {
            result += " (+" + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 5) + " hp).";
        }
        this.miscTxt = result;
    }

    public void getHeadgearC(String h, int randseed) {
        String[] miscellaneous = h.split("-");
        for (int i = 0; i < miscellaneous.length; i++) {
            System.out.println(miscellaneous[i]);
        }
        String result = "headgear " + miscellaneous[1];
        if (Integer.parseInt(miscellaneous[0]) == 1) {
            result += " " + 1;
        } else if (Integer.parseInt(miscellaneous[0]) == 2) {
            result += " " + 2;
        } else if (Integer.parseInt(miscellaneous[0]) == 3) {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 3);
        } else {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 5);
        }
        this.headCom = result;
    }

    public void getHeadgearT(String h, int randseed) {
        String[] miscellaneous = h.split("-");
        String result = " received " + miscellaneous[1];
        if (Integer.parseInt(miscellaneous[0]) == 1) {
            result += " (+" + 1 + " defense).";
        } else if (Integer.parseInt(miscellaneous[0]) == 2) {
            result += " (+" + 2 + " defense).";

        } else if (Integer.parseInt(miscellaneous[0]) == 3) {
            result += " (+" + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 3) + " defense).";
        } else {
            result += " (+" + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 5) + " defense).";
        }
        this.headTxt = result;
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
    
    public void teaC(String h, int randseed) {
        String[] tea = h.split("-");
        for (int i = 0; i < tea.length; i++) {
            System.out.println(tea[i]);
        }
        String result = "tea " + tea[1];
        if (Integer.parseInt(tea[0]) == 1) {
            result += " " + 1;
        } else if (Integer.parseInt(tea[0]) == 2) {
            result += " " + 2;
        } else if (Integer.parseInt(tea[0]) == 3) {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 3);
        } else {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 5);
        }
        this.headCom = result;
    }
    
    public String teaT(String h, int randseed) {
        String[] miscellaneous = h.split("-");
        String result = "'s Poro received " + miscellaneous[1] + " and ";
        if (Integer.parseInt(miscellaneous[0]) == 1) {
            result += "its friendship grew by " + 1 + ".";
        } else if (Integer.parseInt(miscellaneous[0]) == 2) {
            result += "its friendship grew by " + 2 + ".";

        } else if (Integer.parseInt(miscellaneous[0]) == 3) {
            result += "its friendship grew by " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 3) + ".";
        } else {
            result += "its friendship grew by " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 5) + ".";
        }
        return result;
    }
    
    public void pastryC(String h, int randseed) {
        String[] tea = h.split("-");
        for (int i = 0; i < tea.length; i++) {
            System.out.println(tea[i]);
        }
        String result = "tea " + tea[1];
        if (Integer.parseInt(tea[0]) == 1) {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 2);
        } else if (Integer.parseInt(tea[0]) == 2) {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 4);
        } else if (Integer.parseInt(tea[0]) == 3) {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 6);
        } else {
            result += " " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 8);
        }
        this.headCom = result;
    }
    
    public String pastryT(String h, int randseed) {
        String[] miscellaneous = h.split("-");
        String result = "'s Poro received " + miscellaneous[1] + " and ";
        if (Integer.parseInt(miscellaneous[0]) == 1) {
            result += "its friendship grew by " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 2) + ".";
        } else if (Integer.parseInt(miscellaneous[0]) == 2) {
            result += "its friendship grew by " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 4) + ".";

        } else if (Integer.parseInt(miscellaneous[0]) == 3) {
            result += "its friendship grew by " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 6) + ".";
        } else {
            result += "its friendship grew by " + (new Random((long) Math.pow(randseed,3)).nextInt(2) + 8) + ".";
        }
        return result;
    }
}
