package com.weatherapp.gnanaraj.weatherapplication.Utility;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.InverseBindingListener;
import android.databinding.ObservableField;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Prathap Baskar on 07-05-2018.
 */
@BindingMethods({
        @BindingMethod(type = CompoundButton.class, attribute = "android:onCheckedChanged", method = "setOnCheckedChangeListener"),
})
public final class BindingUtils {
    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

    /*@BindingAdapter({"background"})
    public static void addColorLinearLayout(LinearLayout linearLayout,String color)
    {
        linearLayout.setBackgroundColor(Color.parseColor(color));
    }*/


  /*  @BindingAdapter({"adapter"})
    public static void addProducerDetails(RecyclerView recyclerView, ArrayList<Producers> producersArrayList)
    {
        ProducerDetailAdapter producerDetailAdapter=(ProducerDetailAdapter)recyclerView.getAdapter();
        if(producerDetailAdapter!=null)
        {
            producerDetailAdapter.ClearItems();
            producerDetailAdapter.addItems(producersArrayList);
        }
    }*/



    @BindingAdapter(value = {"android:onCheckedChanged", "android:checkedAttrChanged"},
            requireAll = false)
    public static void setListeners(CompoundButton view, final CompoundButton.OnCheckedChangeListener listener,
                                    final InverseBindingListener attrChange) {
        if (attrChange == null) {
            view.setOnCheckedChangeListener(listener);
        } else {
            view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (listener != null) {
                        listener.onCheckedChanged(buttonView, isChecked);
                    }
                    attrChange.onChange();
                }
            });
        }
    }

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, ObservableField<Boolean> value) {
        view.setVisibility(value.get() ? View.VISIBLE : View.GONE);
    }





}
