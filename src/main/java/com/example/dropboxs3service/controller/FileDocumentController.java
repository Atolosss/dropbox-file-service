package com.example.dropboxs3service.controller;

import com.example.dropboxs3service.model.FileDocument;
import com.example.dropboxs3service.service.FileDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequiredArgsConstructor
public class FileDocumentController {

    private FileDocumentService fileDocumentService;

    @RequestMapping(value="/files", method= RequestMethod.POST)
    public String addFile(@RequestParam("title") String title,
                          @RequestParam("file") MultipartFile file, Model model)
            throws IOException {
        String id = fileDocumentService.addFile(title, file);
        return "redirect:/files/" + id;
    }


    @GetMapping("/files/{id}")
    public String getFile(@PathVariable String id, Model model) {
        FileDocument document = fileDocumentService.getFile(id);
        model.addAttribute("title", document.getName());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(document.getFileData().getData()));
        return "files";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }
}
