public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private int aguante;

// Añada los constructores********************

    // Jugador
    public Pokemon(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = 1;
        actualizarStats();
    }
    // Enemigo
    public Pokemon(String nombre, String tipo, int nivel){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        actualizarStats();
    }


// ******************************************

    public int getAguante() {
        return aguante;
    }

    public void setAguante(int aguante) {
        this.aguante = aguante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int calcularPoder(Pokemon contrincante){
        int poder = 0;
        switch (this.nivel){
            case 1:
                poder = (int) (Math.random() * 8 + 3);
                break;
            case 2:
                poder = (int) (Math.random() * 15 + 6);
                break;
            case 3:
                poder = (int) (Math.random() * 22 + 9);
                break;
            case 4:
                poder = (int) (Math.random() * 29 + 12);
                break;
        }

        if (this.tipo == "agua"){
            if (contrincante.tipo == "fuego"){
                poder += (this.nivel * 2);
            } else if (contrincante.tipo == "tierra") {
                poder -= (contrincante.nivel * 2);
            }
        } else if (this.tipo == "fuego") {
            if (contrincante.tipo == "agua"){
                poder += (this.nivel * 2);
            } else if (contrincante.tipo == "tierra") {
                poder -= (contrincante.nivel * 2);
            }
        } else if (this.tipo == "tierra") {
            if (contrincante.tipo == "agua"){
                poder += (this.nivel * 2);
            } else if (contrincante.tipo == "fuego") {
                poder -= (contrincante.nivel * 2);
            }
        }
        if (poder < 0){
            return 0;
        }
        else
            return poder;
    }

    public void subirNivel(){
        this.nivel++;
        this.actualizarStats();
    }

    public void actualizarStats(){
        this.aguante = (int) Math.round(nivel * 2.5);
    }

    public void disminuirAguante(){
        this.aguante--;
    }

    public String toString(){
        return "Nombre: " + this.nombre +
                "\n tipo: " + this.tipo +
                "\n nivel: " + this.nivel +
                "\n aguante " + this.aguante;
    }

}
