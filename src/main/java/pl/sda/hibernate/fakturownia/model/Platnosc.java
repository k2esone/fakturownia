package pl.sda.hibernate.fakturownia.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double kwota;

    @Enumerated(EnumType.STRING)
    private FormaPlatnosci forma;

    @CreationTimestamp
    private LocalDateTime dataRealizacji;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Faktura faktura;

}
