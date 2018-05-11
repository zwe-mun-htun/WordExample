package xyz.zwemunhtun.roomwordsexample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.zwemunhtun.roomwordsexample.R;
import xyz.zwemunhtun.roomwordsexample.data.vo.WordVO;
import xyz.zwemunhtun.roomwordsexample.viewholders.WordViewHolder;

public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<WordVO> mWord;

    public WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (mWord!=null){
            WordVO current = mWord.get(position);
            holder.wordItemView.setText(current.getWord());
        }else {
            holder.wordItemView.setText("No Word");
        }
    }

    public void setWords(List<WordVO> word){
        mWord = word;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mWord != null){
            return mWord.size();
        }else
        {
            return 0;
        }
    }
}
