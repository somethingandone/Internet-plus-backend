package cn.edu.nju.web;

import cn.edu.nju.core.MongoPage;
import cn.edu.nju.core.Result;
import cn.edu.nju.core.ResultGenerator;
import cn.edu.nju.model.InRegulation;
import cn.edu.nju.service.impl.InRegulationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/in_regulation")
public class InRegulationController {
    @Resource
    private InRegulationServiceImpl inRegulationService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        MongoPage<InRegulation> pageInfo = inRegulationService.findAllByPage(page, size);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
