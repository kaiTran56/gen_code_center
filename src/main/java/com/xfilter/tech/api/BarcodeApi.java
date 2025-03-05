package com.xfilter.tech.api;

import com.xfilter.tech.services.BarcodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@Slf4j
@RequestMapping("/barcode")
public class BarcodeApi {
    @Autowired
    private BarcodeService barcodeService;
    @GetMapping(value = "/generate/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> barbecueEAN13Barcode(@PathVariable("barcode") String barcode) {
        log.info("barbecueEAN13Barcode|barcode|"+barcode);
        try{
            BufferedImage bufferedImage = barcodeService.generateEAN13BarcodeImage(barcode, 200, 200);
            return new ResponseEntity<>(bufferedImage, HttpStatus.OK);
        } catch (Exception ex){
            log.error("barbecueEAN13Barcode|error|"+ex.getMessage(), ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/generate/code128/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<?> barbecueCode128Barcode(@PathVariable("barcode") String barcode) {
        log.info("barbecueCode128Barcode|barcode|"+barcode);
        try{
            BufferedImage bufferedImage = barcodeService.generateCode128BarcodeImage(barcode, 200, 200);
            return new ResponseEntity<>(bufferedImage, HttpStatus.OK);
        } catch (Exception ex){
            log.error("barbecueCode128Barcode|error|"+ex.getMessage(), ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
