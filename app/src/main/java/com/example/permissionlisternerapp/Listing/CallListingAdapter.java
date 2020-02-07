package com.example.permissionlisternerapp.Listing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.permissionlisternerapp.R;
import com.example.permissionlisternerapp.database.entity.CallListEntity;
import com.example.permissionlisternerapp.database.entity.CallListEntityManager;

import java.util.List;

public class CallListingAdapter extends RecyclerView.Adapter<CallListingAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
//    private List<CallListEntityManager> mList;
    private List<CallListEntity> mList;
    private Context context;

//    public CallListingAdapter(List<CallListEntityManager> mList, Context context) {
    public CallListingAdapter(List<CallListEntity> mList, Context context) {
        this.mList = mList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.row_item_calllist, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtId.setText(""+mList.get(position).getUniqueId());
        holder.txtState.setText(""+mList.get(position).getState());
        holder.txtNumber.setText(""+mList.get(position).getNumber());
        holder.txtStart.setText(""+mList.get(position).getStartTime());
        holder.txtEnd.setText(""+mList.get(position).getEndTime());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout relCheck;
        private TextView txtId, txtState, txtNumber, txtStart, txtEnd;

        public ViewHolder(View itemView) {
            super(itemView);
//            tvBookDate = (TextView) itemView.findViewById(R.id.tvBookDate);
            //relCheck = (RelativeLayout) itemView.findViewById(R.id.relCheck);

            txtId = (TextView) itemView.findViewById(R.id.txtId);
            txtState = (TextView) itemView.findViewById(R.id.txtState);
            txtNumber = (TextView) itemView.findViewById(R.id.txtNumber);
            txtStart = (TextView) itemView.findViewById(R.id.txtStart);
            txtEnd = (TextView) itemView.findViewById(R.id.txtEnd);

        }
    }

}
