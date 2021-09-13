package com.binar.binar.controller.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
//@EnableCaching
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    //Save the uploaded file to this folder

    @Value("${app.uploadto.cdn}")//FILE_SHOW_RUL
    private String UPLOADED_FOLDER;//="/home/tog/toggit/";


    @Autowired
    private FileStorageService fileStorageService;


    @RequestMapping(value = "/v1/upload", method = RequestMethod.POST, consumes = {"multipart/form-data", "application/json"})
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMyyyyhhmmss");
        String strDate = formatter.format(date);
        System.out.println("date=" + strDate);
        String fileName = UPLOADED_FOLDER + strDate + file.getOriginalFilename();
        String fileNameforDOwnload = strDate + file.getOriginalFilename();
        Path TO = Paths.get(fileName);
        System.out.println("fileNameforDOwnload=" + fileNameforDOwnload);
        System.out.println("file=" + file.getName());
        System.out.println("file.getContentType()=" + file.getContentType()); // image/png
        System.out.println("file.getResource()=" + file.getResource()); // 23474 == 23kb  , 10000kb = 10MB https://www.google.com/search?q=1+kb+berapa+mb&oq=1+kb+berapa+mb&aqs=chrome..69i57j0i22i30l9.3835j0j4&sourceid=chrome&ie=UTF-8
        System.out.println("file.getOriginalFilename()=" + file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), TO);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            return new UploadFileResponse(fileName, null,
                    file.getContentType(), file.getSize(), e.getMessage());
        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/v1/showFile/")
                .path(fileNameforDOwnload)
                .toUriString();

        return new UploadFileResponse(fileNameforDOwnload, fileDownloadUri,
                file.getContentType(), file.getSize(), "false");
    }

    @GetMapping("v1/showFile/{fileName:.+}")
    public ResponseEntity<Resource> showFile(@PathVariable String fileName, HttpServletRequest request) {


        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            System.out.println("resource.getFile().getAbsolutePath" + resource.getFile().getAbsolutePath());
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }


        System.out.println("filename=2=" + HttpHeaders.CONTENT_DISPOSITION);
        System.out.println("filename=3=" + resource.getFilename());
        System.out.println("filename=3=" + resource);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }



    @PostMapping("v1/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
        return Arrays.asList(files)
                .stream()
                .map(file -> {
                    try {
                        return uploadFile(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }


    private File multipartToFile(MultipartFile upload, String routeName) {
        String base = "";


        logger.info(String.format("Trying upload file: %s", upload.getOriginalFilename()));

        File file = new File(base + upload.getOriginalFilename());

        try {
            logger.info(String.format("Saving uploaded file to: '%s'", file.getAbsolutePath()));
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(upload.getBytes());
            fos.close();
        } catch (IOException e) {
            logger.error(String.format("Error: POST|UPLOAD %s", routeName), e);
        }

        return file;
    }

    private File multipartToFile(MultipartFile upload) {
        return multipartToFile(upload, UPLOADED_FOLDER);
    }





}
