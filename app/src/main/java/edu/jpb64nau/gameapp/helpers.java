package edu.jpb64nau.gameapp;

import android.graphics.Color;
import android.os.Handler;
import android.widget.Button;

/**
 * Created by JARID on 12/4/2016.
 */

public class helpers {

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for(char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;

            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;

            }
            titleCase.append(c);

        }
        return titleCase.toString();

    }


    public static void resetGame(Button[] btn, String value, String shade) {
        for(int i = 0; i < btn.length; i++) {
            btn[i].setBackgroundColor(Color.parseColor(shade));
            btn[i].setTextColor(Color.parseColor(shade));
            btn[i].setText(value);
        }

    }


    public static void buttonFlash(final Button[] btn, final int index, final int delay, final String shadeF, final String shadeN) {
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after delay
                btn[index].setTextColor(Color.parseColor(shadeF));
                btn[index].setBackgroundColor(Color.parseColor(shadeF));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after delay
                        btn[index].setTextColor(Color.parseColor(shadeN));
                        btn[index].setBackgroundColor(Color.parseColor(shadeN));
                    }
                }, delay);

            }
        }, delay);

    }


    public static void hideAll(final Button[] btn, final int delay, final String shade) {
        for(int i = 0; i < btn.length; i++) {

            final Handler handler = new Handler();
            final int x = i;

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after delay
                    btn[x].setBackgroundColor(Color.parseColor(shade));

                }
            }, delay);

        }

    }


    public static void recursiveHideAll(final Button[] btn, final int current, final int delay, final String shade) {

        if(current < btn.length) {
            helpers.recursiveHideAll(btn, (current + 1), delay, shade);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after delay
                    btn[current].setBackgroundColor(Color.parseColor(shade));

                }
            }, delay);
        }

    }


    public static void showTiles(final Handler handler, final Button[] btn, final int[] list, final int index, final int flash_delay, final int flash_speed, final String color1, final String color2) {
        int temp = 0;

        if(index < list.length) {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after delay
                    helpers.showTiles(handler, btn, list, (index + 1), flash_delay, flash_speed, color1, color2);
                    helpers.buttonFlash(btn, list[index], flash_speed, color1, color2);

                }
            }, flash_delay);

            // Set text to "on"
            btn[list[index]].setText("on");
        }

    }

}
