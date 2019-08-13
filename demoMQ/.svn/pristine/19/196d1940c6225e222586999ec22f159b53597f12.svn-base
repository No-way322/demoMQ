/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UdpClientController
 * Author:   Administrator
 * Date:     2019/1/24 15:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.qif.mainstate.manage.tag.controller;

import com.qif.mainstate.manage.tag.entity.MessageSender;
import com.qif.mainstate.util.StringHelper;
import com.qif.mainstate.util.UpFileUtil;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping("/udp")
public class UdpClientController {
    private Logger logger = LoggerFactory.getLogger(UdpClientController.class);

    private String sendStr = "hello";
    private String netAddress = "127.0.0.1";
    private final int PORT = 8800;

    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;

    @RequestMapping(value = "/udpClient")
    @ResponseBody
    public Map<String, Object> UdpClient() {
        Map<String, Object> map = new HashMap<>();
        String receStr = null;
        String serverIp = null;
        try {
            datagramSocket = new DatagramSocket();
            byte[] buf = sendStr.getBytes();
            InetAddress address = InetAddress.getByName(netAddress);
            datagramPacket = new DatagramPacket(buf, buf.length, address, PORT);
            datagramSocket.send(datagramPacket);

            byte[] receBuf = new byte[1024];
            DatagramPacket recePacket = new DatagramPacket(receBuf, receBuf.length);

            //为接受的数据包创建空间
//            DatagramPacket recePacket = new DatagramPacket(new byte[1024], 1024);
//            datagramSocket.receive(recePacket);
//            String result = new String(recePacket.getData(), 0, recePacket.getLength(), "UTF-8");
            String info = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("我是客户端，服务器端说：" + info);

//            System.out.println(result);

            datagramSocket.receive(recePacket);

            receStr = new String(recePacket.getData(), 0, recePacket.getLength());
            //获取服务端ip
            serverIp = String.valueOf(recePacket.getAddress());
            logger.info("receStr: " + receStr + " serverIp: " + serverIp);

            map.put("receStr", receStr);
            map.put("serverIp", serverIp);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭socket
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
        return map;
    }

    /**
     * 上传图片
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/upLoad")
    @ResponseBody
    public Map<String, Object> upLoad(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
//            String url = request.getParameter("url");
            String url = null;
            if (!StringHelper.isNotBlack(url)) {
                MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;//request强制转换注意
                MultipartFile file = mRequest.getFile("file");
                String name = String.valueOf(new Date().getTime());
                url = UpFileUtil.upFile(request, file, name);
            }
            if ("".equals(url)) {
                map.put("status", "2");
                map.put("msg", "上传失败");
                return map;
            } else {
                map.put("url", url);
            }
        } catch (Exception e) {
            System.out.println("error");
            map.put("status", "2");
            map.put("msg", "上传失败");
            return map;
        }
        map.put("status", "1");
        map.put("msg", "success");
        return map;
    }


}