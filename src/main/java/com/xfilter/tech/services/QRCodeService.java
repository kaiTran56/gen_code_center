package com.xfilter.tech.services;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    BufferedImage generateQrCode(final String qrCodeText, final int width, final int height) throws WriterException;

}
