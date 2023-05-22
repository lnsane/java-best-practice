package com.best.spring.boot;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidBucketNameException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author CunLu Wang
 * @since 2023/5/22
 */
@RestController
@Slf4j
public class UploadController {

    @Autowired
    private MinioClient client;

    private final String fileName = "1231231312.png";
    @PostMapping("/upload")
    public void upload(@RequestPart(value = "file") MultipartFile multipartFile) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        InputStream inputStream = multipartFile.getInputStream();
        client.putObject(PutObjectArgs.builder().bucket("dev-itnio-soss").object(fileName).stream(inputStream,
                inputStream.available(), -1).build());
        log.info("图片上传成功");
    }

    @GetMapping("/download")
    public void download( HttpServletResponse response) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        InputStream inputStream = client.getObject(
                GetObjectArgs.builder()
                        .bucket("dev-itnio-soss")  // 存储桶名称
                        .object(fileName)  // 文件在存储桶中的路径和名称
                        .build()
        );
        // 设置响应头
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        // 将文件写入响应输出流
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, bytesRead);
        }

        // 关闭输入流和输出流
        inputStream.close();
        response.getOutputStream().flush();
        response.getOutputStream().close();
        log.info("图片下载成功");
    }
}
