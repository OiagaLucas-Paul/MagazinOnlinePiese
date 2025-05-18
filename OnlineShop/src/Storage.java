public class Storage extends Produs {
    private String tip;
    private int capacitateGB;
    private int vitezaCitire;
    private int vitezaScriere;

    public Storage(String id, String nume, double pret, String producator, String tip, int capacitateGB, int vitezaCitire, int vitezaScriere) {
        super(id, nume, pret, producator);
        this.tip = tip;
        this.capacitateGB = capacitateGB;
        this.vitezaCitire = vitezaCitire;
        this.vitezaScriere = vitezaScriere;
    }

    public String getTip() { return tip; }
    public int getCapacitateGB() { return capacitateGB; }
    public int getVitezaCitire() { return vitezaCitire; }
    public int getVitezaScriere() { return vitezaScriere; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "tip": return tip;
            case "capacitategb": return capacitateGB;
            case "vitezacitirе": return vitezaCitire;
            case "vitezascriere": return vitezaScriere;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Storage: %s, %dGB, Read: %dMB/s, Write: %dMB/s", tip, capacitateGB, vitezaCitire, vitezaScriere);
    }
}
