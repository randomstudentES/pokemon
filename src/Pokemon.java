/**
 * Clase que representa a un Pokémon. Un Pokémon tiene un nombre, tipo, nivel y aguante.
 * Dependiendo de su tipo y nivel, puede enfrentarse a otros Pokémon en combate.
 */
public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

    // Constructores para crear un Pokémon de jugador o enemigo

    /**
     * Constructor para crear un Pokémon de jugador.
     *
     * @param nombre el nombre del Pokémon
     * @param tipo el tipo del Pokémon (agua, fuego, tierra)
     */
    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = 1;  // El nivel inicial es 1
        actualizarStats();  // Actualiza los stats según el nivel
    }

    /**
     * Constructor para crear un Pokémon de enemigo.
     *
     * @param nombre el nombre del Pokémon
     * @param tipo el tipo del Pokémon (agua, fuego, tierra)
     * @param nivel el nivel del Pokémon
     */
    public Pokemon(String nombre, String tipo, int nivel){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        actualizarStats();  // Actualiza los stats según el nivel
    }

    // Getters y setters

    /**
     * Obtiene el aguante del Pokémon.
     *
     * @return el aguante del Pokémon
     */
    public int getAguante() {
        return aguante;
    }

    /**
     * Establece el aguante del Pokémon.
     *
     * @param aguante el nuevo valor de aguante
     */
    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    /**
     * Obtiene el nombre del Pokémon.
     *
     * @return el nombre del Pokémon
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el tipo del Pokémon.
     *
     * @return el tipo del Pokémon (agua, fuego, tierra)
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nivel del Pokémon.
     *
     * @return el nivel del Pokémon
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel del Pokémon.
     *
     * @param nivel el nuevo nivel del Pokémon
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * Calcula el poder de un Pokémon en función de su nivel y el tipo de Pokémon rival.
     * El poder varía dependiendo de las interacciones entre tipos de Pokémon.
     *
     * @param contrincante el Pokémon rival
     * @return el poder calculado del Pokémon para esta partida
     */
    public int calcularPoder(Pokemon contrincante){
        int poder = 0;
        // Dependiendo del nivel del Pokémon, se genera un poder aleatorio
        switch (this.nivel){
            case 1:
                poder = (int) (Math.random() * 8 + 3);  // Poder entre 3 y 10
                break;
            case 2:
                poder = (int) (Math.random() * 15 + 6); // Poder entre 6 y 20
                break;
            case 3:
                poder = (int) (Math.random() * 22 + 9); // Poder entre 9 y 30
                break;
            case 4:
                poder = (int) (Math.random() * 29 + 12); // Poder entre 12 y 40
                break;
        }

        // Modificaciones de poder según la interacción de tipos
        if (this.tipo == "agua"){
            if (contrincante.tipo == "fuego"){
                poder += (this.nivel * 2);  // El agua vence al fuego
            } else if (contrincante.tipo == "tierra") {
                poder -= (contrincante.nivel * 2);  // El agua es débil contra tierra
            }
        } else if (this.tipo == "fuego") {
            if (contrincante.tipo == "agua"){
                poder += (this.nivel * 2);  // El fuego vence al agua
            } else if (contrincante.tipo == "tierra") {
                poder -= (contrincante.nivel * 2);  // El fuego es débil contra tierra
            }
        } else if (this.tipo == "tierra") {
            if (contrincante.tipo == "agua"){
                poder += (this.nivel * 2);  // La tierra vence al agua
            } else if (contrincante.tipo == "fuego") {
                poder -= (contrincante.nivel * 2);  // La tierra es débil contra fuego
            }
        }

        // Si el poder es negativo, se establece en 0
        if (poder < 0){
            return 0;
        }
        else {
            return poder;
        }
    }

    /**
     * Sube el nivel del Pokémon, mejorando sus estadísticas.
     */
    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();  // Actualiza las estadísticas al subir de nivel
    }

    /**
     * Actualiza las estadísticas del Pokémon según su nivel.
     * Actualmente solo se actualiza el aguante.
     */
    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);  // Calcula el aguante basado en el nivel
    }

    /**
     * Disminuye el aguante del Pokémon en 1, simulando que ha recibido daño.
     */
    public void disminuirAguante(){
        this.aguante--;
    }

    /**
     * Representa al Pokémon como una cadena de texto.
     *
     * @return una cadena con la información del Pokémon (nombre, tipo, nivel y aguante)
     */
    public String toString(){
        return "Nombre: " + this.nombre +
                "\n Tipo: " + this.tipo +
                "\n Nivel: " + this.nivel +
                "\n Aguante: " + this.aguante;
    }
}
