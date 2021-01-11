//package cn.liuyiyou.cloud.app;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import java.awt.Font;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import net.coobird.thumbnailator.Thumbnails;
//
///**
// * @author: liuyiyou.cn
// * @date: 2021/1/5
// * @version: V1.0
// */
//public class ImageUtils {
//
//    public void test() throws IOException {
//        String url = "https://newoss.yanglaoban.com/ibalife/images/16050653260923BM3Q6GHX7.jpg";
//        //获取图片
//        Thumbnails.of(new URL(url))
//            .scale(1)
//            .asBufferedImage();
//
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
//            g.setFont( new Font("微软雅黑", Font.BOLD, 22));
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
//
//    public static void generateQRCodeImage(String text, int width, int height, String filePath)
//        throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//    }
//
//    public static void main(String[] args) {
//        try {
//            generateQRCodeImage("Hello World", 350, 350, "E:/dev/image/QRTest.png");
//        } catch (WriterException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
