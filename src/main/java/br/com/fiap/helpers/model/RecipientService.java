package br.com.fiap.helpers.model;

import br.com.fiap.helpers.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class RecipientService extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(initialValue = 1, name = "generator", sequenceName = "recipient_service_sequence")
    @Column
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "recipient", cascade = CascadeType.ALL)
    private ReceivedService service;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime date;

}
