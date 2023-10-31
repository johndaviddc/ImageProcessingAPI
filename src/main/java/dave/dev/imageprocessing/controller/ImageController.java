package dave.dev.imageprocessing.controller;

import dave.dev.imageprocessing.model.Image;
import dave.dev.imageprocessing.service.ImageProcessingException;
import dave.dev.imageprocessing.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
        try {
            // I can implement image upload and processing logic here
            // For example, save the image file, perform validation, and then call the service to save the image data

            String imageUrl = "path/to/my/uploaded/image";
            Image savedImage = imageService/uploadImage(name, imageUrl);

            return ResponseEntity.ok("Image uploaded successfully with ID: " + savedImage.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Image upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        try {
            Image image = imageService.getImageById(id);
            return ResponseEntity.ok(image);
        } catch (ImageProcessingException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
