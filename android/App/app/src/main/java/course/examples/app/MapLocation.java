package course.examples.app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MapLocation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView view = (TextView)findViewById(R.id.view);
        final EditText addrText = (EditText) findViewById(R.id.location);
        Button button = (Button)findViewById(R.id.mapButton);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String address = addrText.getText().toString();
                address = address.replace(' ','+');
                view.setText(address);
            }
        });
    }
}
