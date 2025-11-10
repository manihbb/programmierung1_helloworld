// Produkte:
// * Namen
// * Netto-Preis
// * MwSt von 19 % für jedes Produkt
// * Netto-Preis ausgeben
// * Brutto-Preis ausgeben
// * Beschreibung mit Name + Brutto-Preis ausgeben

class Produkt {

    private final String name;
    private final int nettoPreis;
//     private double steuersatz = 0.19;
    static final double STEUERSATZ = 0.19;
    
    private static int anzahlProdukte = 0;
    
    Produkt(String name, int nettoPreis) {
        this.name = name;
        this.nettoPreis = nettoPreis;
        anzahlProdukte++;
    }
    
    int getNettoPreis() {
        return nettoPreis;
    }
    
    int getBruttoPreis() {
        return (int)(nettoPreis * (1 + STEUERSATZ));
    }
    
    public String toString() {
        return name + " " + this.getBruttoPreis() / 100.0 + " €"; // Punkt- vor Strich-Rechnung
    }
    
    static int getAnzahlProdukte() {
        return anzahlProdukte; //this geht nicht in static
    }
    
    // Wir können die main-Methode auch in eine Klasse schreiben, wenn wir nur kurz was testen wollen.
    static void main() {
        Produkt produkt = new Produkt("TV", 190_00);
        System.out.println(produkt.getBruttoPreis());
        System.out.println(produkt.getNettoPreis());
        System.out.println(produkt);
        // jetzt kann ich Produkte durch die Gegend schupsen und muss nicht
        // * String + double rumreichen
        // * keine Gedanken, wie Netto-Preis berechnet wird
        System.out.println(Produkt.STEUERSATZ);
        System.out.println(produkt.STEUERSATZ); //unüblich
        
        System.out.println(produkt.getAnzahlProdukte());
        new Produkt("Mikrowelle", 44_99);
        System.out.println(produkt.getAnzahlProdukte()); // Achtung: nur deklarierte Klasse zählt
        System.out.println(Produkt.getAnzahlProdukte());
    }
}

