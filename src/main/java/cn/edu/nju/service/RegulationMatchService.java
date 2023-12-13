package cn.edu.nju.service;

import cn.edu.nju.model.VO.InRegulationMatchVO;
import cn.edu.nju.model.VO.MatchItem;
import cn.edu.nju.model.VO.RegulationRetrievalVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 完成分词、计算TF-IDF相似度
 */
public interface RegulationMatchService {
    List<MatchItem> retrieval(RegulationRetrievalVO regulationRetrievalVO) throws Exception;
}
