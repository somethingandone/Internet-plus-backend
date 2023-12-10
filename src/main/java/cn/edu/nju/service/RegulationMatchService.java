package cn.edu.nju.service;

import cn.edu.nju.model.VO.InRegulationMatchVO;
import cn.edu.nju.model.VO.RegulationRetrievalVO;

/**
 * 完成分词、计算TF-IDF相似度
 */
public interface RegulationMatchService {
    InRegulationMatchVO retrieval(RegulationRetrievalVO regulationRetrievalVO);
}
