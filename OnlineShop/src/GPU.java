public class GPU extends Produs {
    private int memorieGB;
    private int consumW;

    public GPU(String id, String nume, double pret, String producator, int memorieGB, int consumW) {
        super(id, nume, pret, producator);
        this.memorieGB = memorieGB;
        this.consumW = consumW;
    }

    public int getMemorieGB() { return memorieGB; }
    public int getConsumW() { return consumW; }

    @Override
    public Object getAtribut(String key) {
        switch(key.toLowerCase()) {
            case "id": return id;
            case "nume": return nume;
            case "pret": return pret;
            case "producator": return producator;
            case "memoriegb": return memorieGB;
            case "consumw": return consumW;
            default: return null;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | GPU: %dGB, %dW", memorieGB, consumW);
    }
}
