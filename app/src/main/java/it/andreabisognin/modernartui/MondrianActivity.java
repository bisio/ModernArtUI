package it.andreabisognin.modernartui;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;


public class MondrianActivity extends ActionBarActivity {

    private int[] originalColors = {  R.color.yellow, R.color.white,
            R.color.blue, R.color.red,R.color.white };
    private String TAG="bisio";
    private ArrayList<TextView> blockList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mondrian);
        blockList = new ArrayList<TextView>();
        TextView block1 = (TextView) findViewById(R.id.block1);
        TextView block2 = (TextView) findViewById(R.id.block2);
        TextView block3 = (TextView) findViewById(R.id.block3);
        TextView block4 = (TextView) findViewById(R.id.block4);
        TextView block5 = (TextView) findViewById(R.id.block5);
        blockList.add(block1);
        blockList.add(block2);
        blockList.add(block3);
        blockList.add(block4);
        blockList.add(block5);
        initColors();
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                               @Override
                                               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                //Log.i(TAG,"changed seekBar value to " + progress);
                                               }

                                               @Override
                                               public void onStartTrackingTouch(SeekBar seekBar) {

                                               }

                                               @Override
                                               public void onStopTrackingTouch(SeekBar seekBar) {
                                                Log.i(TAG,"changed seekBar value to "+ seekBar.getProgress());
                                               }
                                           }
        );
    }


    public void initColors() {
        for(int i=0; i<blockList.size(); i++) {
            int color = getResources().getColor(originalColors[i]);
            blockList.get(i).setBackgroundColor(color);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mondrian, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
