package com.knighthood.knighthood.Repositories;

import com.knighthood.knighthood.Model.Score;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findByuserid(int user_id);
}
