package PDP201.G6.customizable;

import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

public interface invoiceClickListener {

    void onConfirmClick(int position, Button btn_confirm);

    void onItemView(int position, RecyclerView rv_item_cart);
}
