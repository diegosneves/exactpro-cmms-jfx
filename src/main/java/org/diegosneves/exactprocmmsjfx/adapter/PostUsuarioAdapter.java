package org.diegosneves.exactprocmmsjfx.adapter;

import lombok.extern.slf4j.Slf4j;
import org.diegosneves.exactprocmmsjfx.model.Usuario;
import org.diegosneves.exactprocmmsjfx.response.UsuarioApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;


@Component
@Slf4j
public class PostUsuarioAdapter extends HttpAdapter {

    public static final String CREATE_USER_ENDPOINT = "/user/create";

    public UsuarioApiResponse postUsuario(Usuario usuario) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.apiUrl).pathSegment(CREATE_USER_ENDPOINT);
        try {
            ResponseEntity<UsuarioApiResponse> response = this.restTemplateSimpleWebClient.getRestTemplate().postForEntity(builder.build().toUri(), usuario, UsuarioApiResponse.class);
            return response.getBody();
        } catch (RestClientException e) {
            log.error(String.format("Fail: %s.postUsuario(Params...) -> [%s]", PostUsuarioAdapter.class.getSimpleName(), e.getMessage()), e);
        }
        return null;
    }

}
