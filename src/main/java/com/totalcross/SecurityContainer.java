package com.totalcross;


import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class SecurityContainer extends Container{
    Icon SecureIcon =  new Icon(MaterialIcons._VERIFIED_USER);
    Label lSecurity = new Label("Segurança");
    Button Arm_Home = new Button("Armar Em Casa");
    Button Arm_Out = new Button("Armar Ausente");
    Button Disarm =  new Button("Desarmar");

    @Override
    public void initUI() {
        Font ft = Font.getFont(true, Font.NORMAL_SIZE+8);
        lSecurity.setFont(ft);

        Arm_Out.setForeColor(Color.getRGB(20,20,200));
        Arm_Home.setForeColor(Color.getRGB(20,20,200));

        SecureIcon.setForeColor(Color.getRGB(20,150,20));
        SecureIcon.setFont(SecureIcon.getFont().adjustedBy(10));
        add(lSecurity,LEFT+10,TOP+5);
        add(SecureIcon,RIGHT-10,TOP+5);
        setBorderStyle(BORDER_ROUNDED);
        add(Arm_Home,LEFT+50,BOTTOM-20);
        add(Arm_Out,RIGHT-50,BOTTOM-20);

    }
    public <H extends EventHandler> void _onEvent(Event<H> e){
        
        if(e.type==300){
            if(e.target==Arm_Home || e.target==Arm_Out){
                remove(Arm_Home);
                remove(Arm_Out);
                add(Disarm,CENTER,BOTTOM-20);
                SecureIcon.setForeColor(Color.RED);
            }else if(e.target==Disarm){
                remove(Disarm);
                SecureIcon.setForeColor(Color.getRGB(20,150,20));
                add(Arm_Home,LEFT+50,BOTTOM-20);
                add(Arm_Out,RIGHT-50,BOTTOM-20);

            }
        }


    }
    
}
