package picture;

/**
 * Created by jsh3571 on 12/10/2016.
 */

public class Processor {

    public Picture invert(Picture src) {
        int intensity = 255;

        Picture dst =
                picture.Utils.createPicture(src.getWidth(), src.getHeight());

        for (int i = 0; i < dst.getHeight(); i++) {
            for (int j = 0; j < dst.getWidth(); j++) {
                Color c = src.getPixel(j, i);

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                c.setRed(intensity - r);
                c.setGreen(intensity - g);
                c.setBlue(intensity - b);

                dst.setPixel(j, i, c);
            }
        }

        return dst;
    }

    public Picture grayscale(Picture src) {
        Picture dst =
                picture.Utils.createPicture(src.getWidth(), src.getHeight());

        for (int i = 0; i < dst.getHeight(); i++) {
            for (int j = 0; j < dst.getWidth(); j++) {
                Color c = src.getPixel(j, i);

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                int gray = (r+g+b)/3;

                c.setRed(gray);
                c.setGreen(gray);
                c.setBlue(gray);

                dst.setPixel(j, i, c);
            }
        }

        return dst;
    }
}
