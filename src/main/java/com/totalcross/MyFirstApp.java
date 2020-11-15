package com.totalcross;
import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.MainWindow;
import totalcross.ui.ScrollContainer;
import totalcross.ui.SideMenuContainer;
import totalcross.ui.gfx.Color;
import totalcross.ui.gfx.Rect;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
//import totalcross.ui.Label;
import totalcross.sys.Settings;

import com.totalcross.LightsAndDoorsController.DoorBellContainer;
import com.totalcross.LightsAndDoorsController.HouseContainer;
import com.totalcross.LightsAndDoorsController.LightsContainer;

public class MyFirstApp extends MainWindow {

    SideMenuContainer Sidemenu;
    

    public MyFirstApp() {
        setUIStyle(Settings.MATERIAL_UI);
    }



    @Override
    public void initUI() {
        //Label helloWord = new Label("Hello World!");
        setBackColor(255);
        ScrollContainer sc = new ScrollContainer(true,true);
        Container headerContainer = new Container(){
            Icon MORE = new Icon(MaterialIcons._LIST);
            Button More_Button= new Button(""); 
            public void initUI(){
                setBackForeColors(Color.getRGB(100, 100, 255), Color.getRGB(100, 100, 255));
                MORE.setForeColor(Color.WHITE);
                add(MORE,LEFT+10,CENTER);
                More_Button.transparentBackground=true;
                //add(Sidemenu,MORE.getX(),MORE.getY(),MORE.getWidth(),MORE.getHeight());
            }
        };




        headerContainer.setBackForeColors(Color.getRGB(100, 100, 255), Color.getRGB(100, 100, 255));
        add(headerContainer,LEFT,TOP,FILL,50);
        add(sc,LEFT,AFTER,FILL,FILL);
        sc.add(new Container(),LEFT,TOP,2000,1000);
        // add(helloWord, CENTER, CENTER);
        LightsAndDoorsController L_DController = new LightsAndDoorsController();
        LightsContainer lightsContainer = L_DController.lightsContainer;
        DoorBellContainer doorbellContainer = L_DController.Doorbellcontainer;
        HouseContainer houseContainer = L_DController.houseContainer;
        TempertureContainer tp = new TempertureContainer();
        EntertainmentContainer Ec = new EntertainmentContainer();
        musicContainer Mc = new musicContainer();
        
        sc.add(lightsContainer,2,4,400,250);
        sc.add(doorbellContainer,SAME,AFTER+4,400,250);

     
        sc.add(tp,AFTER+4,TOP+4,400,250);

        sc.add(Ec,tp.getX(),tp.getY2()+4,400,500);

        sc.add(houseContainer,AFTER+4,TOP+4,500,600);

        sc.add(Mc,SAME,houseContainer.getY2()+4,500,200);



        



       


    }

}
