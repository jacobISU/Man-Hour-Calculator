package com.example.man_hourcalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    //Monday
    private EditText editTextMondayTime1, editTextMondayTime2, editTextMondayPeople;
    private Spinner spinnerMondayAMPM1, spinnerMondayAMPM2;
    private TextView textViewMondayResult;

    //Tuesday
    private EditText editTextTuesdayTime1, editTextTuesdayTime2, editTextTuesdayPeople;
    private Spinner spinnerTuesdayAMPM1, spinnerTuesdayAMPM2;
    private TextView textViewTuesdayResult;

    //Wednesday
    private EditText editTextWednesdayTime1, editTextWednesdayTime2, editTextWednesdayPeople;
    private Spinner spinnerWednesdayAMPM1, spinnerWednesdayAMPM2;
    private TextView textViewWednesdayResult;

    //Thursday
    private EditText editTextThursdayTime1, editTextThursdayTime2, editTextThursdayPeople;
    private Spinner spinnerThursdayAMPM1, spinnerThursdayAMPM2;
    private TextView textViewThursdayResult;

    //Friday
    private EditText editTextFridayTime1, editTextFridayTime2, editTextFridayPeople;
    private Spinner spinnerFridayAMPM1, spinnerFridayAMPM2;
    private TextView textViewFridayResult;

    //Saturday
    private EditText editTextSaturdayTime1, editTextSaturdayTime2, editTextSaturdayPeople;
    private Spinner spinnerSaturdayAMPM1, spinnerSaturdayAMPM2;
    private TextView textViewSaturdayResult;

    //Sunday
    private EditText editTextSundayTime1, editTextSundayTime2, editTextSundayPeople;
    private Spinner spinnerSundayAMPM1, spinnerSundayAMPM2;
    private TextView textViewSundayResult;

    //Total
    private TextView textViewTotalManhours;

    //Saved Info
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText, Spinner, and TextView variables for each day
        //Monday
        editTextMondayTime1 = findViewById(R.id.editTextMondayTime1);
        editTextMondayTime2 = findViewById(R.id.editTextMondayTime2);
        spinnerMondayAMPM1 = findViewById(R.id.spinnerMondayAMPM1);
        spinnerMondayAMPM2 = findViewById(R.id.spinnerMondayAMPM2);
        editTextMondayPeople = findViewById(R.id.editTextMondayPeople);
        textViewMondayResult = findViewById(R.id.textViewMondayResult);

        //Tuesday
        editTextTuesdayTime1 = findViewById(R.id.editTextTuesdayTime1);
        editTextTuesdayTime2 = findViewById(R.id.editTextTuesdayTime2);
        spinnerTuesdayAMPM1 = findViewById(R.id.spinnerTuesdayAMPM1);
        spinnerTuesdayAMPM2 = findViewById(R.id.spinnerTuesdayAMPM2);
        editTextTuesdayPeople = findViewById(R.id.editTextTuesdayPeople);
        textViewTuesdayResult = findViewById(R.id.textViewTuesdayResult);

        //Wednesday
        editTextWednesdayTime1 = findViewById(R.id.editTextWednesdayTime1);
        editTextWednesdayTime2 = findViewById(R.id.editTextWednesdayTime2);
        spinnerWednesdayAMPM1 = findViewById(R.id.spinnerWednesdayAMPM1);
        spinnerWednesdayAMPM2 = findViewById(R.id.spinnerWednesdayAMPM2);
        editTextWednesdayPeople = findViewById(R.id.editTextWednesdayPeople);
        textViewWednesdayResult = findViewById(R.id.textViewWednesdayResult);

        //Thursday
        editTextThursdayTime1 = findViewById(R.id.editTextThursdayTime1);
        editTextThursdayTime2 = findViewById(R.id.editTextThursdayTime2);
        spinnerThursdayAMPM1 = findViewById(R.id.spinnerThursdayAMPM1);
        spinnerThursdayAMPM2 = findViewById(R.id.spinnerThursdayAMPM2);
        editTextThursdayPeople = findViewById(R.id.editTextThursdayPeople);
        textViewThursdayResult = findViewById(R.id.textViewThursdayResult);

        //Friday
        editTextFridayTime1 = findViewById(R.id.editTextFridayTime1);
        editTextFridayTime2 = findViewById(R.id.editTextFridayTime2);
        spinnerFridayAMPM1 = findViewById(R.id.spinnerFridayAMPM1);
        spinnerFridayAMPM2 = findViewById(R.id.spinnerFridayAMPM2);
        editTextFridayPeople = findViewById(R.id.editTextFridayPeople);
        textViewFridayResult = findViewById(R.id.textViewFridayResult);

        //Saturday
        editTextSaturdayTime1 = findViewById(R.id.editTextSaturdayTime1);
        editTextSaturdayTime2 = findViewById(R.id.editTextSaturdayTime2);
        spinnerSaturdayAMPM1 = findViewById(R.id.spinnerSaturdayAMPM1);
        spinnerSaturdayAMPM2 = findViewById(R.id.spinnerSaturdayAMPM2);
        editTextSaturdayPeople = findViewById(R.id.editTextSaturdayPeople);
        textViewSaturdayResult = findViewById(R.id.textViewSaturdayResult);

        //Sunday
        editTextSundayTime1 = findViewById(R.id.editTextSundayTime1);
        editTextSundayTime2 = findViewById(R.id.editTextSundayTime2);
        spinnerSundayAMPM1 = findViewById(R.id.spinnerSundayAMPM1);
        spinnerSundayAMPM2 = findViewById(R.id.spinnerSundayAMPM2);
        editTextSundayPeople = findViewById(R.id.editTextSundayPeople);
        textViewSundayResult = findViewById(R.id.textViewSundayResult);

        //Total
        textViewTotalManhours = findViewById(R.id.textViewTotalManhours);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ManHourPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Load data for each day
        loadDataForDay(editTextMondayTime1, spinnerMondayAMPM1, editTextMondayTime2, spinnerMondayAMPM2, editTextMondayPeople, textViewMondayResult, "Monday");
        loadDataForDay(editTextTuesdayTime1, spinnerTuesdayAMPM1, editTextTuesdayTime2, spinnerTuesdayAMPM2, editTextTuesdayPeople, textViewTuesdayResult, "Tuesday");
        loadDataForDay(editTextWednesdayTime1, spinnerWednesdayAMPM1, editTextWednesdayTime2, spinnerWednesdayAMPM2, editTextWednesdayPeople, textViewWednesdayResult, "Wednesday");
        loadDataForDay(editTextThursdayTime1, spinnerThursdayAMPM1, editTextThursdayTime2, spinnerThursdayAMPM2, editTextThursdayPeople, textViewThursdayResult, "Thursday");
        loadDataForDay(editTextFridayTime1, spinnerFridayAMPM1, editTextFridayTime2, spinnerFridayAMPM2, editTextFridayPeople, textViewFridayResult, "Friday");
        loadDataForDay(editTextSaturdayTime1, spinnerSaturdayAMPM1, editTextSaturdayTime2, spinnerSaturdayAMPM2, editTextSaturdayPeople, textViewSaturdayResult, "Saturday");
        loadDataForDay(editTextSundayTime1, spinnerSundayAMPM1, editTextSundayTime2, spinnerSundayAMPM2, editTextSundayPeople, textViewSundayResult, "Sunday");

        //Upon Submit Button being clicked, processes result for each day and sums all results.
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalManhours = 0;

                totalManhours += calculateResultForDay(editTextMondayTime1, spinnerMondayAMPM1, editTextMondayTime2, spinnerMondayAMPM2, editTextMondayPeople, textViewMondayResult, "Monday");
                totalManhours += calculateResultForDay(editTextTuesdayTime1, spinnerTuesdayAMPM1, editTextTuesdayTime2, spinnerTuesdayAMPM2, editTextTuesdayPeople, textViewTuesdayResult, "Tuesday");
                totalManhours += calculateResultForDay(editTextWednesdayTime1, spinnerWednesdayAMPM1, editTextWednesdayTime2, spinnerWednesdayAMPM2, editTextWednesdayPeople, textViewWednesdayResult, "Wednesday");
                totalManhours += calculateResultForDay(editTextThursdayTime1, spinnerThursdayAMPM1, editTextThursdayTime2, spinnerThursdayAMPM2, editTextThursdayPeople, textViewThursdayResult, "Thursday");
                totalManhours += calculateResultForDay(editTextFridayTime1, spinnerFridayAMPM1, editTextFridayTime2, spinnerFridayAMPM2, editTextFridayPeople, textViewFridayResult, "Friday");
                totalManhours += calculateResultForDay(editTextSaturdayTime1, spinnerSaturdayAMPM1, editTextSaturdayTime2, spinnerSaturdayAMPM2, editTextSaturdayPeople, textViewSaturdayResult, "Saturday");
                totalManhours += calculateResultForDay(editTextSundayTime1, spinnerSundayAMPM1, editTextSundayTime2, spinnerSundayAMPM2, editTextSundayPeople, textViewSundayResult, "Sunday");

                textViewTotalManhours.setText("Total Man-hours: " + totalManhours);
            }
        });

        //Upon Reset Button being clicked, resets all data to default.
        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });
    }

    //Converts 12hour time format to 24 hour format.
    //Subtracts second time from first time then multiplies by Number of people for result.
    private int calculateResultForDay(EditText time1EditText, Spinner ampm1Spinner, EditText time2EditText, Spinner ampm2Spinner, EditText peopleEditText, TextView resultTextView, String keyPrefix) {
        String time1 = time1EditText.getText().toString() + " " + ampm1Spinner.getSelectedItem().toString();
        String time2 = time2EditText.getText().toString() + " " + ampm2Spinner.getSelectedItem().toString();
        String peopleStr = peopleEditText.getText().toString();

        SimpleDateFormat format12Hour = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat format24Hour = new SimpleDateFormat("HH:mm");

        try {
            Date date1 = format12Hour.parse(time1);
            Date date2 = format12Hour.parse(time2);

            String time1In24Hour = format24Hour.format(date1);
            String time2In24Hour = format24Hour.format(date2);

            date1 = format24Hour.parse(time1In24Hour);
            date2 = format24Hour.parse(time2In24Hour);

            long difference = date2.getTime() - date1.getTime();
            int hours = (int) (difference / (1000 * 60 * 60));

            int people = Integer.parseInt(peopleStr);
            int result = hours * people;

            resultTextView.setText("Result: " + result);

            // Save result to SharedPreferences
            editor.putInt(keyPrefix + "Result", result);
            editor.putString(keyPrefix + "Time1", time1);
            editor.putString(keyPrefix + "Time2", time2);
            editor.putString(keyPrefix + "People", peopleStr);
            editor.apply();

            return result;
        } catch (ParseException | NumberFormatException e) {
            resultTextView.setText("Result: 0");
            return 0;
        }
    }

    //Reloading data for when app is closed.
    private void loadDataForDay(EditText time1EditText, Spinner ampm1Spinner, EditText time2EditText, Spinner ampm2Spinner, EditText peopleEditText, TextView resultTextView, String keyPrefix) {
        int result = sharedPreferences.getInt(keyPrefix + "Result", 0);
        String time1 = sharedPreferences.getString(keyPrefix + "Time1", "");
        String time2 = sharedPreferences.getString(keyPrefix + "Time2", "");
        String peopleStr = sharedPreferences.getString(keyPrefix + "People", "");

        resultTextView.setText("Result: " + result);

        if (!time1.isEmpty()) {
            String[] time1Parts = time1.split(" ");
            time1EditText.setText(time1Parts[0]);
            ampm1Spinner.setSelection(((ArrayAdapter<String>) ampm1Spinner.getAdapter()).getPosition(time1Parts[1]));
        }
        if (!time2.isEmpty()) {
            String[] time2Parts = time2.split(" ");
            time2EditText.setText(time2Parts[0]);
            ampm2Spinner.setSelection(((ArrayAdapter<String>) ampm2Spinner.getAdapter()).getPosition(time2Parts[1]));
        }
        peopleEditText.setText(peopleStr);
    }

    //Resets all all days to default values.
    private void clearData() {
        // Clear all data from SharedPreferences
        editor.clear();
        editor.apply();

        // Reset UI elements
        resetFields(editTextMondayTime1, spinnerMondayAMPM1, editTextMondayTime2, spinnerMondayAMPM2, editTextMondayPeople, textViewMondayResult);
        resetFields(editTextTuesdayTime1, spinnerTuesdayAMPM1, editTextTuesdayTime2, spinnerTuesdayAMPM2, editTextTuesdayPeople, textViewTuesdayResult);
        resetFields(editTextWednesdayTime1, spinnerWednesdayAMPM1, editTextWednesdayTime2, spinnerWednesdayAMPM2, editTextWednesdayPeople, textViewWednesdayResult);
        resetFields(editTextThursdayTime1, spinnerThursdayAMPM1, editTextThursdayTime2, spinnerThursdayAMPM2, editTextThursdayPeople, textViewThursdayResult);
        resetFields(editTextFridayTime1, spinnerFridayAMPM1, editTextFridayTime2, spinnerFridayAMPM2, editTextFridayPeople, textViewFridayResult);
        resetFields(editTextSaturdayTime1, spinnerSaturdayAMPM1, editTextSaturdayTime2, spinnerSaturdayAMPM2, editTextSaturdayPeople, textViewSaturdayResult);
        resetFields(editTextSundayTime1, spinnerSundayAMPM1, editTextSundayTime2, spinnerSundayAMPM2, editTextSundayPeople, textViewSundayResult);

        // Reset total manhours
        textViewTotalManhours.setText("Total Man-hours: 0");
    }

    //Resets a specific Day to default.
    private void resetFields(EditText time1EditText, Spinner ampm1Spinner, EditText time2EditText, Spinner ampm2Spinner, EditText peopleEditText, TextView resultTextView) {
        // Reset EditText fields
        time1EditText.setText("");
        time2EditText.setText("");
        peopleEditText.setText("");

        // Reset Spinner selections to default
        ampm1Spinner.setSelection(0);
        ampm2Spinner.setSelection(0);

        // Reset TextView result
        resultTextView.setText("Result: 0");
    }
}