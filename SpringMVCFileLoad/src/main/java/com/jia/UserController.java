package com.jia;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    //文件上传
    @RequestMapping("/fileupload1")
    public String fileUpLoad1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //使用组件完成文件上传
        //指定上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        //判断文件是否存在
        File file=new File(path);
        //如果存在
        if(!file.exists())
        {
            //创建文件夹
            file.mkdirs();
        }
        //解析 request 对象，获取上传文件项
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
       List<FileItem> items=upload.parseRequest(request);
       //遍历
        for(FileItem item:items)
        {
            //判断当前 item 是否是上传文件项,
            // 如果是，需要把文件存在路径下，否则需要额外处理
            if(item.isFormField())
            {
                //说明是普通表单项
            }
            else
            {
                //需要获取到上传文件的名称
                String fileName=item.getName();
                //把文件的名称设置为唯一值
               String uid=UUID.randomUUID().toString().replace("-","");
               fileName=uid+"_"+fileName;
                //完成文件上传
                item.write(new File(path,fileName));
                //删除临时文件
                item.delete();
            }
        }
        System.out.println(path);
        return "success";
    }


    @RequestMapping("/fileupload2")
    public String fileUpLoad2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件上传");
        //使用组件完成文件上传
        //指定上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        //判断文件是否存在
        File file=new File(path);
        //如果存在
        if(!file.exists())
        {
            //创建文件夹
            file.mkdirs();
        }



                //需要获取到上传文件的名称
        String fileName=upload.getOriginalFilename();
              /*  String fileName=item.getName();*/
                //把文件的名称设置为唯一值
                String uid=UUID.randomUUID().toString().replace("-","");
                fileName=uid+"_"+fileName;

                /*完成文件上传
                item.write(new File(path,fileName));
                删除临时文件
                item.delete();*/
                //完成文件上传
        upload.transferTo(new File(path,fileName));
        return "success";
    }

    //跨服务器上传
    @RequestMapping("/fileupload3")
    public String fileUpLoad3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传");

        //定义上传服务器的路径
        String path="http://localhost:9090/uploads/";

        //获取上传文件的名称
        String fileName=upload.getOriginalFilename();
        //把文件的名称设置成唯一值
        String uid=UUID.randomUUID().toString().replace("-","");
        fileName=uid+"_"+fileName;

        //创建客户端对象
        Client client=Client.create();

        //连接图片服务器
        WebResource resource=client.resource(path+fileName);

        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }


}
