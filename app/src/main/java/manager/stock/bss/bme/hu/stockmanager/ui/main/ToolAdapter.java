package manager.stock.bss.bme.hu.stockmanager.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import manager.stock.bss.bme.hu.stockmanager.R;
import manager.stock.bss.bme.hu.stockmanager.domain.Tool;

public class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.ViewHolder>{

    private Context context;
    private List<Tool> tools;

    public ClickListener clickListener;


    public ToolAdapter(Context context, List<Tool> tools){
        this.context = context;
        this.tools = tools;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_tool, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ToolAdapter.ViewHolder holder, int position) {
        Tool tool = tools.get(position);

        holder.tvToolName.setText(tool.getName());
        holder.tvToolBarcode.setText(tool.getBarcode());
        holder.toolId = tool.getId();
    }

    @Override
    public int getItemCount() {
        return tools.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvToolName;
        public TextView tvToolBarcode;
        public Long toolId;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvToolName = (TextView) itemView.findViewById(R.id.list_tool_name);
            tvToolBarcode = (TextView) itemView.findViewById(R.id.list_tool_barcode);
        }

        @Override
        public void onClick(View view) {
            clickListener.itemClicked(view, getAdapterPosition());
        }
    }


    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        public void itemClicked(View view, int position);
    }
}
