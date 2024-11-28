import java.util.Scanner;
public class InterfazPokemon {
    private Scanner teclado;

    public InterfazPokemon(){
        teclado = new Scanner(System.in);
    }

    public void Juego() {
        Pokemon pokemonJugador = menuCreacionPokemonJugador();

        for (int i = 1; i <= 3; i++) {
            Pokemon enemigo = siguientePokemonRival(i);
            System.out.println("Presentación del pokemon oponente");
            System.out.println(enemigo.toString());

            System.out.println("\nPULSE ENTER PARA CONTINUAR");
            Scanner leer = new Scanner(System.in);
            leer.nextLine();

            if(Partida(pokemonJugador, enemigo) != pokemonJugador){
                mostrarFinPartida();
                return;
            }
            else {
                pokemonJugador.subirNivel();
                System.out.println("Hast ganado \n*****************");
            }

        }

        mostrarJuegoSuperado();
    }

    private Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival){
        Combate ronda = new Combate(pokemonJugador, pokemonRival);
        while (ronda.Ganador() == null){
            ronda.Ronda();

        }
        if (ronda.Ganador() == pokemonJugador){
            return pokemonJugador;
        }
        else
            return pokemonRival;
    }


    private Pokemon menuCreacionPokemonJugador(){
        System.out.println(" ..........................................................");
        System.out.println(" Crea tu pokemon ......");
        System.out.println(" ..........................................................");
        System.out.println("Introduzca un nombre: ");
        String nombre = teclado.next();
        System.out.println("Elige su tipo: \n1.- Agua\n2.- Tierra\n3.- Fuego");
        String tipo = teclado.next();
        if (tipo.equalsIgnoreCase("agua") || tipo.equals("1")) {
            tipo = "agua";
        } else if (tipo.equalsIgnoreCase("tierra") || tipo.equals("2")) {
            tipo = "tierra";
        } else if (tipo.equalsIgnoreCase("fuego") || tipo.equals("3")) {
            tipo = "fuego";
        }
        else{
            menuCreacionPokemonJugador();
        }
        return new Pokemon(nombre, tipo);
    }

    public Pokemon siguientePokemonRival(int numero) {

        if (numero == 1){
            return new Pokemon("Caterpie", "tierra", 1);
        } else if (numero == 2) {
            return new Pokemon("Bulbasur", "agua", 2);
        } else if (numero == 3) {
            return new Pokemon("Charmander", "fuego", 3);
        }
        else
            return null;

    }

    private void mostrarJuegoSuperado(){
        System.out.println("++++++++++ ENHORABUENA +++++++++++");
        System.out.println("+++++ HAS SUPERADO EL JUEGO ++++++");
        System.out.println("++++ ERES UN MAESTRO POKEMON +++++");
    }

    private void mostrarFinPartida(){
        System.out.println("++++++++++ LO SIENTO +++++++++++");
        System.out.println("+++++ HAS SIDO ELIMINADO ++++++");
        System.out.println("+++++ VUELVE A INTENTARLO +++++");
    }
}
