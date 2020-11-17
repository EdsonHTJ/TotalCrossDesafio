package com.totalcross;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Window;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class SimplePopupWindow extends Window{
    Label name;
    Container container = new Container();
    Button Close =  new Button("");
    Icon CloseIcon =  new Icon(MaterialIcons._CLEAR);

    @Override
    protected void onPopup() {
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
        },CENTER,CENTER-200,470,50);
        add(container,CENTER,AFTER,470,270);
        Close.addPressListener(e -> {
            unpop();
        });;
    }
}