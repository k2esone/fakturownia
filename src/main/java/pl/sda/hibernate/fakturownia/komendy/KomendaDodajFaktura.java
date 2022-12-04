package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KomendaDodajFaktura implements Komenda {

    private DataAccessObject<Faktura> dao = new DataAccessObject<Faktura>();

    @Override
    public String getKomenda() {
        return "dodaj fakture";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj numer faktury");
        String numer = Komenda.scanner.nextLine();

        System.out.println("Podaj termin platnosci");
        String terminString = Komenda.scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate termin = LocalDate.parse(terminString, dateTimeFormatter);

        System.out.println("Podaj kwote");
        String kwotaString = Komenda.scanner.nextLine();
        Double kwota = Double.parseDouble(kwotaString);

        Faktura faktura = Faktura.builder()
                .numerFaktury(numer)
                .terminPlatnosci(termin)
                .kwota(kwota)
                .build();

        dao.insert(faktura);


    }
}
