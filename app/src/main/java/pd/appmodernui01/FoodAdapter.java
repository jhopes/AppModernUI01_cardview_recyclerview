package pd.appmodernui01;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by P&D on 16/04/2018.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<ModelFood>  mlist;
    public FoodAdapter(Context mcontext, ArrayList<ModelFood> list) {
        this.mcontext = mcontext;
        mlist = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
       View view = layoutInflater.inflate(R.layout.rv_item_food,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView name,place,price;
        ImageView image;
       final ModelFood item = mlist.get(position);
        image = holder.item_image;
        name = holder.item_name;
        place = holder.item_place;
        price = holder.item_price;
        image.setImageResource(item.getImage());

        name.setText(item.getName());
        place.setText(item.getPlace());
        price.setText(item.getPrice());
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, item.getPrice()+" "+item.getName()+" "+item.getPlace(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView item_image;
        TextView item_name, item_place, item_price;
        public ViewHolder(View itemView ) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            item_place = itemView.findViewById(R.id.item_place);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);
        }
    }
}
