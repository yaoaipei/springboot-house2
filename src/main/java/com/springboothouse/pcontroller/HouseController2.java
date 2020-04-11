package com.springboothouse.pcontroller;


import com.github.pagehelper.PageInfo;
import com.springboothouse.entity.House;
import com.springboothouse.entity.Users;
import com.springboothouse.service.HouseService;
import com.springboothouse.utils.HouseCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller("housecontroller2")
@RequestMapping("/page/")
public class HouseController2 {


    @Autowired
    private HouseService houseService;


    //得到房用户屋信息
    //无需其他参数
    @RequestMapping("getUserHouse")
    public String getUserHouse(HttpSession session, Model model){

        Users user = (Users) session.getAttribute("userinfo");
        List<House> houseList = houseService.getHouseByUserid(user.getId());
        model.addAttribute("houseList",houseList);
        return "guanli";
    }


    //显示修改内容
    @RequestMapping("showHouse")
    public String showHouse(String id,Model model){
        House house = houseService.getHouseById(id);
        model.addAttribute("house",house);
        return "upfabu";
    }



    //实际修改
    @RequestMapping("updateHouse")
    public String updateHouse(House house,String oldPic,@RequestParam(value = "pfile",required = false) MultipartFile pfile){

        try {
            if (!pfile.isEmpty()){
                // System.out.println("不为空则修改图片");
          //1.上传文件
                String sourceFile = pfile.getOriginalFilename();
                String extName = sourceFile.substring(sourceFile.lastIndexOf("."));//扩展名
                String bh = System.currentTimeMillis() + "";
                String filename=bh+extName;
                String path="D:\\IMG\\" + filename;
                File savafile=new File(path);
                //上传
                pfile.transferTo(savafile);
                //设置图片
            house.setPath(filename);
            }
            //2.调用业务保存在数据库
            houseService.updateHouse(house);
            //删除旧图
            if (!pfile.isEmpty()){
                File file = new File("D:\\IMG\\" + oldPic);
                file.delete();
            }
            return "redirect:getUserHouse";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "error";
    }


    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session, @RequestParam(value = "pfile",required = false)MultipartFile pfile){

        try {
            //1.文件上传
            String souceFile = pfile.getOriginalFilename();//文件名
            String extname = souceFile.substring(souceFile.lastIndexOf("."));//扩展名
            String bh = System.currentTimeMillis() + "";//为了让每个文件编号不同
            String filename=bh+extname;
            String path="D:\\IMG\\"+filename;
            File savefile = new File(path);
            //上传
            pfile.transferTo(savefile);
            //2.调用业务
            //设置编号
            house.setId(bh);
            //设置图片
            house.setPath(filename);
            //设置用户编号
            Users user =(Users) session.getAttribute("userinfo");
            house.setUserId(user.getId());
            houseService.addHouse(house);
            return "fabu";
        } catch (IOException e) {
            e.printStackTrace();
        }

         return "error";
    }

    //查询用户浏览的出租房
    @RequestMapping("searchHouse")
    public String searchHouse(HouseCondition condition,Model model){
        //调用业务
        condition.setRows(5);
        PageInfo<House> houses = houseService.getHouseByBroswer(condition);
        model.addAttribute("houses",houses);
        model.addAttribute("conditioin",condition);
            return "list";
    }

}
