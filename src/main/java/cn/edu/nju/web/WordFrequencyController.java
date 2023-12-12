package cn.edu.nju.web;
import cn.edu.nju.core.Result;
import cn.edu.nju.core.ResultGenerator;
import cn.edu.nju.model.WordFrequency;
import cn.edu.nju.service.WordFrequencyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2023/12/12.
*/
@RestController
@RequestMapping("/word/frequency")
public class WordFrequencyController {
    @Resource
    private WordFrequencyService wordFrequencyService;

    @PostMapping("/add")
    public Result add(WordFrequency wordFrequency) {
        wordFrequencyService.save(wordFrequency);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        wordFrequencyService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(WordFrequency wordFrequency) {
        wordFrequencyService.update(wordFrequency);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        WordFrequency wordFrequency = wordFrequencyService.findById(id);
        return ResultGenerator.genSuccessResult(wordFrequency);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<WordFrequency> list = wordFrequencyService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
