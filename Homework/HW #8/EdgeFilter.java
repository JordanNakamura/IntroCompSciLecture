
/**
 * Write a description of class EdgeFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EdgeFilter implements Filter
{


    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
        
        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                data[row][col].getRed();
                data[row][col].getBlue();
                data[row][col].getGreen();
                if(row != 0 && row != pi.getHeight() && col != 0 && col != pi.getWidth()){
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        
                    }
                    }
            }
        }  
        // reset data into the PixelImage object pi
        pi.setData(data);
}


}

