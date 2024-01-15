package g313.gusev.lab05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;
    CheckBox cbSuper;
    CheckBox cbDuper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.tbText);
        cbSuper = findViewById(R.id.cbSuper);
        cbDuper = findViewById(R.id.cbDuper);
    }

    public void OnDialogClick(View v) {
        String s = text.getText().toString();

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("abc", s);
        i.putExtra("checkSuper", cbSuper.isChecked());
        i.putExtra("checkDuper", cbDuper.isChecked());

        startActivityForResult(i, 555);
    }

    public void OnExitClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Выйти из программы");
        builder.setMessage("Вы точно хотите выйти из программы?");
        builder.setIcon(R.drawable.exit);
        builder.setPositiveButton("Да",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.setNegativeButton("Нет",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 555) {
            if (data != null) {
                String s = data.getStringExtra("qwe");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                text.setText(s);

                cbSuper.setChecked(data.getBooleanExtra("checkSuper", false));
                cbDuper.setChecked(data.getBooleanExtra("checkDuper", false));
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}