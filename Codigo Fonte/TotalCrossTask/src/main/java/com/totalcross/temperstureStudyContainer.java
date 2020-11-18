package com.totalcross;


import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.Image;

public class temperstureStudyContainer extends Container{
    ImageControl TControl;
    ImageControl THistoryControl;
    Label tempLabel =  new Label("20.9°");
    Button ContainerButton =  new Button(" ");


    public void TempStudyPop(){

        SimplePopupWindow pwindow = new SimplePopupWindow();
        pwindow.name = new Label("Estudo da Temperatura");

        pwindow.container=new Container(){
            @Override
            public void initUI() {
                setBorderStyle(BORDER_ROUNDED);
                add(new Container(){
                    public void initUI(){
                        try{
                            Image Thermometer =  new Image("utils/thermometerIcon.png");

                            TControl  = new ImageControl(Thermometer.scaledBy(0.2, 0.15));

                            add(TControl,LEFT,TOP+10);
                        }catch(Exception ex){

                        }

                        add(new Label("Estudo da Temperatura"),AFTER,CENTER);
                        add(new Label("20,9°"),RIGHT-20,CENTER);
                    }
                },LEFT,TOP,FILL,40);
                ImageControl imageControl;
                try{
                    Image img = new Image("utils/tempGraph.png");
                    img = img.scaledBy(1.2, 1.2);
                    imageControl = new ImageControl(img);
                    add(imageControl,CENTER,AFTER+30);

                }catch(Exception exe){

                }

                
            }
        };

        pwindow.popup();

    }


    @Override
    public void initUI(){
        setBackColor(Color.WHITE);

        setBorderStyle(BORDER_ROUNDED);
        add(new Label("Estudo da Temperatura"),LEFT+5,TOP+10);
        tempLabel.setFont(tempLabel.getFont().adjustedBy(10));
        add(tempLabel,LEFT+5,AFTER+10);
        try{
            Image Thermometer =  new Image("utils/thermometerIcon.png");

            TControl  = new ImageControl(Thermometer.scaledBy(0.2, 0.15));
            

            THistoryControl=  new ImageControl( new Image("utils/tHistory.png"));

            add(TControl,RIGHT-5,TOP+10); 
            add(THistoryControl,LEFT,BOTTOM,PARENTSIZE,PREFERRED);  
            ContainerButton.setBorder(BORDER_NONE);
            ContainerButton.transparentBackground=true; 
            add(ContainerButton,LEFT,TOP,FILL,FILL);  
        }catch(Exception e){
        
        }

        ContainerButton.addPressListener(e->{
           
            TempStudyPop();
            
        });
            
    }
    
}
