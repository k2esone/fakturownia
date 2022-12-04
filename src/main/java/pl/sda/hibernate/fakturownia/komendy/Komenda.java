package pl.sda.hibernate.fakturownia.komendy;

import java.util.Scanner;

public interface Komenda {
    Scanner scanner = new Scanner(System.in);
    String getKomenda();
    void obsluga();
}
