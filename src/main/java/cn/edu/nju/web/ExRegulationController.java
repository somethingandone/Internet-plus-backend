package cn.edu.nju.web;

import cn.edu.nju.core.MongoPage;
import cn.edu.nju.core.Result;
import cn.edu.nju.core.ResultGenerator;
import cn.edu.nju.model.ExRegulation;
import cn.edu.nju.service.impl.ExRegulationServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ex_regulation")
public class ExRegulationController {
    @Resource
    private ExRegulationServiceImpl exRegulationService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        MongoPage<ExRegulation> pageInfo = exRegulationService.findAllByPage(page, size);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
