package ru.netis.bird.develop.dialogfragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;


public class PaymentsActivity extends AppCompatActivity implements View.OnClickListener{
    Date dateFrom;
    Date dateTo;
    String strFormat = "%02d.%02d.%4d";
    Button btnFrom;
    Button btnTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayFrom = 1;
        int dayTo = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        btnFrom = (Button) findViewById(R.id.btnFrom);
        btnTo = (Button) findViewById(R.id.btnTo);

        btnFrom.setOnClickListener(this);
        btnTo.setOnClickListener(this);

        btnFrom.setText(String.format(strFormat, dayFrom, month+1, year));
        btnTo.setText(String.format(strFormat, dayTo, month+1, year));
    }

    @Override
    public void onClick(View view) {

        DialogFragment newFragment;

        switch (view.getId()){
            case R.id.btnFrom:
                newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePickerFrom");
                break;
            case R.id.btnTo:
                newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePickerTo");
                break;
            case R.id.btnSubmit:
                break;
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private static final String LOG_TAG = "myLog";

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            if (("datePickerFrom").equals(this.getTag())) {
                ((PaymentsActivity) getActivity())
                        .btnFrom.setText(String.format(((PaymentsActivity) getActivity()).strFormat,
                        day, month + 1, year));
            } else {
                if (("datePickerTo").equals(this.getTag())) {
                    ((PaymentsActivity) getActivity())
                            .btnTo.setText(String.format(((PaymentsActivity) getActivity()).strFormat,
                            day, month + 1, year));
                } else
                    Log.d(LOG_TAG, "Bla-bla-bla");
            }
        }
    }
}
