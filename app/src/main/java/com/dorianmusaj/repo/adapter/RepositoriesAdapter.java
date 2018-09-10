package com.dorianmusaj.repo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dorianmusaj.repo.R;
import com.dorianmusaj.repo.model.GithubRepository;

import java.util.List;

public class RepositoriesAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_LIST_ITEM = 0;
    private static final int VIEW_TYPE_LIST_EMPTY = 1;

    private List<GithubRepository> mData;
    private Context context;
    private LayoutInflater mInflater;

    public RepositoriesAdapter(Context c){
        context=c;
        mInflater = LayoutInflater.from(c);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_LIST_ITEM:
                return new ViewHolder(mInflater.inflate(R.layout.item_repo_list, parent, false));
            case VIEW_TYPE_LIST_EMPTY:
                return new ViewHolderEmpty(mInflater.inflate(R.layout.item_repo_list_empty, parent, false));
            default:
                return new ViewHolderEmpty(mInflater.inflate(R.layout.item_repo_list_empty, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case VIEW_TYPE_LIST_ITEM:
                ViewHolder holder = (ViewHolder) viewHolder;

                Uri uri = Uri.parse(mData.get(position).getAvatar()).buildUpon()
                        .build();
                Glide
                        .with(context)
                        .load(uri)
                        .error(R.drawable.ic_splash_github)
                        .into(holder.iconImageView);

                holder.titleTextView.setText((mData.get(position).getName()));


                break;
            case VIEW_TYPE_LIST_EMPTY:
                ViewHolderEmpty holderEmpty = (ViewHolderEmpty) viewHolder;
                holderEmpty.emptyTextView.setText("No repositories!");

                break;
        }
    }

    public void setData(List<GithubRepository> dataList){
        mData=dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData== null ? 1 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData!=null && mData.size()>0 ? VIEW_TYPE_LIST_ITEM : VIEW_TYPE_LIST_EMPTY;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout layout;
        private TextView titleTextView;
        private ImageView iconImageView;

        ViewHolder(View item) {
            super(item);
            layout = (RelativeLayout) item.findViewById(R.id.layout_item_repo);
            iconImageView = (ImageView) item.findViewById(R.id.repo_icon);
            titleTextView = (TextView) item.findViewById(R.id.repo_title);

        }
    }


    class ViewHolderEmpty extends RecyclerView.ViewHolder {
        private TextView emptyTextView;
        public ViewHolderEmpty(View item) {
            super(item);
            emptyTextView = (TextView) item.findViewById(R.id.textview_empty_list);
        }
    }

}
