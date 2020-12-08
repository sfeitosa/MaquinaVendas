/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.maquinavendas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author samuel
 */
public class Venda {
    Integer id;
    Produto produto;
    FormaPgto formaPgto;

    public Venda(Produto produto, FormaPgto formaPgto) {
        this.produto = produto;
        this.formaPgto = formaPgto;
    }
    
    public void salvar() throws Exception {
        DBController db = new DBController();
        Map<String,String> dados = new HashMap<>();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println(dtf.format(now));
        
        dados.put("produto_id", String.valueOf(produto.getId()));
        dados.put("formapgto_id", String.valueOf(formaPgto.getId()));
        dados.put("datahora", dtf.format(now));
        
        db.conectar();
        db.insert("Venda", dados);
        db.desconectar();
    }
}
