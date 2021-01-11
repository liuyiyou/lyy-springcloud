package cn.liuyiyou.cloud.app.controller;

import cn.liuyiyou.cloud.app.utils.PosterUtil;
import cn.liuyiyou.starter.exception.AlertException;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/7
 * @version: V1.0
 */
@RestController
public class ImageController {


    @GetMapping("/getPoster")
    public void getPoster(HttpServletResponse response){
        try {
            BufferedImage backgroundImg = PosterUtil
                .createBackgroundImg(307, 492, "255,255,255", "shareUrl", "131", "12", "12355", "https://ibatest.oss-cn-shenzhen.aliyuncs.com/ibalife/images/1597127047026YPWWW4PHKB.jpg");
            response.setContentType("image/jpg");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(backgroundImg, "jpg", outputStream);
        } catch (IOException e) {
            throw new AlertException("获取二维码失败");
        }
    }
}
