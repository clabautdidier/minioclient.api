package be.vlaanderen.example.minioclient.service;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Bean
    public MinioClient minioClient(
            @Value("${minio.url}") String minioUrl,
            @Value("${minio.accesskey}") String minioAccessKey,
            @Value("${minio.secretkey}") String minioSecretKey
            ) {
        return MinioClient.builder()
                .endpoint(minioUrl)
                .credentials(minioAccessKey, minioSecretKey)
                .build();
    }
}
