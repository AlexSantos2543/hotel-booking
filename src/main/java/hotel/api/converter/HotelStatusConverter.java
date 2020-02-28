package hotel.api.converter;

import hotel.model.hotel.HotelStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class HotelStatusConverter  implements Converter<String, HotelStatus> {

    @Override
    public HotelStatus convert(String source) {
        HotelStatus result = HotelStatus.getHotelStatus(source);
        if(result == null) {
            throw new IllegalArgumentException("'" + source + "' is not valid NotificationStatus. "
                    + "Valid values are " + Arrays.deepToString(HotelStatus.values()));
        }
        return result;
    }
}
