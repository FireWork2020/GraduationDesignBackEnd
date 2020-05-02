package per.gyx.graduationdesign.Utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class QRCodeGenerator {
    public static final int QRCODE_SIZE = 300;

    public static void generateQRCodePic(String content){
        generateQRCodePic(content,300,300,"png");
    }
    public static void generateQRCodePic(String content,int width,int height,String picFormat){
        //hints参数信息
        HashMap<EncodeHintType,Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hints.put(EncodeHintType.MARGIN,1);
        String path = "/Users/gwag-wi/QRCode/"+content+".png";
        try{
            //构造二维字节数组
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
            Path outPutPath = Paths.get(path);
            MatrixToImageWriter.writeToPath(bitMatrix,"png",outPutPath);
        }catch (WriterException | IOException e){
            e.printStackTrace();
        }
    }
    public static void deleteQRCodePic(String picName){
        String path = "/Users/gwag-wi/QRCode/" + picName +".png";
        File file = new File(path);
        if(file.delete()){
            System.out.println(file.getName()+" file has been deleted");
        }else{
            System.out.println("File Name:"+picName+"file deleted fail");
        }
    }
}
