package com.example.emsbackend.repository;

import com.example.emsbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    //Rechercher le client par son email
    Client findByEmail(String email);


}
