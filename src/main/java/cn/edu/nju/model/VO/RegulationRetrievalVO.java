package cn.edu.nju.model.VO;

import lombok.Builder;
import lombok.Data;

/**
 * 待分词匹配的外规
 */
@Data
@Builder
public class RegulationRetrievalVO {
    int id;
    String title;
    String text;
}
