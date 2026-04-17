package com.senai.backend.controle_frequencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.backend.controle_frequencia.models.Usuario;
import com.senai.backend.controle_frequencia.services.UsuariosServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuariosServices usuariosServices;

    @GetMapping("/contar-usuarios")
    public Long contarUsuarios() {
        return usuariosServices.contarUsuarios();
    }

    @GetMapping("/buscar-usuario/{id}")
    public Usuario buscUsuario(@PathVariable Integer id) {
        return usuariosServices.buscarUsuario(id);
    }

    @GetMapping("/listar-usuarios")
    public List<Usuario> listarUsuarios() {
        return usuariosServices.listarUsuarios();
    }

    @DeleteMapping("/deletar-usuario/{id}")
    public String deletarUsuario(@PathVariable Integer id) {
        if (usuariosServices.deletarUsuario(id)) {
            return "Usuário deletado com sucesso";
        }
        return "Falha ao deletar o usuário";
    }

    @PostMapping("/salvar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuariosServices.cadastrarUsuario(usuario);
    }

    @PutMapping("/atualizar-usuario/{id}")
    public String atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        if (usuariosServices.atualizarUsuario(id, usuario) != null) {
            return "Usuário atualizado com sucesso";
        }
        return "Falha ao atualizar o usuário";

    }

}
