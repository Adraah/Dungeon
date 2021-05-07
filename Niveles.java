/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dungeon;


/**
 *
 * @author TecMilenio
 */
public class Niveles {
    private int id;
    private String name;
    private int numball=7;
    private int numwall;
    private int numenemy;
    private int numbean;
    
    public static Niveles levels[]={
        new Niveles(1,"pokimane",3,2,1),
        new Niveles(2, "destiny",5,7,3),
        new Niveles(3,"loltylerone",10,15,6),
        new Niveles(4,"xqc",15,20,8),
        new Niveles(5,"alexelcapo",25,30,10),
        new Niveles(6,"imaqtipie",35,37,12),
        new Niveles(7,"scarra",42,45,15),
        new Niveles(8,"shroud",50,53,20),
        new Niveles(9,"asmongold",57,60,22),
        new Niveles(10,"papipone",65,70,30),
    };

    public Niveles(int id, String name, int numwall, int numenemy, int numbean) {
        this.id = id;
        this.name = name;
        this.numwall = numwall;
        this.numenemy = numenemy;
        this.numbean = numbean;
    }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumball() {
        return numball;
    }

    public void setNumball(int numball) {
        this.numball = numball;
    }

    public int getNumwall() {
        return numwall;
    }

    public void setNumwall(int numwall) {
        this.numwall = numwall;
    }

    public int getNumenemy() {
        return numenemy;
    }

    public void setNumenemy(int numenemy) {
        this.numenemy = numenemy;
    }

    public int getNumbean() {
        return numbean;
    }

    public void setNumbean(int numbean) {
        this.numbean = numbean;
    }
    
}
