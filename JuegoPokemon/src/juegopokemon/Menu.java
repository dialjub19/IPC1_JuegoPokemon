/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopokemon;

import Objetos.Jugador;
import Objetos.Pokemon;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dialj
 */
public class Menu {

    private int contador;
    private int contadorJugador;
    private static Pokemon[] poke;
    private static Jugador[] jugadorUno;
    private static Jugador[] jugadorDos;

    public Menu() {
        this.contador = 0;
        this.contadorJugador = 0;
        this.poke = new Pokemon[20];
        this.jugadorUno = new Jugador[100];
        this.jugadorDos = new Jugador[100];
        this.pokemonPorDefecto();
    }

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
                    menuBatallar();
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

    public void menuBatallar() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        System.out.println("1. Batallar.");
        System.out.println("2. Salir.");
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");

        int opcion = 0;
        do {
            System.out.println("Ingrese una opcion : ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    batallar();
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

    // Metodo que permite almacenar o agregar un pokemon nuevo al arreglo.
    private void agregarPokemon() {

        Scanner valor = new Scanner(System.in);
        Random random = new Random();
        String nombre, imagen;

        String estado = "Vivo";
        int vida = (random.nextInt()) * 100 + 50;
        int ataque = (random.nextInt()) * 20 + 5;

        System.out.println("Ingrese el nombre del Pokemon : ");
        nombre = valor.nextLine();

        System.out.println("Ingrese una imagen para del Pokemon : ");
        imagen = valor.nextLine();

        poke[this.contador] = new Pokemon(nombre, vida, estado, ataque, imagen);
        this.contador++;

        System.out.println("¡ Pokemon creado exitosamente !\n");
        opcion();
    }

    // Metodo que permite editar a cada pokemon que tenemos almacenado en el arreglo.
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

    private void batallar() {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el nombre del primer Jugador :");
        String jugadorUno = entrada.nextLine();

        //System.out.println("Ingrese el nombre del segundo Jugador :");
        //String jugadorDos = entrada.nextLine();
        //this.jugadorDos[this.contadorJugador].setNombre(jugadorDos);
        System.out.println("Jugador " + jugadorUno + " eliga su primer pokemon ingresando el nombre : ");
        String eleccion = entrada.nextLine();
        Pokemon miPokemon = elegirPokemon(eleccion);

        this.jugadorUno[this.contador] = new Jugador(jugadorUno, miPokemon, 0, "");

        System.out.println("Mi pokemon elegido es : " + this.jugadorUno[this.contador].getPokemon().getNombre());
        System.out.println("Su ataque es : " + this.jugadorUno[this.contador].getPokemon().getAtaque());
        System.out.println(this.jugadorUno[this.contador].getPokemon().getImagen());

        //System.out.println("Jugador " + jugadorUno + " eliga su segundo pokemon ingresando el nombre : ");
        //System.out.println("Jugador " + jugadorDos + " eliga su primer pokemon ingresando el nombre : ");
        //System.out.println("Jugador " + jugadorDos + " eliga su segundo pokemon ingresando el nombre : ");
        contadorJugador++;

    }

    private Pokemon elegirPokemon(String pokemon) {

        for (int i = 0; i < this.contador; i++) {
            if (poke[i].getNombre().equalsIgnoreCase(pokemon)) {
                Pokemon retorno = poke[i];
                return retorno;
            }
        }
        return null;
    }

    // Metodo que almacena a 6 pokemon por defecto, este metodo se inicializa al iniciar la ejecucion del programa.
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
                + "                        %%%,%       %%%.                    ");

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
                + "                                              ");

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
                + "                                 ###(####.##( ");

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
                + "                                       .  .   ");
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
                + "@@@@@@@@@@@%/&@@@@@@@@@@@@@@@@@@@@@@@@@********/@@@@@@@@@@@@");

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
                + "          %%%#%##(,                       /##%%%%#.    ");

    }

    // Metodo
    private void opcion() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("¿ Desea continuar en el menu administrador ?");
        String opcion = entrada.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            menuAdmon();
        } else {
            menuPrincipal();
        }
    }

    // Metodo que permite finalizar la ejecucion del programa.
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
