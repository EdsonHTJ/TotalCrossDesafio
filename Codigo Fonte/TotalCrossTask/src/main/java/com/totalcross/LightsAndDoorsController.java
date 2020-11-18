package com.totalcross;




import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.Switch;
import totalcross.ui.Window;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.font.*;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.*;
import totalcross.ui.image.Image;


public class LightsAndDoorsController{
    boolean lightsValue = false;
    boolean KitchenValue = false;
    boolean livingValue = false;
    boolean porchValue = false;
    boolean garageValue = false;







    LightsContainer lightsContainer = new LightsContainer();
    DoorBellContainer Doorbellcontainer = new DoorBellContainer();
    HouseContainer houseContainer = new HouseContainer();


    public void AtualLights(){
        lightsValue = (KitchenValue | livingValue | porchValue | garageValue);
        lightsContainer.lightsSwitch.setOn(lightsValue);
        lightsContainer.kitchenSwitch.setOn(KitchenValue);
        lightsContainer.livingSwitch.setOn(livingValue);
        lightsContainer.porchSwitch.setOn(porchValue);
        lightsContainer.garageSwitch.setOn(garageValue);

        lightsContainer.kitchenIcon.setForeColor(!KitchenValue? Color.getRGB(20,20,150):Color.YELLOW);
        lightsContainer.livingIcon.setForeColor(!livingValue? Color.getRGB(20,20,150):Color.YELLOW);
        lightsContainer.porchIcon.setForeColor(!porchValue? Color.getRGB(20,20,150):Color.YELLOW);
        lightsContainer.garageIcon.setForeColor(!garageValue? Color.getRGB(20,20,150):Color.YELLOW);

        houseContainer.kitchenIcon.setForeColor(!KitchenValue? Color.getRGB(20,20,150):Color.YELLOW);
        houseContainer.livingIcon.setForeColor(!livingValue? Color.getRGB(20,20,150):Color.YELLOW);
        houseContainer.porchIcon.setForeColor(!porchValue? Color.getRGB(20,20,150):Color.YELLOW);
        houseContainer.garageIcon.setForeColor(!garageValue? Color.getRGB(20,20,150):Color.YELLOW);
    }

    public void PopupLightWindow(String WindowName, int LightCode){
        Window lightWindow = new Window(){

            Label name = new Label(WindowName);
            Button Close =  new Button("");
            Icon CloseIcon =  new Icon(MaterialIcons._CLEAR);
            Slider slide = new Slider();
            Switch sw = new Switch();
            Icon LightIcon ;




            Button Detalhes = new Button("Detalhes");
            Button Historico =  new Button("Historico");    
    
            Container historyContainer = new Container(){

                @Override
                public void initUI() {
                    try{
                        Image image = new Image("utils/lightBar.png");
                        ImageControl imageControl = new ImageControl(image);
                        add(imageControl,CENTER,CENTER);
                    }catch(Exception ex){
                    }
                }

            };
            



            @Override
            protected void onPopup() {


            Detalhes.setForeColor(Color.getRGB(20,20,200));
            Historico.setForeColor(Color.getRGB(20,20,200));

            
            setBackColor(Color.WHITE);
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
                    int cor;

                    @Override
                    public void initUI() {
                        boolean swValue=false;
                        setBorderStyle(BORDER_ROUNDED);
                        slide.setForeColor(Color.getRGB(20,20,200));;
                        switch (LightCode) {
                            case 0:
                                cor = lightsContainer.kitchenIcon.getForeColor();
                                LightIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
                                swValue = (KitchenValue);
                                break;

                            case 1:
                                cor = lightsContainer.livingIcon.getForeColor();
                                LightIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
                                swValue = (livingValue);
                                break;

                            case 2:
                                cor = lightsContainer.porchIcon.getForeColor();
                                LightIcon = new Icon(MaterialIcons._FLASH_ON);
                                swValue = (porchValue);
                                break;
    
                            case 3:
                                cor = lightsContainer.garageIcon.getForeColor();
                                LightIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
                                swValue = (garageValue);
                                break;
                            
                            default:
                                break;
                        }
                        LightIcon.setForeColor(cor);
                        add(LightIcon,LEFT+20,TOP+10);
                        add(new Label(name.getText()),AFTER+30,TOP+15);
                        add(sw,RIGHT-20,SAME);
                        add(new Label("Brilho"),LEFT+20,AFTER+30);
                        add(slide,CENTER,AFTER+20);
                        add(new Icon(MaterialIcons._SETTINGS),LEFT+20,SAME-10);
                        sw.setOn(swValue);
                        
                    }
          
                        


                        
                    
                

                },SAME,AFTER,400,150);
                
                Historico.addPressListener(e ->{
                    add(historyContainer,SAME,SAME,400,200);
                });

                Detalhes.addPressListener(e->{
                    remove(historyContainer);
                });


                Close.addPressListener(e -> {
                    unpop();
                });

                
                
            }
            public <H extends EventHandler> void _onEvent(Event<H> e){
                if(e.target==slide){
                    
                    
                    float bright = (float)((float)slide.getValue()/(float)slide.getMaximum());

                    int rgbColor = Color.getRGB((int)(255*bright),(int)(255*bright),0);

                    LightIcon.setForeColor(rgbColor);
                    switch (LightCode) {
                        case 0:
                            lightsContainer.kitchenIcon.setForeColor(rgbColor);
                            
                            break;
                        case 1:
                            lightsContainer.livingIcon.setForeColor(rgbColor);

                            break;
                        case 2:
                            lightsContainer.porchIcon.setForeColor(rgbColor);

                            break;
                        
                        case 3:
                            lightsContainer.garageIcon.setForeColor(rgbColor);

                            break;
                    
                        default:
                            break;
                    }

                }
                else if(e.type==300){
                    if(e.target==sw){

                        LightIcon.setForeColor(!sw.isOn()? Color.getRGB(20,20,150):Color.YELLOW);

                        switch (LightCode) {
                            case 0:
                                KitchenValue=sw.isOn();
                                AtualLights();
                                break;
                            case 1:
                                livingValue=sw.isOn();
                                AtualLights();
                                break;
                            case 2:
                                porchValue=sw.isOn();
                                AtualLights();
                                break;
                            
                            case 3:
                                garageValue=sw.isOn();
                                AtualLights();
                                break;
                        
                            default:
                                break;
                        }
                    }
                }

                
            }
            
            };
            lightWindow.popup();

            
    };

    public class LightsContainer extends Container{
        
    // BorderContainer BC = new BorderContainer("");


        Button kitchenButton = new Button(" ");
        Button livingButton = new Button(" ");
        Button porchButton = new Button(" ");
        Button garageButton = new Button(" ");
        Icon kitchenIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon livingIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon porchIcon = new Icon(MaterialIcons._FLASH_ON);
        Icon garageIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Switch lightsSwitch = new Switch();
        Switch kitchenSwitch = new Switch();
        Switch livingSwitch = new Switch();
        Switch porchSwitch = new Switch();
        Switch garageSwitch = new Switch();
        Label lightsLabel = new Label("Luzes");
        Label kitchenLabel = new Label("Kitchen Lights");
        Label livingLabel = new Label("Living Room Lights");
        Label porchLabel = new Label("Porch Lights");
        Label garageLabel = new Label("Garage Lights");




    
        @Override
        public void initUI() {
            //BC.borderThickness=100;
            //BC.fillW=true;
            //add(BC,LEFT,TOP,FILL,FILL);
            setBorderStyle(BORDER_ROUNDED);
            setBackColor(Color.WHITE);

            Label lightsLabel = new Label("Luzes");
            Label kitchenLabel = new Label("Kitchen Lights");
            Label livingLabel = new Label("Living Room Lights");
            Label porchLabel = new Label("Porch Lights");
            Label garageLabel = new Label("Garage Lights");

            Font ft = Font.getFont(true, Font.NORMAL_SIZE+8);
            lightsLabel.setFont(ft);


            kitchenIcon.setForeColor(Color.getRGB(20,20,150));
            livingIcon.setForeColor(Color.getRGB(20,20,150));
            porchIcon.setForeColor(Color.getRGB(20,20,150));
            garageIcon.setForeColor(Color.getRGB(20,20,150));



            kitchenButton.transparentBackground=true;
            kitchenButton.setBorder(Button.BORDER_NONE);

  
            livingButton.transparentBackground=true;
            livingButton.setBorder(Button.BORDER_NONE);


            porchButton.transparentBackground=true;
            porchButton.setBorder(Button.BORDER_NONE);

       
            garageButton.transparentBackground=true;
            garageButton.setBorder(Button.BORDER_NONE);
            

            
            add(kitchenIcon,LEFT+10,TOP+50);
            add(livingIcon,LEFT+10,AFTER+15);
            add(porchIcon,LEFT+10,AFTER+15);
            add(garageIcon,LEFT+10,AFTER+15);

            add(kitchenButton,kitchenIcon.getX(),kitchenIcon.getY(),kitchenIcon.getWidth(),kitchenIcon.getHeight());
            add(livingButton,livingIcon.getX(),livingIcon.getY(),livingIcon.getWidth(),livingIcon.getHeight());
            add(porchButton,porchIcon.getX(),porchIcon.getY(),porchIcon.getWidth(),porchIcon.getHeight());
            add(garageButton,garageIcon.getX(),garageIcon.getY(),garageIcon.getWidth(),garageIcon.getHeight());


            
            add(lightsLabel,LEFT+10,TOP+5);
            add(kitchenLabel,LEFT+80,AFTER+15);
            add(livingLabel,LEFT+80,AFTER+25);
            add(porchLabel,LEFT+80,AFTER+25);
            add(garageLabel,LEFT+80,AFTER+25);

        

            add(lightsSwitch,RIGHT-10,lightsLabel.getY());
            add(kitchenSwitch,RIGHT-10,kitchenLabel.getY());
            add(livingSwitch,RIGHT-10,livingLabel.getY());
            add(porchSwitch,RIGHT-10,porchLabel.getY());
            add(garageSwitch,RIGHT-10,garageLabel.getY());

            lightsSwitch.setOn(lightsValue);
            kitchenSwitch.setOn(KitchenValue);
            livingSwitch.setOn(livingValue);
            porchSwitch.setOn(porchValue);
            garageSwitch.setOn(garageValue);
            
        }
        public <H extends EventHandler> void _onEvent(Event<H> e){
            if (e.type == 300){
                if(e.target.equals(lightsSwitch)){
                    if (lightsSwitch.isOn()){
                        lightsValue = true;
                        KitchenValue = true;
                        livingValue = true;
                        porchValue = true;
                        garageValue = true;
                    }else{
                        lightsValue = false;
                        KitchenValue = false;
                        livingValue = false;
                        porchValue = false;
                        garageValue = false;
                    }
                    
                }
                if(e.target.equals(kitchenSwitch)){
                    if (kitchenSwitch.isOn()){
                        lightsValue=true;
                        KitchenValue=true;
                    }else{
                        KitchenValue=false;
                    }

                }
                if(e.target.equals(livingSwitch)){
                    if (livingSwitch.isOn()){
                        lightsValue=true;
                        livingValue=true;
                    }else{
                        livingValue=false;
                    }

                }
                if(e.target.equals(porchSwitch)){
                    if (porchSwitch.isOn()){
                        lightsValue=true;
                        porchValue=true;
                    }else{
                        porchValue=false;
                    }

                }
                if(e.target.equals(garageSwitch)){
                    if (garageSwitch.isOn()){
                        lightsValue=true;
                        garageValue=true;
                    }else{
                        garageValue=false;
                    }

                }
                if(e.target == kitchenButton){
                    PopupLightWindow(kitchenLabel.getText(), 0);
                }
                if(e.target == livingButton){
                    PopupLightWindow(livingLabel.getText(), 1);
                    
                }
                if(e.target == porchButton){
                    PopupLightWindow(porchLabel.getText(), 2);

                }
                if(e.target == garageButton){
                    PopupLightWindow(garageLabel.getText(), 3);

                }


                AtualLights();                
                
            }
        }
    }


    public class DoorBellContainer extends Container{

            Icon houseIcon = new Icon(MaterialIcons._HOME);
            Icon Walking = new Icon(MaterialIcons._DIRECTIONS_WALK);
            Icon Clock = new Icon(MaterialIcons._HISTORY);
            Icon Clock2 = new Icon(MaterialIcons._HISTORY);

            Label lDoorbell = new Label("Doorbell");
            Label lFrontDoorDing = new Label("Front Door Ding");
            Label lFrontDoorMotion = new Label("Front Door Motion");
            Label lFrontDoorLastRing = new Label("Front Door Last Ding");
            Label lFrontDoorLastMotion = new Label("Front Door Last Motion");

            Label FDRStatus = new Label("Desocupado");
            Label FDMStatus = new Label("Desligado");
            Label LFDDStatus = new Label("6:44");
            Label LFDMStatus = new Label("13:21");

            Button FDDButton = new Button(" ");
            Button FDMButton = new Button(" ");
            Button LFDDButton = new Button(" ");
            Button LFDMButton = new Button(" ");

            public void FDDpop(){
                        SimplePopupWindow pwindow = new SimplePopupWindow();
                        pwindow.name = new Label("Front Door Ding");

                        pwindow.container=new Container(){
                            @Override
                            public void initUI() {
                                setBorderStyle(BORDER_ROUNDED);
                                add(new Container(){
                                    public void initUI(){
                                        add(new Icon(MaterialIcons._HOME),LEFT+5,CENTER);
                                        add(new Label("Front Door Ding"),AFTER,CENTER);
                                        add(new Label("Desocupado"),RIGHT-20,CENTER);
                                    }
                                },LEFT,TOP,FILL,40);
                                ImageControl imageControl;
                                try{
                                    Image img = new Image("utils/frontdoorbar.png");
                                    img = img.scaledBy(1.2, 1.2);
                                    imageControl = new ImageControl(img);
                                    add(imageControl,CENTER,AFTER+30);

                                }catch(Exception exe){
            
                                }
                                add(new Label("Device Id"),LEFT,AFTER+50);
                                add(new Label("e04f434dca02"),RIGHT,SAME);
                                add(new Label("Fimware"),LEFT,AFTER);
                                add(new Label("Up to Date"),RIGHT,SAME);
                                add(new Label("Timezone"),LEFT,AFTER);
                                add(new Label("America/newYork"),RIGHT,SAME);

                                
                            }
                        };

                        pwindow.popup();
            };


            public void FDMpop(){

            
                SimplePopupWindow pwindow = new SimplePopupWindow();
                pwindow.name = new Label("Front Door Motion");

                pwindow.container=new Container(){
                    @Override
                    public void initUI() {
                        setBorderStyle(BORDER_ROUNDED);
                        add(new Container(){
                            public void initUI(){
                                add(new Icon(MaterialIcons._DIRECTIONS_WALK),LEFT+5,CENTER);
                                add(new Label("Front Door Motion"),AFTER,CENTER);
                                add(new Label("Desligado"),RIGHT-20,CENTER);
                            }
                        },LEFT,TOP,FILL,40);
                        ImageControl imageControl;
                        try{
                            Image img = new Image("utils/frontdoorbar.png");
                            img = img.scaledBy(1.2, 1.2);
                            imageControl = new ImageControl(img);
                            add(imageControl,CENTER,AFTER+30);

                        }catch(Exception exe){
    
                        }
                        add(new Label("Device Id"),LEFT,AFTER+50);
                        add(new Label("e04f434dca02"),RIGHT,SAME);
                        add(new Label("Fimware"),LEFT,AFTER);
                        add(new Label("Up to Date"),RIGHT,SAME);
                        add(new Label("Timezone"),LEFT,AFTER);
                        add(new Label("America/newYork"),RIGHT,SAME);

                        
                    }
                };

                pwindow.popup();
            };

            public void LFDDpop(){
                SimplePopupWindow pwindow = new SimplePopupWindow();
                pwindow.name = new Label("Front Last Ding");

                pwindow.container=new Container(){
                    @Override
                    public void initUI() {
                        setBorderStyle(BORDER_ROUNDED);
                        add(new Container(){
                            public void initUI(){
                                add(new Icon(MaterialIcons._HISTORY),LEFT+5,CENTER);
                                add(new Label("Front Door Last Ding"),AFTER,CENTER);
                                add(new Label("6:44"),RIGHT-20,CENTER);
                            }
                        },LEFT,TOP,FILL,40);
                        ImageControl imageControl;
                        try{
                            Image img = new Image("utils/lastbar.png");
                            img = img.scaledBy(1.2, 1.2);
                            imageControl = new ImageControl(img);
                            add(imageControl,CENTER,AFTER+30);

                        }catch(Exception exe){

                        }
                        add(new Label("Answered"),LEFT,AFTER+70);
                        add(new Label("False"),RIGHT,SAME);
                        

                        
                    }
                };

                pwindow.popup();
            };

            public void LFDMpop(){
                SimplePopupWindow pwindow = new SimplePopupWindow();
                pwindow.name = new Label("Front Last Motion");

                pwindow.container=new Container(){
                    @Override
                    public void initUI() {
                        setBorderStyle(BORDER_ROUNDED);
                        add(new Container(){
                            public void initUI(){
                                add(new Icon(MaterialIcons._HISTORY),LEFT+5,CENTER);
                                add(new Label("Front Door Last Motion"),AFTER,CENTER);
                                add(new Label("6:44"),RIGHT-20,CENTER);
                            }
                        },LEFT,TOP,FILL,40);
                        ImageControl imageControl;
                        try{
                            Image img = new Image("utils/lastbar.png");
                            img = img.scaledBy(1.2, 1.2);
                            imageControl = new ImageControl(img);
                            add(imageControl,CENTER,AFTER+30);

                        }catch(Exception exe){

                        }
                        add(new Label("Answered"),LEFT,AFTER+70);
                        add(new Label("False"),RIGHT,SAME);
                        

                        
                    }
                };

                pwindow.popup();
           };



            @Override
            public void initUI() {
                setBackColor(Color.WHITE);

                houseIcon.setForeColor(Color.getRGB(20,20,150));
                Walking.setForeColor(Color.getRGB(20,20,150));
                Clock.setForeColor(Color.getRGB(20,20,150));
                Clock2.setForeColor(Color.getRGB(20,20,150));

                FDDButton.transparentBackground=true;
                FDDButton.setBorder(Button.BORDER_NONE);

                FDMButton.transparentBackground=true;
                FDMButton.setBorder(Button.BORDER_NONE);

                LFDDButton.transparentBackground=true;
                LFDDButton.setBorder(Button.BORDER_NONE);

                LFDMButton.transparentBackground=true;
                LFDMButton.setBorder(Button.BORDER_NONE);


                setBorderStyle(BORDER_ROUNDED);
                Font ft = Font.getFont(true, Font.NORMAL_SIZE+8);
                lDoorbell.setFont(ft);
                add(lDoorbell,LEFT+10,TOP+5);
                add(new Container(){
                    public void initUI(){
                        add(houseIcon,LEFT+5,CENTER);
                        add(lFrontDoorDing,AFTER,CENTER);
                        add(FDRStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(FDDButton,SAME,SAME,FILL,40);

                add(new Container(){
                    public void initUI(){
                        add(Walking,LEFT+5,CENTER);
                        add(lFrontDoorMotion,lFrontDoorDing.getX(),CENTER);
                        add(FDMStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(FDMButton,SAME,SAME,FILL,40);


                add(new Container(){
                    public void initUI(){
                        add(Clock,LEFT+5,CENTER);
                        add(lFrontDoorLastRing,lFrontDoorDing.getX(),CENTER);
                        add(LFDDStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(LFDDButton,SAME,SAME,FILL,40);


                add(new Container(){
                    public void initUI(){
                        add(Clock2,LEFT+5,CENTER);
                        add(lFrontDoorLastMotion,lFrontDoorDing.getX(),CENTER);
                        add(LFDMStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(LFDMButton,SAME,SAME,FILL,40);

                FDDButton.addPressListener(e -> {
                    FDDpop();
                });

                FDMButton.addPressListener(e -> {
                    FDMpop();
                });
                LFDDButton.addPressListener(e -> {
                    LFDDpop();
                });
                LFDMButton.addPressListener(e -> {
                    LFDMpop();
                });


            }
    }

    public class HouseContainer extends Container{
        
        ImageControl HouseImage;
        Icon Camera1 = new Icon(MaterialIcons._VIDEOCAM);
        Icon Camera2 = new Icon(MaterialIcons._VIDEOCAM);
        Icon Camera3 = new Icon(MaterialIcons._VIDEOCAM);
        Icon Camera4 = new Icon(MaterialIcons._VIDEOCAM);

        Button CameraButton1 = new Button(" ");
        Button CameraButton2 = new Button(" ");
        Button CameraButton3 = new Button(" ");
        Button CameraButton4 = new Button(" ");

        Icon kitchenIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon livingIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon porchIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon garageIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);

        Button kitchenButton = new Button(" ");
        Button livingButton = new Button(" ");
        Button porchButton = new Button(" ");
        Button garageButton = new Button(" ");

        Icon WALK1 = new Icon(MaterialIcons._DIRECTIONS_WALK);
        Icon WALK2 = new Icon(MaterialIcons._DIRECTIONS_WALK);
        Icon WALK3 = new Icon(MaterialIcons._DIRECTIONS_WALK);
        
        ImageControl DOOR1;
        ImageControl DOOR2;
        ImageControl DOOR3;

        Button FrontDoorButton = new Button(" ");
        Button BackDoorButton = new Button(" ");
        Button GarageDoorButton = new Button(" ");

        public void DoorPop(String doorName){
            SimplePopupWindow pwindow = new SimplePopupWindow();
                pwindow.name = new Label(doorName);

                pwindow.container=new Container(){
                    @Override
                    public void initUI() {
                        setBorderStyle(BORDER_ROUNDED);
                        add(new Container(){
                            public void initUI(){
                                add(new Icon(MaterialIcons._HISTORY),LEFT+5,CENTER);
                                add(new Label(doorName),AFTER,CENTER);
                                add(new Label("Fechado"),RIGHT-20,CENTER);
                            }
                        },LEFT,TOP,FILL,40);
                        ImageControl imageControl;
                        try{
                            Image img = new Image("utils/doorBar.png");
                            img = img.scaledBy(1.2, 1.2);
                            imageControl = new ImageControl(img);
                            add(imageControl,CENTER,AFTER+30);

                        }catch(Exception exe){

                        }
                        add(new Label("DEVICE ID"),LEFT+10,AFTER+40);
                        add(new Label("RF:005e8810"),RIGHT-20,SAME);

                        add(new Label("Batery Low"),LEFT+10,AFTER+20);
                        add(new Label("False"),RIGHT-20,SAME);


                        

                        
                    }
                };

                pwindow.popup();
        };


        @Override
        public void initUI() { 
           setBackColor(Color.WHITE);

            setBorderStyle(BORDER_ROUNDED);

            Camera1.transparentBackground=true;
            Camera2.transparentBackground=true;
            Camera3.transparentBackground=true;
            Camera4.transparentBackground=true;
            kitchenIcon.transparentBackground=true;
            kitchenIcon.setForeColor(Color.getRGB(20,20,200));
            livingIcon.transparentBackground=true;
            livingIcon.setForeColor(Color.getRGB(20,20,200));
            porchIcon.transparentBackground=true;
            porchIcon.setForeColor(Color.getRGB(20,20,200));
            garageIcon.transparentBackground=true;
            garageIcon.setForeColor(Color.getRGB(20,20,200));
            
            WALK1.transparentBackground=true;
            WALK2.transparentBackground=true;
            WALK3.transparentBackground=true;

            CameraButton1.transparentBackground=true;
            CameraButton1.setBorder(BORDER_NONE);
            CameraButton2.transparentBackground=true;
            CameraButton2.setBorder(BORDER_NONE);
            CameraButton3.transparentBackground=true;
            CameraButton3.setBorder(BORDER_NONE);
            CameraButton4.transparentBackground=true;
            CameraButton4.setBorder(BORDER_NONE);
            kitchenButton.transparentBackground=true;
            kitchenButton.setBorder(BORDER_NONE);
            livingButton.transparentBackground=true;
            livingButton.setBorder(BORDER_NONE);
            porchButton.transparentBackground=true;
            porchButton.setBorder(BORDER_NONE);
            garageButton.transparentBackground=true;
            garageButton.setBorder(BORDER_NONE);
            FrontDoorButton.transparentBackground=true;
            FrontDoorButton.setBorder(BORDER_NONE);
            BackDoorButton.transparentBackground=true;
            BackDoorButton.setBorder(BORDER_NONE);
            GarageDoorButton.transparentBackground=true;
            GarageDoorButton.setBorder(BORDER_NONE);


            try{
              
                HouseImage = new ImageControl(new Image("utils/house.png"));
                Image DoorImg = new Image("utils/door.png");
                
                DOOR1 = new ImageControl(DoorImg);
                DOOR1.transparentBackground=true;

                DOOR2 = new ImageControl(DoorImg);
                DOOR2.transparentBackground=true;

                DOOR3 = new ImageControl(DoorImg);
                DOOR3.transparentBackground=true;

                add(HouseImage,LEFT,TOP,FILL,FILL);
                add(Camera1,LEFT,TOP+80);
                add(CameraButton1,SAME,SAME,SAME,SAME);
                add(Camera2,RIGHT-10,TOP+80);
                add(CameraButton2,SAME,SAME,SAME,SAME);
                add(Camera3,RIGHT-10,TOP+450);
                add(CameraButton3,SAME,SAME,SAME,SAME);
                add(Camera4,LEFT,TOP+500);
                add(CameraButton4,SAME,SAME,SAME,SAME);
                add(kitchenIcon,LEFT+50,TOP+200);
                add(kitchenButton,SAME,SAME,SAME,SAME);
                add(livingIcon,LEFT+240,TOP+200);
                add(livingButton,SAME,SAME,SAME,SAME);
                add(porchIcon,LEFT+90,TOP+500);
                add(porchButton,SAME,SAME,SAME,SAME);
                add(garageIcon,RIGHT-100,TOP+370);
                add(garageButton,SAME,SAME,SAME,SAME);
                add(DOOR1,LEFT+50,TOP+80);
                add(BackDoorButton,SAME,SAME,SAME,SAME);
                add(DOOR2,RIGHT-200,TOP+350);
                add(GarageDoorButton,SAME,SAME,SAME,SAME);
                add(DOOR3,LEFT+135,TOP+490);
                add(FrontDoorButton,SAME,SAME,SAME,SAME);
                add(WALK1,LEFT+240,TOP+150);
                add(WALK2,RIGHT-50,TOP+150);
                add(WALK3,LEFT+130,TOP+530);

                FrontDoorButton.addPressListener(e->{
                    DoorPop("Front Door");
                });

                BackDoorButton.addPressListener(e->{
                    DoorPop("Back Door");
                });

                GarageDoorButton.addPressListener(e->{
                    DoorPop("Garage Door");
                });


                

             

            }catch (Exception e){

            }
            



            

        }
        public <H extends EventHandler> void _onEvent(Event<H> e){
            if(e.type==300){
                if(e.target == CameraButton1){
                    SimplePopupWindow pwindow = new SimplePopupWindow();
                    pwindow.name = new Label("Patio");

                    pwindow.container=new Container(){
                        @Override
                        public void initUI() {
                            setBorderStyle(BORDER_ROUNDED);
                            ImageControl imageControl;
                            try{
                                imageControl = new ImageControl(new Image("utils/patio.jpg"));
                                add(imageControl,LEFT,TOP,FILL,FILL);

                            }catch(Exception exe){
        
                            }

                            
                        }
                    };

                    pwindow.popup();


                }
                if(e.target == CameraButton2){
                    SimplePopupWindow pwindow = new SimplePopupWindow();
                    pwindow.name = new Label("Backyard");

                    pwindow.container=new Container(){
                        @Override
                        public void initUI() {
                            setBorderStyle(BORDER_ROUNDED);
                            ImageControl imageControl;
                            try{
                                imageControl = new ImageControl(new Image("utils/backyard.jpg"));
                                add(imageControl,LEFT,TOP,FILL,FILL);

                                
                                
                            }catch(Exception exe){
        
                            }

                            
                        }
                    };

                    pwindow.popup();


                }
                if(e.target == CameraButton3){
                    SimplePopupWindow pwindow = new SimplePopupWindow();
                    pwindow.name = new Label("Driveway");

                    pwindow.container=new Container(){
                        @Override
                        public void initUI() {
                            setBorderStyle(BORDER_ROUNDED);
                            ImageControl imageControl;
                            try{
                                imageControl = new ImageControl(new Image("utils/driveway.jpg"));
                                add(imageControl,LEFT,TOP,FILL,FILL);

                                
                                
                            }catch(Exception exe){
        
                            }

                            
                        }
                    };

                    pwindow.popup();


                }
                if(e.target == CameraButton3){
                    SimplePopupWindow pwindow = new SimplePopupWindow();
                    pwindow.name = new Label("Driveway");

                    pwindow.container=new Container(){
                        @Override
                        public void initUI() {
                            setBorderStyle(BORDER_ROUNDED);
                            ImageControl imageControl;
                            try{
                                imageControl = new ImageControl(new Image("utils/driveway.jpg"));
                                add(imageControl,LEFT,TOP,FILL,FILL);

                                
                                
                            }catch(Exception exe){
        
                            }

                            
                        }
                    };

                    pwindow.popup();


                }
                if(e.target == CameraButton4){
                    SimplePopupWindow pwindow = new SimplePopupWindow();
                    pwindow.name = new Label("Porch");

                    pwindow.container=new Container(){
                        @Override
                        public void initUI() {
                            setBorderStyle(BORDER_ROUNDED);
                            ImageControl imageControl;
                            try{
                                imageControl = new ImageControl(new Image("utils/porch.jpg"));
                                add(imageControl,LEFT,TOP,FILL,FILL);

                                
                                
                            }catch(Exception exe){
        
                            }

                            
                        }
                    };

                    pwindow.popup();


                }
                if(e.target == kitchenButton){
                    KitchenValue=!KitchenValue;
                    AtualLights();
                }

                if(e.target == livingButton){
                    livingValue=!livingValue;
                    AtualLights();
                }
                if(e.target == porchButton){
                    porchValue=!porchValue;
                    AtualLights();
                }
                if(e.target == garageButton){
                    garageValue=!garageValue;
                    AtualLights();
                }
                
            }
        }
    }

    
}