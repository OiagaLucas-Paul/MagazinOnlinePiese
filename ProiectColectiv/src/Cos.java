import java.util.ArrayList;
import java.util.List;

public class Cos {
    private List<Componenta> componente = new ArrayList<>();

    public void addProduct(Componenta p) {
    	componente.add(p);
    }

    public void viewCos() {
        if (componente.isEmpty()) {
            System.out.println("Cosul este gol.");
            return;
        }

        double total = 0;
        System.out.println("Produse in cos:");
        for (Componenta c : componente) {
            System.out.println(c);
            total += c.getPret();
        }
        System.out.println("Total: " + total + " RON");
    }
    
    public boolean stergeComponenta(int id) {
        for (int i = 0; i < componente.size(); i++) {
            if (componente.get(i).getId() == id) {
            	componente.remove(i);
                return true;
            }
        }
        return false;
    }


    public void clearCos() {
        componente.clear();
    }
}
