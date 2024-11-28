/**
 * Clase principal que ejecuta el juego de Pokémon.
 * Inicia el juego creando una instancia de la clase InterfazPokemon
 * y ejecuta el juego a través de su método Juego.
 */
public class AppPokemon {

    /**
     * Método principal que ejecuta el juego de Pokémon.
     * Crea una instancia de la clase InterfazPokemon y llama al método Juego para iniciar la partida.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crea una nueva instancia del juego
        InterfazPokemon juegoPokemon = new InterfazPokemon();

        // Inicia el juego
        juegoPokemon.Juego();
    }
}
