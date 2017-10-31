package android.example.com.androidworkshop.adapters;

/*
 * Created by John Melin on 27/10/2017.
 */

import android.content.Context;
import android.example.com.androidworkshop.R;
import android.example.com.androidworkshop.models.OrganisationUnit;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OrganisationUnitAdapter extends RecyclerView.Adapter<OrganisationUnitAdapter.OrgUnitViewHolder>  {
    private List<OrganisationUnit> organisationUnits;
    private final OnItemClickListener listener;

    private int rowLayout;
    private Context context;

    static class OrgUnitViewHolder extends RecyclerView.ViewHolder {
        private TextView orgUnitNameView;

        OrgUnitViewHolder(View itemView) {
            super(itemView);
            orgUnitNameView = (TextView) itemView.findViewById(R.id.name);
        }

        void bind(final OrganisationUnit orgUnit, final OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(orgUnit));
        }
    }

    public OrganisationUnitAdapter(List<OrganisationUnit> organisationUnits,
                                   int rowLayout,
                                   Context context,
                                   OnItemClickListener listener) {
        this.organisationUnits = organisationUnits;
        this.rowLayout = rowLayout;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public OrgUnitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_org_unit, parent, false);

        return new OrgUnitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrgUnitViewHolder holder, int position) {
        holder.bind(organisationUnits.get(position), listener);
        holder.orgUnitNameView.setText(organisationUnits.get(position).getDisplayName());
    }

    @Override
    public int getItemCount() {
        return organisationUnits.size();
    }

    public interface OnItemClickListener {
        void onItemClick(OrganisationUnit orgUnit);
    }

}
