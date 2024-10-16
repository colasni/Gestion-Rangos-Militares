import java.util.ArrayList;

public class ImprimirDatos {

    public ImprimirDatos() {


    }

    public void imprimirSoldadoRaso(ArrayList<SoldadoRaso> soldadoRasos) {
        for (Soldado soldado : soldadoRasos) {
            System.out.println("Identificación: " + soldado.getId());
            System.out.println("Coronel: " + soldado.getNombre());
            System.out.println("Rango: " + soldado.getRango());
            System.out.println();
        }
    }

    public void imprimirTeniente(ArrayList<Teniente> tenientes) {
        for (Teniente teniente : tenientes) {
            System.out.println("Identificación: " + teniente.getId());
            System.out.println("Nombre: " + teniente.getNombre());
            System.out.println("Rango: " + teniente.getRango());
            System.out.println("Unidad: " + teniente.getUnidad());
            System.out.println();
        }
    }


    public void imprimirCapitan(ArrayList<Capitan> capitanes) {
        for (Capitan capitan : capitanes) {
            System.out.println("Identificación: " + capitan.getId());
            System.out.println("Nombre: " + capitan.getNombre());
            System.out.println("Rango: " + capitan.getRango());
            System.out.println("Estrategia: " + capitan.getCantidadSoldadosBajoSuMando());
            System.out.println();
        }
    }

    public void imprimirCoronel(ArrayList<Coronel> coroneles) {
        for (Coronel coronel : coroneles) {
            System.out.println("Identificación: " + coronel.getId());
            System.out.println("Nombre: " + coronel.getNombre());
            System.out.println("Rango: " + coronel.getRango());
            System.out.println("Estrategia: " + coronel.getEstrategia());
            System.out.println();
        }
    }

}
