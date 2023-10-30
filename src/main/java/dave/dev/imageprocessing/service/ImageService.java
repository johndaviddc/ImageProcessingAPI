package dave.dev.imageprocessing.service;

import dave.dev.imageprocessing.model.Image;
import dave.dev.imageprocessing.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image uploadImage(String name, String url) {
        Image image = new Image(name, url);
        return imageRepository.save(image);
    }

    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() -> new ImageProcessingException("Image not found with ID: " + id));
    }

    public void deleteImage(Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
        } else {
            throw new ImageProcessingException("Image not found with ID: " + id);
        }
    }
}
