package cd.amateurmobiledev.upakobuz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import cd.amateurmobiledev.upakobuz.fragment.FavoriteFragment;
import cd.amateurmobiledev.upakobuz.fragment.HomeFragment;
import cd.amateurmobiledev.upakobuz.fragment.MessageFragment;
import cd.amateurmobiledev.upakobuz.fragment.NotificationFragment;
import cd.amateurmobiledev.upakobuz.fragment.ProfileFragment;
import cd.amateurmobiledev.upakobuz.fragment.ShareFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        // we can do that as this to
        Fragment selectFragment = null;

        switch (menuItem.getItemId()) {
            case R.id.nav_home:

                /*
                in stead of doing this

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();*/

                selectFragment = new HomeFragment();
                break;
            case R.id.nav_favorite:
                selectFragment = new FavoriteFragment();
                break;
            case R.id.nav_massage:
                selectFragment = new MessageFragment();
                break;
            case R.id.nav_profile:
                selectFragment = new ProfileFragment();
                break;
            case R.id.nav_notification:
                selectFragment = new NotificationFragment();
                break;
            case R.id.nav_share:
                selectFragment = new ShareFragment();
                break;
            case R.id.setting:
                Toast.makeText(getApplicationContext(),"Setting Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ass_center:
                Toast.makeText(getApplicationContext(),"Assistance Center Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mode_dark:
                Toast.makeText(getApplicationContext(),"Dark Mode Active", Toast.LENGTH_SHORT).show();
                break;
        }
        assert selectFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectFragment).commit();

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
