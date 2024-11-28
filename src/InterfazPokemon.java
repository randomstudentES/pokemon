import java.util.Scanner;

/**
 * Esta clase representa la interfaz del juego Pokémon, donde el jugador crea su propio Pokémon
 * y luego se enfrenta a tres Pokémon rivales en rondas de combate.
 * El objetivo es derrotar a los tres rivales para ganar el juego.
 */
public class InterfazPokemon {
    private Scanner teclado;

    /**
     * Constructor de la clase que inicializa el escáner para leer la entrada del jugador.
     */
    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    /**
     * Método principal del juego. Permite al jugador crear su Pokémon y enfrentarse a tres Pokémon rivales.
     * El jugador debe vencer a los tres rivales para superar el juego.
     */
    public void Juego() {
        // Crea el Pokémon del jugador
        Pokemon pokemonJugador = menuCreacionPokemonJugador();

        // Enfrenta al jugador con tres rivales
        for (int i = 1; i <= 3; i++) {
            // Obtiene el siguiente Pokémon rival
            Pokemon enemigo = siguientePokemonRival(i);
            System.out.println("Presentación del pokemon oponente");
            System.out.println(enemigo.toString());

            System.out.println("\nPULSE ENTER PARA CONTINUAR");
            // Espera a que el jugador presione Enter para continuar
            Scanner leer = new Scanner(System.in);
            leer.nextLine();

            // Inicia la partida entre el jugador y el enemigo
            if(Partida(pokemonJugador, enemigo) != pokemonJugador){
                // Si el jugador pierde, muestra el mensaje de fin de partida
                mostrarFinPartida();
                return;
            }
            else {
                // Si el jugador gana, sube de nivel
                pokemonJugador.subirNivel();
                System.out.println("Has ganado \n*****************");
            }

        }

        // Si el jugador vence a los tres rivales, muestra el mensaje de éxito
        mostrarJuegoSuperado();
    }

    /**
     * Inicia una partida de combate entre el Pokémon del jugador y el Pokémon rival.
     * El combate continúa hasta que uno de los Pokémon gane, lo que se determina por su aguante.
     *
     * @param pokemonJugador el Pokémon del jugador
     * @param pokemonRival el Pokémon rival
     * @return el Pokémon ganador de la partida
     */
    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival){
        // Crea una nueva instancia de la clase Combate
        Combate ronda = new Combate(pokemonJugador, pokemonRival);

        // Realiza rondas hasta que un Pokémon gane
        while (ronda.Ganador() == null){
            ronda.Ronda();
        }

        // Retorna el Pokémon ganador
        if (ronda.Ganador() == pokemonJugador){
            return pokemonJugador;
        }
        else {
            return pokemonRival;
        }
    }

    /**
     * Muestra un menú para que el jugador cree su propio Pokémon.
     * El jugador debe ingresar un nombre y elegir un tipo de Pokémon.
     *
     * @return el Pokémon creado por el jugador
     */
    private Pokemon menuCreacionPokemonJugador(){
        System.out.println(" ..........................................................");
        System.out.println(" Crea tu pokemon ......");
        System.out.println(" ..........................................................");
        System.out.println("Introduzca un nombre: ");
        String nombre = teclado.next();
        System.out.println("Elige su tipo: \n1.- Agua\n2.- Tierra\n3.- Fuego");
        String tipo = teclado.next();

        // Asigna el tipo elegido al Pokémon
        if (tipo.equalsIgnoreCase("agua") || tipo.equals("1")) {
            tipo = "agua";
        } else if (tipo.equalsIgnoreCase("tierra") || tipo.equals("2")) {
            tipo = "tierra";
        } else if (tipo.equalsIgnoreCase("fuego") || tipo.equals("3")) {
            tipo = "fuego";
        }
        else{
            // Si la entrada no es válida, se llama recursivamente al menú
            menuCreacionPokemonJugador();
        }

        // Retorna el Pokémon creado
        return new Pokemon(nombre, tipo);
    }

    /**
     * Devuelve el siguiente Pokémon rival según el número de la ronda.
     *
     * @param numero el número de la ronda (1, 2 o 3)
     * @return el Pokémon rival correspondiente
     */
    public Pokemon siguientePokemonRival(int numero) {
        // Dependiendo del número de la ronda, devuelve el Pokémon correspondiente
        if (numero == 1){
            return new Pokemon("Caterpie", "tierra", 1);
        } else if (numero == 2) {
            return new Pokemon("Bulbasur", "agua", 2);
        } else if (numero == 3) {
            return new Pokemon("Charmander", "fuego", 3);
        }
        else {
            return null;
        }
    }

    /**
     * Muestra un mensaje de éxito cuando el jugador supera el juego.
     */
    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    /**
     * Muestra un mensaje de fin de partida cuando el jugador es derrotado.
     */
    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }
}
