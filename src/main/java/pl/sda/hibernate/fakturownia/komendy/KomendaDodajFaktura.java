package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class KomendaDodajFaktura implements Komenda {

    private DataAccessObject<Faktura> dao = new DataAccessObject<Faktura>();
    private DataAccessObject<Firma> daoFirma = new DataAccessObject<>();
    private DataAccessObject<Kontrahent> daoKontrahent = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj fakture";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id firmy:");
        String idFirmyString = Komenda.scanner.nextLine();
        Long idFirmy = Long.parseLong(idFirmyString);
        Optional<Firma> firmaOptional = daoFirma.find(Firma.class, idFirmy);
        if (firmaOptional.isEmpty()) {
            System.err.println("Firma o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj id kontrahenta:");
        String idKontrahentaString = Komenda.scanner.nextLine();
        Long idKontrahenta = Long.parseLong(idKontrahentaString);
        Optional<Kontrahent> kontrahentOptional = daoKontrahent.find(Kontrahent.class, idKontrahenta);
        if (kontrahentOptional.isEmpty()) {
            System.err.println("Kontrahent o podanym id nie istnieje");
            return;
        }
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
                .kontrahent(kontrahentOptional.get())
                .firma(firmaOptional.get())
                .numerFaktury(numer)
                .terminPlatnosci(termin)
                .kwota(kwota)
                .build();

        dao.insert(faktura);


    }
}
