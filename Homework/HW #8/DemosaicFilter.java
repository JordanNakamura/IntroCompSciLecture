
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

        Pixel[][] newData = new Pixel[data.length][data[0].length];
        int red = 0;
        int green = 0;
        int blue = 0;
        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                if(row != 0 && row != pi.getHeight()-1 && col != 0 && col != pi.getWidth()-1){
                    if(data[row][col].getDigCamColor() == Pixel.RED){
                        green = getGreenAvg(data[row + 1][col], data[row - 1][col], data[row][col - 1], data[row][col + 1]);
                        blue = getBlueAvg(data[row + 1][col + 1], data[row - 1][col - 1], data[row + 1][col - 1], data[row - 1][col + 1]);
                        red = data[row][col].getRed();
                        newData[row][col] = new Pixel(red, green, blue);
                    }
                    else if(data[row][col].getDigCamColor() == Pixel.BLUE){
                        green = getGreenAvg(data[row + 1][col], data[row - 1][col], data[row][col - 1], data[row][col + 1]);
                        red = getRedAvg(data[row + 1][col + 1], data[row - 1][col - 1], data[row + 1][col - 1], data[row - 1][col + 1]);
                        blue = data[row][col].getBlue();
                        newData[row][col] = new Pixel(red, green, blue);
                    }
                    else if(data[row][col].getDigCamColor() == Pixel.GREEN){
                        red = getRedAvg(data[row + 1][col], data[row - 1][col], data[row][col - 1], data[row][col + 1]);
                        blue = getBlueAvg(data[row + 1][col], data[row - 1][col], data[row][col - 1], data[row][col + 1]);
                        green = (data[row + 1][col + 1].getGreen() + data[row - 1][col - 1].getGreen() + data[row + 1][col - 1].getGreen() + data[row - 1][col + 1].getGreen() + data[row][col].getGreen()) / 5;
                        newData[row][col] = new Pixel(red, green, blue);
                    }
                }
                else{
                    newData[row][col] = new Pixel(0,0,0);
                }
                /**
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
                } */
                red = 0;
                green = 0;
                blue = 0;

            }
        }
        pi.setData(newData);
    }

    public static int getGreenAvg(Pixel p1, Pixel p2, Pixel p3, Pixel p4){
        return (p1.getGreen() + p2.getGreen() + p3.getGreen() + p4.getGreen()) / 4;
    }

    public static int getBlueAvg(Pixel p1, Pixel p2, Pixel p3, Pixel p4){
        return (p1.getBlue() + p2.getBlue() + p3.getBlue() + p4.getBlue()) / 4;
    }
    
    public static int getRedAvg(Pixel p1, Pixel p2, Pixel p3, Pixel p4){
        return (p1.getRed() + p2.getRed() + p3.getRed() + p4.getRed()) / 4;
    }

}
