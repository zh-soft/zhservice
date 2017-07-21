package com.zh.qrcode.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.zh.qrcode.configs.QrcodeConfig;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lait on 2017/7/14.
 */
@Service
public class QrcodeService {

    @Autowired
    private QrcodeConfig qrcodeConfig;

    public void generateQRCode(String url,String path,String ext) throws WriterException, IOException {
        String psn = null;
        String regex="(psn=[0-9]*)";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(url);
        while(m.find()){
            psn = m.group(1).substring(4);
        }

        BufferedImage image=null;
        //二维码输出流
        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
        Map map=new HashMap();
        //设置编码方式
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        BitMatrix matrix= multiFormatWriter.encode(url, BarcodeFormat.QR_CODE,qrcodeConfig.getQrcodeWidth() , qrcodeConfig.getQrcodeHeight(),map);
        image= MatrixToImageWriter.toBufferedImage(matrix);
        ImageIO.write(image, "png", new File(qrcodeConfig.getQrcodeStorePath() + File.separator + psn + qrcodeConfig.getQrcodeExt()));
    }


    public void generateQRCode(String url) throws WriterException, IOException {
        generateQRCode(url,qrcodeConfig.getQrcodeStorePath(),qrcodeConfig.getQrcodeExt());
    }






    public static void main(String[] args) {
        QrcodeService  qrcodeService = new QrcodeService();
        try {
            qrcodeService.generateQRCode("http://www.zhservice.cn?brand=yuetu&psn=058917070000000131904&model=KFR-35GW/DY&pt=2017-07-20&gt=3921-01-20&wechat=众合服务","F:/sss",".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
