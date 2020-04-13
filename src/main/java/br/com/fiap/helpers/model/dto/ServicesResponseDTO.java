package br.com.fiap.helpers.model.dto;

import br.com.fiap.helpers.model.Voluntier;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServicesResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Voluntier> voluntiers;
}
