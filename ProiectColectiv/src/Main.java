import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login admin = new Login();
        Stock componente = new Stock();
        Cont cont = null;
        Cos cos = new Cos();

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Alege o optiune: ");
            int opt = scanner.nextInt();
            scanner.nextLine(); 

            if (opt == 1) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();

                boolean ok = admin.register(username, password, email);
                if (ok)
                    System.out.println("Cont creat cu succes!");
                else
                    System.out.println("Username deja folosit.");

            } else if (opt == 2) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                cont = admin.login(username, password);
                if (cont != null) {
                    System.out.println("Autentificare reusita. Bine ai venit, " + cont.getUser() + "!");
                    cos = new Cos(); 

                    while (true) {
                        System.out.println("\n1. Modificare email");
                        System.out.println("2. Schimbare parola");
                        System.out.println("3. Lista produse");
                        System.out.println("4. Adauga produs in cos");
                        System.out.println("5. Vezi cos");
                        System.out.println("6. Sterge produs din cos");
                        System.out.println("7. Checkout");
                        System.out.println("8. Logout");


                        System.out.print("Alege o optiune: ");
                        int opt2 = scanner.nextInt();
                        scanner.nextLine();

                        if (opt2 == 1) {
                            System.out.print("Email nou: ");
                            String newEmail = scanner.nextLine();
                            admin.updateEmail(cont.getUser(), newEmail);
                            System.out.println("Email actualizat.");
                        } else if (opt2 == 2) {
                            System.out.print("Parola veche: ");
                            String oldPass = scanner.nextLine();
                            System.out.print("Parola noua: ");
                            String newPass = scanner.nextLine();

                            boolean success = admin.updatePassword(cont.getUser(), oldPass, newPass);
                            if (success)
                                System.out.println("Parola a fost schimbata.");
                            else
                                System.out.println("Parola veche incorecta.");
                        } else if (opt2 == 3) {
                            System.out.println("\n--- Produse disponibile ---");
                            for (Componenta p : componente.getComponente()) {
                                System.out.println(p);
                            }
                        } else if (opt2 == 4) {
                            System.out.print("ID produs de adaugat in cos: ");
                            int id = scanner.nextInt();
                            Componenta p = componente.getComponenta(id);
                            if (p != null) {
                                cos.addProduct(p);
                                System.out.println("Produs adaugat in cos.");
                            } else {
                                System.out.println("Produs inexistent.");
                            }
                        } else if (opt2 == 5) {
                            cos.viewCos();
                        }else if (opt2 == 6) {
                            System.out.print("ID produs de sters din cos: ");
                            int idToRemove = scanner.nextInt();
                            boolean removed = cos.stergeComponenta(idToRemove);
                            if (removed)
                                System.out.println("Produs sters din cos.");
                            else
                                System.out.println("Produsul nu a fost gasit in cos.");
                        } else if (opt2 == 7) {
                            cos.viewCos();
                            System.out.println("Finalizare comanda...");
                            cos.clearCos();
                            System.out.println("Comanda plasata cu succes!");
                        } else if (opt2 == 8) {
                        	cont = null;
                            cos = new Cos();
                            System.out.println("Delogat cu succes.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Autentificare esuata.");
                }

            } else if (opt == 3) {
                System.out.println("La revedere!");
                break;
            }
        }

        scanner.close();
    }
}
