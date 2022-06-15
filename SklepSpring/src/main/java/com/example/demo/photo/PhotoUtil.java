package com.example.demo.photo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class PhotoUtil {
    // tak można odczytać wartość będącą elementem konfiguracji
    @Value("${photo_dir}")
    private String photo_dir;
    
    public byte[] readPhoto(int productId) {
        String fileName = productId + ".jpg";
        Path file = Paths.get(photo_dir, fileName);
        
        try {
            return Files.readAllBytes(file);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produktu o numerze " + productId + " nie posiada zdjęcia");
        }
    }
}



