package android.example.com.androidworkshop;

import android.app.Application;
import android.example.com.androidworkshop.models.Indicator;

import java.util.List;

/**
 * Created by fmtumbuka on 11/2/17.
 */

public class IndicatorsData extends Application
{
    private static List<Indicator> indicators;

    public static List<Indicator> getIndicator()
    {
        return indicators;
    }

    public static List<Indicator> setIndicators( List <Indicator> indicatorList)
    {
        indicators = indicatorList;
        return indicators;
    }
}
