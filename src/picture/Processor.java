package picture;

/**
 * Created by jsh3571 on 12/10/2016.
 */

public class Processor {

    public Picture invert(Picture src) {
        int intensity = 255;

        for (int i = 0; i < src.getWidth(); i++) {
            for (int j = 0; j < src.getHeight(); j++) {
                Color c = src.getPixel(i, j);

                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                c.setRed(intensity - r);
                c.setGreen(intensity - g);
                c.setBlue(intensity - b);

                src.setPixel(i, j, c);
            }
        }

        return src;
    }

    public Picture grayscale(Picture src) {
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

                src.setPixel(i, j, c);
            }
        }

        return src;
    }

    public Picture rotate(Picture src, int angle) {
        int offset = 1;
        int oneCycle = 360;
        int rightAngle = 90;

        Picture dst
                = picture.Utils.createPicture(src.getWidth(), src.getHeight());

        while (angle != oneCycle) {
            dst = picture.Utils.createPicture(src.getHeight(), src.getWidth());

            for (int i = 0; i < src.getWidth(); i++)
                for (int j = 0; j < src.getHeight(); j++)
                    dst.setPixel(j, src.getWidth()-offset-i, src.getPixel(i, j));

            src = dst;
            angle += rightAngle;
        }

        return dst;
    }

    public Picture flip(Picture src, char direction) {
        int width = src.getWidth();
        int height = src.getHeight();

        int offset = 1;

        Picture dst
                = picture.Utils.createPicture(width, height);

        switch (direction) {
            case 'H':
                for (int i = 0; i < width; i++)
                    for (int j = 0; j < height; j++)
                        dst.setPixel(width - offset - i, j, src.getPixel(i, j));
                break;
            case 'V':
                for (int i = 0; i < width; i++)
                    for (int j = 0; j < height; j++)
                        dst.setPixel(i, height - offset - j, src.getPixel(i, j));
                break;
            default:
                System.out.println("Direction must be either of 'H' or 'V'.");
                break;
        }

        return dst;
    }
}
