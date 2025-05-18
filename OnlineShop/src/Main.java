import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Magazin magazin = new Magazin();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Meniu Magazin Componente PC ---");
            System.out.println("1. Adauga produs");
            System.out.println("2. Afiseaza toate produsele");
            System.out.println("3. Cauta produse dupa tip si filtre");
            System.out.println("4. Verifica compatibilitatea componentelor");
            System.out.println("5. Iesire");
            System.out.print("Alege o optiune: ");

            int optiune = Integer.parseInt(scanner.nextLine());

            switch (optiune) {
                case 1:
                    adaugaProdus(magazin, scanner);
                    break;
                case 2:
                    magazin.afiseazaProduse();
                    break;
                case 3:
                    System.out.print("Introdu tipul produsului (ex: CPU, GPU, RAM, Motherboard, PSU, Carcasa, Storage): ");
                    String tip = scanner.nextLine();

                    Map<String, Object> filtre = new HashMap<>();

                    if (tip.equalsIgnoreCase("CPU")) {
                        System.out.print("Frecventa (GHz) [ENTER pentru skip]: ");
                        String f = scanner.nextLine();
                        if (!f.isEmpty()) filtre.put("frecventaGHz", Double.parseDouble(f));

                        System.out.print("Numar nuclee [ENTER pentru skip]: ");
                        String n = scanner.nextLine();
                        if (!n.isEmpty()) filtre.put("nrNuclee", Integer.parseInt(n));

                        System.out.print("Consum (W) [ENTER pentru skip]: ");
                        String c = scanner.nextLine();
                        if (!c.isEmpty()) filtre.put("consumW", Integer.parseInt(c));

                        System.out.print("Socket [ENTER pentru skip]: ");
                        String s = scanner.nextLine();
                        if (!s.isEmpty()) filtre.put("socket", s);

                    } else if (tip.equalsIgnoreCase("GPU")) {
                        System.out.print("Memorie (GB) [ENTER pentru skip]: ");
                        String mem = scanner.nextLine();
                        if (!mem.isEmpty()) filtre.put("memorieGB", Integer.parseInt(mem));

                        System.out.print("Consum (W) [ENTER pentru skip]: ");
                        String c = scanner.nextLine();
                        if (!c.isEmpty()) filtre.put("consumW", Integer.parseInt(c));

                    } else if (tip.equalsIgnoreCase("RAM")) {
                        System.out.print("Capacitate (GB) [ENTER pentru skip]: ");
                        String cap = scanner.nextLine();
                        if (!cap.isEmpty()) filtre.put("capacitateGB", Integer.parseInt(cap));

                        System.out.print("Frecventa (MHz) [ENTER pentru skip]: ");
                        String f = scanner.nextLine();
                        if (!f.isEmpty()) filtre.put("frecventaMHz", Integer.parseInt(f));

                        System.out.print("Tip RAM (ex: DDR4) [ENTER pentru skip]: ");
                        String t = scanner.nextLine();
                        if (!t.isEmpty()) filtre.put("tip", t);

                    } else if (tip.equalsIgnoreCase("Motherboard")) {
                        System.out.print("Socket [ENTER pentru skip]: ");
                        String s = scanner.nextLine();
                        if (!s.isEmpty()) filtre.put("socket", s);

                        System.out.print("Chipset [ENTER pentru skip]: ");
                        String ch = scanner.nextLine();
                        if (!ch.isEmpty()) filtre.put("chipset", ch);

                        System.out.print("Tip RAM [ENTER pentru skip]: ");
                        String tr = scanner.nextLine();
                        if (!tr.isEmpty()) filtre.put("tipRam", tr);

                        System.out.print("Format [ENTER pentru skip]: ");
                        String f = scanner.nextLine();
                        if (!f.isEmpty()) filtre.put("format", f);

                        System.out.print("Numar sloturi RAM [ENTER pentru skip]: ");
                        String sr = scanner.nextLine();
                        if (!sr.isEmpty()) filtre.put("sloturiRam", Integer.parseInt(sr));

                        System.out.print("Numar sloturi M.2 [ENTER pentru skip]: ");
                        String sm = scanner.nextLine();
                        if (!sm.isEmpty()) filtre.put("sloturiM2", Integer.parseInt(sm));

                    } else if (tip.equalsIgnoreCase("PSU")) {
                        System.out.print("Putere (W) [ENTER pentru skip]: ");
                        String p = scanner.nextLine();
                        if (!p.isEmpty()) filtre.put("putere", Integer.parseInt(p));

                        System.out.print("Format (ex: ATX) [ENTER pentru skip]: ");
                        String f = scanner.nextLine();
                        if (!f.isEmpty()) filtre.put("format", f);

                    } else if (tip.equalsIgnoreCase("Carcasa")) {
                        System.out.print("Tip carcasa (ex: Mid Tower) [ENTER pentru skip]: ");
                        String t = scanner.nextLine();
                        if (!t.isEmpty()) filtre.put("tip", t);

                        System.out.print("Format compatibil (ex: ATX) [ENTER pentru skip]: ");
                        String f = scanner.nextLine();
                        if (!f.isEmpty()) filtre.put("formatCompatibil", f);

                    } else if (tip.equalsIgnoreCase("Storage")) {
                        System.out.print("Tip storage (ex: SSD, HDD) [ENTER pentru skip]: ");
                        String t = scanner.nextLine();
                        if (!t.isEmpty()) filtre.put("tip", t);

                        System.out.print("Capacitate (GB) [ENTER pentru skip]: ");
                        String c = scanner.nextLine();
                        if (!c.isEmpty()) filtre.put("capacitateGB", Integer.parseInt(c));

                        System.out.print("Viteza citire (MB/s) [ENTER pentru skip]: ");
                        String vc = scanner.nextLine();
                        if (!vc.isEmpty()) filtre.put("vitezaCitire", Integer.parseInt(vc));

                        System.out.print("Viteza scriere (MB/s) [ENTER pentru skip]: ");
                        String vs = scanner.nextLine();
                        if (!vs.isEmpty()) filtre.put("vitezaScriere", Integer.parseInt(vs));
                    } else {
                        System.out.println("Tip produs necunoscut.");
                        break;
                    }

                    List<Produs> rezultate = magazin.cautaProduse(tip, filtre);
                    if (rezultate.isEmpty()) {
                        System.out.println("Nu s-au gasit produse care sa corespunda.");
                    } else {
                        System.out.println("Rezultate gasite:");
                        for (Produs p : rezultate) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    magazin.verificaCompatibilitate();
                    break;

                case 5:
                    running = false;
                    System.out.println("La revedere!");
                    break;

                default:
                    System.out.println("Optiune invalida.");
            }
        }

        scanner.close();
    }

    private static void adaugaProdus(Magazin magazin, Scanner scanner) {
        System.out.println("Alege tipul produsului:");
        System.out.println("1. CPU");
        System.out.println("2. GPU");
        System.out.println("3. PSU");
        System.out.println("4. RAM");
        System.out.println("5. Motherboard");
        System.out.println("6. Carcasa");
        System.out.println("7. Storage");
        System.out.print("Tip produs: ");

        int tip = Integer.parseInt(scanner.nextLine());

        System.out.print("Nume produs: ");
        String nume = scanner.nextLine();

        System.out.print("Pret produs (RON): ");
        double pret = Double.parseDouble(scanner.nextLine());

        System.out.print("Producator: ");
        String producator = scanner.nextLine();

        switch (tip) {
            case 1:
                System.out.print("Frecventa (GHz): ");
                double frecventa = Double.parseDouble(scanner.nextLine());

                System.out.print("Numar nuclee: ");
                int nuclee = Integer.parseInt(scanner.nextLine());

                System.out.print("Consum (W): ");
                int consum = Integer.parseInt(scanner.nextLine());

                System.out.print("Socket: ");
                String socket = scanner.nextLine();

                CPU cpu = new CPU("", nume, pret, producator, frecventa, nuclee, consum, socket);
                magazin.adaugaProdus(cpu);
                break;

            case 2:
                System.out.print("Memorie (GB): ");
                int memorie = Integer.parseInt(scanner.nextLine());

                System.out.print("Consum (W): ");
                int consumGpu = Integer.parseInt(scanner.nextLine());

                GPU gpu = new GPU("", nume, pret, producator, memorie, consumGpu);
                magazin.adaugaProdus(gpu);
                break;

            case 3:
                System.out.print("Putere (W): ");
                int putere = Integer.parseInt(scanner.nextLine());

                System.out.print("Format (ex: ATX): ");
                String formatPsu = scanner.nextLine();

                PSU psu = new PSU("", nume, pret, producator, putere, formatPsu);
                magazin.adaugaProdus(psu);
                break;

            case 4:
                System.out.print("Capacitate (GB): ");
                int capacitate = Integer.parseInt(scanner.nextLine());

                System.out.print("Frecventa (MHz): ");
                int frecventaRam = Integer.parseInt(scanner.nextLine());

                System.out.print("Tip RAM (ex: DDR4): ");
                String tipRam = scanner.nextLine();

                RAM ram = new RAM("", nume, pret, producator, capacitate, frecventaRam, tipRam);
                magazin.adaugaProdus(ram);
                break;

            case 5:
                System.out.print("Socket: ");
                String socketMb = scanner.nextLine();

                System.out.print("Chipset: ");
                String chipset = scanner.nextLine();

                System.out.print("Tip RAM: ");
                String tipRamMb = scanner.nextLine();

                System.out.print("Format: ");
                String formatMb = scanner.nextLine();

                System.out.print("Numar sloturi RAM: ");
                int sloturiRam = Integer.parseInt(scanner.nextLine());

                System.out.print("Numar sloturi M.2: ");
                int sloturiM2 = Integer.parseInt(scanner.nextLine());

                Motherboard mb = new Motherboard("", nume, pret, producator, socketMb, chipset, tipRamMb, formatMb, sloturiRam, sloturiM2);
                magazin.adaugaProdus(mb);
                break;

            case 6:
                System.out.print("Tip carcasa (ex: Mid Tower): ");
                String tipCarcasa = scanner.nextLine();

                System.out.print("Format compatibil (ex: ATX): ");
                String formatCarcasa = scanner.nextLine();

                Carcasa carcasa = new Carcasa("", nume, pret, producator, tipCarcasa, formatCarcasa);
                magazin.adaugaProdus(carcasa);
                break;

            case 7:
                System.out.print("Tip storage (ex: SSD, HDD): ");
                String tipStorage = scanner.nextLine();

                System.out.print("Capacitate (GB): ");
                int capacitateStorage = Integer.parseInt(scanner.nextLine());

                System.out.print("Viteza citire (MB/s): ");
                int vitezaCitire = Integer.parseInt(scanner.nextLine());

                System.out.print("Viteza scriere (MB/s): ");
                int vitezaScriere = Integer.parseInt(scanner.nextLine());

                Storage storage = new Storage("", nume, pret, producator, tipStorage, capacitateStorage, vitezaCitire, vitezaScriere);
                magazin.adaugaProdus(storage);
                break;

            default:
                System.out.println("Tip produs invalid.");
                return;
        }
        System.out.println("Produs adaugat cu succes!");
    }
}
