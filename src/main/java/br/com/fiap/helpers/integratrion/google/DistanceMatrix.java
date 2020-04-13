package  br.com.fiap.helpers.integratrion.google;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A complete result from a Distance Matrix API call.
 *
 * @see <a
 *     href="https://developers.google.com/maps/documentation/distancematrix/#DistanceMatrixResponses">
 *     Distance Matrix Results</a>
 */
@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistanceMatrix implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Origin addresses as returned by the API from your original request. These are formatted by the
     * geocoder and localized according to the language parameter passed with the request.
     */
    public String[] originAddresses;

    /**
     * Destination addresses as returned by the API from your original request. As with {@link
     * #originAddresses}, these are localized if appropriate.
     */
    public String[] destinationAddresses;

    /**
     * An array of elements, each of which in turn contains a status, duration, and distance element.
     */
    public DistanceMatrixRow[] rows;


    @Override
    public String toString() {
        return String.format(
                "DistanceMatrix: %d origins x %d destinations, %d rows",
                originAddresses.length, destinationAddresses.length, rows.length);
    }
}