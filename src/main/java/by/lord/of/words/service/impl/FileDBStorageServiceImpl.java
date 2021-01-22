package by.lord.of.words.service.impl;

import by.lord.of.words.exception.DocumentNotFountException;
import by.lord.of.words.exception.FileNotFoundException;
import by.lord.of.words.model.FileDB;
import by.lord.of.words.repository.FileDBRepository;
import by.lord.of.words.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class FileDBStorageServiceImpl implements FileStorageService {

    private final FileDBRepository fileDBRepository;

    @Override
    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()); // разобраться с подсветкой
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(fileDB);
    }

    @Override
    public FileDB getFile(String id) {
        return fileDBRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException(id));
    }

    @Override
    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
