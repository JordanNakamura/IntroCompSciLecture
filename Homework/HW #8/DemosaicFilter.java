
/**
 * Write a description of class DemosaicFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DemosaicFilter implements Filter
{
    
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();  // get image data
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int row = 0; row < pi.getHeight()-1; row++) {
            for (int col = 0; col < pi.getWidth()-1; col++) {
                if(data[row][col].getDigCamColor() == Pixel.RED){
                    data[row][col].setRed(data[row][col].getRed());
                }
                else if(data[row][col].getDigCamColor() == Pixel.BLUE){
                    data[row][col].setBlue(data[row][col].getBlue());
                }
                else if(data[row][col].getDigCamColor() == Pixel.GREEN){
                    data[row][col].setGreen(data[row][col].getGreen());
                }
                //checks top left corner 
                if(row == 0 && col == 0){   
                    if(data[row + 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //ckecks bottom left corner
                else if(row == pi.getHeight() && col == 0){   
                    if(data[row - 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //top right corner 
                else if(row == 0 && col == pi.getWidth()){   
                    if(data[row + 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //bottom right corner
                else if(row == pi.getHeight() && col == pi.getWidth()){   
                    if(data[row - 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //top side 
                else if(row == 0 && col != 0 && col != pi.getWidth()){
                    if(data[row + 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //left side
                else if(row != 0 && col == 0 && row != pi.getHeight()){
                    if(data[row + 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row - 1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row - 1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row - 1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //right side 
                else if(row != 0 && col == pi.getWidth() && row != pi.getHeight()){
                    if(data[row + 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row - 1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row - 1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row - 1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                //bottom side
                else if(row == pi.getHeight() && col != 0 && col != pi.getWidth()){
                    if(data[row - 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                
                else if(row != 0 && row != pi.getHeight() && col != 0 && col != pi.getWidth()){
                    if(data[row - 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row - 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row + 1][col].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row + 1][col].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row+1][col-1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row+1][col-1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                    if(data[row-1][col+1].getDigCamColor() == Pixel.GREEN){
                        green = green + 1;
                    }
                    else if(data[row-1][col+1].getDigCamColor() == Pixel.BLUE){
                        blue = blue + 1;
                    }
                    else if(data[row-1][col+1].getDigCamColor() == Pixel.RED){
                        red = red + 1;
                    }
                }
                
                
                
                Pixel pixel = data[row][col];
                data[row][col].setRed(red*50);
                data[row][col].setBlue(blue*50);
                data[row][col].setGreen(green*50);
                
                red = 0;
                green = 0;
                blue = 0;

            }
        }
        pi.setData(data);
    }
}
