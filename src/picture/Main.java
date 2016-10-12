package picture;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor();
        Picture src, dst;

        int lastIndex = args.length - 1;

        switch (args[0]) {
            case "invert":
                src = picture.Utils.loadPicture(args[1]);
                dst = processor.invert(src);

                picture.Utils.savePicture(dst, args[lastIndex]);
                break;
            case "grayscale":
                src = picture.Utils.loadPicture(args[1]);
                dst = processor.grayscale(src);

                picture.Utils.savePicture(dst, args[lastIndex]);
                break;
            case "rotate":
                int angle = Integer.parseInt(args[1]);

                src = picture.Utils.loadPicture(args[2]);
                dst = processor.rotate(src, angle);

                picture.Utils.savePicture(dst, args[lastIndex]);
                break;
            case "flip":
                char direction = args[1].charAt(0);

                src = picture.Utils.loadPicture(args[2]);
                dst = processor.flip(src, direction);

                picture.Utils.savePicture(dst, args[lastIndex]);
                break;
            case "blend":
                int nonInputLength = 2;
                int inputLength = args.length - nonInputLength;

                List<Picture> srcs = new ArrayList();

                for (int i = 1; i <= inputLength; i++)
                    srcs.add(picture.Utils.loadPicture(args[i]));

                dst = processor.blend(srcs);
                picture.Utils.savePicture(dst, args[lastIndex]);
                break;
            case "blur":
                src = picture.Utils.loadPicture(args[1]);
                dst = processor.blur(src);

                picture.Utils.savePicture(dst, args[lastIndex]);
                break;
            default:
                System.out.println("The first argument needs to be command.");
                break;
        }
    }
}
