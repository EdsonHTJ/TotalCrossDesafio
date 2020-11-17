package com.totalcross;


import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.ImageControl;
import totalcross.ui.Label;
import totalcross.ui.Slider;
import totalcross.ui.event.Event;
import totalcross.ui.event.EventHandler;
import totalcross.ui.gfx.Color;
import totalcross.ui.icon.Icon;
import totalcross.ui.icon.MaterialIcons;
import totalcross.ui.image.Image;

public class musicContainer extends Container{
    Icon CAST = new Icon(MaterialIcons._CAST);
    Icon SKIP = new Icon(MaterialIcons._SKIP_NEXT);
    Icon PREV = new Icon(MaterialIcons._SKIP_PREVIOUS);
    Icon PLAY = new Icon(MaterialIcons._PLAY_ARROW);

    boolean isPlaying=false;

    Button SKIPButton = new Button(" ");
    Button PREVButton = new Button(" ");
    Button PLAYButton = new Button(" ");



    ImageControl AlbumCover;

    Slider MusicSlider =  new Slider();
    @Override
    public void initUI(){
        try{
            Image albumCoverImage = new Image("/utils/easyRider.jpg");

            AlbumCover = new ImageControl(albumCoverImage.scaledBy(0.5,0.5));
        }catch(Exception e){
            
        }


        PLAYButton.transparentBackground=true;
        PLAYButton.setBorder(BORDER_NONE);

        SKIPButton.transparentBackground=true;
        SKIPButton.setBorder(BORDER_NONE);

        PREVButton.transparentBackground=true;
        PREVButton.setBorder(BORDER_NONE);

        setBorderStyle(BORDER_ROUNDED);
        setBackColor(Color.getRGB(251,194,4));
        add(AlbumCover,RIGHT,CENTER,PREFERRED-2,height-5);
        add(CAST,LEFT+5,TOP+5);
        add(new Label("I Wasn't Born To Follow "),SAME,AFTER+10);
        add(new Label("The Birds "),SAME,AFTER+10);
        add(PREV,SAME,AFTER+10);
        add(PREVButton,SAME,SAME,SAME,SAME);
        add(PLAY,AFTER+5,SAME);
        add(PLAYButton,SAME,SAME,SAME,SAME);
        add(SKIP,AFTER+5,SAME);
        add(SKIPButton,SAME,SAME,SAME,SAME);


        

        MusicSlider.sliderColor = Color.BLACK;
        MusicSlider.circleColor = Color.BLACK;
        MusicSlider.fillColor = Color.BLACK;
        MusicSlider.setForeColor(Color.BLACK);
        add(MusicSlider,LEFT+5,BOTTOM-5,FILL-5,10);
    }
    public <H extends EventHandler> void _onEvent(Event<H> e){
        if(e.type==300){
            if(e.target == PLAYButton){
                isPlaying = !isPlaying;

                PLAY.setGlyph((isPlaying? MaterialIcons._PAUSE:MaterialIcons._PLAY_ARROW));
                CAST.setGlyph((isPlaying? MaterialIcons._CAST_CONNECTED:MaterialIcons._CAST));

            }
        }
        
    }
    
}
