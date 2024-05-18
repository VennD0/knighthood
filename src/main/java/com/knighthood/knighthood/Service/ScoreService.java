package com.knighthood.knighthood.Service;

import com.knighthood.knighthood.Model.Score;
import com.knighthood.knighthood.Repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public Score getScoreById(int id) {
        return scoreRepository.findById(id).orElse(null);
    }

    public Score addScore(Score score) {
        return scoreRepository.save(score);
    }

    public Score updateScore(int id, Score score) {
        if (scoreRepository.existsById(id)) {
            score.setScore_id(id);
            return scoreRepository.save(score);
        } else {
            return null; // Handle error
        }
    }

    public void deleteScore(int id) {
        scoreRepository.deleteById(id);
    }

    public List<Score> getScoresByUserId(int userId) {
        return scoreRepository.findByuserid(userId);
    }
}
