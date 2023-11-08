package com.example.lista_mecados.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.lista_mecados.DTO.Lista_record_dto;
import com.example.lista_mecados.models.lista_model;
import com.example.lista_mecados.repositori.product;

import jakarta.validation.Valid;

@RestController
public class lista_controller {
    

@Autowired
product produto; // o repositrio que a gente cria


@PostMapping("/product")

public ResponseEntity<Object> saveProduct(@RequestBody @Valid  Lista_record_dto lista_record_dto){

var lista_model = new lista_model();
List<lista_model> ident = produto.findAll();


BeanUtils.copyProperties(lista_record_dto, lista_model);

if(ident.size() >= 10){

        return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).body("Quantidade excedida");

    }

return ResponseEntity.status(HttpStatus.CREATED).body(produto.save(lista_model));
    
}



@GetMapping("/product")
public ResponseEntity <List<lista_model>> getall(){
    return ResponseEntity.status(HttpStatus.OK).body(produto.findAll());
}






@PutMapping("/product/{id}")
public ResponseEntity<Object> updateSave(@PathVariable (value = "id" ) UUID id,
@RequestBody @Valid Lista_record_dto lista_record_dto ){

Optional<lista_model> update = produto.findById(id);

if(update.isEmpty()){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produto Não Encontrado");
}

var lista_model = update.get(); 
BeanUtils.copyProperties(lista_record_dto, lista_model);


return ResponseEntity.status(HttpStatus.OK).body(produto.save(lista_model));

}


@DeleteMapping("/product/{id}")
public ResponseEntity <Object> deletando(@PathVariable(value = "id") UUID id){

Optional <lista_model> delet = produto.findById(id);
 // Criamos uma variavel usando o "Opitional" do java para guardar o id do produto

if(delet.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não consta na lista");
}


produto.delete(delet.get());
return ResponseEntity.status(HttpStatus.OK).body("Produto Deletado Com Sucesso");

}




}
