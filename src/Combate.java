public class Combate {

    // Añada los atributos y el constructor *************

    Pokemon pokemonJugador;
    Pokemon pokemonRival;

    public Combate(Pokemon pokemonJugador, Pokemon pokemonRival){
        this.pokemonJugador = pokemonJugador;
        this.pokemonRival = pokemonRival;
    }

    //***************************************************


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
        }
        else
            System.out.println("No ataca nadie");
            return null;
    }

    public Pokemon Ganador(){



        if (this.pokemonJugador.getAguante() > 0 && this.pokemonRival.getAguante() == 0){
            System.out.println("Has derrotado a " + this.pokemonRival.getNombre());
            return this.pokemonJugador;
        } else if (this.pokemonRival.getAguante() > 0 && this.pokemonJugador.getAguante() == 0) {
            System.out.println(this.pokemonRival.getNombre() + " te ha derrotado");
            return this.pokemonRival;
        }
        else
            return null;
    }


}
