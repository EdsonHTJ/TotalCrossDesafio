package com.totalcross;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;


public class InfoContainer extends Container{
    Icon CAR = new Icon(MaterialIcons._DRIVE_ETA);
    Icon CAR2 = new Icon(MaterialIcons._DRIVE_ETA);
    Icon EYE = new Icon(MaterialIcons._VISIBILITY);
    Icon MONEY = new Icon(MaterialIcons._ATTACH_MONEY);

    Label lInfo = new Label("Informação");
    Label lwork = new Label("Indo para o trabalho");
    Label lgoHome = new Label("Indo para casa");
    Label lPlexSpy = new Label("PlexSpy");
    Label lUSDINR = new Label("USDINR");

    Label WorkStatus = new Label("37 min");
    Label HomeStatus = new Label("41 min");
    Label PlexStatus = new Label("0 Watching");
    Label USDINRStatus = new Label("71,25 INR");

    Button WorkButton = new Button(" ");
    Button HomeButton = new Button(" ");
    Button PlexButton = new Button(" ");
    Button USDINRButton = new Button(" ");

    @Override
    public void initUI() {
        CAR.setForeColor(Color.getRGB(20,20,150));
        CAR2.setForeColor(Color.getRGB(20,20,150));
        EYE.setForeColor(Color.getRGB(20,20,150));
        MONEY.setForeColor(Color.getRGB(20,20,150));

        WorkButton.transparentBackground=true;
        WorkButton.setBorder(Button.BORDER_NONE);

        HomeButton.transparentBackground=true;
        HomeButton.setBorder(Button.BORDER_NONE);

        PlexButton.transparentBackground=true;
        PlexButton.setBorder(Button.BORDER_NONE);

        USDINRButton.transparentBackground=true;
        USDINRButton.setBorder(Button.BORDER_NONE);


        setBorderStyle(BORDER_ROUNDED);
        Font ft = Font.getFont(true, Font.NORMAL_SIZE+8);
        lInfo.setFont(ft);
        add(lInfo,LEFT+10,TOP+5);
        add(new Container(){
            public void initUI(){
                add(CAR,LEFT+5,CENTER);
                add(lwork,AFTER,CENTER);
                add(WorkStatus,RIGHT-20,CENTER);
            }
        },SAME,AFTER,FILL,40);
        add(WorkButton,SAME,SAME,FILL,40);

        add(new Container(){
            public void initUI(){
                add(CAR2,LEFT+5,CENTER);
                add(lgoHome,lwork.getX(),CENTER);
                add(HomeStatus,RIGHT-20,CENTER);
            }
        },SAME,AFTER,FILL,40);
        add(HomeButton,SAME,SAME,FILL,40);


        add(new Container(){
            public void initUI(){
                add(EYE,LEFT+5,CENTER);
                add(lPlexSpy,lwork.getX(),CENTER);
                add(PlexStatus,RIGHT-20,CENTER);
            }
        },SAME,AFTER,FILL,40);
        add(PlexButton,SAME,SAME,FILL,40);


        add(new Container(){
            public void initUI(){
                add(MONEY,LEFT+5,CENTER);
                add(lUSDINR,lwork.getX(),CENTER);
                add(USDINRStatus,RIGHT-20,CENTER);
            }
        },SAME,AFTER,FILL,40);
        add(USDINRButton,SAME,SAME,FILL,40);


    }

    
}
