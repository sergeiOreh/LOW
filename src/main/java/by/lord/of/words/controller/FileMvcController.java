package by.lord.of.words.controller;

import by.lord.of.words.dto.ResponseFile;
import by.lord.of.words.service.impl.FileDBStorageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class FileMvcController {

    private final FileDBStorageServiceImpl fileDBService;

    @GetMapping("/")
    public String listUploadedFiles(Model model) {
        model.addAttribute("files", fileDBService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList()));

        return "uploadForm";
    }

    // загружает файлы в систему
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        String message = "";
        // обрабатывать здесь или пробрасывать наверх?
        try {
            fileDBService.store(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename() + "!";
            redirectAttributes.addFlashAttribute("message", message);
        } catch (IOException e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            redirectAttributes.addFlashAttribute("message", message);
        }
        return "redirect:/";
    }

}
