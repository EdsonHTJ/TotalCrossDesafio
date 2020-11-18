package com.totalcross;




import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.Image;

public class EntertainmentContainer extends Container{
    Label name = new Label("Entretenimento");

    ImageControl Harmony;

    @Override
    public void initUI() {
        setBackColor(Color.WHITE);
        Font ft = Font.getFont(true, Font.NORMAL_SIZE+8);
        name.setFont(ft);
        setBorderStyle(BORDER_ROUNDED);
        add(name,LEFT+10,TOP+5);

        try{
            Harmony = new ImageControl((new Image("utils/Harmony.png").scaledBy(0.1, 0.1)));
            add(new Container(){
                public void initUI(){
                    add(Harmony,LEFT+5,CENTER);
                    add(new Label("Harmony"),AFTER+10,CENTER);
                    add(new Label("YouTube"),RIGHT-20,CENTER);
    
                }
            },SAME,AFTER+20,FILL,40);
        }catch(Exception e){
        
        }
        

        add(new Container(){
            public void initUI(){
                Icon Remote = new Icon(MaterialIcons._SETTINGS_REMOTE);
                Remote.transparentBackground=true;
                String[] Items =  {"Power Off","Watch Fire TV","Youtube","SATV","Watch Apple TV"};
                ComboBox CB = new ComboBox(Items);
                CB.caption  = "Atividade";
                Remote.setForeColor(Color.getRGB(20,20,150));
                add(Remote,AFTER+10,CENTER);
                add(CB,AFTER+20,CENTER,FILL,40);

            }
        },SAME,AFTER+20,FILL,40);

        add(new Container(){
            public void initUI(){
                Icon Remote = new Icon(MaterialIcons._SETTINGS_REMOTE);
                Remote.transparentBackground=true;
                String[] Items =  {"Apple TV","Fire TV","Shield"};
                ComboBox CB = new ComboBox(Items);
                CB.caption  = "Comutador HDMI";
                Remote.setForeColor(Color.getRGB(20,20,150));
                add(Remote,AFTER+10,CENTER);
                add(CB,AFTER+20,CENTER,FILL,40);

            }
        },SAME,AFTER+20,FILL,40);

        add(new Container(){
            public void initUI(){
                Icon Remote = new Icon(MaterialIcons._SETTINGS_REMOTE);
                Remote.transparentBackground=true;
                String[] Items =  {"Input HDMI1","Input HDMI2","Input HDMI3","Input HDMI4"};
                ComboBox CB = new ComboBox(Items);
                CB.caption  = "Entrada HDMI";
                Remote.setForeColor(Color.getRGB(20,20,150));
                add(Remote,AFTER+10,CENTER);
                add(CB,AFTER+20,CENTER,FILL,40);

            }
        },SAME,AFTER+20,FILL,40);

        add(new Container(){
            
            Slider volumeSlider  = new Slider();
            Label Volume = new Label("0   "); 

            public void initUI(){
                Icon Audio = new Icon(MaterialIcons._VOLUME_UP);
                Audio.transparentBackground=true;
                Audio.setForeColor(Color.getRGB(20,20,150));
                add(Audio,AFTER+10,CENTER);
                add(new Label("Volume"),AFTER+20,CENTER);
                
                volumeSlider.sliderColor = Color.getRGB(20,20,150);
                add(volumeSlider,AFTER+20,CENTER,width*2/5,40);
                volumeSlider.setMaximum(100);
                volumeSlider.setMinimum(0);
                add(Volume,RIGHT-10,CENTER);
            }
            
            public <H extends EventHandler> void _onEvent(Event<H> e){
                if(e.target == volumeSlider){
                    Volume.setText(""+volumeSlider.getValue());
                }
            }

        },SAME,AFTER+20,FILL,40);

        add(new Container(){
            public void initUI(){
                Icon Chart = new Icon(MaterialIcons._INSERT_CHART);
                Chart.transparentBackground=true;
                Chart.setForeColor(Color.getRGB(20,20,150));
                add(Chart,AFTER+10,CENTER);
                add(new Label("Tempo total de TV"),AFTER+20,CENTER);
                add(new Label("0,42h"),RIGHT-10,CENTER);

            }
        },SAME,AFTER+20,FILL,40);

        add(new Container(){
            public void initUI(){
                Icon OffTv = new Icon(MaterialIcons._POWER);
                Button TurnOff = new Button("Executar");
                TurnOff.transparentBackground=true;
                TurnOff.setForeColor(Color.getRGB(20,20,150));
                OffTv.transparentBackground=true;
                OffTv.setForeColor(Color.getRGB(20,20,150));
                add(OffTv,AFTER+10,CENTER);
                add(new Label("Desligar TV"),AFTER+20,CENTER);
                add(TurnOff,RIGHT-10,CENTER);

            }
        },SAME,AFTER+20,FILL,40);

    }
    
};




