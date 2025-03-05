package com.xfilter.tech.api;

import com.xfilter.tech.services.QRCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/qr")
@Slf4j
public class QRCodeApi {
    @Autowired
    private QRCodeService qrCodeService;

    @GetMapping(value = "/generate/{qrCode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> genQRCode(@PathVariable("qrCode") String qrCode) {
        log.info("genQRCode|qrCode|"+qrCode);
        try{
            BufferedImage bufferedImage = qrCodeService.generateQrCode(qrCode, 200, 200);
            return new ResponseEntity<>(bufferedImage, HttpStatus.OK);
        } catch (Exception ex){
            log.error("genQRCode|error|"+ex.getMessage(), ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
