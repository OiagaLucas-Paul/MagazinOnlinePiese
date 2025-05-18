public class RAM extends Produs {
    private int capacitateGB;
    private int frecventaMHz;
    private String tip;

    public RAM(String id, String nume, double pret, String producator, int capacitateGB, int frecventaMHz, String tip) {
        super(id, nume, pret, producator);
        this.capacitateGB = capacitateGB;
        this.frecventaMHz = frecventaMHz;
        this.tip = tip;
    }

    public int getCapacitateGB() { return capacitateGB; }
    public int getFrecventaMHz() { return frecventaMHz; }
    public String getTip() { return tip; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "capacitategb": return capacitateGB;
            case "frecventamhz": return frecventaMHz;
            case "tip": return tip;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | RAM: %dGB, %dMHz, Tip: %s", capacitateGB, frecventaMHz, tip);
    }
}
