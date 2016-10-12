package picture;

/**
 * Created by jsh3571 on 12/10/2016.
 */

public class Processor {

    public Picture invert(Picture src) {
        int intensity = 255;

        Picture dst =
                picture.Utils.createPicture(src.getWidth(), src.getHeight());

        for (int i = 0; i < src.getWidth(); i++) {
            for (int j = 0; j < src.getHeight(); j++) {
                Color c = src.getPixel(i, j);

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                c.setRed(intensity - r);
                c.setGreen(intensity - g);
                c.setBlue(intensity - b);

                dst.setPixel(i, j, c);
            }
        }

        return dst;
    }

    public Picture grayscale(Picture src) {
        Picture dst =
                picture.Utils.createPicture(src.getWidth(), src.getHeight());

        for (int i = 0; i < src.getWidth(); i++) {
            for (int j = 0; j < src.getHeight(); j++) {
                Color c = src.getPixel(i, j);

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                int gray = (r+g+b)/3;

                c.setRed(gray);
                c.setGreen(gray);
                c.setBlue(gray);

                dst.setPixel(i, j, c);
            }
        }

        return dst;
    }

    public Picture rotate(Picture src, int angle) {
        int width = src.getWidth();
        int height = src.getHeight();

        Color[][] srcArr = new Color[width][height];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                srcArr[j][i] = src.getPixel(j, i);

        Color[][] dstArr = new Color[height][width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                dstArr[j][i] = new Color(1, 1, 1);
            }
        }

        return src;
    }
}
