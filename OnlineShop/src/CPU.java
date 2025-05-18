public class CPU extends Produs {
    private double frecventaGHz;
    private int nrNuclee;
    private int consumW;
    private String socket;

    public CPU(String id, String nume, double pret, String producator, double frecventaGHz, int nrNuclee, int consumW, String socket) {
        super(id, nume, pret, producator);
        this.frecventaGHz = frecventaGHz;
        this.nrNuclee = nrNuclee;
        this.consumW = consumW;
        this.socket = socket;
    }

    public double getFrecventaGHz() { return frecventaGHz; }
    public double getFrecventaMHz() { return frecventaGHz * 1000; }
    public int getNrNuclee() { return nrNuclee; }
    public int getConsumW() { return consumW; }
    public String getSocket() { return socket; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "frecventa": return frecventaGHz;
            case "nrnuclee": return nrNuclee;
            case "consumw": return consumW;
            case "socket": return socket;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | CPU: %.2fGHz, %d nuclee, %dW, socket: %s", frecventaGHz, nrNuclee, consumW, socket);
    }
}
