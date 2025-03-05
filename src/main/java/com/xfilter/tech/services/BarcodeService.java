package com.xfilter.tech.services;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;

public interface BarcodeService {
    BufferedImage generateEAN13BarcodeImage(String barcodeContent, int width, int height) throws WriterException;
    BufferedImage generateCode128BarcodeImage(String barcodeContent, int width, int height) throws WriterException;
}
