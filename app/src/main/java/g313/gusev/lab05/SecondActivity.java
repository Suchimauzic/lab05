package g313.gusev.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity {

    EditText txt;
    Switch swSuper;
    Switch swDuper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt = findViewById(R.id.tbText);
        swSuper = findViewById(R.id.switchSuper);
        swDuper = findViewById(R.id.switchDuper);

        Intent intent = getIntent();

        String s = intent.getStringExtra("abc");
        txt.setText(s);

        swSuper.setChecked(intent.getBooleanExtra("checkSuper", false));
        swDuper.setChecked(intent.getBooleanExtra("checkDuper", false));
    }

    public void btnCancel_Click(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }

    public void btnOk_Click(View v) {
        Intent intent = new Intent();

        String s = txt.getText().toString();
        intent.putExtra("qwe", s);
        intent.putExtra("checkSuper", swSuper.isChecked());
        intent.putExtra("checkDuper", swDuper.isChecked());

        setResult(RESULT_OK, intent);
        finish();
    }
}