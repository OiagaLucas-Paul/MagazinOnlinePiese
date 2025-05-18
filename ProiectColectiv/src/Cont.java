public class Cont {
    private String user;
    private String parola;
    private String email;

    public Cont(String user, String parola, String email) {
        this.user = user;
        this.parola = parola;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public String getParola() {
        return parola;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setParola(String parola) {
        this.parola = parola;
    }

}
