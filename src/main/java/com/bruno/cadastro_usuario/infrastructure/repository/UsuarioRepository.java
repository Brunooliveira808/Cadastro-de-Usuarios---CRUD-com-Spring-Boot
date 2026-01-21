package com.bruno.cadastro_usuario.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bruno.cadastro_usuario.infrastructure.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	//Optional obriga a criar uma exceção caso aquele email nao exista
	Optional<Usuario> findByEmail(String email);
	
	@Transactional //qualquer erro que houver ele nao pode deletar
	void deleteByEmail(String email);
}
