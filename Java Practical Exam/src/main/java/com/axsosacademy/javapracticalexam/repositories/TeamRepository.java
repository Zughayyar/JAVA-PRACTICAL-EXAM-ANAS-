package com.axsosacademy.javapracticalexam.repositories;

import com.axsosacademy.javapracticalexam.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll();
}
