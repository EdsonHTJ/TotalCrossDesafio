package com.totalcross;



import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.Switch;
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


    public void AtualIconsAndSwitchs(){
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

    }


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

                AtualIconsAndSwitchs();                
                
            }
        }
    }


    public class DoorBellContainer extends Container{
            Icon houseIcon = new Icon(MaterialIcons._HOME);
            Icon Walking = new Icon(MaterialIcons._DIRECTIONS_WALK);
            Icon Clock = new Icon(MaterialIcons._HISTORY);
            Icon Clock2 = new Icon(MaterialIcons._HISTORY);

            Label lDoorbell = new Label("Doorbell");
            Label lFrontDoorRing = new Label("Front Door Ring");
            Label lFrontDoorMotion = new Label("Front Door Motion");
            Label lFrontDoorLastRing = new Label("Front Door Last Ring");
            Label lFrontDoorLastMotion = new Label("Front Door Last Motion Ring");

            Label FDRStatus = new Label("Desocupado");
            Label FDMStatus = new Label("Desligado");
            Label LFDRStatus = new Label("6:44");
            Label LFDMStatus = new Label("13:21");

            Button FDRButton = new Button(" ");
            Button FDMButton = new Button(" ");
            Button LFDRButton = new Button(" ");
            Button LFDMButton = new Button(" ");

            @Override
            public void initUI() {
                houseIcon.setForeColor(Color.getRGB(20,20,150));
                Walking.setForeColor(Color.getRGB(20,20,150));
                Clock.setForeColor(Color.getRGB(20,20,150));
                Clock2.setForeColor(Color.getRGB(20,20,150));

                FDRButton.transparentBackground=true;
                FDRButton.setBorder(Button.BORDER_NONE);

                FDMButton.transparentBackground=true;
                FDMButton.setBorder(Button.BORDER_NONE);

                LFDRButton.transparentBackground=true;
                LFDRButton.setBorder(Button.BORDER_NONE);

                LFDMButton.transparentBackground=true;
                LFDMButton.setBorder(Button.BORDER_NONE);


                setBorderStyle(BORDER_ROUNDED);
                Font ft = Font.getFont(true, Font.NORMAL_SIZE+8);
                lDoorbell.setFont(ft);
                add(lDoorbell,LEFT+10,TOP+5);
                add(new Container(){
                    public void initUI(){
                        add(houseIcon,LEFT+5,CENTER);
                        add(lFrontDoorRing,AFTER,CENTER);
                        add(FDRStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(FDRButton,SAME,SAME,FILL,40);

                add(new Container(){
                    public void initUI(){
                        add(Walking,LEFT+5,CENTER);
                        add(lFrontDoorMotion,lFrontDoorRing.getX(),CENTER);
                        add(FDMStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(FDMButton,SAME,SAME,FILL,40);


                add(new Container(){
                    public void initUI(){
                        add(Clock,LEFT+5,CENTER);
                        add(lFrontDoorLastRing,lFrontDoorRing.getX(),CENTER);
                        add(LFDRStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(LFDRButton,SAME,SAME,FILL,40);


                add(new Container(){
                    public void initUI(){
                        add(Clock2,LEFT+5,CENTER);
                        add(lFrontDoorLastMotion,lFrontDoorRing.getX(),CENTER);
                        add(LFDMStatus,RIGHT-20,CENTER);
                    }
                },SAME,AFTER,FILL,40);
                add(LFDMButton,SAME,SAME,FILL,40);


            }
    }

    public class HouseContainer extends Container{
        ImageControl HouseImage;
        Icon Camera1 = new Icon(MaterialIcons._VIDEOCAM);
        Icon Camera2 = new Icon(MaterialIcons._VIDEOCAM);
        Icon Camera3 = new Icon(MaterialIcons._VIDEOCAM);
        Icon Camera4 = new Icon(MaterialIcons._VIDEOCAM);

        Icon kitchenIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon livingIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon porchIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);
        Icon garageIcon = new Icon(MaterialIcons._LIGHTBULB_OUTLINE);

        @Override
        public void initUI() { 
            setBorderStyle(BORDER_ROUNDED);

            Camera1.transparentBackground=true;
            Camera2.transparentBackground=true;
            Camera3.transparentBackground=true;
            Camera4.transparentBackground=true;
            kitchenIcon.transparentBackground=true;
            livingIcon.transparentBackground=true;
            porchIcon.transparentBackground=true;
            garageIcon.transparentBackground=true;


            try{
              
                HouseImage = new ImageControl(new Image("./utils/house.png"));

            }catch (Exception e){

            }
            add(HouseImage,LEFT,TOP,FILL,FILL);
            add(Camera1,LEFT,TOP+80);
            add(Camera2,RIGHT-10,TOP+80);
            add(Camera3,RIGHT-10,TOP+450);
            add(Camera4,LEFT,TOP+500);
            add(kitchenIcon,LEFT+50,TOP+200);
            add(kitchenIcon,LEFT+50,TOP+200);
            add(livingIcon,LEFT+240,TOP+200);
            add(porchIcon,LEFT+100,TOP+500);
            add(garageIcon,RIGHT-100,TOP+370);


            

        }
    }

    public class popUpContainer extends Container{
        Label name;
        Icon icon;
        Switch lSwitch;
    }
}