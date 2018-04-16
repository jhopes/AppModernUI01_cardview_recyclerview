package pd.appmodernui01;

import android.service.autofill.FillEventHistory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvlista;
    ArrayList<ModelFood> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvlista = (RecyclerView) findViewById(R.id.rvlista);
        list = new ArrayList<>();
        list.add(new ModelFood(R.drawable.img1,"Arroz con pollo","3","sdsd"));
        list.add(new ModelFood(R.drawable.img1,"Arroz verde","5","sdsdsd"));
        list.add(new ModelFood(R.drawable.img1,"Arroz chaufa","7","sdsd"));
        list.add(new ModelFood(R.drawable.img1,"jjjsjs","4","dfdfd"));
        list.add(new ModelFood(R.drawable.img1,"dfdfd","6","dfdfdf"));
        list.add(new ModelFood(R.drawable.img1,"dfdfd","6","dfdfd"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlmanager = linearLayoutManager;
        rvlista.setLayoutManager(rvlmanager);

        FoodAdapter adapter = new FoodAdapter(this,list);
        rvlista.setAdapter(adapter);
    }
}
