package  br.com.fiap.helpers.integratrion;

import br.com.fiap.helpers.model.Donor;
import br.com.fiap.helpers.model.Location;
import br.com.fiap.helpers.model.Voluntier;
import  br.com.fiap.helpers.integratrion.google.DistanceMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationIntegration {

    @Value("${google.url}")
    private String apiUrl;

    @Value("${google.key}")
    private String apiKey;

    private String destinations = "&destinations=";

    private String origins = "origins=";

    private String key = "&key=";

    private DistanceMatrix distanceMatrix;

    @Value("${google.distance}")
    private long distanceLimit;

    private String completedUrl;

    private RestTemplate restTemplate;

    public List<Voluntier> getNextVoluntiers(Location location, List<Voluntier> allVoluntiers) {

        List<Voluntier> returedVoluntiers = new ArrayList<>();

        restTemplate = new RestTemplate();

        key = key + apiKey;

        for (Voluntier voluntier : allVoluntiers) {

            destinations = destinations + String.valueOf(voluntier.getLocation().getLatitude()) + "," + String.valueOf(
                    voluntier.getLocation().getLongitude());

            completedUrl = apiUrl + origins + String.valueOf(location.getLatitude()) + "," + location.getLongitude() + destinations;

            completedUrl = completedUrl + destinations + key;

            try {

                ResponseEntity<DistanceMatrix> responseEntity =
                        restTemplate.exchange(completedUrl, HttpMethod.GET, HttpEntity.EMPTY, DistanceMatrix.class);


                DistanceMatrix distanceMatrix = responseEntity.getBody();

                long distance = distanceMatrix.rows[0].elements[0].distance.inMeters;

                if (distance <= distanceLimit) {
                    returedVoluntiers.add(voluntier);
                }

            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (HttpClientErrorException http) {
                http.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return returedVoluntiers;
    }

    public List<Donor> getNextDonors(Location location, List<Donor> allDonors) {

        List<Donor> returnedDonors = new ArrayList<>();

        restTemplate = new RestTemplate();

        key = key + apiKey;

        for (Donor donor : allDonors) {

            destinations = destinations + String.valueOf(donor.getLocation().getLatitude()) + "," + String.valueOf(
                    donor.getLocation().getLongitude());

            completedUrl = apiUrl + origins + String.valueOf(location.getLatitude()) + "," + location.getLongitude() + destinations;

            completedUrl = completedUrl + destinations + key;

            try {

                ResponseEntity<DistanceMatrix> responseEntity =
                        restTemplate.exchange(completedUrl, HttpMethod.GET, HttpEntity.EMPTY, DistanceMatrix.class);


                DistanceMatrix distanceMatrix = responseEntity.getBody();

                long distance = distanceMatrix.rows[0].elements[0].distance.inMeters;

                if (distance <= distanceLimit) {
                    returnedDonors.add(donor);
                }

            } catch (NullPointerException npe) {
                npe.printStackTrace();
            } catch (HttpClientErrorException http) {
                http.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return returnedDonors;
    }
}
