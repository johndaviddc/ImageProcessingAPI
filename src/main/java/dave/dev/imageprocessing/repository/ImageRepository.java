package dave.dev.imageprocessing.repository;

import dave.dev.imageprocessing.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
