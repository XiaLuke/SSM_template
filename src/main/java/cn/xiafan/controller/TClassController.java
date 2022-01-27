package cn.xiafan.controller;

import cn.xiafan.entity.TClass;
import cn.xiafan.service.ITClassService;
import cn.xiafan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tclass")
public class TClassController {
    @Autowired
    private ITClassService itClassService;

    /**
     *
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result list(){
        List<TClass> list = itClassService.list();
        return Result.success().add("list",list);
    }
}
