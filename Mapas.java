/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dungeon;
import java.util.Random;

/**
 *
 * @author TecMilenio
 */
public class Mapas {
    
    String mapa[][][] = new String[5][5][10];
    String mapa2[][][] = new String[5][5][10];
    String mapa3[][][] = new String[5][5][10];
    Random  rnd = new Random();
    
    public void crearMapa(int x) //Crea el mapa interno del juego
    {
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<5;j++)
            {
                for(int k=0;k<5;k++)
                {
                    mapa[j][k][i]="[ ]";
                    mapa3[j][k][i]="[ ]";
                }
            }
        }
        mapa[0][0][0]="[P]";
    }
    public void crearMapa2(int x)  //Crea el mapa visible del juego
    {
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<5;j++)
            {
                for(int k=0;k<5;k++)
                {
                    mapa2[j][k][i]="[*]";  //Cuadro desconocido del mapa
                }
            }
        }
        mapa2[0][0][0]="[P]";
    }
    public void actualizarMapa(int x,int y, int z,int x1,int y1, int z1)  //Actualiza la posicion en el mapa del jugador
    {
        mapa[x1][y1][z1]="[ ]";
        mapa2[x1][y1][z1]="[ ]";
        mapa[x][y][z]="[P]";
        mapa2[x][y][z]="[P]";
    }
    public void showMapa(int z)   //Imprime el mapa visible
    {
        for(int j=0;j<5;j++)
        {
            for(int k=0;k<5;k++)
            {
                System.out.print(mapa2[j][k][z]); 
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public void crearEnemigo(int b) //Crea un enemigo
    {
        int x;
        int y;
        int z;
        do
        {
            x=rnd.nextInt(5);
            y=rnd.nextInt(5);
            z=rnd.nextInt(b);
        }while(!"[ ]".equals(mapa[x][y][z]));  //Si el lugar seleccionado no esta vacio se selecciona otra lugar
        mapa[x][y][z]="[X]";
    }
    public void crearEsferas(int b)
    {
        int x;
        int y;
        int z;
        do
        {
            x=rnd.nextInt(5);
            y=rnd.nextInt(5);
            z=rnd.nextInt(b);
        }while(!"[ ]".equals(mapa[x][y][z]));
        mapa[x][y][z]="[@]";
        mapa3[x][y][z]="[@]";
    }
    public void crearMuros(int b)
    {
        int x;
        int y;
        int z;
        do
        {
            x=rnd.nextInt(5);
            y=rnd.nextInt(5);
            z=rnd.nextInt(b);
        }while(!"[ ]".equals(mapa[x][y][z]));
        mapa[x][y][z]="[-]";
    }
    public void crearSemillas(int b)
    {
        int x;
        int y;
        int z;
        do
        {
            x=rnd.nextInt(5);
            y=rnd.nextInt(5);
            z=rnd.nextInt(b);
        }while(!"[ ]".equals(mapa[x][y][z]));
        mapa[x][y][z]="[+]";
    }
}
