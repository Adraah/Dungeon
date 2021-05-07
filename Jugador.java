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
public class Jugador {
    
    private int x=0;
    private int y=0;
    private int z=0;
    private int vida=8000;
    
    public void moverse(char opc)   //Movimiento del jugador segun la tecla seleccionada
    {
        switch(opc)
        {
            case 'a':
                this.x=this.x-1;
                break;
            case 's':
                this.y=this.y+1;
                break;
            case 'd':
                this.x=this.x+1;
                break;
            case 'w':
                this.y=this.y-1;
                break;
            case 'q':
                this.z=this.z-1;
                break;
            case 'e':
                this.z=this.z+1;
                break;
        }
    }
    
    public char moverAI(int X,int Y,String letras) {  //Funcion para el movimiento de una AI
        Random rd = new Random();
        char mov;
        switch (X) {  //Un switch para la posicion en X del jugador
            case 0:
                switch (Y) {  //Un switch para la posicion en Y del jugador
                    case 0:
                        letras = "sd";  //Se le dan los valores de las teclas que puede seleccionar dependiendo de su posicion
                        mov = letras.charAt(rd.nextInt(letras.length()));   //Selecciona una tecla al azar
                        break;
                    case 1:
                        letras = "wsd";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 2:
                        letras = "wsd";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 3:
                        letras = "wsd";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 4:
                        letras = "dw";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    default:
                        letras = "sdwa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                }
                break;
            case 1:
                switch (Y) {
                    case 0:
                        letras = "asd";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 1:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 2:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 3:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 4:
                        letras = "dwa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    default:
                        letras = "sadw";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                }
                break;
            case 2:
                switch (Y) {
                    case 0:
                        letras = "asd";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 1:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 2:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 3:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 4:
                        letras = "dwa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    default:
                        letras = "sadw";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                }
                break;
            case 3:
                switch (Y) {
                    case 0:
                        letras = "asd";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 1:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 2:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 3:
                        letras = "wsda";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 4:
                        letras = "dwa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    default:
                        letras = "sadw";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                }
                break;
            case 4:
                switch (Y) {
                    case 0:
                        letras = "as";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 1:
                        letras = "wsa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 2:
                        letras = "wsa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 3:
                        letras = "wsa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    case 4:
                        letras = "wa";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                    default:
                        letras = "sadw";
                        mov = letras.charAt(rd.nextInt(letras.length()));
                        break;
                }
                break;
            default:
                letras = "dsaw";
                mov = letras.charAt(rd.nextInt(letras.length()));
                break;
        }
        return mov;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
}
