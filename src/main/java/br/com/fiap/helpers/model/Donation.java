package br.com.fiap.helpers.model;

import br.com.fiap.helpers.model.enums.DonationType;
import br.com.fiap.helpers.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Donation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(initialValue = 1, name = "generator", sequenceName = "donation_sequence")
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id")
    private Donor donor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recepient_id")
    private RecipientDonation recipient;

    private String description;
    private String additionInformation;

    @Enumerated(EnumType.STRING)
    private DonationType type;

    private Double value;
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private Status status;

}
