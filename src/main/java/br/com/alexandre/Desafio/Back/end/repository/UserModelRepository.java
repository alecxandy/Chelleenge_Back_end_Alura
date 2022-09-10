package br.com.alexandre.Desafio.Back.end.repository;

import br.com.alexandre.Desafio.Back.end.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, UUID> {


    Optional<UserModel> findByName(String nome);
}
