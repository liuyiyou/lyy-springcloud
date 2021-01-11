package cn.liuyiyou.cloud.app.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class PosterUtil {

    /**
     * 合成纯色背景图
     *
     * @param width     宽度
     * @param height    高度
     * @param colorCode tgb 颜色代码
     * @return
     */
    public static BufferedImage createBackgroundImg(Integer width, Integer height, String colorCode,
        String shareUrl, String text, String price, String marketPrice, String imageUrl) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        String[] colorArr = formatColorCode(colorCode);
        return writeImage(bufferedImage,"jpg", colorArr, shareUrl, text, price, marketPrice, imageUrl);
    }

    /**
     * 格式化颜色参数
     *
     * @param colorCode
     * @return
     */
    private static String[] formatColorCode(String colorCode) {

        colorCode = colorCode.replaceAll("rgba\\(", "").replaceAll("\\)", "");

        return colorCode.split(",");
    }

    /**
     * 通过指定参数写一个图片
     */
    private static BufferedImage writeImage(BufferedImage bi, String picType, String[] colorArr,
        String shareUrl, String text, String price, String marketPrice, String imageUrl) throws IOException {

        Graphics g = bi.getGraphics();

        g.setColor(new Color(Integer.parseInt(colorArr[0]), Integer.parseInt(colorArr[1]), Integer.parseInt(colorArr[2])));

        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                g.drawLine(i, j, bi.getWidth(), bi.getHeight());
            }
        }
        g.dispose();
        BufferedImage waterImg = getBufferedImageDestUrl(imageUrl);
        BufferedImage qrCodeImage = QrCodeUtil.getQrCodeImage(shareUrl);
        //waterImg.getGraphics().drawImage(waterImg.getScaledInstance(283,282,Image.SCALE_SMOOTH),0,0,null);
        BufferedImage backImage = new BufferedImage(283, 282, BufferedImage.TYPE_INT_RGB);
        Image scaledInstance = waterImg.getScaledInstance(283, 282, Image.SCALE_SMOOTH);
        backImage.getGraphics().drawImage(scaledInstance,0,0,null);
        BufferedImage tempImage = overlyingImage(bi, backImage, 12, 24, 1.0f);
        BufferedImage posterImage = overlyingImage(tempImage, qrCodeImage, 207, 352, 1.0f);
        Graphics graphics = posterImage.getGraphics();
        Font f = new Font("苹方-简",Font.PLAIN,16);
        Color color = Color.BLACK;
        graphics.setColor(color);
        graphics.setFont(f);
        List<String> stringList = getListText(text);
        for (int i = 0; i < stringList.size(); i++) {
            graphics.drawString(stringList.get(i),16,336+22*i);
        }
//        graphics.drawString("宝加利亚薰衣草舒眠香薰精油植物成分",16,336);
//        graphics.drawString("舒适甜保加利亚薰衣草舒眠香薰...",16,358);

        graphics.setColor(color);
        graphics.setFont(new Font("苹方-简", Font.BOLD, 24));
        graphics.drawString(price,26,392);

        graphics.setColor(color);
        graphics.setFont(new Font("苹方-简", Font.PLAIN, 14));
        graphics.drawString("¥",16,392);

        graphics.setColor(Color.darkGray);
        graphics.setFont(new Font("苹方-简", Font.PLAIN, 14));
        graphics.drawString(marketPrice,18,416);

        graphics.setColor(Color.darkGray);
        graphics.drawLine(16,411,18+marketPrice.length()*8,411);
        graphics.dispose();

        return posterImage;
    }

    public static BufferedImage getBufferedImage(String fileUrl)
        throws IOException {
        File f = new File(fileUrl);
        return ImageIO.read(f);
    }

    /**
     * 远程图片转BufferedImage
     * @param destUrl    远程图片地址
     * @return
     */
    public static BufferedImage getBufferedImageDestUrl(String destUrl) {
        HttpURLConnection conn = null;
        BufferedImage image = null;
        try {
            URL url = new URL(destUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == 200) {
                image = ImageIO.read(conn.getInputStream());
                return image;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn!=null) {
                conn.disconnect();
            }
        }
        return null;
    }

    /**
     *
     * @Title: 构造图片
     * @Description: 生成水印并返回java.awt.image.BufferedImage
     * @param buffImg 源文件(BufferedImage)
     * @param waterImg 水印文件(BufferedImage)
     * @param x 距离右下角的X偏移量
     * @param y  距离右下角的Y偏移量
     * @param alpha  透明度, 选择值从0.0~1.0: 完全透明~完全不透明
     * @return BufferedImage
     * @throws IOException
     */
    public static BufferedImage overlyingImage(BufferedImage buffImg, BufferedImage waterImg, int x, int y, float alpha) throws IOException {

        // 创建Graphics2D对象，用在底图对象上绘图
        Graphics2D g2d = buffImg.createGraphics();
        int waterImgWidth = waterImg.getWidth();// 获取层图的宽度
        int waterImgHeight = waterImg.getHeight();// 获取层图的高度
        // 在图形和图像中实现混合和透明效果
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        // 绘制
        g2d.drawImage(waterImg, x, y, waterImgWidth, waterImgHeight, null);
        g2d.dispose();// 释放图形上下文使用的系统资源
        return buffImg;
    }

    /**
     * 处理文案
     * @param str
     * @return
     */
    private static List<String> getListText(String str){
        List<String> stringList = new ArrayList<String>();
        if (str.length()<=17){
            stringList.add(str);
        }else if (str.length()<=17+14){
            stringList.add(str.substring(1,17));
            stringList.add(str.substring(18));
        }else {
            stringList.add(str.substring(1,17));
            stringList.add(str.substring(18,31)+"...");
        }
        return stringList;
    }
}
