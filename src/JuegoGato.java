/*
Copyright (C) <29/11/2014r>  <Nicolas Lemus Plascencia "Niox">

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package bin;
import java.util.Scanner;

public class JuegoGato {
	

static char gato[][] = {{'-','-','-'}
						, {'-','-','-'}
						, {'-','-','-'}
						};

static int turno = 0, ronda = 0;


	public static void main(String args[])
	{
		int ganador;
		String posicion;
		char win[] = {'X','O'};
		char _posicion;
		boolean nueva_partida = false;
		Scanner leer = new Scanner(System.in);

		do{
		inicio();
			while (true)
			{
				ganador = ganador();
				
				if(ganador==1 || ganador == 2)
				{
					limpiarPantalla();
					System.out.println("\nEl ganador es el jugador "+ganador+" ---- "+win[ganador-1]);
					break;
				}
				else if(ronda == 9){
					limpiarPantalla();
					System.out.println("\nEs un empate");
					break;
				}
				
				posicion = leer.next();
				posicion = posicion.toUpperCase();
				_posicion = posicion.charAt(0);
				
				switch(_posicion)
				{
					case'Q':
						jugador(0,0,turno);
					break;
					case'W':
						jugador(0,1,turno);
					break;
					case 'E':
						jugador(0,2,turno);
					break;
					case 'A':
						jugador(1,0,turno);
					break;
					case 'S':
						jugador(1,1,turno);
					break;
					case 'D':
						jugador(1,2,turno);
					break;
					case 'Z':
						jugador(2,0,turno);
					break;
					case 'X':
						jugador(2,1,turno);
					break;
					case 'C':
						jugador(2,2,turno);
					break;
					default:
						limpiarPantalla();
						gatoGraf();
						System.out.println("Presiona alguna tecla valida");
						turnoJugador();
						
				}//Fin de switch
			
			}//Fin de while
		gatoGraf();
		System.out.println("Presiona 1 para volver a jugar, otra tecla para salir ");	
		
			
			if(leer.next().equals("1"))
			{
				nueva_partida = true;
				inicializarGato();
				limpiarPantalla();
			}
			else{
				nueva_partida = false;
				System.out.println("Fin del juego");
			}

		}while(nueva_partida);
	}//Fin de main

	public static void inicio()
	{
		Scanner leer = new Scanner(System.in);
		System.out.println("======El Juego del Gato #======");
		gatoTeclas();
		System.out.println("Elige quien inicia: Jugador 1 = X	Jugador 2 = O");
		while (true)
		{
			String num = leer.next();
			if(num.equals("1") || num.equals("2")){
				turno = Integer.parseInt(num);
				break;	
			}
			else
				System.out.println("Opcion no valida");
		}
		limpiarPantalla();
		gatoGraf();
		turnoJugador();
	}
	
	
	public static void gatoGraf()
	{

		 System.out.println(" -----------------");
		 System.out.println("|  "+gato[0][0] + "  |  "+gato[0][1] + "  |  " +gato[0][2] + "  |");
		 System.out.println("|  "+gato[1][0] + "  |  "+gato[1][1] + "  |  " +gato[1][2] + "  |");
		 System.out.println("|  "+gato[2][0] + "  |  "+gato[2][1] + "  |  " +gato[2][2] + "  |");
		 System.out.println(" -----------------");
		 
	 }
	
	public static void gatoTeclas()
	{

		 System.out.println(" -----------------");
		 System.out.println("|  Q "+ " | " + " W  | " + " E  |");
		 System.out.println("|  A "+ " | " + " S  | " + " D  |");
		 System.out.println("|  Z "+ " | " + " X  | " + " C  |");
		 System.out.println(" -----------------");
		 
	 }
	
	public static void turnoJugador()
	{
		if(turno==1)
			 System.out.println("Jugador 1 --- X");
		 else if(turno == 2)
			 System.out.println("Jugador 2 ---  O");
	} 
	

	public static int ganador()
	 {
		 //Comprobación por filas
		 for(int i = 0; i < 3; i++)
		 {	
				 if(gato[i][0] == 'X' && gato[i][1] == 'X' && gato [i][2] == 'X')
					 return 1;
				 else if (gato[i][0] == 'O' && gato[i][1] == 'O' && gato [i][2] == 'O')
					 return 2;
		 }
		 //Posiciones 0,0  1,0  2,0 y 0,1  1,1  2,1 y 0,2  1,2  2,2
		//Comprobación por columnas
		 for(int i = 0; i < 3; i++)
		 {
			 if(gato[0][i] == 'X' && gato[1][i] == 'X' && gato[2][i] == 'X')
				 return 1;
			 else if(gato[0][i] == 'O' && gato[1][i] == 'O' && gato[2][i] == 'O')
				 return 2;
		 }
		 
		 //Comprobación en diagonal secundaria
		 //Posiciones 0,2  1,1  2,0 
		 if(gato[0][2] == 'X' && gato[1][1] == 'X' && gato[2][0] == 'X')
			 return 1;
		 else if(gato[0][2] == 'O' && gato[1][1] == 'O' && gato[2][0] == 'O')
			 return 2;
		 
		//Comprobación en diagonal principal
		//Posiciones 0,0  1,1  2,2 
			 if(gato[0][0] == 'X' && gato[1][1] == 'X' && gato[2][2] == 'X')
				 return 1;
			 else if(gato[0][0] == 'O' && gato[1][1] == 'O' && gato[2][2] == 'O')
				 return 2;
			 else
				 return 0;
	 }
	 

	//El metodo jugador almacena el valor correspondiente en la posicion seleccionada, alterna los turnos
	// aumenta la ronda y valida si una casilla ha sido seleccionada
	public static void jugador(int i, int j, int turn)
	{
		if(gato[i][j] == 'X' || gato[i][j] == 'O')
		{
			limpiarPantalla();
			gatoGraf();
			turnoJugador();
			System.out.println("La casilla ya esta llena, selecciona otra");
		} 
		else
		{
			 if(turn==1)
			{
				gato[i][j] = 'X';
				turno = 2;
			}
			else {
				gato[i][j] = 'O';
				turno = 1;
			}
			 limpiarPantalla();
			 gatoGraf();
			 turnoJugador();
			 ronda++;
		}
			
	}//Fin de metodo jugador

	//Incializa los valores de gato a "-", para la proxima partida
	public static void inicializarGato()
	{
		turno = 0;
		ronda = 0;
		for(int i = 0; i < 3; i++)
			for(int k = 0; k < 3; k++)
				gato[i][k] = '-';		
	}

	
	//Metodo para limpiar pantalla
	public static void limpiarPantalla()
	{
	   for (int i =0; i<10; i++)
		 System.out.println();
	} 
	
}//Fin de la clase
