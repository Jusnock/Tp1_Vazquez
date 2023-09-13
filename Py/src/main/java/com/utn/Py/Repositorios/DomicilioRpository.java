package com.utn.Py.Repositorios;

import com.utn.Py.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRpository extends JpaRepository<Domicilio,Long> {
}
