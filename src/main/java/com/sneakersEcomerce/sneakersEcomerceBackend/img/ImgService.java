package com.sneakersEcomerce.sneakersEcomerceBackend.img;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.sneakersEcomerce.sneakersEcomerceBackend.generycs.GenericServiceImpl;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ImgService extends GenericServiceImpl<ImgModel,Integer> {

    Dotenv dotenv = Dotenv.load();
    @Autowired
    Cloudinary cloudinary;
    @Autowired
    ImgRepository imgRepository;

    public ImgService(ImgRepository imgRepository){
        super(imgRepository);
    }
    @PostMapping("/upload")
    public List<ImgModel> uploadMultiple(List<MultipartFile> files) throws IOException {
        List<ImgModel>uploaedImages=new ArrayList<>();
        for (MultipartFile file:files){
            Map<?,?>uploadResults=cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            ImgModel img=ImgModel.builder()
                    .imgName((String) uploadResults.get("original_filename"))
                    .imgUrl((String) uploadResults.get("secure_url"))
                    .build();
            uploaedImages.add(img);
            imgRepository.save(img);
        }
        return uploaedImages;
    }
}
