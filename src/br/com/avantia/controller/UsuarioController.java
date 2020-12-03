/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avantia.controller;
import br.com.avantia.model.Usuario;
import br.com.avantia.dados.RepositorioUsuario;
import java.util.ArrayList;
/**
 *
 * @author thiago
 */
public class UsuarioController {
    
    public RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
    private static UsuarioController instance = null;

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }
    
    public boolean addUsuario(String nome, String sobrenome, String email,
                            String senha, String telefone){
        if(!"".equals(nome) && !"".equals(sobrenome) && !"".equals(email) && !"".equals(senha) && !"".equals(telefone)){
            Usuario novo = new Usuario(nome, sobrenome, email, senha, telefone);
            return this.repositorioUsuario.addUsuario(novo);
        }else{
            return false;
        }
    }
    
     
    public ArrayList<Usuario> listar(){
       return this.repositorioUsuario.listar();
    }
    
    public boolean removerUsuario(int index){
        Usuario u = repositorioUsuario.buscarIndex(index);
        if (u != null){
            return repositorioUsuario.removeUsuario(u);
        }
       return false;
    }
    
    public boolean edtUsuario(String nome, String sobrenome, String email,
                            String senha, String telefone, int index){
        if(!"".equals(nome) && !"".equals(sobrenome) && !"".equals(email) && !"".equals(senha) && !"".equals(telefone)){
            return this.repositorioUsuario.updateUsuario( nome,  sobrenome,  email,  senha,  telefone,  index);
        }
        return false;
    }
}
