package cn.edu.nju.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 待分词匹配的外规
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegulationRetrievalVO {
    int id;
    String title;
    String text;
}
