import Media.*;                  // for Picture and PictureDisplayer
import java.awt.*;               // for Color class
import BasicIO.*;

/** This class is a program to show color represented by RGB value.
  * 
  * @author  D. Hughes
  * 
  * @version  1.0 (June 2013)
  * 
  * new concepts: Picture constructor, function method                           */

public class ColorPicker {
    BasicForm bf;
    int R;
    int G;
    int B;
    int button;
        
    public ColorPicker ( ) {
        Picture pic;     // picture to be displayed
        Color c;
        c = new Color(0,0,0);
        pic = makeSwatch(200,200,c);
        buildForm();
        while(true){
            button = bf.accept();
            if (button == 0){
            R=bf.readInt("sR");
            G=bf.readInt("sG");
            B=bf.readInt("sB");
            c = new Color(R,G,B);
            pic = makeSwatch(200,200,c);
            bf.placePicture("can",pic);
            }
            if (button==1){
            pic.save();
            }
            if(button==2){
            break;
            }
        }
    }  // constructor
    
    
    private Picture makeSwatch ( int width, int height, Color aColor ) {
        
        Picture  result;  // picture for swatch
        Pixel    p;       // a pixel of the picture
        
        result = new Picture(width,height);
        while ( result.hasNext() ) {
            p = result.next();
            p.setColor(aColor);
        };
        return result;
        
    }
    // makeSwatch
    private void buildForm(){
        bf = new BasicForm("View", "Save", "Quit");
        bf.addSlider("sR","R",0,255);

        bf.addSlider("sG","G",0,255);
        
        bf.addSlider("sB","B",0,255);
        
        bf.addCanvas("can","Color");
    }
    
    
}  // ColorPicker