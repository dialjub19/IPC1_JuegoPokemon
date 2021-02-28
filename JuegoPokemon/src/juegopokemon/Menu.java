/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon;

import Objetos.Jugador;
import Objetos.Pokemon;
import Objetos.ReportePokemon;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class Menu {

    // Declaracion de variables locales.
    private int contador;
    private int contadorJugador;
    private int contadorReporte;
    private static Pokemon[] poke;
    private static Pokemon[] pokeAux;
    private static Jugador[] jugadorUno;
    private static Jugador[] jugadorDos;
    private static ReportePokemon[] reporte;

    // Metodo constructor.
    public Menu() {
        this.contador = 0;
        this.contadorJugador = 0;
        this.contadorReporte = 0;
        this.poke = new Pokemon[20];
        this.pokeAux = new Pokemon[20];
        this.jugadorUno = new Jugador[100];
        this.jugadorDos = new Jugador[100];
        this.reporte = new ReportePokemon[100];
        this.pokemonPorDefecto();
    }

    // Metodo que muestra las opciones principales al iniciar el juego.
    public void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1. Administrador.");
        System.out.println("2. Iniciar Juego.");
        System.out.println("3. Salir.");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    menuAdmon();
                    break;
                case 2:
                    elegirPokemon();
                    break;
                case 3:
                    salir();
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                    menuPrincipal();
            }
        } while (opcion > 0 && opcion <= 4);
    }

    // Metodo que muestra las opciones del menu administrador.
    private void menuAdmon() {

        int contraseña = 201700770;
        int validarContraseña = 0;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la contraseña para continuar : ");
        validarContraseña = entrada.nextInt();

        if (contraseña != validarContraseña) {
            System.out.println("Contraseña Invalida, vuelva a intentarlo...");
            menuPrincipal();
        } else {

            System.out.println("\n-.-.-.- Bienvenido Administrador .-.-.-.-.-.-.-.-.-.-.-.-.-.-");
            System.out.println("1. Lista de Pokemon.");
            System.out.println("2. Agregar Pokemon.");
            System.out.println("3. Editar Pokemon.");
            System.out.println("4. Reportes.");
            System.out.println("5. Regresar al Menu Principal.");
            System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

            int opcion = 0;
            do {
                System.out.println("Ingrese una opcion : ");
                opcion = entrada.nextInt();
                switch (opcion) {
                    case 1:
                        listarPokemon();
                        break;
                    case 2:
                        agregarPokemon();
                        break;
                    case 3:
                        editarPokemon();
                        break;
                    case 4:
                        menuReporte();
                        break;
                    case 5:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                        menuPrincipal();
                }
            } while (opcion > 0 && opcion <= 5);
        }
    }

    // Metodo que muestra las opciones del menu de reportes.
    private void menuReporte() {

        Scanner entrada = new Scanner(System.in);

        System.out.println(".---------- Menu Reportes ----------.");
        System.out.println("1.Registro de Partidas.");
        System.out.println("2.Lista de los pokemones mas fuertes.");
        System.out.println("3.Lista de los pokemones mas debiles.");
        System.out.println("4.Regresar al menu principal.");

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    registroPartida();
                    break;
                case 2:
                    pokemonMasFuerte();
                    break;
                case 3:
                    break;
                case 4:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                    menuReporte();
            }
        } while (opcion >= 1 && opcion <= 4);

    }

    // Este metodo muestra un listado del pokemon mas fuerte basado en la cantidad de veces que fue elegido y la cantitdad de veces que a ganado.
    private void pokemonMasFuerte() {

        for (int i = 0; i < this.contadorReporte; i++) {
            for (int j = 1; j < this.contadorReporte; j++) {
                if (reporte[i].getMiPokemon() != null) {
                    if (reporte[i].getMiPokemon().getElegido() > reporte[j].getMiPokemon().getElegido()) {
                        Pokemon aux = reporte[i].getMiPokemon();
                        reporte[i] = reporte[j];
                        reporte[j].setMiPokemon(aux);
                    }
                } else {
                    System.out.println("No hay registro de partidas");
                }

            }
        }

        for (int i = 0; i < this.contadorReporte; i++) {
            System.out.println("\n--------------------Pokemones mas fuertes------------------");
            System.out.println("Nombre : " + reporte[i].getMiPokemon().getNombre());
            System.out.println("Ataque : " + reporte[i].getMiPokemon().getAtaque());
            System.out.println("Vida : " + reporte[i].getMiPokemon().getVida());
            System.out.println("Numero de veces seleccionado : " + reporte[i].getMiPokemon().getElegido());
            System.out.println("Partidas Ganadas :" + reporte[i].getMiPokemon().getEstadoPartida());
        }

    }

    // Este metodo muestra un listado de todas las partidas o batallas realizadas a lo largo del juego.
    private void registroPartida() {

        for (int i = 0; i < this.contadorJugador; i++) {
            System.out.println(".-.-.-.-.-.-.-. Batalla #" + (i + 1) + " .-.-.-.-.-.-.-.-.-.");
            System.out.println("Nombre jugador 1 : " + jugadorUno[i].getNombre());
            System.out.println("Pokemon 1 " + jugadorUno[i].getPokemon().getNombre());
            System.out.println("Pokemon 2 " + jugadorUno[i].getPokemonDos().getNombre());
            System.out.println("Total de ataques realizados : " + jugadorUno[i].getNumeroAtaque());
            System.out.println("" + jugadorUno[i].getEstado());
            System.out.println("Nombre jugador 2 : " + jugadorDos[i].getNombre());
            System.out.println("Pokemon 1 " + jugadorDos[i].getPokemon().getNombre());
            System.out.println("Pokemon 2 " + jugadorDos[i].getPokemonDos().getNombre());
            System.out.println("Total de ataques realizados : " + jugadorDos[i].getNumeroAtaque());
            System.out.println("" + jugadorDos[i].getEstado() + "\n");
        }

    }

    // Metodo que muestra las opciones del menu de batallar.
    private void menuBatallar(Jugador jugadorUno, Jugador jugadorDos) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("\n-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1. Batallar.");
        System.out.println("2. Finalizar Partida.");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    batallar(jugadorUno, jugadorDos);
                    break;
                case 2:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion Invalida, vuelva a intentarlo... \n");
                    menuPrincipal();
            }
        } while (opcion >= 1 && opcion <= 2);
    }

    // Metodo que muestra o lista a todos los pokemon que tenemos en el arreglo.
    private void listarPokemon() {

        int iteracion = 1;
        for (int i = 0; i < this.contador; i++) {

            System.out.println("\n------ Pokemon " + iteracion + " ------");
            System.out.println("Nombre : " + poke[i].getNombre());
            System.out.println("Puntos de Vida : " + poke[i].getVida());
            System.out.println("Puntos de Ataque : " + poke[i].getAtaque());
            System.out.println(poke[i].getImagen());
            System.out.println("");
            iteracion++;
        }
        opcion();
    }

    // Metodo que lista todos los pokemon.
    private void mostrarPokemon() {

        int iteracion = 1;
        for (int i = 0; i < this.contador; i++) {

            System.out.println("\n------ Pokemon " + iteracion + " ------");
            System.out.println("Nombre : " + poke[i].getNombre());
            System.out.println("Puntos de Vida : " + poke[i].getVida());
            System.out.println("Puntos de Ataque : " + poke[i].getAtaque());
            System.out.println(poke[i].getImagen());
            System.out.println("");
            iteracion++;
        }

    }

    // Metodo que permite almacenar o agregar un pokemon nuevo al arreglo.
    private void agregarPokemon() {

        Scanner valor = new Scanner(System.in);
        Random random = new Random();
        String nombre, imagen;

        String estado = "Vivo";
        int vida = (random.nextInt()) * 100 + 50;
        int ataque = (random.nextInt()) * 20 + 5;

        System.out.println("Ingrese el nombre del Pokemon : ");
        nombre = valor.nextLine().trim();

        System.out.println("Ingrese una imagen para del Pokemon : ");
        imagen = valor.nextLine().trim();

        poke[this.contador] = new Pokemon(nombre, vida, estado, ataque, imagen, 0, 0, 0);
        this.contador++;

        System.out.println("¡ Pokemon creado exitosamente !\n");
        opcion();
    }

    // Este metodo que permite editar a cada pokemon que tenemos almacenado en el arreglo.
    private void editarPokemon() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Pokemon a modificar : ");
        String nombre = entrada.nextLine().trim();

        for (int i = 0; i < this.contador; i++) {
            if (poke[i].getNombre().equalsIgnoreCase(nombre)) {

                System.out.println("Ingrese el nuevo nombre de su pokemon :");
                String nuevoNombre = entrada.nextLine();
                poke[i].setNombre(nuevoNombre);

                System.out.println("Ingrese el nuevo puntaje de ataque de su pokemon en un rango de [5-20] :");
                int nuevoAtaque = entrada.nextInt();
                while ((nuevoAtaque < 5) || (nuevoAtaque > 20)) {
                    System.out.println("¡ El ataque es mayor o menor al rango especificado por favor vuelva a intentarlo !");
                    nuevoAtaque = entrada.nextInt();
                }
                poke[i].setVida(nuevoAtaque);

                System.out.println("Ingrese el nuevo puntaje de vida de su pokemon en un rango de [50-100] :");
                int nuevaVida = entrada.nextInt();
                while ((nuevaVida < 50) || (nuevaVida > 100)) {
                    System.out.println("¡ La vida es mayor o menor al rango especificado, por favor vuelva a intentarlo !");
                    nuevaVida = entrada.nextInt();
                }
                poke[i].setVida(nuevaVida);

                System.out.println("¡ Pokemon modificado exitosamente !\n");
                break;
            }
        }
        opcion();

    }

    // Este metodo permite almanecar en un vector a los jugadores.
    private void elegirPokemon() {

        Scanner entrada = new Scanner(System.in);
        int numeroAleatorio = (int) (Math.random() * (2));
        copiaPokemon();

        System.out.println("Ingrese el nombre del primer Jugador :");
        String nombreUno = entrada.nextLine().trim();

        System.out.println("Ingrese el nombre del segundo Jugador :");
        String nombreDos = entrada.nextLine().trim();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("----------------------- Lista de Pokemon ----------------------------------------------");
        mostrarPokemon();
        System.out.println("");

        System.out.println("Jugador " + nombreUno + " eliga su primer pokemon ingresando el nombre : ");
        String eleccionUno = entrada.nextLine().trim();
        Pokemon miPokemonUno = elegirPokemon(eleccionUno);
        int numeroEleccion = miPokemonUno.getElegido();
        miPokemonUno.setElegido(numeroEleccion + 1);
        this.reporte[contadorReporte] = new ReportePokemon(miPokemonUno);
        this.contadorReporte++;

        System.out.println("Jugador " + nombreUno + " eliga su segundo pokemon ingresando el nombre : ");
        String eleccionDos = entrada.nextLine().trim();
        Pokemon miPokemonDos = elegirPokemon(eleccionDos);
        int numeroEleccionDos = miPokemonDos.getElegido();
        miPokemonDos.setElegido(numeroEleccionDos + 1);
        this.reporte[contadorReporte] = new ReportePokemon(miPokemonDos);
        this.contadorReporte++;

        System.out.println("\nJugador " + nombreDos + " eliga su primer pokemon ingresando el nombre : ");
        String eleccionTres = entrada.nextLine().trim();
        Pokemon miPokemonTres = elegirPokemon(eleccionTres);
        int numeroEleccionTres = miPokemonTres.getElegido();
        miPokemonTres.setElegido(numeroEleccionTres + 1);
        this.reporte[contadorReporte] = new ReportePokemon(miPokemonTres);
        this.contadorReporte++;

        System.out.println("Jugador " + nombreDos + " eliga su segundo pokemon ingresando el nombre : ");
        String eleccionCuatro = entrada.nextLine().trim();
        Pokemon miPokemonCuatro = elegirPokemon(eleccionCuatro);
        int numeroEleccionCuatro = miPokemonCuatro.getElegido();
        miPokemonCuatro.setElegido(numeroEleccionCuatro + 1);
        this.reporte[contadorReporte] = new ReportePokemon(miPokemonCuatro);
        this.contadorReporte++;

        this.jugadorUno[this.contadorJugador] = new Jugador(nombreUno, miPokemonUno, miPokemonDos, 0, "");
        this.jugadorDos[this.contadorJugador] = new Jugador(nombreDos, miPokemonTres, miPokemonCuatro, 0, "");

        Jugador uno = this.jugadorUno[this.contadorJugador];
        Jugador dos = this.jugadorDos[this.contadorJugador];

        this.contadorJugador++;

        if (numeroAleatorio == 1) {
            menuBatallar(uno, dos);
        } else {
            menuBatallar(dos, uno);
        }

    }

    // Este metodo contiene toda la logica de la batalla pokemon.
    private void batallar(Jugador jugadorUno, Jugador jugadorDos) {

        Scanner entrada = new Scanner(System.in);
        Pokemon pokeUno = null, pokeDos = null, pokeTres = null, pokeCuatro = null;
        int contadorAtaqueUno = 0;
        int contadorAtaqueDos = 0;

        while ((jugadorUno.getPokemon().getVida() > 0 || jugadorUno.getPokemonDos().getVida() > 0) && (jugadorDos.getPokemon().getVida() > 0 || jugadorDos.getPokemonDos().getVida() > 0)) {

            if (jugadorUno.getPokemon().getVida() > 0 || jugadorUno.getPokemonDos().getVida() > 0) {

                System.out.println("\nJugador " + jugadorUno.getNombre() + " ¿ con que pokemon desea atacar ?");
                pokeUno = jugadorUno.elegirPokemonDeAtaque(jugadorUno);

                System.out.println("\nJugador " + jugadorUno.getNombre() + " ¿ a que pokemon desea atacar ?");
                pokeTres = jugadorDos.elegirPokemonAtacar(jugadorDos);

                if (!(jugadorDos.getPokemon().getVida() < 0) && (pokeTres.equals(jugadorDos.getPokemon()))) {

                    int ataque = pokeUno.getAtaque();
                    int vida = pokeTres.getVida();
                    int total = vida - ataque;

                    System.out.println("\n----------- ATACANDO --------------");
                    System.out.println(pokeUno.getNombre() + " esta atacando a " + pokeTres.getNombre());
                    System.out.println("Actualmente " + pokeTres.getEstado());
                    System.out.println("Vida " + pokeTres.getVida());
                    System.out.println("Ataque " + pokeTres.getAtaque());
                    pokeTres.setVida(total);

                    System.out.println("¡ Ataque realizado exitosamente !");
                    System.out.println("El pokemon " + pokeTres.getNombre() + " quedo con una vida actual de " + pokeTres.getVida() + "\n");

                    if (pokeTres.getVida() <= 0) {
                        System.out.println("------------MUERTO--------------");
                        pokeTres.setEstado("Muerto");
                        System.out.println("¡ El Pokemon " + pokeTres.getNombre() + " esta muerto, este pokemon ya no puede continuar !\n");
                    }

                } else if (!(jugadorDos.getPokemonDos().getVida() < 0) && (pokeTres.equals(jugadorDos.getPokemonDos()))) {

                    int ataque = pokeUno.getAtaque();
                    int vida = pokeTres.getVida();
                    int total = vida - ataque;

                    System.out.println("\n----------- ATACANDO --------------");
                    System.out.println(pokeUno.getNombre() + " esta atacando a " + pokeTres.getNombre());
                    System.out.println("Actualmente " + pokeTres.getEstado());
                    System.out.println("Vida " + pokeTres.getVida());
                    System.out.println("Ataque " + pokeTres.getAtaque());
                    pokeTres.setVida(total);

                    System.out.println("¡ Ataque realizado exitosamente !");
                    System.out.println("El pokemon " + pokeTres.getNombre() + " quedo con una vida actual de " + pokeTres.getVida() + "\n");

                    if (pokeTres.getVida() <= 0) {
                        System.out.println("------------MUERTO--------------");
                        pokeTres.setEstado("Muerto");
                        System.out.println("¡ El Pokemon " + pokeTres.getNombre() + " esta muerto, este pokemon ya no puede continuar !\n");
                    }

                }
            }
            jugadorUno.setNumeroAtaque(contadorAtaqueUno);
            contadorAtaqueUno++;

            if (jugadorDos.getPokemon().getVida() > 0 || jugadorDos.getPokemonDos().getVida() > 0) {

                System.out.println("\nJugador " + jugadorDos.getNombre() + " ¿ con que pokemon desea atacar ?");
                pokeDos = jugadorDos.elegirPokemonDeAtaque(jugadorDos);

                System.out.println("\nJugador " + jugadorDos.getNombre() + " ¿ a que pokemon desea atacar ?");
                pokeCuatro = jugadorUno.elegirPokemonAtacar(jugadorUno);

                if (!(jugadorUno.getPokemon().getVida() < 0) && (pokeCuatro.equals(jugadorUno.getPokemon()))) {

                    int ataque = pokeDos.getAtaque();
                    int vida = pokeCuatro.getVida();
                    int total = vida - ataque;

                    System.out.println("\n----------- ATACANDO --------------");
                    System.out.println(pokeDos.getNombre() + " esta atacando a " + pokeCuatro.getNombre());
                    System.out.println("Actualmente " + pokeCuatro.getEstado());
                    System.out.println("Vida " + pokeCuatro.getVida());
                    System.out.println("Ataque " + pokeCuatro.getAtaque());
                    pokeCuatro.setVida(total);

                    System.out.println("¡ Ataque realizado exitosamente !");
                    System.out.println("Vida actualizada " + pokeCuatro.getVida() + "\n");
                    System.out.println("El pokemon " + pokeCuatro.getNombre() + " quedo con una vida actual de " + pokeCuatro.getVida() + "\n");

                    if (pokeCuatro.getVida() <= 0) {
                        System.out.println("------------MUERTO--------------");
                        pokeCuatro.setEstado("Muerto");
                        System.out.println("¡ El Pokemon " + pokeCuatro.getNombre() + " esta muerto, este pokemon ya no puede continuar !\n");
                    }

                } else if (!(jugadorUno.getPokemonDos().getVida() < 0) && (pokeCuatro.equals(jugadorUno.getPokemonDos()))) {

                    int ataque = pokeDos.getAtaque();
                    int vida = pokeCuatro.getVida();
                    int total = vida - ataque;

                    System.out.println("\n----------- ATACANDO --------------");
                    System.out.println(pokeDos.getNombre() + "esta atacando a " + pokeCuatro.getNombre());
                    System.out.println("Actualmente " + pokeCuatro.getEstado());
                    System.out.println("Vida " + pokeCuatro.getVida());
                    System.out.println("Ataque " + pokeCuatro.getAtaque());
                    pokeCuatro.setVida(total);

                    System.out.println("¡ Ataque realizado exitosamente !");
                    System.out.println("Vida actualizada " + pokeCuatro.getVida() + "\n");
                    System.out.println("El pokemon " + pokeCuatro.getNombre() + " quedo con una vida actual de " + pokeCuatro.getVida() + "\n");

                    if (pokeCuatro.getVida() <= 0) {
                        System.out.println("------------MUERTO--------------");
                        pokeCuatro.setEstado("Muerto");
                        System.out.println("¡ El Pokemon " + pokeCuatro.getNombre() + " esta muerto, este pokemon ya no puede continuar !\n");
                    }

                }
            }
            jugadorDos.setNumeroAtaque(contadorAtaqueDos);
            contadorAtaqueDos++;

        }

        if (jugadorUno.getPokemon().getEstado().equals("Muerto") && jugadorUno.getPokemonDos().getEstado().equals("Muerto")) {
            System.out.println("\n*-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-*");
            System.out.println("¡ Jugador " + jugadorDos.getNombre() + " felicitaciones has ganado la batalla !");
            System.out.println("*-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-*\n");

            int partidaGanada = jugadorDos.getPokemon().getEstadoPartida();
            jugadorDos.getPokemon().setEstadoPartida(partidaGanada + 1);

            int partidaGanadaDos = jugadorDos.getPokemonDos().getEstadoPartida();
            jugadorDos.getPokemonDos().setEstadoPartida(partidaGanadaDos + 1);

            jugadorDos.setEstado("Ganador");
            jugadorUno.setEstado("Perdedor");
            menuPrincipal();
        } else if (jugadorDos.getPokemon().getEstado().equals("Muerto") && jugadorDos.getPokemonDos().getEstado().equals("Muerto")) {
            System.out.println("\n*-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-*");
            System.out.println("¡ Jugador " + jugadorUno.getNombre() + " felicitaciones has ganado la batalla !");
            System.out.println("*-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-**-*-*\n");

            int partidaGanada = jugadorUno.getPokemon().getEstadoPartida();
            jugadorUno.getPokemon().setEstadoPartida(partidaGanada + 1);

            int partidaGanadaDos = jugadorUno.getPokemonDos().getEstadoPartida();
            jugadorUno.getPokemonDos().setEstadoPartida(partidaGanadaDos + 1);

            jugadorUno.setEstado("Ganador");
            jugadorDos.setEstado("Perdedor");
            menuPrincipal();
        }

    }

    private void copiaPokemon() {

        for (int i = 0; i < this.contador; i++) {
            pokeAux[i] = poke[i];
        }

    }

    // Este metodo recibe como parametro el nombre del pokemon para luego buscarlo en el arreglo y de encontrarlo retornara el pokemon en caso contrario retornara un null.
    private Pokemon elegirPokemon(String pokemon) {

        Scanner entrada = new Scanner(System.in);
        Pokemon retorno = null;

        for (int i = 0; i < this.contador; i++) {
            if (pokeAux[i].getNombre().equalsIgnoreCase(pokemon)) {
                retorno = pokeAux[i];
                return retorno;
            }
        }

        if (retorno == null) {
            System.out.println("¡ El nombre del pokemon " + pokemon + " esta incorrecto o no existe, vuelva a intentarlo !\n");
            System.out.println("Ingrese el nombre de su pokemon nuevamente : ");
            String nombrePokemon = entrada.nextLine();
            return elegirPokemon(nombrePokemon);
        }
        return retorno;
    }

    // Este metodo que almacena a 6 pokemon por defecto, este metodo se inicializa al iniciar la ejecucion del programa.
    private void pokemonPorDefecto() {

        poke[this.contador] = new Pokemon("Cyndaquil", 100, "Vivo", 20, "\n"
                + "                                  *                         \n"
                + "                           ,      **                        \n"
                + "                           **    ***                        \n"
                + "            **             *** * ****                       \n"
                + "  ***         ****    *    **********   **                  \n"
                + "    ,*******  * ********** *******/*******,,,,.             \n"
                + "       **************(**********/*%%***,,,,,,,,,,,,,        \n"
                + "         ****%*********/%%******&%%%*,&&&&&&&,,,,,,,,,      \n"
                + "        *, /****%%%%*****%%%%%((%%%..&&&&&&&&&&&,,,,,,,     \n"
                + "           ,*******%%%%%%%%...,% ,,..&&&&&&&& &&&...,,,     \n"
                + "              ,**(/**#%%%%%.,,,,,,,,,.&&&&&&&&&&&&....,,    \n"
                + "               ******%%,,,,,,,&&&&&&&&&&&&&&&&&&&&&&&&.,,.  \n"
                + "             ******** ,,,,,,&&&&&&&&&&(&&&&&& .%&&&&&&&&&,, \n"
                + "          **********.,/&&&&&&&&&&%(%% #&&&*%%%&&     &&&&&&,\n"
                + "                    ,%&&&&&&&&&&&&&&&&&&&               ,&&.\n"
                + "                     %%%%&&&&&&%%%%%%%%%&                   \n"
                + "                      /%%%%%%%%  %%%%%%&,                   \n"
                + "                        %%%,%       %%%.                    ", 0, 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Chikorita", 100, "Vivo", 20, "                                                            \n"
                + "                               #@@@@@&,                     \n"
                + "                         @((((((((//////((@#%&              \n"
                + "                      @(#@     ,@###((////(((@#((#          \n"
                + "                     (%            @##(((//((((&#((&        \n"
                + "                  @@&&@@@           @##(((((((((@##((@      \n"
                + "             @,.....,,,,,,,,,@       @##(((((((((###(((     \n"
                + "           @........,,,,,,,,,,,@     @##((((((((((###(((    \n"
                + "          %.......,,,,,@@*,,,,,*@     ###((((((((((###(((   \n"
                + "         @ @#,,,,,,,,@%%@ #,,,,,*@    @###((((((((((@#(((@  \n"
                + "          % @,,,,,,,,# /%@ %,,,,*#     %###((((((((((##(((  \n"
                + "        % %%@,,,,,,,,%%%## @,,,,*/      @#####(#((###@####  \n"
                + "        & //@,,,,,,,,/((/% @,,,,*//      .################  \n"
                + "        @,,,,,,,,,,,,,,,,,,,,,,,*/@         @#############  \n"
                + "        (,,,,,,,,,*,,,,,,,,,,,,,,*@@@/         &######&##@  \n"
                + "         ..,,,,,,,,,,,,,,,,,,,,,*/(#@&           %####%##   \n"
                + "        @..,,,,,,,,,,,,,,,,(((@,**//*****         @#####    \n"
                + "        @.,#((*,,,&((%,,,,,,//****//*******@%      @#@@     \n"
                + "         ,.,**,,,,,*/,,,,,,,,,,***/*********%**/    @       \n"
                + "         @,,,,...,,,,,,,,,,,,,,***//****///**@/@            \n"
                + "          *,,,,....,,,,,,,,,,,,***////////////@             \n"
                + "           ,,*#**,,,,,,,,,,,,,,**/////////////              \n"
                + "           .***///&///**/,,,,,,*@//(/////////(              \n"
                + "             ***///    *@,,,,,*%%%@@/(//////@               \n"
                + "            @,**@        @@**@@@      @(*/(                 \n"
                + "                          *,,@                              \n"
                + "                                              ", 0, 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Totodile", 100, "Vivo", 20, "                                                             \n"
                + "                   ###  # ########(                         \n"
                + "                #######(#############                       \n"
                + "              ######## #### @@@@ #####                      \n"
                + "             ,####### #### @ /@@@, ####                     \n"
                + "             ####### ####  @  @@@., #### ((                 \n"
                + "           ####### ##### , @ ,@@@,, #####*(((((             \n"
                + "      ####### ######### ,,,@@ @  ######## (((((*            \n"
                + "  ####################################### (((               \n"
                + " ##### ######################* ########## (((((             \n"
                + " ################  ###################### (((((((((((       \n"
                + "  ########  @@ ############# ############ (((((((((((       \n"
                + "     ### ####  ######### ######   ####### ((((((((          \n"
                + "                   ##### /@@@@@@ #########((((              \n"
                + "               # @@@.@@@@@@@@@@@########## ((((((((         \n"
                + "             ## @@@.@@@@@@@@@@@ ########*##,(((((           \n"
                + "            ## #@@@@@@@@@ (####(######## ###,((,            \n"
                + "          ### ### @@  #########(########*####               \n"
                + "          ### ################# ####### #######        (    \n"
                + "          ##################### ########### #####  (((((    \n"
                + "          ##################.#.#####/## #### ######## *(    \n"
                + "           ######.######################################### \n"
                + "            ########  ###### ################.###########   \n"
                + "           ### ##########      #############                \n"
                + "        ####  #########           ########                  \n"
                + "         ######                   ###### ##,                \n"
                + "                                 ######## ###               \n"
                + "                                 ###(####.##( ", 0, 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Charizard", 80, "Vivo", 16, "                                          *                 \n"
                + "                (***#           ,(  /     **&/*(            \n"
                + "           ,**#%%%%%**          *****(   /*%&%##%&*         \n"
                + "         */%%%%##%&%%.         *(*.***   *%###%####%((      \n"
                + "       *%%%#####%%%#%%*.      **(((***  .%%####%#####%%/    \n"
                + "    **%%%#######%%####%%/.**..**((,  .*&%%#####%########%*  \n"
                + "   (%%####%(/###%%########./***(((((%%#########&%        (%*\n"
                + "  *%#          #%%#%*,(**(%*((((%//#(/%##%     %            \n"
                + " &              &      #*(**((********#(((*#% (             \n"
                + "  (  /                  ((*(**********#                     \n"
                + "   ....../    (..,.. (./****#*********#**.                  \n"
                + "     (.#*((,(//(**%(/********#********(***.                 \n"
                + "                     ./((((((/******(((((((                 \n"
                + "                        (((%        (((%(                   \n"
                + "                      ,****.          ****                  \n"
                + "                                       .  .   ", 0, 0, 0);
        this.contador++;
        poke[this.contador] = new Pokemon("Gengar", 100, "Vivo", 20, ""
                + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@\n"
                + "@@@@@@#@@@@@@@@@@@@@@@@@@@@@&#@@@@@@@@@@@@@@@&((/#@@@@@@@@@@\n"
                + "@@@@@@@(((#&@@@@@@@@@@@@@@@%(/@@@@@@@@@@@%#(((/*%@@@@@@@@@@@\n"
                + "@@@@@@@&#(((((#%@@@@@&@&#%((//#(/@@((%#(((((/**&@@@@@@@@@@@@\n"
                + "@@@@@@@@@#(((((((((##(#(((((((((((((((((((//**@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@&#((((((((((((((((((((((((((((///***@@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@&#(((((((((((((((((((((((((////***((@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@%(((((((((((((((((((((((((////*****@@@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@#((((((((((((((((((((((((((/////*///&@@@@@@@@@@@@\n"
                + "@@@@@@@@@##(((((((((((((((((((((*((((/////////////#@@@@@@@@@\n"
                + "@@@@@&%(/(#((*%/(((((((((((((,%%*(((////////////////(@@@@@@@\n"
                + "@@@@%////((((/%%.*((((((((//,%%%,/////////*///////////(@@@@@\n"
                + "@@@#/////#(/(((%%%%*((((/(%%%#/*////,/////**////////////@@@@\n"
                + "@@#((///*#((&(/(((((((((((((//*/(%%%/////*****///////////(@@\n"
                + "@#((//***((((&@@@@#@@@#@@&@(&&&&(%#//////********////////*/@\n"
                + "@#(/****&@#(((/&@@%@@@@@@&&%&&&&(//////**********(@@&//*/*@@\n"
                + "@@/&@@@@@@@((((((/(#%%&(%#(//////////************@@@@@@@@@@@\n"
                + "@@@@@@@@@@@@((((//////////////////***************@@@@@@@@@@@\n"
                + "@@@@@@@@@@&#((///////////////**************,****/@@@@@@@@@@@\n"
                + "@@@@@@@@@&(///////////*****************,,,******(@@@@@@@@@@@\n"
                + "@@@@@@@@#(///**********************,,,,,,*******%@@@@@@@@@@@\n"
                + "@@@@@@@@#//****,,,,,,*************,,,,**********@@@@@@@@@@@@\n"
                + "@@@@@@@%(/***,,,,,,,#@@@@@@@@@@@@@@@@**********&@@@@@@@@@@@@\n"
                + "@@@@@@@@@@@%/&@@@@@@@@@@@@@@@@@@@@@@@@@********/@@@@@@@@@@@@", 0, 0, 0);

        this.contador++;
        poke[this.contador] = new Pokemon("Chansey", 100, "Vivo", 18, ""
                + "                       #&&&&&&&&&&&&&/                      \n"
                + "                   ,&&&&&&&&&&&&&&&&&&&&&                   \n"
                + "       ...   .%&&&&&&&&&&*,&&&&&&/@&&&&&&&&&&&,   ....      \n"
                + "       %%%%&(*&&&&&&&&&&&//&&&&&&& &&&&&&&&&&&#,&#%%%,      \n"
                + "        /%&&%%&&&&&&&&&&&&&&*..,&&&&&&&&&&&&&&&,&&&#.       \n"
                + "    %%%%#%.&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&#,%%%%%*   \n"
                + "       (#%%#,&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&.#%%%%       \n"
                + "      ### &&&&&&&&&&&&&&&.&&&( &&&,%&&&&&&&&&&&&&&.(%#/     \n"
                + "        &&&&&&&&&&&&&&&&&&&&&.&&&&&&&&&&&&&&&&&&&&&&*       \n"
                + "       &&&&&&&&&&&&&&&&&&&&,&&&&*&&&&&&&&&&&&&&&&&&&&#      \n"
                + "      &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*     \n"
                + "     &&&&&&&&&&&&&&&&&&&& @@@@@@@@ %&&&&&&&&&&&&&&&&&&&     \n"
                + "     &&&&&&&&&&&&&&&&&&/@@@@@@@@@@@@@*&&&&&&&&&&&&&&&&&*    \n"
                + "     &&&&&&&&&&&&&&&& @@@@@@@@@@@@@@@@,&&&&&&&&&&&&&&&&#    \n"
                + "     &&&&&&&&&&&&&&&.@@@@@@@@@@@@@@@@@@,&&&&&&&&&&&&&&&/    \n"
                + "     &&&&&&&&&&&&&&(..(@@@@@@@@@@@@@@&/ .&&&&&&&&&&&&&%     \n"
                + "     .&&&&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%# &&&&&&&&&&&&%#     \n"
                + "      .&&&&&&&&&&&&& #%%%%%%%%%%%%%%%%#*&&&&&&&&&&&%%%      \n"
                + "        %&&&&&&&&&&&&,(%%%%%%%%%%%%%## &&&&&&&&&&%%%.       \n"
                + "          /&&&&&&&&&&&&# ((########.,&&&&&&&&&&%%%          \n"
                + "              %%&&&&&&&&&&&&&&&&&&&&&&&&&&&%%%%             \n"
                + "            ##%##  *%%%%&&&&&&&&&&&%%%%%%, *%%%%            \n"
                + "          %%%#%##(,                       /##%%%%#.    ", 0, 0, 0);
        this.contador++;
    }

    // Este metodo tiene como objetivo preguntar si desea seguir en el menu admon.
    private void opcion() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("¿ Desea continuar en el menu administrador ?");
        System.out.println("Escriba [ " + "si" + " ]" + " o " + "[ " + "no" + " ]");
        String opcion = entrada.nextLine().trim();
        if (opcion.equalsIgnoreCase("si")) {
            menuAdmon();
        } else {
            menuPrincipal();
        }
    }

    // Este metodo que permite finalizar la ejecucion del programa.
    private void salir() {
        System.out.println("Ejecucion del programa finalizada, gracias por jugar Pokemon");
        System.exit(0);
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

}
