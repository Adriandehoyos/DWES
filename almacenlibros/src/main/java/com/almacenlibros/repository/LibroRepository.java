package com.almacenlibros.repository;
import com.almacenlibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LibroRepository extends JpaRepository<Libro, Long> {
}