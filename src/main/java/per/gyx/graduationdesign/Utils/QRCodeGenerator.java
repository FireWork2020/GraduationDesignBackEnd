package per.gyx.graduationdesign.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;

public class QRCodeGenerator {
    public static final int QRCODE_SIZE = 300;
    public static final String CONTENT = "123456";

    public static void generateQRCodePic(String content,int width,int height,String picFormat){
        HashMap<EncodeHintType,Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hints.put(EncodeHintType.MARGIN,1);
        String path = "/Users/gwag-wi/QRCode/first.png";
        try{
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path outPutPath = Paths.get(path);
            MatrixToImageWriter.writeToPath(bitMatrix,"png",outPutPath);
        }catch (WriterException | IOException e){
            e.printStackTrace();
        }
    }
}
