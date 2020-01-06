package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsuarioResource {

    @Autowired
    private UsuarioRepository repositorio;

        public UsuarioResource(UsuarioRepository repositorio){
            this.repositorio = repositorio;
    }
    @RequestMapping(value = "/clientes/", method = RequestMethod.GET)
        public List<Usuario> buscarUsuario(@RequestParam(required = false) String nome) {
            return this.repositorio.findAll();
    }
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)
        public Optional<Usuario> buscarClientes(@PathVariable Long id) {
            return this.repositorio.findById(id);
    }
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
        public void removerClietes(@PathVariable Long id) {
            this.repositorio.deleteById(id);
    }
    @RequestMapping(value = "/clientes/", method = RequestMethod.POST)
        public Usuario criarUsuario(@RequestBody Usuario usuario) {
            String nome = usuario.getNome();
            String sobrenome= usuario.getSobrenome();
            String senha = usuario.getSenha();
                return this.repositorio.save(new Usuario(nome, sobrenome, senha));
}
    @RequestMapping(value ="/clientes/{id}", method=RequestMethod.PUT)
        public void alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioParam) {
            Usuario usuario = this.repositorio.findById(id).get();
            usuario.setNome(usuarioParam.getNome());
            usuario.setSobrenome(usuarioParam.getSobrenome());
            usuario.setSenha(usuarioParam.getSenha());
                this.repositorio.save(usuario);
  }
}