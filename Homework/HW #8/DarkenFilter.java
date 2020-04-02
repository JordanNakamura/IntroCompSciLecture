
/**
 * Write a description of class DarkenFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DarkenFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
    
        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                data[row][col].setRed(data[row][col].getRed()/2);
                data[row][col].setBlue(data[row][col].getBlue()/2);
                data[row][col].setGreen(data[row][col].getGreen()/2);
            }
        }
        pi.setData(data);
    }
}
