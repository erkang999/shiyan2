package com.kang.shiyan02.Controller;


import com.kang.shiyan02.domain.s_school;
import com.kang.shiyan02.domain.s_student;
import com.kang.shiyan02.service.s_studentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
//
//@RestController
//@RequestMapping("/brands")

@RestController
@RequestMapping("/s_student")
@CrossOrigin
public class s_studentController {

    @Resource
    private s_studentService s_studentService;

    @GetMapping
    public Result getAll()
        {
            Result result = new Result();
            result.setData(s_studentService.getAll());
            result.setMsg("success");
//            return s_studentService.getAll();
            return result;
        }
//    @PostMapping
//    public Result add(@RequestBody Brand brand) {
//        boolean flag = brandService.add(brand);
//        System.out.println("add::::::"+brand);
//        return new Result(flag==true? Code.SAVE_OK: Code.SAVE_ERR,flag);
//    }


        @PostMapping
    public Result add(@RequestBody s_student s)
        {
            Result result = new Result();
           result.setMsg(s_studentService.add(s));
            return  result;
        }

        @PutMapping
    public Result update(@RequestBody s_student s)
        {
            Result result = new Result();
            result.setMsg(s_studentService.update(s));
            return  result;
        }

//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id) {  //：通过@PathVariable可以绑定占位符参数到方法参数中
//        boolean flag = brandService.delete(id);
//
//        return new Result(flag==true? Code.DELETE_OK: Code.DELETE_ERR,flag);
//    }
//
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        Result result = new Result();
        result.setMsg(s_studentService.deleteById(id));
        return  result;
    }

    @GetMapping("/selectBypage")
    public Result selectByPage(HttpServletRequest request) {
        //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        System.out.println(currentPage+" "+pageSize);
        Result result = s_studentService.selectByPage(currentPage,pageSize);

        return result;
    }

}
