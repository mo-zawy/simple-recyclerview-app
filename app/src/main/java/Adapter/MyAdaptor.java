package Adapter;

import android.app.Dialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task3.DetielsActivity;
import com.example.task3.R;

import java.util.List;

import Model.ListItem;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.ViewHolder> {
    private  Context context;
    private List<ListItem> listItems;
    public MyAdaptor(Context context, List listitem){
        this.context = context;
        this.listItems = listitem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdaptor.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.title.setText(item.getTitle());
        holder.image.setImageResource(item.getImageId());
        holder.is_Completed.setChecked(item.isCompleted());
        holder.is_Completed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.is_Completed.setChecked(isChecked);
                item.setCompleted(isChecked);
                Toast.makeText(context,item.getTitle() +" is completed",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener {

        public TextView title;
        public Dialog dialog;
        public ImageView image;
        public Button delete;
        public CheckBox is_Completed;
        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


            title = (TextView) itemView.findViewById(R.id.title);
            dialog = new Dialog(context);

            image = (ImageView)itemView.findViewById(R.id.image);
            is_Completed = (CheckBox)itemView.findViewById(R.id.is_completed);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            ListItem item = listItems.get(position);

            Intent intent = new Intent(context, DetielsActivity.class);

            intent.putExtra("title",item.getTitle());
            intent.putExtra("description",item.getDiscription());
            intent.putExtra("image",item.getImageId());
            intent.putExtra("isComplete",item.isCompleted());

            context.startActivity(intent);

        }

        @Override
        public boolean onLongClick(View v) {
            showDialod();
            return false;
        }

        public  void showDialod(){
            dialog.setContentView(R.layout.dialoge);
            dialog.setCancelable(true);

            dialog.show();
            delete = (Button) dialog.findViewById(R.id.di_delete);
            delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    ListItem item = listItems.get(position);
                    ListItem itemafter = listItems.remove(position);
                    notifyItemRemoved(position);
                    Toast.makeText(context,item.getTitle()+" is removed",Toast.LENGTH_LONG).show();
                    dialog.dismiss();

                }
            });
        }

    }
}
