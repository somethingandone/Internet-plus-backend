package cn.edu.nju.model.VO;

import lombok.Data;
import java.util.List;


/**
 * 匹配的内规结果
 */
@Data
public class InRegulationMatchVO {
    String inRegulationDoc;
    List<String> inRegulationMatchItems;
}
