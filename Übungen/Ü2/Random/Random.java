static void main() {
    int untereGrenze = 10;
    int obereGrenze = 16;

    int zufallszahl = (int) (Math.random() * (obereGrenze - untereGrenze + 1)) + untereGrenze;
    
    System.out.println(zufallszahl);
}