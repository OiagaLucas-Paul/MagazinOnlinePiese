import java.util.HashMap;

public class Login {
    private HashMap<String, Cont> users = new HashMap<>();

    public boolean register(String username, String parola, String email) {
        if (users.containsKey(username)) {
            return false; 
        }
        users.put(username, new Cont(username, parola, email));
        return true;
    }

    public Cont login(String username, String parola) {
        if (!users.containsKey(username)) return null;
        Cont user = users.get(username);
        if (user.getParola().equals(parola)) {
            return user;
        }
        return null;
    }
    
    public boolean updateEmail(String username, String newEmail) {
        Cont user = users.get(username);
        if (user != null) {
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }

    public boolean updatePassword(String username, String parolaVeche, String parolaNoua) {
        Cont user = users.get(username);
        if (user != null && user.getParola().equals(parolaVeche)) {
            user.setParola(parolaNoua);
            return true;
        }
        return false;
    }

}
