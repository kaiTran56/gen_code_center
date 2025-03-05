package com.xfilter.tech.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
@Slf4j
public class BarcodeServiceImpl implements BarcodeService{

    @Override
    public BufferedImage generateEAN13BarcodeImage(@NonNull String barcodeContent, int width, int height) throws WriterException {
        log.info("generateEAN13BarcodeImage|barcodeContent|"+barcodeContent);
        MultiFormatWriter writer = new  MultiFormatWriter();
        BitMatrix bitMatrix = writer.encode(barcodeContent, BarcodeFormat.EAN_13,width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    @Override
    public BufferedImage generateCode128BarcodeImage(@NonNull String barcodeContent, int width, int height) throws WriterException {
        log.info("generateCode128BarcodeImage|barcodeContent|"+barcodeContent);
        MultiFormatWriter writer = new  MultiFormatWriter();
        BitMatrix bitMatrix = writer.encode(barcodeContent, BarcodeFormat.CODE_128,width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
