package br.com.fiap.helpers.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URI;
import java.util.List;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Voluntier extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(initialValue = 1, name = "generator", sequenceName = "voluntier_sequence")
    @Column
    private Long id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ProvidedService> providedServices;

    private String uri;

}
