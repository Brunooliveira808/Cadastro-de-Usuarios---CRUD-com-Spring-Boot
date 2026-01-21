package com.bruno.cadastro_usuario.business;

import org.springframework.stereotype.Service;

import com.bruno.cadastro_usuario.infrastructure.entities.Usuario;
import com.bruno.cadastro_usuario.infrastructure.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.repository = usuarioRepository;
	} 
	
	public void salvarUsuario(Usuario usuario) {
		repository.saveAndFlush(usuario);
	}
	
	
	public Usuario buscarUsuarioPorEmail(String email) {
		return repository.findByEmail(email).orElseThrow(
				() -> new RuntimeException("Email não encontrado")
				);
	}
	
	public void deletarUsuarioPorEmail(String email) {	
		repository.deleteByEmail(email);
	}
	
	public void atualizarUsuarioPorEmail(String email, Usuario usuario) {
		Usuario usuarioEntity = buscarUsuarioPorEmail(email);
		Usuario usuarioAtualizado = Usuario.builder()
				.email(email)
				.nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
				.id(usuarioEntity.getId())
				.build();

		repository.saveAndFlush(usuarioAtualizado);
	}
	
	public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
		Usuario usuarioEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		Usuario usuarioAtualizado = Usuario.builder()
				.email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
				.nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
				.id(usuarioEntity.getId())
				.build();
		
		repository.saveAndFlush(usuarioAtualizado);
	}

}
