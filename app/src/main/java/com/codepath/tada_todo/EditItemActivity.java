package com.codepath.tada_todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static com.codepath.tada_todo.PrimaryActivity.ITEM_POSITION;
import static com.codepath.tada_todo.PrimaryActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {

    //track edit text
    EditText etItemText;
    //position of edited item on text
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        //resolve edit text from layout
        etItemText = (EditText) findViewById(R.id.editItemText);
        //set edit text value from Intent Extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        //update position from Intent Extra
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        //update the title bar of the activity
        getSupportActionBar().setTitle("Edit Item");
    }
    //handler for the save button
    public void onSaveItem(View v){
        //prepare new intent for result
        Intent i = new Intent();
        //pass updated item text as extra
        i.putExtra(ITEM_TEXT, etItemText.getText().toString());
        //pass original position as extra
        i.putExtra(ITEM_POSITION, position);
        //set the intent as the result of the activity
        setResult(RESULT_OK, i);
        //close the activity and redirect it to main
        finish();
    }
}
