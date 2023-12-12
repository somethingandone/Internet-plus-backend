package cn.edu.nju.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchItem {
    public String fileName;
    public String text;
    public float similarity;
    public boolean relevance;
}
