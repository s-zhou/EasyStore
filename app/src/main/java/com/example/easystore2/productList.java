package com.example.easystore2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.easystore2.ProductList.Entities.ProductRV;

import java.util.ArrayList;
import java.util.Locale;

public class productList {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<ProductRV> orderBy(String orderBy,ArrayList<ProductRV> listProductRV){
        if(orderBy =="name") {
            listProductRV.sort((d1, d2) -> (d1.getProductName().toUpperCase(Locale.ROOT)).compareTo(d2.getProductName().toUpperCase(Locale.ROOT)));
        }
        else if(orderBy =="data"){
            listProductRV.sort((d1, d2) -> (d1.getProductExpiredDate()).compareTo(d2.getProductExpiredDate()));
        }
        return listProductRV;

    }
    public ArrayList<ProductRV> showCategory(String category,ArrayList<ProductRV> listProductRV) {
        ArrayList<ProductRV> tempList = new ArrayList<>();
        if(category.equals("") || category.equals("Todo")) tempList = listProductRV;
        else{
            for(int i= 0; i < listProductRV.size();++i){
                if (listProductRV.get(i).getProductCategory().equals(category)) {
                    tempList.add(listProductRV.get(i));
                }
            }
        }
        return tempList;
    }

}
