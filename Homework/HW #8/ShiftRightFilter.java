
/**
 * Write a description of class ShiftRightFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShiftRightFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
        Pixel temp;

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = pi.getWidth()-1; col > 0; col--) {
                if(col != 0){
                temp = data[row][pi.getWidth() - 1];
                data[row][col] = data[row][col-1];
                data[row][1] = temp;
            }
               
            }
        }
        pi.setData(data);
    }
}
