package ru.netis.bird.develop.dialogfragment;


import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity implements DialogCloseCallBack{

    DialogFragment dlg1;
    DialogFragment dlg2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dlg1 = new Dialog1(this);
        dlg2 = new Dialog2(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDlg1:
                dlg1.show(getFragmentManager(), "dlg1");
                break;
            case R.id.btnDlg2:
                dlg2.show(getFragmentManager(), "dlg2");
                break;
            case R.id.btnDlg3:
                Intent intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void dialogCloseEvent(String result) {
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}