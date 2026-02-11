package com.MAJORPROJECT.LOVABLE.controllers;


import com.MAJORPROJECT.LOVABLE.dto.project.FileContentResponse;
import com.MAJORPROJECT.LOVABLE.dto.project.FileNode;
import com.MAJORPROJECT.LOVABLE.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RequestMapping("/api/projects/{projectId}/files")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId =1L;
        return ResponseEntity.ok(fileService.getFileTree(projectId,userId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId,
                                                       @PathVariable String path){
        Long userId=1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId,path,userId));
    }
}
