/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avantia.dados;

import java.util.ArrayList;
import br.com.avantia.model.Usuario;

/**
 *
 * @author thiago
 */
public class RepositorioUsuario {
	private ArrayList<Usuario> usuarios = new ArrayList<>();
        
        
        //busca usuario
        public Usuario buscarUsuario(String email){
            for(Usuario u : usuarios){
                if(u.getEmail().equals(email)){
                    return u;
                }
            }
            return null;
        }
        
        public Usuario buscarIndex(int index){
            for(Usuario u : usuarios){
                if((index) == usuarios.indexOf(u)){
                    return u;
                }
            }
            return null;
        }
        //adiciona um usuario
        public boolean addUsuario(Usuario u){
            if(buscarUsuario(u.getEmail()) == null){
                this.usuarios.add(u);
                return true;
            }
            else{
                return false;
            }
        }
        
        //edita um usuario
        public boolean updateUsuario(String nome, String sobrenome, String email,
                            String senha, String telefone, int index){
            for(Usuario u : usuarios){
                if(usuarios.indexOf(u) == index){
                    u.setNome(nome);
                    u.setSobrenome(sobrenome);
                    u.setEmail(email);
                    u.setSenha(senha);
                    u.setTelefone(telefone);
                    return true;
                }
            }
            return false;
        }
        
        //remove um usuario
        public boolean removeUsuario(Usuario u){
            if(buscarUsuario(u.getEmail()) != null){
                this.usuarios.remove(u);
                return true;
            }
            return false;
        }
        
        public ArrayList<Usuario> listar(){
            return usuarios;
        }
}
