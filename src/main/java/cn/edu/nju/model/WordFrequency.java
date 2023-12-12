package cn.edu.nju.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Table(name = "word_frequency")
@Data
@Builder
public class WordFrequency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private Integer frequency;
}
