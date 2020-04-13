package br.com.fiap.helpers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Person {

    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(initialValue = 1, name = "generator", sequenceName = "person_sequence")
    @Column
    private Long id;

    @Column(unique = true,  nullable = false)
    private String cpf;

    private String name;
    private String celPhoneNumber;
    private String email;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDateTime createdDt;


}
