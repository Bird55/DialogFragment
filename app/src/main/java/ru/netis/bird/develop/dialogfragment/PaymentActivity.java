package ru.netis.bird.develop.dialogfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class PaymentActivity extends AppCompatActivity {

    Date dateFrom;
    Date dateTo;
    String strFormat = "%02d.%02d.%4d";
    Button btnFrom;
    Button btnTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnFrom = (Button) findViewById(R.id.btnFrom);
        btnTo = (Button) findViewById(R.id.btnTo);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayFrom = 1;
        int dayTo = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        btnFrom.setText(String.format(strFormat, dayFrom, month+1, year));
        btnTo.setText(String.format(strFormat, dayTo, month+1, year));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_payment, menu);
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
