# PictureProcessing

- **Aims**
  - To practice writing simple programs and designing classes in Java.
  - To introduce the use of packages in Java.
  - To introduce the unit testing framework JUnit.

- **Problem**
  - You will be given a skeleton project with several helper classes, a partially completed test suite and several test images.
  - Your task is to implement several picture transformations, and provide a command line program that allows a user to to transform a specified image, saving the resulting image to a file.
  - You will also need to complete a partially given test suite by adding extra test cases for the parts of your program that it does not currently test.

- **Colours and Pictures**
  - An image can be represented in memory as a bounded two-dimensional array of pixel values. A colour-model is used to translate a pixel-value to colour components. In this lab, pixel-values will be interpreted using the RGB colour-model, so that each point within an image is mapped on to a red, green and blue component. These components are encapsulated in the provided class picture.Color which provides get and set methods for each primary colour. Each component has 256 possible intensities, ranging from 0 to 255. The final colour of each pixel depends on the intensities of the primary colour components. The coordinates (x,y) always mean “along and down”, counting from (0,0) at the top left.
  - You will be given three helper classes to use during this lab: picture.Color,picture.Picture and picture.Utils.
  
**picture.Color**

The class picture.Color provides the following methods for inspecting and setting the colour components of a pixel:

* public int getRed()
* public int getGreen()
* public int getBlue()
* public void setRed(int red)
* public void setGreen(int green)
* public void setBlue(int blue)

**picture.Picture**

The class picture.Picture defines the following interface for manipulating and querying im- ages:

* public int getWidth() returns the width of the picture.
* public int getHeight() returns the height of the picture.
* public Color getPixel(int x, int y) returns the colour of the pixel-value located at (x, y).
* public void setPixel(int x, int y, Color rgb) updates the pixel-value at the lo- cation specified.
* public boolean contains(int x, int y) returns true i↵ the specified point lies within the boundaries of the picture.

**picture.Utils**

The class picture.Utils provides a set of static methods to create, load and save picture.Picture objects. For testing purposes, there are some images provided within the images directory of the skeleton project, but you can always find or create new images yourself.

* public static Picture createPicture(int width, int height) creates a new in- stance of a Picture object of the specified width and height, using the RGB colour model.

* public static Picture loadPicture(String locationString) creates a Picture ob- ject from the the picture at the specified location. The location can either be a filesystem location (e.g. "images/red64x64.png"), or a URL (e.g. "http://www.doc.ic.ac.uk/ ~tora/hello.png")

* public static boolean savePicture(Picture picture, String destination) saves the given Picture to the filesystem location in destination. If anything goes wrong while saving, this method returns false, otherwise it returns true.

* public static String toArray(Picture picture) creates a String representation of the colours within the given Picture which may be helpful for debugging purposes.

- **Picture Transformations**

You will need to implement the following picture transformations:

**Invert**

The invert transformation inverts the colour components of each pixel in the given picture. A colour component may be inverted by replacing the original intensity value of each primary colour, *c*, with the intensity (255-*c*).

**Grayscale**

The grayscale transformation creates a monochrome version of the input picture. Gray values, under the RGB colour model, are defined when the values for red, green and blue are equal. A ‘gray’ value can be computed by first, finding the average, *avg* of the three colour components, then creating a new colour with components {red=*avg*, green=*avg*, blue=*avg*}. Note that you should use integer division (by 3 in this case) freely without worrying about rounding errors.

**Rotate**

The rotate transformation creates a picture that is rotated by **90**, **180** or **270** degrees clockwise about the picture’s centre. The angle of rotation will be specified as a command-line parameter to your program.

**Flip**

The flip transformations rotate a picture about an axis. ‘Flip horizontal’ reflects the image about the y-axis, while ‘flip vertical’ mirrors the image about the x-axis. The direction of reflection horizontal, **H** or vertical, **V** will be specified as a command-line parameter to your program.

**Blend**

The blend transformation takes a list of pictures and combines them together so they appear to be layered on top of each other. The resulting picture will have dimensions corresponding to the *smallest* individual width and individual height within the given set of pictures. A blended pixel is computed by finding the average colour component of each pixel across the list of pictures at any point (as before, use integer division to calculate the average). The list of pictures will be passed as arguments to your program.

**Blur**

The blur transformation creates a blurred version of the input picture. A blurred-pixel-value is computed by setting its pixel-value to the average value of its surrounding ‘neighbourhood’ of pixels. For example, the average of the neighbourhood:

new value for *e* =  *avgerage* (surrounding ‘neighbourhood’ + *e*)

Boundary pixels, where a 3x3 neighbourhood is not defined, should not be changed. As with grayscale, you should use integer division when computing the average.

- **Suggested Extensions**

    - **Mosaic**

The mosaic transformation takes a *list* of pictures and combines them together to create a mosaic. The mosaic transform takes a integer parameter, **tile-size**, which specifies the size of a single square mosaic tile. The output picture will have dimensions corresponding to the *smallest* individual width and individual height within the set of specified pictures, *trimmed to be a multiple of the tile-size.*

The tiles in the picture are arranged so that for every tile, the neighbouring tiles to the east and south come from the next picture in the list, (wrapping round as appropriate). The top-left tile comes from the first picture. e.g. Consider making a mosaic of pictures a, b and c (of different sizes, where *a* is 3 tiles wide by 3 tiles high, *b* is four tiles wide by 3 tiles high, and *c* is four tiles wide by four tiles high):
