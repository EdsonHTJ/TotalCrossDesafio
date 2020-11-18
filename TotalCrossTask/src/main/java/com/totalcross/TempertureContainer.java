package com.totalcross;





import totalcross.ui.Button;
import totalcross.ui.ComboBox;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.Window;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.*;
import totalcross.ui.image.Image;

public class TempertureContainer extends Container{
    Icon AUTO = new Icon(MaterialIcons._EVENT);
    Icon HOT = new Icon(MaterialIcons._WHATSHOT);
    Icon COLD = new Icon(MaterialIcons._AC_UNIT);
    Icon POWER = new Icon(MaterialIcons._POWER_SETTINGS_NEW);
    Icon MORE = new Icon(MaterialIcons._MORE_VERT);

    Slider tempMaxSlider = new Slider();
    Slider tempMinSlider = new Slider();



    Button AutoButton = new Button(" ");
    Button HotButton = new Button(" ");
    Button ColdButton = new Button(" ");
    Button PowerButton = new Button(" ");
    Button MoreButton = new Button(" ");

    Label TempLabel = new Label("22°");
    Label RangeLabel = new Label("22.0°-25.5°");
    Label modeLabel = new Label("Automático - Ausente");    

    String mode1 = "Automático";
    String mode2 = "Ausente";


    public void AtualTemp(){
        modeLabel.setText(mode1+" - "+mode2);

        switch (mode1){
            case "Automático":
                tempMinSlider.sliderColor = Color.getRGB(10, 180, 10);
                tempMaxSlider.sliderColor = Color.getRGB(10, 180, 10);
                AUTO.setForeColor(Color.getRGB(10, 180, 10));
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                break;
            case "Quente":
                tempMinSlider.sliderColor = 0xFF6347;
                tempMaxSlider.sliderColor = 0xFF6347;
                HOT.setForeColor(0xFF6347);
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                break;
            case "Frio":
                tempMinSlider.sliderColor = 0x87CEFA;
                tempMaxSlider.sliderColor = 0x87CEFA;               
                COLD.setForeColor(0x87CEFA);
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                break;
            case "Desligado":
                tempMinSlider.sliderColor = Color.getRGB(100, 100, 100);
                tempMaxSlider.sliderColor = Color.getRGB(100, 100, 100);
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                break;
        }
            



        

    }
    
    public void popUpTemp(){
                
                Window tempWindow = new Window(){

                    Label name = new Label("Andar de Cima");
                    Button Close =  new Button("");
                    Icon CloseIcon =  new Icon(MaterialIcons._CLEAR);
                    String[] Operations = { "Automático","Quente","Frio","Desligado"};
                    String[] Predefinir = { "Home","Ausente","Eco","Suspender"};
                    String[] Ventilacao = { "Automatico","Ligado"};

                    ComboBox OpBox = new ComboBox(Operations);
                    ComboBox PreBox = new ComboBox(Predefinir);
                    ComboBox VentBox = new ComboBox(Ventilacao);

                    Button Detalhes = new Button("Detalhes");
                    Button Historico = new Button("Historico");

                    Container historyContainer = new Container(){

                        @Override
                        public void initUI() {
                            try{
                                Image image = new Image("utils/TempH.png");
                                ImageControl imageControl = new ImageControl(image);
                                add(imageControl,CENTER,CENTER);
                            }catch(Exception ex){
                            }
                        }

                    };

                

                    



                    @Override
                    protected void onPopup() {
                    setBackColor(Color.WHITE);
                        Detalhes.setForeColor(Color.getRGB(20,20,200));
                        Historico.setForeColor(Color.getRGB(20,20,200));

                        OpBox.setSelectedItem(mode1);
                        PreBox.setSelectedItem(mode2);
                        VentBox.setSelectedIndex(0);
                        setBorderStyle(BORDER_SIMPLE);
                        transparentBackground=true;
                        Close.transparentBackground=true;
                        name.setFont(name.getFont().adjustedBy(10));
                        add(new Container(){
                            @Override
                            public void initUI() {
                                setBorderStyle(BORDER_ROUNDED);
                                add(CloseIcon,LEFT+7,CENTER);
                                add(Close,LEFT,TOP,40,FILL);
                                add(name,AFTER+30,CENTER);

                            }
                        },CENTER,CENTER-200,400,50);

                        add(new Container(){
                            @Override
                            public void initUI() {
                                setBorderStyle(BORDER_ROUNDED);
                                add(Detalhes,LEFT,TOP,200,FILL);
                                add(Historico,RIGHT,TOP,200,FILL);

                                
                            }
                        },SAME,AFTER,400,50);

                        add(new Container(){

                            Label tempMinlabel = new Label((float)(tempMinSlider.getValue()/10)+"°C"); 
                            Label tempMaxlabel = new Label((float)(tempMaxSlider.getValue()/10)+"°C");
                            Button TempMinButtonup = new Button("+");
                            Button TempMinButtondown = new Button("-");

                            Button TempMaxButtonup = new Button("+");
                            Button TempMaxButtondown = new Button("-");
                            


                            @Override
                            public void initUI() {
                                setBorderStyle(BORDER_ROUNDED);
                                Font ft = Font.getFont(true, Font.NORMAL_SIZE+15);
                                tempMinlabel.setFont(ft);
                                tempMaxlabel.setFont(ft);
                                add(new Label(modeLabel.getText()),CENTER,AFTER+5);
                                add(new Label(RangeLabel.getText()),AFTER+5,SAME);
                                add(new Label("Atualmente 22 °C"),RIGHT-50,AFTER);
                                add(new Label("Temperatura Desejada"),LEFT+5,AFTER+20);
                                add(tempMinlabel,LEFT+10,AFTER+20);
                                add(TempMinButtonup,AFTER+10,SAME,20,20);
                                add(TempMinButtondown,SAME,AFTER+2,20,20);

                                add(tempMaxlabel,RIGHT-70,tempMinlabel.getY());
                                add(TempMaxButtonup,AFTER+10,SAME,20,20);
                                add(TempMaxButtondown,SAME,AFTER+2,20,20);

                                add(OpBox,LEFT,AFTER+40,FILL,40);
                                add(PreBox,LEFT,AFTER+40,FILL,40);
                                add(VentBox,LEFT,AFTER+40,FILL,40);

                                


                                

                                TempMinButtonup.addPressListener(e -> {

                                    if(tempMinSlider.getValue()<tempMaxSlider.getValue()-5){
                                        tempMinSlider.setValue(tempMinSlider.getValue()+5);
                                        tempMinlabel.setText((float)((float)tempMinSlider.getValue()/10)+"°C"); 
                                    }
                                });
                                TempMinButtondown.addPressListener(e -> {
                                    tempMinSlider.setValue(tempMinSlider.getValue()-5);
                                    tempMinlabel.setText((float)((float)tempMinSlider.getValue()/10)+"°C"); 

                                });
                                TempMaxButtonup.addPressListener(e -> {
                                    tempMaxSlider.setValue(tempMaxSlider.getValue()+5);
                                    tempMaxlabel.setText((float)((float)tempMaxSlider.getValue()/10)+"°C"); 

                                });
                                TempMaxButtondown.addPressListener(e -> {
                                    if(tempMinSlider.getValue()<tempMaxSlider.getValue()-5){
                                        tempMaxSlider.setValue(tempMaxSlider.getValue()-5);
                                        tempMaxlabel.setText((float)((float)tempMaxSlider.getValue()/10)+"°C"); 
                                    }
                                });
                                


                                
                            }
                        

                        },SAME,AFTER,400,500);
                        
                        Historico.addPressListener(e ->{
                            add(historyContainer,SAME,SAME,400,500);
                        });

                        Detalhes.addPressListener(e->{
                            remove(historyContainer);
                        });

                        Close.addPressListener(e -> {
                            mode1= (String)OpBox.getValue();
                            mode2= (String)PreBox.getValue();
                            unpop();
                        });;
                    }
                
                };
                tempWindow.popup();
                AtualTemp();


    }

     @Override
     public void initUI() {
        setBackColor(Color.WHITE);

        setBorderStyle(BORDER_ROUNDED);


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
        MoreButton.transparentBackground=true;
        MoreButton.setBorder(BORDER_NONE);

        
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
        add(RangeLabel,CENTER,AFTER,100,20);
        add(modeLabel,CENTER,AFTER,200,20);





        add(AUTO,75,BOTTOM-25);
        add(AutoButton,SAME,SAME,SAME,SAME);

        add(HOT,AFTER+25,BOTTOM-30);
        add(HotButton,SAME,SAME,SAME,SAME);

        add(COLD,AFTER+25,BOTTOM-30);
        add(ColdButton,SAME,SAME,SAME,SAME);

        add(POWER,AFTER+25,BOTTOM-30);
        add(PowerButton,SAME,SAME,SAME,SAME);

        add(new Label("Andar de cima"),CENTER,BOTTOM);



        add(MORE,RIGHT,TOP);
        add(MoreButton,SAME,SAME,SAME,SAME);





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
                mode1 = "Automático";
                modeLabel.setText(mode1+" - "+mode2);
                AUTO.setForeColor(Color.getRGB(10, 180, 10));
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
            }
            else if(e.target == HotButton){
                tempMinSlider.sliderColor = 0xFF6347;
                tempMaxSlider.sliderColor = 0xFF6347;
                mode1 = "Quente";
                modeLabel.setText(mode1+" - "+mode2);
                HOT.setForeColor(0xFF6347);
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                
            }
            else if(e.target == ColdButton){
                tempMinSlider.sliderColor = 0x87CEFA;
                tempMaxSlider.sliderColor = 0x87CEFA;
                mode1 = "Frio";
                modeLabel.setText(mode1+" - "+mode2);                
                COLD.setForeColor(0x87CEFA);
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
                POWER.setForeColor(Color.getRGB(100, 100, 100));
            }
            else if(e.target == PowerButton){
                tempMinSlider.sliderColor = Color.getRGB(100, 100, 100);
                tempMaxSlider.sliderColor = Color.getRGB(100, 100, 100);
                mode1 = "Desligado";
                modeLabel.setText(mode1+" - "+mode2);
                POWER.setForeColor(Color.getRGB(100, 100, 100));
                HOT.setForeColor(Color.getRGB(100, 100, 100));
                COLD.setForeColor(Color.getRGB(100, 100, 100));
                AUTO.setForeColor(Color.getRGB(100, 100, 100));
            }
            else if(e.target == MoreButton){
                popUpTemp();

            }

        }
        

     }

     
 }