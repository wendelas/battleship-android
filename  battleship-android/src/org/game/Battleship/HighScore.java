package org.game.Battleship;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HighScore extends Activity{
	DBAdapter db;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.highscores);
    	String name, score;
    	long l;
    	Cursor cursor;
    	db = new DBAdapter(this);
        db = db.open();    	
        l = db.insertScore("SID", 100);
        Log.d("Hiscore", "insert");
        cursor = db.getScore(1);
        name = cursor.getString(1);
        score = cursor.getString(2);
        db.close();
        TableLayout tbl = (TableLayout)findViewById(R.id.RHE);
        TableRow newRow = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams();
        lp.gravity = 2;
        lp.setMargins(4, 4, 4, 4);
        TextView cell1 = new TextView(this);
        cell1.setText(name);
        newRow.addView(cell1, lp); 
        TextView cell2 = new TextView(this);
        cell2.setText(score);
        newRow.addView(cell2); 
        tbl.addView(newRow, lp);        
    }	


}
