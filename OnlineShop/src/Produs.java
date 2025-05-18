public abstract class Produs {
    protected String id;
    protected String nume;
    protected double pret;
    protected String producator;

    public Produs(String id, String nume, double pret, String producator) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.producator = producator;
    }

    public String getId() { return id; }
    public String getNume() { return nume; }
    public double getPret() { return pret; }
    public String getProducator() { return producator; }

    public void setId(String id) { this.id = id; }
    public void setNume(String nume) { this.nume = nume; }
    public void setPret(double pret) { this.pret = pret; }

    public String getTip() {
        return this.getClass().getSimpleName();
    }

    public abstract Object getAtribut(String key);

    @Override
    public String toString() {
        return String.format("[%s] %s - %.2f RON - %s", id, nume, pret, producator);
    }
}
