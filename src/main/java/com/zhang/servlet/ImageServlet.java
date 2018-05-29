package com.zhang.servlet;

import com.zhang.commons.ImageCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/17.
 */
@WebServlet("/check_code.jpg")
public class ImageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,BufferedImage> map = ImageCode.getImage(80, 35, 4,20);
        String checkCode = map.keySet().iterator().next();
        req.getSession().setAttribute("imageCode",checkCode);
        BufferedImage image = map.values().iterator().next();
        //禁止图像缓存
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        //将图像输出到servlet输出流中；
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(image,"jpeg",sos);
        sos.close();
    }
}
