package xyz.zwemunhtun.roomwordsexample.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import xyz.zwemunhtun.roomwordsexample.R;

public class WordViewHolder extends RecyclerView.ViewHolder {

    public final TextView wordItemView;

    public WordViewHolder(View itemView) {
        super(itemView);
        wordItemView =itemView.findViewById(R.id.textView);
    }
}
