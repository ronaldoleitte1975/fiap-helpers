package br.com.fiap.helpers.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(initialValue = 1, name = "generator", sequenceName = "location_sequence")
    @Column
    private Long id;

    @JsonIgnore
    @OneToOne(fetch=FetchType.EAGER, mappedBy = "location", cascade = CascadeType.ALL)
    private Person person;

    private String latitude;
    private String longitude;
}
