package com.knighthood.knighthood.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue
    private int score_id;

    @Column(name = "user_id")
    private int userid;
    
    private int score;
}
