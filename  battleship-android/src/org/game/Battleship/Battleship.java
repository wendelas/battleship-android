package org.game.Battleship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Battleship extends Activity implements OnClickListener {
	
	Button buttonPlay, buttonHiscore, buttonQuit;
	DBAdapter db;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	DBAdapter db = new DBAdapter(this);
    	db.open();
    	db.deleteallScores();
    	db.insertScore("SID", 100);
       	db.insertScore("ABC", 12);
    	db.insertScore("XYZ", 24);
       	db.insertScore("DCG", 89);
        Log.d("Hiscore", "insert");
        db.close();
        buttonPlay = (Button)findViewById(R.id.play);
        buttonHiscore = (Button)findViewById(R.id.hiscore);
        buttonQuit = (Button)findViewById(R.id.quit);
        
        buttonPlay.setOnClickListener(this);
        buttonHiscore.setOnClickListener(this);
        buttonQuit.setOnClickListener(this);
    }
    
    public void onDestroy(Bundle savedInstanceState) {
        super.onDestroy();
    }	

	@Override
	public void onClick(View src) {
		switch(src.getId()){
		case R.id.play:
			Intent myIntent = new Intent(Battleship.this, GameBoard.class);
			Battleship.this.startActivity(myIntent);
//			testText.setText("You Pressed Play");
			break;
		case R.id.hiscore:
			Intent hiscore = new Intent(Battleship.this, HighScore.class);
			Battleship.this.startActivity(hiscore);
			break;
		case R.id.quit:
			this.finish();
			break;
		}		
	}
}