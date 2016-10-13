# PictureProcessing
To implement several picture transformations, and provide a command line program that allows a user to to transform a specified image, saving the resulting image to a file.

-- Aims
  -- To practice writing simple programs and designing classes in Java.
  -- To introduce the use of packages in Java.
  -- To introduce the unit testing framework JUnit.

-- Problem
  -- You will be given a skeleton project with several helper classes, a partially completed test suite and several test images.
  -- Your task is to implement several picture transformations, and provide a command line program that allows a user to to transform a specified image, saving the resulting image to a file.
  -- You will also need to complete a partially given test suite by adding extra test cases for the parts of your program that it does not currently test.

-- Colours and Pictures
  -- An image can be represented in memory as a bounded two-dimensional array of pixel values. A colour-model is used to translate a pixel-value to colour components. In this lab, pixel-values will be interpreted using the RGB colour-model, so that each point within an image is mapped on to a red, green and blue component. These components are encapsulated in the provided class picture.Color which provides get and set methods for each primary colour. Each component has 256 possible intensities, ranging from 0 to 255. The final colour of each pixel depends on the intensities of the primary colour components. The coordinates (x,y) always mean “along and down”, counting from (0,0) at the top left.
  -- You will be given three helper classes to use during this lab: picture.Color,picture.Picture and picture.Utils.
  
**picture.Color**

The class picture.Color provides the following methods for inspecting and setting the colour components of a pixel:

public int getRed()
public int getGreen()
public int getBlue()
public void setRed(int red)
public void setGreen(int green)
public void setBlue(int blue)

**picture.Picture**

The class picture.Picture defines the following interface for manipulating and querying im- ages:

public int getWidth() returns the width of the picture.
public int getHeight() returns the height of the picture.
public Color getPixel(int x, int y) returns the colour of the pixel-value located at (x, y).
public void setPixel(int x, int y, Color rgb) updates the pixel-value at the lo- cation specified.
public boolean contains(int x, int y) returns true i↵ the specified point lies within the boundaries of the picture.

**picture.Utils**

The class picture.Utils provides a set of static methods to create, load and save picture.Picture objects. For testing purposes, there are some images provided within the images directory of the skeleton project, but you can always find or create new images yourself.

* public static Picture createPicture(int width, int height) creates a new in- stance of a Picture object of the specified width and height, using the RGB colour model.

* public static Picture loadPicture(String locationString) creates a Picture ob- ject from the the picture at the specified location. The location can either be a filesystem location (e.g. "images/red64x64.png"), or a URL (e.g. "http://www.doc.ic.ac.uk/ ~tora/hello.png")

* public static boolean savePicture(Picture picture, String destination) saves the given Picture to the filesystem location in destination. If anything goes wrong while saving, this method returns false, otherwise it returns true.

* public static String toArray(Picture picture) creates a String representation of the colours within the given Picture which may be helpful for debugging purposes.

**Picture Transformations**

You will need to implement the following picture transformations:
