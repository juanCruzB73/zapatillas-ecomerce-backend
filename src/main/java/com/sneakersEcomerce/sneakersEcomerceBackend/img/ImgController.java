package com.sneakersEcomerce.sneakersEcomerceBackend.img;

import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/img")
public class ImgController extends GenericController<ImgModel,Integer> {
    @Autowired
    ImgService imgService;
    public ImgController(ImgService imgService){
        super(imgService);
    }
    @PostMapping("/upload")
    public ResponseEntity<List<ImgModel>> uploadImages(@RequestParam("files") List<MultipartFile> files) {
        try{
            List<ImgModel>uploaded=imgService.uploadMultiple(files);
            return ResponseEntity.ok(uploaded);
        }catch (IOException e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
