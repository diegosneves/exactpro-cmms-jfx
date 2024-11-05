package org.diegosneves.exactprocmmsjfx.adapter;

import lombok.extern.slf4j.Slf4j;
import org.diegosneves.exactprocmmsjfx.response.AddressApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Classe concreta estendendo {@link HttpAdapter}, responsável por recuperar informações de endereço
 * com base no CEP fornecido.
 * <p>
 * Ela quer dizer que a classe é detectável durante a inicialização do Spring para injeção de dependência e bem
 * como para logging respectivamente.
 * <p>
 * O {@link Autowired @Autowired} em seu contrutor garante a injeção automática de valores da propriedade do Spring.
 *
 * @author diegoneves
 * @since 1.0.0
 */
@Component
@Slf4j
public class RetrieveAddressAdapter extends HttpAdapter {


    public static final String ADDRESS_ENDPOINT = "address";

    /**
     * Recupera informações de endereço com base no CEP fornecido usando a URL fornecida.
     * <p>
     * Este método utiliza o {@link RestTemplate} para fazer a chamada para a API e retorna o corpo da
     * resposta como um {@link AddressApiResponse AddressApiResponse}.
     *
     * @param zipcode O CEP para o qual recuperar as informações de endereço.
     * @return Um objeto {@link AddressApiResponse AddressApiResponse} contendo os detalhes do endereço.
     */
    public AddressApiResponse retrieveAddress(String zipcode) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.apiUrl).pathSegment(ADDRESS_ENDPOINT, zipcode);
        try {
            ResponseEntity<AddressApiResponse> response = this.restTemplateSimpleWebClient.getRestTemplate()
                    .getForEntity(builder.toUriString(), AddressApiResponse.class);
            return response.getBody();
        } catch (RestClientException e) {
            log.error(String.format("Fail: %s.retrieveAddress(Params...) -> [%s]", AddressApiResponse.class.getSimpleName(), e.getMessage()), e);
        }
        return null;
    }

}
