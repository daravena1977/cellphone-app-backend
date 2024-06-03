package com.diegoaravena.cellphoneserviceapp.services.implement;

import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;
import com.diegoaravena.cellphoneserviceapp.repositories.ClientRepository;
import com.diegoaravena.cellphoneserviceapp.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        return this.clientRepository.findById(id).orElse(null);
    }
}
