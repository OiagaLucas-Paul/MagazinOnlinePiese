public class PSU extends Produs {
    private int putere;
    private String format;

    public PSU(String id, String nume, double pret, String producator, int putere, String format) {
        super(id, nume, pret, producator);
        this.putere = putere;
        this.format = format;
    }

    public int getPutere() { return putere; }
    public String getFormat() { return format; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "putere": return putere;
            case "format": return format;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | PSU: %dW, Format: %s", putere, format);
    }
}
