package com.makersacademy.acebook.controller;

import com.makersacademy.acebook.model.Post;
import lombok.var;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class ImageController {

    @RequestMapping(value = "/Homer", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

    public void getHomer(HttpServletResponse response) throws IOException {
//    public void getImage(HttpServletResponse response) throws IOException {

        var imgFile = new ClassPathResource("images/Homer.png");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

    @RequestMapping(value = "images/{pic}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

    public void getImage(HttpServletResponse response, @PathVariable("pic") String pic) throws IOException {

        var imgFile = new ClassPathResource("images/"+pic+".png");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }

}
