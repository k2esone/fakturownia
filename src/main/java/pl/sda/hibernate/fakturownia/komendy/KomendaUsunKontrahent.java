package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

public class KomendaUsunKontrahent implements Komenda {
    private DataAccessObject<Kontrahent> dataAccessObject;

    public KomendaUsunKontrahent() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun kontrahent";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego kontrahenta:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Kontrahent.class, id)) {
            System.out.println("Usunieto kontrahenta!");
        } else {
            System.err.println("Nie udalo sie usunac kontrahenta!");
        }
    }
}
