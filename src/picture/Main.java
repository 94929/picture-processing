package picture;

public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor();

        if (args[0].equals("invert")) {
            Picture src = picture.Utils.loadPicture(args[1]);
            Picture dst = processor.invert(src);

            picture.Utils.savePicture(dst, args[2]);
        }
    }
}
