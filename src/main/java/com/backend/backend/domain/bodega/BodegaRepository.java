package com.backend.backend.domain.bodega;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BodegaRepository extends JpaRepository<Bodega, Long> {
    Optional<Object> findByNombre(String nombre);
}
