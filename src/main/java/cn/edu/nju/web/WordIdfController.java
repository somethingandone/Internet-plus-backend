package cn.edu.nju.web;
import cn.edu.nju.core.Result;
import cn.edu.nju.core.ResultGenerator;
import cn.edu.nju.model.WordIdf;
import cn.edu.nju.service.WordIdfService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2023/12/12.
*/
@RestController
@RequestMapping("/word/idf")
public class WordIdfController {
    @Resource
    private WordIdfService wordIdfService;

    @PostMapping("/add")
    public Result add(WordIdf wordIdf) {
        wordIdfService.save(wordIdf);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        wordIdfService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WordIdf wordIdf) {
        wordIdfService.update(wordIdf);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WordIdf wordIdf = wordIdfService.findById(id);
        return ResultGenerator.genSuccessResult(wordIdf);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WordIdf> list = wordIdfService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
