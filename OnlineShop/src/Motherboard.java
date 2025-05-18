public class Motherboard extends Produs {
    private String socket;
    private String chipset;
    private String tipRam;
    private String format;
    private int sloturiRam;
    private int sloturiM2;

    public Motherboard(String id, String nume, double pret, String producator, String socket, String chipset, String tipRam, String format, int sloturiRam, int sloturiM2) {
        super(id, nume, pret, producator);
        this.socket = socket;
        this.chipset = chipset;
        this.tipRam = tipRam;
        this.format = format;
        this.sloturiRam = sloturiRam;
        this.sloturiM2 = sloturiM2;
    }

    public String getSocket() { return socket; }
    public String getChipset() { return chipset; }
    public String getTipRam() { return tipRam; }
    public String getFormat() { return format; }
    public int getSloturiRam() { return sloturiRam; }
    public int getSloturiM2() { return sloturiM2; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "socket": return socket;
            case "chipset": return chipset;
            case "tipram": return tipRam;
            case "format": return format;
            case "sloturiram": return sloturiRam;
            case "sloturim2": return sloturiM2;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Motherboard: Socket %s, %s, RAM: %s, Format: %s, Sloturi RAM: %d, M.2: %d", socket, chipset, tipRam, format, sloturiRam, sloturiM2);
    }
}
