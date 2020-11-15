package com.totalcross;




import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.*;

public class TempertureContainer extends Container{
    Icon AUTO = new Icon(MaterialIcons._EVENT);
    Icon HOT = new Icon(MaterialIcons._WHATSHOT);
    Icon COLD = new Icon(MaterialIcons._AC_UNIT);
    Icon POWER = new Icon(MaterialIcons._POWER_SETTINGS_NEW);

    Slider tempMaxSlider = new Slider();
    Slider tempMinSlider = new Slider();


    Button AutoButton = new Button(" ");
    Button HotButton = new Button(" ");
    Button ColdButton = new Button(" ");
    Button PowerButton = new Button(" ");

    Label TempLabel = new Label("22°");
    Label RangeLabel = new Label("22.0°-25.5°");
    Label modeLabel = new Label("Automático - Ausente");


	
    // BorderContainer BC = new BorderContainer("");

     @Override
     public void initUI() {

        setBorderStyle(BORDER_ROUNDED);

        AUTO.setFont(AUTO.getFont().adjustedBy(-5));
        HOT.setFont(AUTO.getFont().adjustedBy(-5));
        COLD.setFont(AUTO.getFont().adjustedBy(-5));
        POWER.setFont(AUTO.getFont().adjustedBy(-5));

        AUTO.setForeColor(Color.getRGB(10, 180, 10));
        HOT.setForeColor(Color.getRGB(100, 100, 100));
        COLD.setForeColor(Color.getRGB(100, 100, 100));
        POWER.setForeColor(Color.getRGB(100, 100, 100));

        AutoButton.transparentBackground=true;
        AutoButton.setBorder(Button.BORDER_NONE);
        HotButton.transparentBackground=true;
        HotButton.setBorder(Button.BORDER_NONE);
        ColdButton.transparentBackground=true;
        ColdButton.setBorder(Button.BORDER_NONE);
        PowerButton.transparentBackground=true;
        PowerButton.setBorder(Button.BORDER_NONE);

        
        tempMaxSlider.sliderColor = Color.getRGB(10, 180, 10);
        tempMaxSlider.setBorderStyle(BORDER_ROUNDED);
        add(tempMaxSlider,CENTER,TOP+5,width*2/3,PREFERRED);    
        tempMaxSlider.setMinimum(150); 
        tempMaxSlider.setMaximum(300); 
        tempMaxSlider.setValue(255);

          
        

        
        tempMinSlider.invertDirection=true;
        tempMinSlider.sliderColor = Color.getRGB(10, 180, 10);
        tempMinSlider.setBorderStyle(BORDER_ROUNDED);
        add(tempMinSlider,CENTER,AFTER,width*2/3,PREFERRED);  
        tempMinSlider.setMinimum(150); 
        tempMinSlider.setMaximum(300);
        tempMinSlider.setValue(220);
    

        TempLabel.setFont(TempLabel.getFont().adjustedBy(50));
        add(TempLabel,CENTER,AFTER);
        add(RangeLabel,CENTER,AFTER);
        add(modeLabel,CENTER,AFTER);





        add(AUTO,CENTER-AUTO.getFont().size*7/2-AUTO.getFont().size/2,BOTTOM-25);
        add(AutoButton,SAME,SAME,AUTO.getWidth(),AUTO.getHeight());

        add(HOT,AFTER+AUTO.getWidth(),BOTTOM-30);
        add(HotButton,SAME,SAME,HOT.getWidth(),HOT.getHeight());

        add(COLD,AFTER+AUTO.getWidth(),BOTTOM-30);
        add(ColdButton,SAME,SAME,COLD.getWidth(),COLD.getHeight());

        add(POWER,AFTER+AUTO.getWidth(),BOTTOM-30);
        add(PowerButton,SAME,SAME,POWER.getWidth(),POWER.getHeight());

        add(new Label("Andar de cima"),CENTER,BOTTOM);
     }
     public <H extends EventHandler> void _onEvent(Event<H> e){
        if(e.target==(tempMaxSlider)){
            if(tempMaxSlider.getValue()<tempMinSlider.getValue()){
                tempMaxSlider.setValue(tempMinSlider.getValue());
            }
            RangeLabel.setText((float)(tempMinSlider.getValue()/10)+"°-"+(float)(tempMaxSlider.getValue())/10+"°");
        }
        else if(e.target==(tempMinSlider)){
            if(tempMinSlider.getValue()>tempMaxSlider.getValue()){
                tempMinSlider.setValue(tempMaxSlider.getValue());
            }
            RangeLabel.setText((float)(tempMinSlider.getValue()/10)+"°-"+(float)(tempMaxSlider.getValue())/10+"°");
        }
        else if(e.type == 300){
            if(e.target == AutoButton){
                tempMinSlider.sliderColor = Color.getRGB(10, 180, 10);
                tempMaxSlider.sliderColor = Color.getRGB(10, 180, 10);
                modeLabel.setText("Automático - Ausente");
                AUTO.setForeColor(Color.getRGB(10, 180, 10));
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
            }
            else if(e.target == HotButton){
                tempMinSlider.sliderColor = 0xFF6347;
                tempMaxSlider.sliderColor = 0xFF6347;
                modeLabel.setText("Quente - Ausente");
                HOT.setForeColor(0xFF6347);
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                
            }
            else if(e.target == ColdButton){
                tempMinSlider.sliderColor = 0x87CEFA;
                tempMaxSlider.sliderColor = 0x87CEFA;
                modeLabel.setText("Frio - Ausente");
                COLD.setForeColor(0x87CEFA);
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
            }
            else if(e.target == PowerButton){
                tempMinSlider.sliderColor = Color.getRGB(100, 100, 100);
                tempMaxSlider.sliderColor = Color.getRGB(100, 100, 100);
                modeLabel.setText("Desligado - Ausente");
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
            }

        }
        

     }

     
 }