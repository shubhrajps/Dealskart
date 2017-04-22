package com.example.shubhraj.dealskart;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    NavigationView navigationView;
    String identity;
    private View view1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        identity = getIntent().getStringExtra("STATUS");
        textView = (TextView) findViewById(R.id.mockScreen);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        drawer.openDrawer(Gravity.LEFT);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if(identity.equals("SELLER"))
        {
            Menu nav_menu = navigationView.getMenu();
            nav_menu.findItem(R.id.nav_postreq).setVisible(false);
            View header = navigationView.getHeaderView(0);
            textView.setText("Details about Krishna Electronics");

            TextView textView = (TextView) header.findViewById(R.id.identity);
            textView.setText("KRISHNA ELECTRONICS");
        }
        else if(identity.equals("BUYER"))
        {
            View header = navigationView.getHeaderView(0);
            TextView textViews = (TextView) header.findViewById(R.id.identity);
            textView.setText("Details about Rakesh Patel");
            textViews.setText("RAKESH PATEL");
        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home)
        {
            textView.setText("HOME");
        }
        else if (id == R.id.nav_conv)
        {
            textView.setText("CONVERSATION");
        }
        else if (id == R.id.nav_profile)
        {
            textView.setText("PROFILE");
        }
        else if (id == R.id.nav_postreq)
        {
            textView.setText("POST REQUIREMENTS");
        }
        else if (id == R.id.nav_support)
        {
            textView.setText("SUPPORT");
        }
        else if (id == R.id.nav_logout)
        {
            textView.setText("LOGOUT");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
