public class Capitan extends Rango{

    private String nombre;
    private String id;
    private String rango;
    private int nivel;
    private int cantidadSoldadosBajoSuMando;

    public Capitan(String nombre, String id, String rango, int nivel, int cantidadSoldadosBajoSuMando) {
        super(nombre, id, rango, nivel);
        this.nombre = nombre;
        this.id = id;
        this.rango = rango;
        this.nivel = nivel;
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
        //TODO Auto-generated constructor stub
    }



    @Override
    void realizarAccion() {

    }

    @Override
    public void asignarMision(String mision) {

    }

    @Override
    public void reportarEstado() {

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSoldadosBajoSuMando() {
        return cantidadSoldadosBajoSuMando;
    }

    public void setCantidadSoldadosBajoSuMando(int cantidadSoldadosBajoSuMando) {
        this.cantidadSoldadosBajoSuMando = cantidadSoldadosBajoSuMando;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String getRango() {
        return rango;
    }

    @Override
    public void setRango(String rango) {
        this.rango = rango;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
