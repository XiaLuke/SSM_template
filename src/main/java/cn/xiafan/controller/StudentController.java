package cn.xiafan.controller;

import java.util.HashMap;
import java.util.List;

import cn.xiafan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xiafan.entity.Student;
import cn.xiafan.service.IStudentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    /**
     * 分页查询
     */
//	@RequestMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       Model model) {
        // 分页插件
        // 查询前需要调用分页插件
        PageHelper.startPage(page, size);
        // startPage后紧跟分页查询
        List<Student> list = studentService.list();
        // 使用pageInfo包装查询后结果，只需要返回pageInfo即可,可以传入连续显示的页数
        PageInfo<Student> info = new PageInfo(list, 5);
        model.addAttribute("pageInfo", info);
        return "studentList";
    }

    /**
     * 导入jackson
     * json格式
     */
    @RequestMapping("/jsonList")
    @ResponseBody
    public Result getStudentList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size) {
        // 分页插件
        // 查询前需要调用分页插件
        PageHelper.startPage(page, size);
        // startPage后紧跟分页查询
        List<Student> list = studentService.list();
        // 使用pageInfo包装查询后结果，只需要返回pageInfo即可,可以传入连续显示的页数
        PageInfo<Student> info = new PageInfo(list, 5);
        return Result.success().add("pageInfo", info);
    }

    /**
     * 在首页点击新增
     * 弹出新增对话框
     * 数据库查询下拉数据并显示在弹出框中
     * 对输入数据进行校验
     * -- jquery前端校验，ajax用户名重复校验，后端校验（基于JSR303）
     * 完成保存
     * <p>
     * -----------------------------
     * 使用JSR303需要导入Hibernate-validator
     *
     * @param student
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            HashMap<String, Object> map = new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                // 错误字段和信息
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Result.fail().add("errorMap",map);
        } else {
            studentService.save(student);
            return Result.success();
        }
    }

    @PostMapping("/check")
    @ResponseBody
    public Result check(@RequestParam("realName") String realName) {
        String regx = "(^[a-zA-Z0-9]{4,10}$)|(^[\u2E80-\u9FFF]{2,5}])";
        boolean matches = realName.matches(regx);
        if (!matches) {
            return Result.fail().add("validateMsg", "格式错误");
        }
        boolean result = studentService.check(realName);
        if (result) {
            return Result.success();
        } else {
            return Result.fail().add("validateMsg", "用户名重复");
        }
    }

    @GetMapping(value = "/getone/{id}")
    @ResponseBody
    public Result getOne(@PathVariable Integer id){
        Student student = studentService.getOne(id);
        return Result.success().add("student",student);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public Result update(Student student){
        System.out.println(student);
        studentService.update(student);
        return Result.success();
    }
}
