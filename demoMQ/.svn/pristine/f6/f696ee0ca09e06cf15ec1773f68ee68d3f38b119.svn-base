package com.qif.mainstate.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 上传文件
 *
 * @author hj
 */
public class UpFileUtil {

    public static String upFile(HttpServletRequest request, MultipartFile file, String name) throws ServletException, IOException {
        String url = "";
        //-----代码片段 spingMVC上传文件
        /*MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;//request强制转换注意

        MultipartFile file = mRequest.getFile("file");*/
        // 先判断文件是否为空
        if (!file.isEmpty()) {
            // 获得原始文件名
            String fileName = file.getOriginalFilename();
            String[] names = fileName.split("\\.");
            if (names.length < 2) {
                return url;
            }


            // 重命名文件
            //String newfileName = new Date().getTime() + String.valueOf(fileName);
            String newfileName = name + "." + names[names.length - 1];
            //获得物理路径webapp所在路径
            /**
             * request.getSession().getServletContext().getRealPath("/")表示当前项目的根路径，如
             * D:\Workspaces\eclipse_luna\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\sky\
             */
            String pathRoot = request.getSession().getServletContext().getRealPath("/") + "images/";
            //String pathRoot = "/images/";
            // 项目下相对路径
            String path = pathRoot + newfileName;
            String path1 = "/images/" + newfileName;

            // 创建文件实例
            File tempFile = new File(path);
            // 判断父级目录是否存在，不存在则创建
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
            }
            // 判断文件是否存在，否则创建文件（夹）
            if (!tempFile.exists()) {
                tempFile.mkdir();
            }

            try {
                // 将接收的文件保存到指定文件中
                file.transferTo(tempFile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            url = path1;
        }
        return url;
    }
}
