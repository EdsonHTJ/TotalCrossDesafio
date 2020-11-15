package com.totalcross;


import totalcross.ui.Container;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;

public class musicContainer extends Container{
    Icon CAST = new Icon(MaterialIcons._CAST);
    Icon SKIP = new Icon(MaterialIcons._SKIP_NEXT);
    Icon PREV = new Icon(MaterialIcons._SKIP_PREVIOUS);
    Icon PLAY = new Icon(MaterialIcons._PLAY_ARROW);

    Slider MusicSlider =  new Slider();
    @Override
    public void initUI(){
        // TODO Auto-generated method stub
        setBorderStyle(BORDER_ROUNDED);
        setBackColor(Color.getRGB(251,194,4));
    
        add(CAST,LEFT+5,TOP+5);
        add(new Label("I Wasn't Born To Follow "),SAME,AFTER+10);
        add(new Label("The Birds "),SAME,AFTER+10);
        add(PREV,SAME,AFTER+10);
        add(PLAY,AFTER+5,SAME);
        add(SKIP,AFTER+5,SAME);

        MusicSlider.sliderColor = Color.BLACK;
        MusicSlider.circleColor = Color.BLACK;
        MusicSlider.fillColor = Color.BLACK;
        MusicSlider.setForeColor(Color.BLACK);
        add(MusicSlider,LEFT+5,BOTTOM-5,FILL-5,10);
    }
    
}
