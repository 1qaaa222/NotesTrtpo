package com.example.myapplication;

import static com.example.myapplication.R.id.editText_title;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.Module.Notes;

public class NotesTakerActivity extends AppCompatActivity {


    EditText editText_title, editText_notes;
    ImageView imageView_save;

    Notes notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_taker);

        editText_title=findViewById(R.id.editText_title);
        editText_notes=findViewById(R.id.editText_notes);


        imageView_save=findViewById(R.id.imageView_save);
        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title= editText_title.getText().toString();
                String description = editText_notes.getText().toString();
                if(description.isEmpty()){
                    Toast.makeText(NotesTakerActivity.this, "Please, enter description", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM YYYY HH:mm:ss");
                Date date = new Date();
                notes = new Notes();
                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(formatter.format(date));

                Intent intent = new Intent();
                intent.putExtra("notes", notes);
                setResult(Activity.RESULT_OK.intent());
                finish();
            }
        });

    }
}
