package cd.amateurmobiledev.upakobuz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                Toast.makeText(getApplicationContext(),"Share Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"About us Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(getApplicationContext(),"Setting Clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(getApplicationContext(),"Search Clicked",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}