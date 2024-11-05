package org.diegosneves.exactprocmmsjfx.mapper;


import org.diegosneves.exactprocmmsjfx.model.Endereco;
import org.diegosneves.exactprocmmsjfx.response.AddressApiResponse;

public class EnderecoFromAddressApiMapper {

    public Endereco mapperFrom(AddressApiResponse addressApiResponse) {
        return new Endereco(
                addressApiResponse.getStreet(),
                addressApiResponse.getNeighborhood(),
                addressApiResponse.getCity(),
                addressApiResponse.getState(),
                addressApiResponse.getZip());
    }

}
