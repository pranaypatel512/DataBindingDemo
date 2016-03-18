package com.databindingdemo.app;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.databindingdemo.app.databinding.ContentMainBinding;
import com.databindingdemo.model.User;

public class MainActivity extends AppCompatActivity {

    private User user;
    private Button btnUpdateValue;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnUpdateValue = (Button) findViewById(R.id.btnUpdateValue);
        btnUpdateValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshValue(v);
            }
        });

        textView = (TextView) findViewById(R.id.tvGotoLets);
        String udata = "Engineering at Letsnurture";
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        textView.setText(content);


        //Code for data binding
        ContentMainBinding contentMainBinding = DataBindingUtil.setContentView(this, R.layout.content_main);
        user = new User("Pranay", "Patel", "pranay.letsnurture@gmail.com", "8767899756");
        contentMainBinding.setUser(user);
    }

    private void refreshValue(View v) {
        user.setFirstName("Paresh");
        user.setLastName("Mayani");
        user.setEmail("paresh@gmail.com");
        user.setPhone("4564564565");
        user.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void redirect(View view) {
        Intent gotoLets = new Intent(Intent.ACTION_VIEW, Uri.parse("http://engineering.letsnurture.com/"));
        startActivity(gotoLets);
    }
}
