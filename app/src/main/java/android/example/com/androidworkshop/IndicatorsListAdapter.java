package android.example.com.androidworkshop;

import android.content.Intent;
import android.example.com.androidworkshop.models.Indicator;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class IndicatorsListAdapter extends RecyclerView.Adapter<IndicatorsListAdapter.PersonViewHolder>{

    List<Indicator> persons;
    Indicator indicator;

    IndicatorsListAdapter(List<Indicator> persons){
        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_indicators, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.personName.setText(persons.get(i).getName());
        personViewHolder.personAge.setText(persons.get(i).getDescription());

        if(i==1||i==5||i==1||i==11||i==31){
            personViewHolder.personPhoto.setImageResource(R.drawable.ic_trending_flat);
        } else if(i==2 || i==4 || i==8 || i==16 || i==32 || i==64 ){
            personViewHolder.personPhoto.setImageResource(R.drawable.ic_trending_down);
        }else{
            personViewHolder.personPhoto.setImageResource(R.drawable.ic_trending_up);
        }

        indicator=persons.get(i);

        //personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }



    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
             personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);

            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), IndicatorsDetailsActivity.class);
                    intent.putExtra("indicator", TemporaryData.indicatorList.get(getPosition()));
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}