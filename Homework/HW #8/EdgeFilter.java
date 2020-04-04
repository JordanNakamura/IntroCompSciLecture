
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

        Pixel[][] newData = new Pixel[data.length][data[0].length]; // create new array
        
        newData = data;

        for (int row = 0; row < pi.getHeight(); row++) {
            for (int col = 0; col < pi.getWidth(); col++) {
                //top left corner
                if(row == 0 && col == 0){
                    //right pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //down pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col].getRed() + data[row + 1][col].getBlue()+data[row + 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col + 1].getRed() + data[row + 1][col + 1].getBlue()+data[row + 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //top right pixel
                else if(row == 0 && col == pi.getWidth() - 1){
                    //left pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col-1].getRed() + data[row][col-1].getBlue()+data[row][col-1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col].getRed() + data[row + 1][col].getBlue()+data[row + 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col - 1].getRed() + data[row + 1][col - 1].getBlue()+data[row + 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //bottom right corner
                else if(row == pi.getHeight()-1 && col == pi.getWidth()-1){
                    //left pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col-1].getRed() + data[row][col-1].getBlue()+data[row][col-1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col].getRed() + data[row - 1][col].getBlue()+data[row - 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col - 1].getRed() + data[row - 1][col - 1].getBlue()+data[row - 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //bottom left corner
                else if(row == pi.getHeight() - 1 && col == 0){
                    //right pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //down pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col].getRed() + data[row - 1][col].getBlue()+data[row - 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col + 1].getRed() + data[row - 1][col + 1].getBlue()+data[row - 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //left side
                else if(col == 0 && row != 0 && row != pi.getHeight() -1){
                    //right pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //down pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col].getRed() + data[row - 1][col].getBlue()+data[row - 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //up pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col].getRed() + data[row + 1][col].getBlue()+data[row + 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col + 1].getRed() + data[row - 1][col + 1].getBlue()+data[row - 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col + 1].getRed() + data[row + 1][col + 1].getBlue()+data[row + 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //top side
                else if(row == 0 && col != pi.getWidth() && col != 0){
                    //right pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col-1].getRed() + data[row][col-1].getBlue()+data[row][col-1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //down pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col].getRed() + data[row + 1][col].getBlue()+data[row + 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col + 1].getRed() + data[row + 1][col + 1].getBlue()+data[row + 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col - 1].getRed() + data[row + 1][col - 1].getBlue()+data[row + 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //right side
                else if(row != pi.getHeight() -1 && row != 0 && col == pi.getWidth() - 1){
                    //left pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col-1].getRed() + data[row][col-1].getBlue()+data[row][col-1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //up pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col].getRed() + data[row - 1][col].getBlue()+data[row - 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //down pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col].getRed() + data[row + 1][col].getBlue()+data[row + 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col - 1].getRed() + data[row + 1][col - 1].getBlue()+data[row + 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col - 1].getRed() + data[row - 1][col - 1].getBlue()+data[row - 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //bottom side
                else if(row == pi.getHeight() - 1 && col !=0 && col != pi.getWidth()){
                    //right pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col-1].getRed() + data[row][col-1].getBlue()+data[row][col-1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //up pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col].getRed() + data[row - 1][col].getBlue()+data[row - 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col + 1].getRed() + data[row - 1][col + 1].getBlue()+data[row - 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col - 1].getRed() + data[row - 1][col - 1].getBlue()+data[row - 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                //inside pixel
                else if(row != 0 && row != pi.getHeight()-1 && col != 0 && col != pi.getWidth()-1){
                    //right pixel
                    if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col+1].getRed() + data[row][col+1].getBlue()+data[row][col+1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row][col-1].getRed() + data[row][col-1].getBlue()+data[row][col-1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //down pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col].getRed() + data[row + 1][col].getBlue()+data[row + 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //up pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col].getRed() + data[row - 1][col].getBlue()+data[row - 1][col].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col + 1].getRed() + data[row + 1][col + 1].getBlue()+data[row + 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //bottom left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row + 1][col - 1].getRed() + data[row + 1][col - 1].getBlue()+data[row + 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top right pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col + 1].getRed() + data[row - 1][col + 1].getBlue()+data[row - 1][col + 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    //top left pixel
                    else if(Math.abs(((data[row][col].getRed()+data[row][col].getBlue()+data[row][col].getGreen())/3) 
                        - ((data[row - 1][col - 1].getRed() + data[row - 1][col - 1].getBlue()+data[row - 1][col - 1].getGreen())/3))>20){
                        newData[row][col].setAllColors(0,0,0);
                    }
                    else{
                        newData[row][col].setAllColors(255,255,255);
                    }
                }
                
            }
        }  
        // reset data into the PixelImage object pi
        pi.setData(newData);
    }

}
