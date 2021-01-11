//package cn.liuyiyou.cloud.app;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//import java.awt.RenderingHints;
//import java.awt.geom.Ellipse2D;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import javax.imageio.ImageIO;
//import javax.imageio.ImageReadParam;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;
//import net.coobird.thumbnailator.Thumbnails;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.Assert;
//
///**
// * @author: liuyiyou.cn
// * @date: 2021/1/5
// * @version: V1.0
// */
//public class PictureUtils {
//
//    private static final Logger log = LoggerFactory.getLogger(PictureUtils.class);
//
//    private Font font = new Font("微软雅黑", Font.BOLD, 70);// 添加字体的属性设置
//    private Graphics2D g = null;
//    private int fontsize = 0;
//    private int x = 0;
//    private int y = 0;
//
//    /**
//     * 导入本地图片到缓冲区
//     */
//    public BufferedImage loadImageLocal(String imgName) {
//        try {
//            return ImageIO.read(new File(imgName));
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 导入网络图片到缓冲区
//     */
//    public BufferedImage loadImageUrl(String imgName) {
//        try {
//            URL url = new URL(imgName);
//            return ImageIO.read(url);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 生成新图片到本地
//     */
//    public boolean writeImageLocal(String newImage, BufferedImage img) {
//        boolean isok = false;
//        if (newImage != null && img != null) {
//            try {
//                File outputfile = new File(newImage);
//                isok = ImageIO.write(img, "jpg", outputfile);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        return isok;
//    }
//
//    /**
//     * 将{@link BufferedImage}生成formatName指定格式的图像数据
//     *
//     * @param formatName 图像格式名，图像格式名错误则抛出异常
//     */
//    public static void wirteBytes(BufferedImage source, String formatName, String newImage) {
//        Assert.notNull(source, "source");
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        Graphics2D g = null;
//        try {
//            for (BufferedImage s = source; !ImageIO.write(s, formatName, output); ) {
//                if (null != g) {
//                    throw new IllegalArgumentException(String.format("not found writer for '%s'", formatName));
//                }
//                s = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
//                g = s.createGraphics();
//                g.drawImage(source, 0, 0, null);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (null != g) {
//                g.dispose();
//            }
//        }
//    }
//
//
//    /**
//     * 设定文字的字体等
//     *
//     * @param fontStyle 文字字体
//     * @param fontSize 大小
//     */
//    public void setFont(String fontStyle, int fontSize) {
//        this.fontsize = fontSize;
//        this.font = new Font(fontStyle, Font.PLAIN, fontSize);
//    }
//
//    /**
//     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
//     */
//    public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y) {
//        try {
//            int w = img.getWidth();
//            int h = img.getHeight();
//            g = img.createGraphics();
//            g.setBackground(Color.WHITE);
//            g.setColor(Color.BLACK);//设置字体颜色
//            if (this.font != null) {
//                g.setFont(this.font);
//            }
//// 验证输出位置的纵坐标和横坐标
//            if (x >= h || y >= w) {
//                this.x = h - this.fontsize + 2;
//                this.y = w;
//            } else {
//                this.x = x;
//                this.y = y;
//            }
//            g.setFont(new Font("微软雅黑", Font.BOLD, 22));
//            if (content != null) {
//                g.drawString(content.toString(), this.x, this.y);
//            }
//            g.setBackground(Color.WHITE);
//            g.dispose();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return img;
//    }
//
//    /**
//     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
//     *
//     * @param img 图片
//     */
//    public BufferedImage modifyImageYe(BufferedImage img) {
//        try {
//            int w = img.getWidth();
//            int h = img.getHeight();
//            g = img.createGraphics();
//            g.setBackground(Color.WHITE);
//            g.setColor(Color.blue);//设置字体颜色
//            if (this.font != null) {
//                g.setFont(this.font);
//            }
//            g.drawString("reyo.cn", w - 85, h - 5);
//            g.dispose();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return img;
//    }
//
//    /**
//     * 合成图片
//     *
//     * @param b 图片b
//     * @param d 图片d
//     * @param x x坐标
//     * @param y y坐标
//     * @param height 高度
//     * @param weight 宽度
//     */
//    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d, int x, int y, int height, int weight) {
//        try {
//            g = d.createGraphics();
//            g.drawImage(b, x, y, weight, height, null);
//            g.dispose();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return d;
//    }
//
//    /**
//     * 对图片进行剪裁 返回字节数组
//     *
//     * @param is 图片输入流
//     * @param width 裁剪图片的宽
//     * @param height 裁剪图片的高
//     * @param imageFormat 输出图片的格式 "jpeg jpg等"
//     */
//    public static byte[] clipImage(InputStream is, int width, int height, String imageFormat) {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        try {
//// 构造Image对象
//            BufferedImage src = javax.imageio.ImageIO.read(is);
//// 缩小边长
//            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//// 绘制 缩小 后的图片
//            tag.getGraphics().drawImage(src, 0, 0, width, height, null);
//            ImageIO.write(tag, imageFormat, bos);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bos.toByteArray();
//    }
//
//    /**
//     * 对图片裁剪，并把裁剪新图片保存
//     *
//     * @param srcPath 读取源图片路径
//     * @param toPath 写入图片路径
//     * @param x 剪切起始点x坐标
//     * @param y 剪切起始点y坐标
//     * @param width 剪切宽度
//     * @param height 剪切高度
//     * @param readImageFormat 读取图片格式
//     * @param writeImageFormat 写入图片格式
//     */
//    public static void cropImage(String srcPath, String toPath, int x, int y, int width, int height, String readImageFormat, String writeImageFormat) {
//        FileInputStream fis = null;
//        ImageInputStream iis = null;
//        try {
////读取图片文件
//            fis = new FileInputStream(srcPath);
//            Iterator readers = ImageIO.getImageReadersByFormatName(readImageFormat);
//            ImageReader reader = readers.next();
////获取图片流
//            iis = ImageIO.createImageInputStream(fis);
//            reader.setInput(iis, true);
//            ImageReadParam param = reader.getDefaultReadParam();
////定义一个矩形
//            Rectangle rect = new Rectangle(x, y, width, height);
////提供一个 BufferedImage，将其用作解码像素数据的目标。
//            param.setSourceRegion(rect);
//            BufferedImage bi = reader.read(0, param);
////保存新图片
//            ImageIO.write(bi, writeImageFormat, new File(toPath));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fis != null) {
//                    fis.close();
//                }
//                if (iis != null) {
//                    iis.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 传入的图像必须是正方形的 才会 圆形 如果是长方形的比例则会变成椭圆的
//     *
//     * @param bi1 图片
//     */
//    public static BufferedImage convertCircular(BufferedImage bi1) throws IOException {
//// 透明底的图片
//        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
//        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1.getHeight());
//        Graphics2D g2 = bi2.createGraphics();
//        g2.setClip(shape);
//// 使用 setRenderingHint 设置抗锯齿
//        g2.drawImage(bi1, 0, 0, null);
//// 设置颜色
//        g2.setBackground(Color.green);
//        g2.dispose();
//        return bi2;
//    }
//
//    /**
//     * 缩小Image，此方法返回源图像按给定宽度、高度限制下缩放后的图像
//     */
//    public static BufferedImage scaleByPercentage(BufferedImage inputImage, int newWidth, int newHeight, BufferedImage beijing) throws Exception {
//// 获取原始图像透明度类型
//        int type = inputImage.getColorModel().getTransparency();
//        int width = inputImage.getWidth();
//        int height = inputImage.getHeight();
//// 开启抗锯齿
//        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//// 使用高质量压缩
//        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        BufferedImage img = new BufferedImage(newWidth, newHeight, type);
//        Graphics2D graphics2d = img.createGraphics();
//        graphics2d.setRenderingHints(renderingHints);
//        graphics2d.drawImage(inputImage, 0, 0, newWidth, newHeight, 0, 0, width, height, null);
//        graphics2d.dispose();
//        return img;
//    }
//
//    /**
//     * 头像缩放 四舍五入 double转int
//     */
//    public static Integer doubleToInt(BufferedImage beijing_, double d) {
//        return (new Double((d * beijing_.getHeight()))).intValue();
//    }
//
//    /**
//     * 让字符串隔开展现
//     */
//    public static String getCode(String code) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < code.length(); i++) {
//            if (i != (code.length() - 1)) {
//                sb.append(code.charAt(i)).append(" ");
//            } else {
//                sb.append(code.charAt(i));
//            }
//        }
//        return sb.toString();
//    }
//
//    /**
//     * 网络图片输出到BufferedImage
//     */
//    private BufferedImage getBufferedImageForURL(String filePath) throws IOException {
////asBufferedImage() 返回BufferedImage
//        BufferedImage thumbnail = Thumbnails.of(new URL(filePath))
//            .scale(1)
//            .asBufferedImage();
//        return thumbnail;
//    }
//
//    /**
//     * 本地图片输出到BufferedImage
//     */
//    private BufferedImage getBufferedImageForLocal(String filePath) throws IOException {
///**
// * asBufferedImage() 返回BufferedImage
// */
//        BufferedImage thumbnail = Thumbnails.of(filePath)
//            .scale(1)
//            .asBufferedImage();
//        return thumbnail;
//    }
//
//    /**
//     * 合成图片
//     *
//     * @param user 用户
//     */
//    public static void initImage(UserInfo user) throws IOException {
//        Map map = new HashMap();
//        PictureUtils tt = new PictureUtils();
//
//        //底边合成背景
//        String newPicUrl = new StringBuffer(baseUrl).append("ok/").append(user.getUserId()).append(".jpg").toString();
//        if (!new File(newPicUrl).exists()) {
////获取绑定二维码图片
//
//            {
//                boolean isOk = true;
//                try {
//                    BufferedImage head_ = tt.getBufferedImageForURL(user.getHeadImgUrl());
//                    BufferedImage qrCodeImg = tt.getBufferedImageForLocal(qrCodeImgURL);
//                    BufferedImage beijing_ = tt.getBufferedImageForURL(beijing);
//                    BufferedImage dibian_ = tt.getBufferedImageForURL(dibian);
//
//                    head_ = convertCircular(head_);
//                    head_ = scaleByPercentage(head_, doubleToInt(dibian_, PicConstant.DOUBLE_TO_INT_HEAD), doubleToInt(dibian_, PicConstant.DOUBLE_TO_INT_HEAD), beijing_);
//                    isOk = tt.writeImageLocal(new StringBuilder(baseUrl).append("head.jpg").toString(), head_);
//
////合成头像
//                    int x = 30;
//                    int y = 75;
//                    int weight1 = head_.getWidth();
//                    int height1 = head_.getHeight();
//                    tt.modifyImagetogeter(head_, dibian_, x, y, height1, weight1);
//                    isOk = tt.writeImageLocal(new StringBuilder(baseUrl).append("dibian.jpg").toString(), tt.modifyImagetogeter(head_, dibian_, x, y, height1, weight1));
//
////添加文字
//                    x = 100;
//                    y = 135;
//                    tt.modifyImage(dibian_, getCode(user.getInviteCode()), x, y);
//                    isOk = tt.writeImageLocal(new StringBuilder(baseUrl).append("xiabufen1.jpg").toString(), tt.modifyImage(dibian_, getCode(user.getInviteCode()), x, y));
//
////合成二维码
//                    x = 325;
//                    y = 12;
//                    int weight3 = doubleToInt(qrCodeImg, PicConstant.DOUBLE_TO_INT_QR);
//                    int height3 = doubleToInt(qrCodeImg, PicConstant.DOUBLE_TO_INT_QR);
//                    tt.modifyImagetogeter(qrCodeImg, dibian_, x, y, doubleToInt(qrCodeImg, PicConstant.DOUBLE_TO_INT_QR), doubleToInt(qrCodeImg, PicConstant.DOUBLE_TO_INT_QR));
//                    isOk = tt.writeImageLocal(new StringBuilder(baseUrl).append("xiabufen2.jpg").toString(), tt.modifyImagetogeter(qrCodeImg, dibian_, x, y, height3, weight3));
//
//                    x = 0;
//                    y = beijing_.getHeight() - dibian_.getHeight();
//                    int weight = dibian_.getWidth();
//                    int height = dibian_.getHeight();
//                    isOk = tt.writeImageLocal(newPicUrl, tt.modifyImagetogeter(dibian_, beijing_, x, y, height, weight));
//                } catch (Exception e) {
//                    log.error("合成" + e.getMessage());
//                }
//                if (!isOk) {
//                    log.error("生成图片失败!");
//                }
//                map.put("qrCode", qrCode);
//                map.put("newPicUrl", newPicUrl);
//            }
//            log.info(map.toString());
//        }
//
//        public static void main (String[]args) throws IOException {
//            UserInfo user = new UserInfo();
//            user.setUserId(1);
//            user.setHeadImgUrl("http://thirdwx.qlogo.cn/mmopen/vi_32/WicSf2eL9ic6F9panRknZPlFicNeiazFqN3Qv76Vic1dl41mQMuy7GprLWpvdZrhOspU0dXicBxRxX1ibgxGx4FEHE05g/132");
//            user.setInviteCode("123456");
//            initImage(user);
//        }
//
//        public static void generateQRCodeImage (String text,int width, int height, String filePath)
//        throws WriterException, IOException {
//            QRCodeWriter qrCodeWriter = new QRCodeWriter();
//            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//            Path path = FileSystems.getDefault().getPath(filePath);
//            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//        }
//
//
//    }
//
//
//    class UserInfo {
//
//        private Integer userId;
//        private String headImgUrl;
//        private String inviteCode;
//
//        public Integer getUserId() {
//            return userId;
//        }
//
//        public void setUserId(final Integer userId) {
//            this.userId = userId;
//        }
//
//        public String getHeadImgUrl() {
//            return headImgUrl;
//        }
//
//        public void setHeadImgUrl(final String headImgUrl) {
//            this.headImgUrl = headImgUrl;
//        }
//
//        public String getInviteCode() {
//            return inviteCode;
//        }
//
//        public void setInviteCode(final String inviteCode) {
//            this.inviteCode = inviteCode;
//        }
//    }