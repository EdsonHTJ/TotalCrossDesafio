package com.totalcross;


import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.gfx.Color;
import totalcross.ui.image.Image;

public class temperstureStudyContainer extends Container{
    ImageControl TControl;
    ImageControl THistoryControl;
    Label tempLabel =  new Label("20.9°");
    Button ContainerButton =  new Button(" ");

    @Override
    public void initUI(){
        setBorderStyle(BORDER_ROUNDED);
        add(new Label("Estudo da Temperatura"),LEFT+5,TOP+10);
        tempLabel.setFont(tempLabel.getFont().adjustedBy(10));
        add(tempLabel,LEFT+5,AFTER+10);
        try{
            Image Thermometer =  new Image("/utils/thermometerIcon.png");
            Thermometer.applyColor(Color.getRGB(20,20,150));
            Thermometer.applyColor2(Color.getRGB(20,20,150));
           // Thermometer.changeColors(Color.BLACK, Color.getRGB(20,20,150));
            Thermometer.applyChanges();

            TControl  = new ImageControl(Thermometer.scaledBy(0.2, 0.15));
            

            THistoryControl=  new ImageControl( new Image("./utils/tHistory.png"));
        }catch(Exception e){
        
        }
        add(TControl,RIGHT-5,TOP+10); 
        add(THistoryControl,LEFT,BOTTOM,PARENTSIZE,PREFERRED);  
        ContainerButton.setBorder(BORDER_NONE);
        ContainerButton.transparentBackground=true; 
        add(ContainerButton,LEFT,TOP,FILL,FILL);      
    }
    
}
