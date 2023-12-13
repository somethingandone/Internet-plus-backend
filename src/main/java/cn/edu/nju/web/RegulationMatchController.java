package cn.edu.nju.web;

import cn.edu.nju.core.Result;
import cn.edu.nju.core.ResultGenerator;
import cn.edu.nju.model.VO.InRegulationMatchVO;
import cn.edu.nju.model.VO.MatchItem;
import cn.edu.nju.model.VO.RegulationRetrievalVO;
import cn.edu.nju.model.WordIdf;
import cn.edu.nju.service.RegulationMatchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/regulation")
public class RegulationMatchController {
    @Resource
    private RegulationMatchService regulationMatchService;

    @PostMapping("/match")
    public Result match(@RequestBody RegulationRetrievalVO retrievalVO) throws Exception {
        List<MatchItem> matchResult = regulationMatchService.retrieval(retrievalVO);
        if(Objects.isNull(matchResult)){
            return ResultGenerator.genFailResult("选择文本过短或无匹配！");
        }
        return ResultGenerator.genSuccessResult(matchResult);
    }
}
