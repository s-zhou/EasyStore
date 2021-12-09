package com.example.easystore2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easystore2.Entities.ProductRV;
import com.example.easystore2.R;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    LayoutInflater inflater;
    ArrayList<ProductRV> model;
    private Button dropdownBtn;
    private TextView expiredDateTV, categoryTV, descriptionTV;
    private View.OnClickListener listener;
    public AdapterProducts(Context context, ArrayList<ProductRV> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_list_item, parent, false);
        dropdownBtn = view.findViewById(R.id.productDropdown);
        dropdownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expiredDateTV = view.findViewById(R.id.expiredDate);
                categoryTV = view.findViewById(R.id.category);
                descriptionTV = view.findViewById(R.id.description);
                if(expiredDateTV.getVisibility() == View.GONE){
                    expiredDateTV.setVisibility(View.VISIBLE);
                }
                else{
                    expiredDateTV.setVisibility(View.GONE);
                }if(categoryTV.getVisibility() == View.GONE){
                    categoryTV.setVisibility(View.VISIBLE);
                }
                else{
                    categoryTV.setVisibility(View.GONE);
                }if(descriptionTV.getVisibility() == View.GONE){
                    descriptionTV.setVisibility(View.VISIBLE);
                }
                else{
                    descriptionTV.setVisibility(View.GONE);
                }
            }
        });
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = model.get(position).getProductName();
        String quantity = model.get(position).getProductQuantity();
        String dataExpired = model.get(position).getProductExpiredDate();
        String category = model.get(position).getProductCategory();
        String description = model.get(position).getProductDescription();
        holder.productName.setText(name);
        holder.productQuantity.setText(quantity);
        holder.productExpiredDate.setText(dataExpired);
        holder.productCategory.setText(category);
        if(description.equals("")) description =" -";
        holder.productDescrition.setText(description);
    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

}
