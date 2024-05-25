package com.example.myfoodapp.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfoodapp.R;
import com.example.myfoodapp.models.HomeHorModel;
import com.example.myfoodapp.models.HomeVerModel;
import com.example.myfoodapp.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    UpdateVerticalRec updateVerticalRec;
    FragmentActivity activity;
    ArrayList<HomeHorModel> list;
    boolean check = true;
    boolean select = true;
    int row_index = -1;


    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, FragmentActivity activity, ArrayList<HomeHorModel> homeHorModelList) {
        this.activity =  activity;
        this.list = homeHorModelList;
        this.updateVerticalRec = updateVerticalRec;
    }


    @NonNull
    @Override
    public HomeHorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHorAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());


        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
                if (position == 0) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "Pizza", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    updateVerticalRec.callBack(position, homeVerModels);


                } else if (position == 1) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Burger", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger4, "Burger", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Burger", "10:00 - 23:00", "4.9", "Min - Rs.100"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 2) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.fries1, "Fries", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries2, "Fries", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries3, "Fries", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries4, "Fries", "10:00 - 23:00", "4.9", "Min - Rs.100"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 3) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice-Cream", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Ice-Cream", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Ice-Cream", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream4, "Ice-Cream", "10:00 - 23:00", "4.9", "Min - Rs.100"));

                    updateVerticalRec.callBack(position, homeVerModels);
                } else if (position == 4) {
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich1, "Sandwich", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich2, "Sandwich", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich3, "Sandwich", "10:00 - 23:00", "4.9", "Min - Rs.100"));
                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich4, "Sandwich", "10:00 - 23:00", "4.9", "Min - Rs.100"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }

            }

        });


    }

    @Override
    public int getItemCount() {
        return list.size();    }

    public class ViewHolder  extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_txt);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}







