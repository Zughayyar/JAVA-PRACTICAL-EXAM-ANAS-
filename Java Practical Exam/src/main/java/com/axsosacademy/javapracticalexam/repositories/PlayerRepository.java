package com.axsosacademy.javapracticalexam.repositories;

import com.axsosacademy.javapracticalexam.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAll();
    void deleteAllByTeamId(Long teamId);
}
