/**
 * Clase que representa un combate entre dos Pokémon.
 * El combate consiste en rondas donde ambos Pokémon se enfrentan,
 * y el primero en quedar sin aguante es derrotado.
 */
public class Combate {

    /** Pokémon del jugador. */
    Pokemon pokemonJugador;

    /** Pokémon del rival. */
    Pokemon pokemonRival;

    /**
     * Constructor que inicializa el combate con los Pokémon del jugador y del rival.
     *
     * @param pokemonJugador el Pokémon del jugador
     * @param pokemonRival el Pokémon del rival
     */
    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }

    /**
     * Ejecuta una ronda del combate. El Pokémon que tiene mayor poder ataca al rival,
     * disminuyendo su aguante.
     *
     * @return el Pokémon que ha ganado la ronda, o null si no ha habido un ganador.
     */
    public Pokemon Ronda(){
        int poderJugador = this.pokemonJugador.calcularPoder(this.pokemonRival);
        int poderRival = this.pokemonRival.calcularPoder(this.pokemonJugador);

        if (poderJugador > poderRival){
            this.pokemonRival.disminuirAguante();
            System.out.println("Gana la ronda:  " + this.pokemonJugador.getNombre());
            System.out.println("Aguante de " + this.pokemonJugador.getNombre() + ": " + this.pokemonJugador.getAguante());
            System.out.println("Aguante de " + this.pokemonRival.getNombre() + ": " + this.pokemonRival.getAguante());
            return this.pokemonJugador;
        } else if (poderRival > poderJugador) {
            this.pokemonJugador.disminuirAguante();
            System.out.println("Ataca " + this.pokemonRival.getNombre());
            System.out.println("Aguante de " + this.pokemonJugador.getNombre() + ": " + this.pokemonJugador.getAguante());
            System.out.println("Aguante de " + this.pokemonRival.getNombre() + ": " + this.pokemonRival.getAguante());
            return this.pokemonRival;
        } else {
            System.out.println("No ataca nadie");
            return null;
        }
    }

    /**
     * Determina el ganador del combate, comparando los aguantes de ambos Pokémon.
     * El ganador es el Pokémon que tiene aguante mayor a cero y el rival tiene aguante cero.
     *
     * @return el Pokémon ganador del combate, o null si ninguno ha ganado aún.
     */
    public Pokemon Ganador(){
        if (this.pokemonJugador.getAguante() > 0 && this.pokemonRival.getAguante() == 0){
            System.out.println("Has derrotado a " + this.pokemonRival.getNombre());
            return this.pokemonJugador;
        } else if (this.pokemonRival.getAguante() > 0 && this.pokemonJugador.getAguante() == 0) {
            System.out.println(this.pokemonRival.getNombre() + " te ha derrotado");
            return this.pokemonRival;
        } else {
            return null;
        }
    }
}
