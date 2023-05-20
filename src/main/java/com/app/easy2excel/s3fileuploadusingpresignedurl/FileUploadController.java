package com.app.easy2excel.s3fileuploadusingpresignedurl;

import com.amazonaws.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadService awsS3Service;
    @Value("${aws.s3.bucket}")
    private String bucketName;

    @GetMapping("/generate-presigned-url")
    public ResponseEntity<String> generatePresignedUrl(@RequestParam String extension) {
        return ResponseEntity.ok(
                awsS3Service.generatePreSignedUrl(UUID.randomUUID()+"."+extension, bucketName, HttpMethod.PUT));
    }
}
