package be.vlaanderen.example.minioclient.service;

import be.vlaanderen.example.minioclient.exception.BackendServerException;
import be.vlaanderen.example.minioclient.exception.InvalidConfigurationException;
import be.vlaanderen.example.minioclient.exception.InvalidInputException;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class UploadService {
    private final MinioClient minioClient;

    @Value("${minio.bucket}")
    String bucketName;

    public void uploadFile(MultipartFile file) {
        try {

            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(file.getOriginalFilename())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .build());

        } catch (ErrorResponseException | XmlParserException | ServerException | IOException | NoSuchAlgorithmException | InvalidResponseException e) {
            throw new BackendServerException(e);
        } catch (InsufficientDataException e) {
            throw new InvalidInputException(e);
        } catch (InternalException | InvalidKeyException e) {
            throw new InvalidConfigurationException(e);
        }

    }
}
