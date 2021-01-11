package cn.liuyiyou.cloud.app.utils;

import static com.google.zxing.client.j2se.MatrixToImageConfig.BLACK;
import static com.google.zxing.client.j2se.MatrixToImageConfig.WHITE;

import cn.liuyiyou.starter.exception.AlertException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrCodeUtil {



    public static BufferedImage getQrCodeImage(String url){
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            @SuppressWarnings("rawtypes")
            Map hints = new HashMap();

            //设置UTF-8， 防止中文乱码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            //设置二维码四周白色区域的大小
            hints.put(EncodeHintType.MARGIN, 0);
            //设置二维码的容错性
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            //width:图片完整的宽;height:图片完整的高
            int width = 100;//352
            int height = 100;//612

            //画二维码，记得调用multiFormatWriter.encode()时最后要带上hints参数，不然上面设置无效
            BitMatrix bitMatrix = multiFormatWriter
                .encode(url, BarcodeFormat.QR_CODE, width, height, hints);

            //开始画二维码
            BufferedImage barCodeImage = MatrixToImageWriter.writeToFile(bitMatrix, "jpg");
            BufferedImage image = new BufferedImage(barCodeImage.getWidth(),
                barCodeImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFF000000）白（0xFFFFFFFF）两色
            for (int x = 0; x < barCodeImage.getWidth(); x++) {
                for (int y = 0; y < barCodeImage.getHeight(); y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
                }
            }
            return image;
        } catch (WriterException e) {
            e.printStackTrace();
            throw new AlertException("生成二维码失败");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AlertException("生成二维码失败");
        }
    }
}