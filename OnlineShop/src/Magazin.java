import java.util.*;
import java.util.stream.Collectors;

public class Magazin {

    private List<Produs> produse;
    private int nextId = 1;
    
    public Magazin() {
        produse = new ArrayList<>();
    }

    public void adaugaProdus(Produs p) {
        String idNou = "P" + nextId++;
        p.setId(idNou);
        produse.add(p);
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void afiseazaProduse() {
        if (produse.isEmpty()) {
            System.out.println("Nu exista produse in magazin.");
            return;
        }
        for (Produs p : produse) {
            System.out.println(p);
        }
    }

    public List<Produs> cautaProduse(String tip, Map<String, Object> filtre) {
        return produse.stream().filter(p -> {
            boolean tipCorect = false;
            switch (tip.toLowerCase()) {
                case "cpu": tipCorect = p instanceof CPU; break;
                case "gpu": tipCorect = p instanceof GPU; break;
                case "ram": tipCorect = p instanceof RAM; break;
                case "motherboard": tipCorect = p instanceof Motherboard; break;
                case "psu": tipCorect = p instanceof PSU; break;
                case "carcasa": tipCorect = p instanceof Carcasa; break;
                case "storage": tipCorect = p instanceof Storage; break;
                default: tipCorect = false;
            }
            if (!tipCorect) return false;

            if (p instanceof CPU) {
                CPU cpu = (CPU) p;
                if (filtre.containsKey("frecventaGHz") && cpu.getFrecventaGHz() != (double)filtre.get("frecventaGHz"))
                    return false;
                if (filtre.containsKey("nrNuclee") && cpu.getNrNuclee() != (int)filtre.get("nrNuclee"))
                    return false;
                if (filtre.containsKey("consumW") && cpu.getConsumW() != (int)filtre.get("consumW"))
                    return false;
                if (filtre.containsKey("socket") && !cpu.getSocket().equalsIgnoreCase((String)filtre.get("socket")))
                    return false;
            } else if (p instanceof GPU) {
                GPU gpu = (GPU) p;
                if (filtre.containsKey("memorieGB") && gpu.getMemorieGB() != (int)filtre.get("memorieGB"))
                    return false;
                if (filtre.containsKey("consumW") && gpu.getConsumW() != (int)filtre.get("consumW"))
                    return false;
            } else if (p instanceof RAM) {
                RAM ram = (RAM) p;
                if (filtre.containsKey("capacitateGB") && ram.getCapacitateGB() != (int)filtre.get("capacitateGB"))
                    return false;
                if (filtre.containsKey("frecventaMHz") && ram.getFrecventaMHz() != (int)filtre.get("frecventaMHz"))
                    return false;
                if (filtre.containsKey("tip") && !ram.getTip().equalsIgnoreCase((String)filtre.get("tip")))
                    return false;
            } else if (p instanceof Motherboard) {
                Motherboard mb = (Motherboard) p;
                if (filtre.containsKey("socket") && !mb.getSocket().equalsIgnoreCase((String)filtre.get("socket")))
                    return false;
                if (filtre.containsKey("chipset") && !mb.getChipset().equalsIgnoreCase((String)filtre.get("chipset")))
                    return false;
                if (filtre.containsKey("tipRam") && !mb.getTipRam().equalsIgnoreCase((String)filtre.get("tipRam")))
                    return false;
                if (filtre.containsKey("format") && !mb.getFormat().equalsIgnoreCase((String)filtre.get("format")))
                    return false;
                if (filtre.containsKey("sloturiRam") && mb.getSloturiRam() != (int)filtre.get("sloturiRam"))
                    return false;
                if (filtre.containsKey("sloturiM2") && mb.getSloturiM2() != (int)filtre.get("sloturiM2"))
                    return false;
            } else if (p instanceof PSU) {
                PSU psu = (PSU) p;
                if (filtre.containsKey("putere") && psu.getPutere() != (int)filtre.get("putere"))
                    return false;
                if (filtre.containsKey("format") && !psu.getFormat().equalsIgnoreCase((String)filtre.get("format")))
                    return false;
            } else if (p instanceof Carcasa) {
                Carcasa carcasa = (Carcasa) p;
                if (filtre.containsKey("tip") && !carcasa.getTip().equalsIgnoreCase((String)filtre.get("tip")))
                    return false;
                if (filtre.containsKey("formatCompatibil") && !carcasa.getFormatCompatibil().equalsIgnoreCase((String)filtre.get("formatCompatibil")))
                    return false;
            } else if (p instanceof Storage) {
                Storage storage = (Storage) p;
                if (filtre.containsKey("tip") && !storage.getTip().equalsIgnoreCase((String)filtre.get("tip")))
                    return false;
                if (filtre.containsKey("capacitateGB") && storage.getCapacitateGB() != (int)filtre.get("capacitateGB"))
                    return false;
                if (filtre.containsKey("vitezaCitire") && storage.getVitezaCitire() != (int)filtre.get("vitezaCitire"))
                    return false;
                if (filtre.containsKey("vitezaScriere") && storage.getVitezaScriere() != (int)filtre.get("vitezaScriere"))
                    return false;
            }

            return true;
        }).collect(Collectors.toList());
    }

    public void verificaCompatibilitate() {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Produs>> grupate = produse.stream()
            .filter(p -> p instanceof CPU || p instanceof Motherboard || p instanceof RAM
                    || p instanceof PSU || p instanceof Carcasa || p instanceof GPU)
            .collect(Collectors.groupingBy(p -> {
                if (p instanceof CPU) return "cpu";
                if (p instanceof GPU) return "gpu";
                if (p instanceof Motherboard) return "motherboard";
                if (p instanceof RAM) return "ram";
                if (p instanceof PSU) return "psu";
                if (p instanceof Carcasa) return "carcasa";
                return "unknown";
            }));

        java.util.function.Function<List<Produs>, Produs> alegeProdus = (lista) -> {
            if (lista.size() == 1) return lista.get(0);

            System.out.println("\nSelecteaza o componenta din lista:");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + lista.get(i));
            }
            int opt;
            while (true) {
                System.out.print("Alege un numar (1-" + lista.size() + "): ");
                try {
                    opt = Integer.parseInt(scanner.nextLine());
                    if (opt >= 1 && opt <= lista.size()) break;
                } catch (Exception e) {}
                System.out.println("Optiune invalida, incearca din nou.");
            }
            return lista.get(opt - 1);
        };

        CPU cpu = null;
        Motherboard mb = null;
        RAM ram = null;
        PSU psu = null;
        Carcasa carcasa = null;
        int consumTotal = 0;

        boolean areIncompatibilitati = false;

        if (grupate.containsKey("cpu")) {
            cpu = (CPU) alegeProdus.apply(grupate.get("cpu"));
            consumTotal += cpu.getConsumW();
        }

        if (grupate.containsKey("gpu")) {
            for (Produs gpuProd : grupate.get("gpu")) {
                GPU gpu = (GPU) gpuProd;
                consumTotal += gpu.getConsumW();
            }
        }

        if (grupate.containsKey("motherboard")) {
            mb = (Motherboard) alegeProdus.apply(grupate.get("motherboard"));
        }

        if (grupate.containsKey("ram")) {
            ram = (RAM) alegeProdus.apply(grupate.get("ram"));
        }

        if (grupate.containsKey("psu")) {
            psu = (PSU) alegeProdus.apply(grupate.get("psu"));
        }

        if (grupate.containsKey("carcasa")) {
            carcasa = (Carcasa) alegeProdus.apply(grupate.get("carcasa"));
        }

        System.out.println("\n--- Verificare compatibilitate ---");

        if (cpu != null && mb != null) {
            if (!cpu.getSocket().equalsIgnoreCase(mb.getSocket())) {
                System.out.println("CPU si Motherboard au socket diferit!");
                areIncompatibilitati = true;
            } else {
                System.out.println("Socket CPU si Motherboard sunt compatibile.");
            }
        } else {
            if (cpu == null) System.out.println("Lipseste CPU pentru verificare socket.");
            if (mb == null) System.out.println("Lipseste Motherboard pentru verificare socket.");
        }

        if (ram != null && mb != null) {
            if (!ram.getTip().equalsIgnoreCase(mb.getTipRam())) {
                System.out.println("RAM-ul nu este compatibil cu tipul de RAM acceptat de Motherboard!");
                areIncompatibilitati = true;
            } else {
                System.out.println("RAM-ul este compatibil cu Motherboard.");
            }
        } else {
            if (ram == null) System.out.println("Lipseste RAM pentru verificare.");
            if (mb == null) System.out.println("Lipseste Motherboard pentru verificare RAM.");
        }

        if (psu != null) {
            int puterePSU = psu.getPutere();
            int necesar = (int)(consumTotal * 1.5);
            if (puterePSU < necesar) {
                System.out.printf("PSU are %dW, dar necesarul este %dW (%.0fW * 1.5)%n", puterePSU, necesar, (float)consumTotal);
                areIncompatibilitati = true;
            } else {
                System.out.println("PSU are puterea necesara.");
            }
        } else {
            System.out.println("Lipseste PSU pentru verificare putere.");
        }

        if (carcasa != null && mb != null) {
            if (!carcasa.getFormatCompatibil().equalsIgnoreCase(mb.getFormat())) {
                System.out.println("Carcasa nu este compatibila cu formatul placii de baza!");
                areIncompatibilitati = true;
            } else {
                System.out.println("Carcasa este compatibila cu placa de baza.");
            }
        } else {
            if (carcasa == null) System.out.println("Lipseste Carcasa pentru verificare format.");
            if (mb == null) System.out.println("Lipseste Motherboard pentru verificare carcasa.");
        }

        if (carcasa != null && psu != null) {
            if (!carcasa.getFormatCompatibil().equalsIgnoreCase(psu.getFormat())) {
                System.out.println("Carcasa nu este compatibila cu formatul sursei de alimentare!");
                areIncompatibilitati = true;
            } else {
                System.out.println("Carcasa este compatibila cu sursa de alimentare.");
            }
        } else {
            if (carcasa == null) System.out.println("Lipseste Carcasa pentru verificare format sursa.");
            if (psu == null) System.out.println("Lipseste PSU pentru verificare carcasa.");
        }

        if (!areIncompatibilitati) {
            System.out.println("\nToate componentele selectate sunt compatibile!");
        }
    }
}
