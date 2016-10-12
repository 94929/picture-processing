package picture;

import java.util.List;

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

    public Picture blend(List<Picture> srcs) {
        int minWidth = Integer.MAX_VALUE;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < srcs.size(); i++) {
            Picture temp = srcs.get(i);
            if (minWidth > temp.getWidth()) minWidth = temp.getWidth();
            if (minHeight > temp.getHeight()) minHeight = temp.getHeight();
        }

        Picture dst = picture.Utils.createPicture(minWidth, minHeight);

        for (int i = 0; i < srcs.size(); i++) {
            Picture temp = srcs.get(i);

            if (i == 0) {
                for (int x = 0; x < minWidth; x++) {
                    for (int y = 0; y < minHeight; y++) {
                        Color c = temp.getPixel(x, y);
                        dst.setPixel(x, y, c);
                    }
                }
            } else {
                for (int x = 0; x < minWidth; x++) {
                    for (int y = 0; y < minHeight; y++) {
                        Color dstPixel = dst.getPixel(x, y);
                        Color tempPixel = temp.getPixel(x, y);

                        int r = (dstPixel.getRed() + tempPixel.getRed())/2;
                        int g = (dstPixel.getGreen() + tempPixel.getGreen())/2;
                        int b = (dstPixel.getBlue() + tempPixel.getBlue())/2;

                        Color c = new Color(r, g, b);

                        dst.setPixel(x, y, c);
                    }
                }
            }
        }
        return dst;
    }

    public Picture blur(Picture src) {
        int width = src.getWidth();
        int height = src.getHeight();

        Picture dst =
                picture.Utils.createPicture(width, height);

        int offset = 1;
        int surroundingCells = 9;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                /* When new value has to be calculated. */
                if (i > 0 && j > 0 &&
                        i < width - offset && j < height - offset) {

                    Color NW = src.getPixel(i-1,j-1);
                    Color N  = src.getPixel(i-1, j);
                    Color NE = src.getPixel(i-1, j+1);

                    Color W  = src.getPixel(i, j-1);
                    Color C  = src.getPixel(i, j);
                    Color E  = src.getPixel(i, j+1);

                    Color SW = src.getPixel(i+1, j-1);
                    Color S  = src.getPixel(i+1, j);
                    Color SE = src.getPixel(i+1, j+1);

                    int newRed   = (NW.getRed()+N.getRed()+NE.getRed()+
                            W.getRed()+C.getRed()+E.getRed()+
                            SW.getRed()+S.getRed()+SE.getRed())
                            /surroundingCells;
                    int newGreen = (NW.getGreen()+N.getGreen()+NE.getGreen()+
                            W.getGreen()+C.getGreen()+E.getGreen()+
                            SW.getGreen()+S.getGreen()+SE.getGreen())
                            /surroundingCells;
                    int newBlue  = (NW.getBlue()+N.getBlue()+NE.getBlue()+
                            W.getBlue()+C.getBlue()+E.getBlue()+
                            SW.getBlue()+S.getBlue()+SE.getBlue())
                            /surroundingCells;

                    Color c = new Color(newRed, newGreen, newBlue);

                    dst.setPixel(i, j, c);
                }

                /* Otherwise. */
                else {
                    dst.setPixel(i, j, src.getPixel(i, j));
                }
            }
        }

        return dst;
    }

    public Picture mosaic(List<Picture> srcs) {

        return srcs.get(0);
    }
}
