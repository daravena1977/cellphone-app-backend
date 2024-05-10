package com.diegoaravena.cellphoneserviceapp.controllers;

import com.diegoaravena.cellphoneserviceapp.dtos.ClientDTO;
import com.diegoaravena.cellphoneserviceapp.models.subclass.Client;
import com.diegoaravena.cellphoneserviceapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/clients")
    public Set<ClientDTO> getClientsDTO(){
        return clientRepository
                .findAll()
                .stream()
                .map(ClientDTO::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/clients/id/{id}")
    public ClientDTO getClientDTO(@PathVariable Long id){
        Client client = clientRepository.findById(id).orElse(null);

        return new ClientDTO(client);
    }

    @GetMapping("/clients/dni/{dni}")
    public ClientDTO getClientDTO(@PathVariable String dni){
        Client client = clientRepository.findByDni(dni);
        return new ClientDTO(client);
    }

    @PostMapping("/clients")
    public ResponseEntity<Object> register(@RequestParam String dni,  @RequestParam String firstName, @RequestParam String lastName,
                                           @RequestParam String email, @RequestParam String password,
                                           @RequestParam String phoneNumber){

        if (dni.isBlank()){
            return new ResponseEntity<>("The dni data is missing", HttpStatus.FORBIDDEN);
        }

        if (firstName.isBlank()){
            return new ResponseEntity<>("The first name data is missing", HttpStatus.FORBIDDEN);
        }

        if (lastName.isBlank()){
            return new ResponseEntity<>("The last name data is missing", HttpStatus.FORBIDDEN);
        }

        if (email.isBlank()){
            return new ResponseEntity<>("The email data is missing", HttpStatus.FORBIDDEN);
        }

        if (password.isBlank()){
            return new ResponseEntity<>("The password data is missing", HttpStatus.FORBIDDEN);
        }

        if (phoneNumber.isBlank()){
            return new ResponseEntity<>("The phoneNumber data is missing", HttpStatus.FORBIDDEN);
        }

        if (clientRepository.existsByDni(dni)){
            return new ResponseEntity<>("This client exists in the database", HttpStatus.FORBIDDEN);
        }

        if (clientRepository.existsByEmail(email)){
            return new ResponseEntity<>("This email is already in use", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(dni, firstName, lastName, email, passwordEncoder.encode(password), phoneNumber);

        clientRepository.save(client);

        return new ResponseEntity<>("Client created successfully", HttpStatus.CREATED);
    }

    @PatchMapping("/clients")
    public ResponseEntity<Object> editClient(@RequestBody ClientDTO clientDTO){
        Client client = clientRepository.findById(clientDTO.getId()).orElse(null);

        if (client == null){
            return new ResponseEntity<>("This client don't exists", HttpStatus.FORBIDDEN);
        }

        if (clientDTO.getId() == null){
            return new ResponseEntity<>("The id data is missing", HttpStatus.FORBIDDEN);
        }

        if (clientDTO.getDni().isBlank()){
            return new ResponseEntity<>("The dni data is missing", HttpStatus.FORBIDDEN);
        }

        if (clientDTO.getFirstName().isBlank()){
            return new ResponseEntity<>("The first name data is missing", HttpStatus.FORBIDDEN);
        }

        if (clientDTO.getLastName().isBlank()){
            return new ResponseEntity<>("The last name data is missing", HttpStatus.FORBIDDEN);
        }

        if (clientDTO.getEmail().isBlank()){
            return new ResponseEntity<>("The email data is missing", HttpStatus.FORBIDDEN);
        }

        if (clientDTO.getPhoneNumber().isBlank()){
            return new ResponseEntity<>("The phone number data is missing", HttpStatus.FORBIDDEN);
        }

        client.setDni(clientDTO.getDni());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setPhoneNumber(clientDTO.getPhoneNumber());

        clientRepository.save(client);

        return new ResponseEntity<>("Update was successfully", HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Object> getClientByDni(@RequestParam String dni) {
        Client client = clientRepository.findByDni(dni);

        if (client == null) {
            return new ResponseEntity<>("El cliente no existe en la base de datos",
                    HttpStatus.NOT_FOUND);
        }

        ClientDTO clientDTO = new ClientDTO(client);

        return new ResponseEntity<>(clientDTO, HttpStatus.OK);

    }

}
