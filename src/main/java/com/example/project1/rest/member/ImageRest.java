package com.example.project1.rest.member;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.example.project1.bean.ImageModel;
import com.example.project1.dao.ImageModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/member/image")

public class ImageRest {
    @Autowired
    ImageModelDao imageRepository;
    @PostMapping("/upload")
    public ResponseEntity.BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

    System.out.println("Original Image Byte Size - " + file.getBytes().length);
    ImageModel img = new ImageModel();
    img.setName(file.getName());
    img.setType(file.getContentType());
    img.setPicByte(file.getBytes());
    imageRepository.save(img);
    return ResponseEntity.status(HttpStatus.OK);

    }
    @GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
        ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
