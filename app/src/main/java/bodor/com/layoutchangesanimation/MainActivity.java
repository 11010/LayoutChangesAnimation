package bodor.com.layoutchangesanimation;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button add;
    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit);
        add = (Button) findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                final View item = inflater.inflate(R.layout.row,null);
                TextView text = item.findViewById(R.id.text);
                text.setText(editText.getText().toString());
                Button button = item.findViewById(R.id.button);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        container.removeView(item);
                    }
                });

                container.addView(item);
                editText.setText("");
            }
        });
        LayoutTransition layoutTransition = new LayoutTransition();
        container.setLayoutTransition(layoutTransition);


    }
}
