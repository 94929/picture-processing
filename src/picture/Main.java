package picture;

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
        }
    }
}
