package com.JoaoDev.ListaContados.Repository;

import com.JoaoDev.ListaContados.Dominio.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos,Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM CONTATOS x WHERE x.email= :email OR x.numero= :telefone")
    List<Contatos> procuraContatoCadastradado(@Param("email")String email, @Param("telefone")String telefone);

    @Query(nativeQuery = true, value = "SELECT * FROM contatos x WHERE lower(x.nome) LIKE LOWER(CONCAT('%', :informacao, '%')) OR lower(x.email) LIKE LOWER(CONCAT('%', :informacao, '%')) OR x.DDD LIKE CONCAT('%', :informacao, '%') OR x.numero LIKE CONCAT('%', :informacao, '%') OR x.id LIKE CONCAT('%', :informacao, '%')")
    List<Contatos> procurarContatoInformacao(@Param("informacao") String informacao);

}
