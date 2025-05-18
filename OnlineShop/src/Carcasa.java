public class Carcasa extends Produs {
    private String tip;
    private String formatCompatibil;

    public Carcasa(String id, String nume, double pret, String producator, String tip, String formatCompatibil) {
        super(id, nume, pret, producator);
        this.tip = tip;
        this.formatCompatibil = formatCompatibil;
    }

    public String getTip() { return tip; }
    public String getFormatCompatibil() { return formatCompatibil; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "tip": return tip;
            case "formatcompatibil": return formatCompatibil;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Carcasa: %s, Compatibil: %s", tip, formatCompatibil);
    }
}
