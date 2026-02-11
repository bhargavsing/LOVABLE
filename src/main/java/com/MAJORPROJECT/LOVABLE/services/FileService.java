package com.MAJORPROJECT.LOVABLE.services;

import com.MAJORPROJECT.LOVABLE.dto.project.FileContentResponse;
import com.MAJORPROJECT.LOVABLE.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {

   List<FileNode> getFileTree(Long projectId, Long userId);
   FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
