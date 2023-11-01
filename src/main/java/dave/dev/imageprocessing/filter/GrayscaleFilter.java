package dave.dev.imageprocessing.filter;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

public class GrayscaleFilter {
    public static BufferedImage applyGrayscaleFilter(String inputImagePath, String outputImagePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(inputImagePath));

        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        BufferedImage grayscaleImage = op.filter(image, null);
    }
}
