package com.example.tienda.controller;

import com.example.tienda.model.PedidoEntity;
import com.example.tienda.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
 @Autowired
 private PedidoRepository pedidoRepository;
 // GET /pedidos (lista todos los pedidos)
 @GetMapping
 public List<PedidoEntity> getAll() {
 return pedidoRepository.findAll();
 }
 // GET /pedidos/{id} (busca un pedido por id)
 @GetMapping("/{id}")
 public ResponseEntity<PedidoEntity> getById(@PathVariable Long id) {
 Optional<PedidoEntity> pedidoOpt = pedidoRepository.findById(id);
 if (pedidoOpt.isPresent()){
    return ResponseEntity.ok(pedidoOpt.get());
 } else {
 return ResponseEntity.notFound().build();
 }
 }
 // POST /pedidos (crea un nuevo pedido)
 @PostMapping
 public ResponseEntity<PedidoEntity> create(@RequestBody PedidoEntity pedido) {
 // Nos aseguramos de que venga sin id o lo ignoramos
 pedido.setId(null);
 PedidoEntity guardado = pedidoRepository.save(pedido);
 return ResponseEntity
 .created(URI.create("/pedidos/" + guardado.getId()))
 .body(guardado);
 }
 // DELETE /pedidos/{id} (borra un pedido por id)
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable Long id) {
 if (!pedidoRepository.existsById(id)) {
 return ResponseEntity.notFound().build();
 }
 pedidoRepository.deleteById(id);
 return ResponseEntity.noContent().build(); // 204
 }
}

