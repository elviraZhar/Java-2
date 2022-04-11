package lesson1;

import java.awt.*;
import java.util.Random;

public class Background {
    private Random rnd = new Random();
    private GameCanvas canvas;
    private int R;
    private int G;
    private int B;

    public Background(GameCanvas canvas) {
        this.canvas = canvas;
        R = rnd.nextInt(255);
        G = rnd.nextInt(255);
        B = rnd.nextInt(255);

        canvas.setBackground(new Color(R,G,B));
    }

    void updateColor(GameCanvas canvas, float deltaTime) {
        R += R*deltaTime;
        G += G*deltaTime;
        B += B*deltaTime;

        if (R > 254) { R--; } if (R < 1) { R++; }

        if (G > 254) { G--; } if (G < 1) { G++; }

        if (B > 254) { B--; } if (B < 1) { B++; }

        canvas.setBackground(new Color(R,G,B));
    }
}




