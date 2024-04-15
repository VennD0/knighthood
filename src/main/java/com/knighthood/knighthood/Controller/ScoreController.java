package com.knighthood.knighthood.Controller;

import com.knighthood.knighthood.Model.Score;
import com.knighthood.knighthood.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public List<Score> getAllScores() {
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Score getScoreById(@PathVariable("id") int id) {
        return scoreService.getScoreById(id);
    }

    @PostMapping
    public Score addScore(@RequestBody Score score) {
        return scoreService.addScore(score);
    }

    @PutMapping("/{id}")
    public Score updateScore(@PathVariable("id") int id, @RequestBody Score score) {
        return scoreService.updateScore(id, score);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable("id") int id) {
        scoreService.deleteScore(id);
    }
}
