package com.ControleAcessoMundoSENAI.ControleAcesso.Repository;

import com.ControleAcessoMundoSENAI.ControleAcesso.Model.M_Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Pessoa extends JpaRepository<M_Pessoa, Long> {

    @Query(value = "INSERT INTO pessoa (nome, cpf, email, telefone, senha", nativeQuery = true)
    M_Pessoa cadastrarPessoa(@Param("nome") String nome, @Param("cpf") String cpf, @Param("email") String email, @Param("telefone") String telefone,
    @Param("senha") String senha);

    @Query(value = "SELECT * FROM pessoa WHERE id = :id", nativeQuery = true)
    M_Pessoa findById(@Param("id") String id);
}