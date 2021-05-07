 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dungeon;
import java.util.Scanner;
/**
 *
 * @author TecMilenio
 */
public class Dungeon {

    public static Niveles currentlevel = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        Jugador player = new Jugador();
        int l = 0; //Contador de nivel
        Mapas map = new Mapas();
        char mov;
        System.out.println("1. AI");
        System.out.println("2. Player");
        int opc = in.nextInt();
        do {
            currentlevel = Niveles.levels[l]; //Asigna el nivel segun el contador
            player.setX(0); //Le da las posiciones de 0,0,0 al player
            player.setY(0);
            player.setZ(0);
            int esfera=0;
            map.crearMapa(currentlevel.getId());
            map.crearMapa2(currentlevel.getId());
            //Crea los mapas y sus contenidos
            for (int i = 0; i < currentlevel.getNumenemy(); i++) {
                map.crearEnemigo(currentlevel.getId());
            }
            for (int i = 0; i < currentlevel.getNumball(); i++) {
                map.crearEsferas(currentlevel.getId());
            }
            for (int i = 0; i < currentlevel.getNumwall(); i++) {
                map.crearMuros(currentlevel.getId());
            }
            for (int i = 0; i < currentlevel.getNumbean(); i++) {
                map.crearSemillas(currentlevel.getId());
            }
            do {
                System.out.println("Mundo:" + currentlevel.getName());  //Imprime el nivel en que estas
                System.out.println("Piso:" + (player.getZ() + 1));        //Imprime el piso
                System.out.println("Numero de bolas restantes:" + currentlevel.getNumball()); //Imprime el numero de bolas restantes
                System.out.println("Ki:" + player.getVida());         //Imprime el ki
                map.showMapa(player.getZ());        //Se imprime el mapa segun el piso en el que se encuentra el jugador
                int x = player.getX(), y = player.getY(), z = player.getZ(); //Se guarda la posicion en donde se encuentra el jugador
                if (opc == 2) { //Se revisa la opcion seleccionada y se decide como se va a obtener el movimiento
                    System.out.print("Movimiento:");
                    mov = in.next().charAt(0);   //Lee del teclado la tecla del movimiento
                } else {
                    for (int j = 0; j <= 4; j++) {
                        for (int k = 0; k <= 4; k++) {
                            if ("[@]".equals(map.mapa3[j][k][player.getZ()])) {
                                esfera++;
                            }
                        }
                    }
                    if (esfera != 0) {
                        String abc = "";  //Se inicializa la variable de las teclas
                        mov = player.moverAI(player.getX(), player.getY(), abc);  //Movimiento de AI
                        esfera=0;
                    } else {
                        mov = 'e';
                        esfera=0;
                    }
                }  
                switch (mov) //Movimiento del jugador dependiendo de la tecla seleccionada
                {
                    case 'a': //Se mueve a la izquierda
                        switch (map.mapa[y][x - 1][z]) {
                            case "[@]": //Si se encuentra una esfera se resta una
                                currentlevel.setNumball(currentlevel.getNumball() - 1);
                                player.moverse(mov); //Se mueve el jugador
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z); //Actualiza el mapa con las posiciones actuales
                                break;
                            case "[X]": //Si se encuentra un enemigo el jugador pierde vida
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() - 750);
                                break;
                            case "[+]": //Si se encuentra un healthpack el jugador recupera vida
                                player.setVida(player.getVida() + 1000);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[-]": //Si se encuentra un muro el jugador pierde vida y no avanza
                                player.setVida(player.getVida() - 250);
                                map.mapa2[y][x - 1][z] = "[-]";
                                break;
                            default:
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                        }
                        break;
                    case 's': //Se mueve para abajo
                        switch (map.mapa[y + 1][x][z]) {
                            case "[@]":
                                currentlevel.setNumball(currentlevel.getNumball() - 1);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[X]":
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() - 750);
                                break;
                            case "[+]":
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() + 1000);
                                break;
                            case "[-]":
                                player.setVida(player.getVida() - 250);
                                map.mapa2[y + 1][x][z] = "[-]";
                                break;
                            default:
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                        }
                        break;
                    case 'd': //Se mueve a la derecha
                        switch (map.mapa[y][x + 1][z]) {
                            case "[@]":
                                currentlevel.setNumball(currentlevel.getNumball() - 1);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[X]":
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() - 750);
                                break;
                            case "[+]":
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() + 1000);
                                break;
                            case "[-]":
                                player.setVida(player.getVida() - 250);
                                map.mapa2[y][x + 1][z] = "[-]";
                                break;
                            default:
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                        }
                        break;
                    case 'w': //Se mueve para arriba
                        switch (map.mapa[y - 1][x][z]) {
                            case "[@]":
                                currentlevel.setNumball(currentlevel.getNumball() - 1);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[X]":
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() - 750);
                                break;
                            case "[+]":
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                player.setVida(player.getVida() + 1000);
                                break;
                            case "[-]":
                                player.setVida(player.getVida() - 250);
                                map.mapa2[y - 1][x][z] = "[-]";
                                break;
                            default:
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                        }
                        break;
                    case 'q': //Se mueve al piso anterior
                        switch (map.mapa[y][x][z - 1]) {
                            case "[@]":
                                currentlevel.setNumball(currentlevel.getNumball() - 1);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[X]":
                                player.setVida(player.getVida() - 750);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[+]":
                                player.setVida(player.getVida() + 1000);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[-]":
                                player.setVida(player.getVida() - 250);
                                map.mapa2[y][x][z - 1] = "[-]";
                                break;
                            default:
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                        }
                        break;
                    case 'e': //Se mueve al piso siguiente
                        switch (map.mapa[y][x][z + 1]) {
                            case "[@]":
                                currentlevel.setNumball(currentlevel.getNumball() - 1);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[X]":
                                player.setVida(player.getVida() - 750);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[+]":
                                player.setVida(player.getVida() + 1000);
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                            case "[-]":
                                player.setVida(player.getVida() - 250);
                                map.mapa2[y][x][z + 1] = "[-]";
                                break;
                            default:
                                player.moverse(mov);
                                map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                                break;
                        }
                        break;
                    default:
                        player.moverse(mov);
                        map.actualizarMapa(player.getY(), player.getX(), player.getZ(), y, x, z);
                        break;
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                if(opc==1){
                  Thread.sleep(100);  //Se alenta el programa para verse mejor si se elige como AI
                }         
            } while (currentlevel.getNumball() >= 1 && player.getVida() > 0); //Mientras aun hayan pelotas y que la vida del jugador no sea cero se sigue jugando el mismo nivel
            l++; //Se aumenta un nivel cuando se recolectan las esferas
        } while (player.getVida() > 0); //Si el player ya no tiene vida el juego se termina
        System.out.println("Has muerto :("); //Mensaje de decepcion
    }
}