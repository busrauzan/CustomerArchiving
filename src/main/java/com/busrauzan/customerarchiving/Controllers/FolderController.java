package com.busrauzan.customerarchiving.Controllers;

import com.busrauzan.customerarchiving.DataAccess.FolderRepository;
import com.busrauzan.customerarchiving.Entities.Folder;
import com.busrauzan.customerarchiving.ExceptionMessages.ResourceNotFoundException;
import com.busrauzan.customerarchiving.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;

    @GetMapping(path = "/folders")
    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    @GetMapping(path = "/folder/{id}")
    public ResponseEntity<Folder> getFolderById(@PathVariable(value = "id") Long folderId)
            throws ResourceNotFoundException {
        final Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSG_FOLDER + folderId));
        return ResponseEntity.ok().body(folder);
    }

    @PostMapping(path = "/folder")
    public Folder createFolder(@RequestBody Folder folder) {
        return folderRepository.save(folder);
    }

    @PutMapping(path = "folder/{id}")
    public ResponseEntity<Folder> updateFolder(@PathVariable(value = "id") Long folderId,
                                               @RequestBody Folder updatedFolder) throws ResourceNotFoundException {
        final Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSG_FOLDER + folderId));
        updatedFolder.setId(folder.getId());
        return ResponseEntity.ok().body(folderRepository.save(updatedFolder));

    }

    @DeleteMapping(path = "/folder/{id}")
    public Map<String, Boolean> deleteFolder(@PathVariable(value = "id") Long folderId)
            throws ResourceNotFoundException {
        final Folder folder = folderRepository.findById(folderId)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.ERR_MSG_FOLDER + folderId));
        folderRepository.delete(folder);
        Map<String, Boolean> response = new HashMap<>();
        response.put(Constants.DELETED, Boolean.TRUE);
        return response;
    }

}

