package picture;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor();

        if (args[0].equals("invert")) {
            Picture src = picture.Utils.loadPicture(args[1]);
            Picture dst = processor.invert(src);

            picture.Utils.savePicture(dst, args[2]);
        } else if (args[0].equals("grayscale")) {
            Picture src = picture.Utils.loadPicture(args[1]);
            Picture dst = processor.grayscale(src);

            picture.Utils.savePicture(dst, args[2]);
        } else if (args[0].equals("rotate")) {
            int angle = Integer.parseInt(args[1]);

            Picture src = picture.Utils.loadPicture(args[2]);
            Picture dst = processor.rotate(src, angle);

            picture.Utils.savePicture(dst, args[3]);
        } else if (args[0].equals("flip")) {
            char direction = args[1].charAt(0);

            Picture src = picture.Utils.loadPicture(args[2]);
            Picture dst = processor.flip(src, direction);

            picture.Utils.savePicture(dst, args[3]);
        } else if (args[0].equals("blend")) {
            int nonInputLength = 2;
            int inputLength = args.length - nonInputLength;

            List<Picture> srcs = new ArrayList();

            for (int i = 1; i <= inputLength; i++)
                srcs.add(picture.Utils.loadPicture(args[i]));

            Picture dst = processor.blend(srcs);
            picture.Utils.savePicture(dst, args[args.length - 1]);
        } else if (args[0].equals("blur")) {
            Picture src = picture.Utils.loadPicture(args[1]);
            Picture dst = processor.blur(src);

            picture.Utils.savePicture(dst, args[2]);
        } else if (args[0].equals("mosaic")) {
            int nonInputLength = 2;
            int inputLength = args.length - nonInputLength;

            List<Picture> srcs = new ArrayList();

            for (int i = 1; i <= inputLength; i++)
                srcs.add(picture.Utils.loadPicture(args[i]));

            Picture dst = processor.mosaic(srcs);
            picture.Utils.savePicture(dst, args[args.length - 1]);
        } else {
            System.out.println("The first argument needs to be a command.");
        }
    }
}
