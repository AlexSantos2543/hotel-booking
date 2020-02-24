package hotel.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BedDetails {

    private String type;
    private String desc;
    private int count;

    @JsonCreator
    public BedDetails(@JsonProperty("type") String type,
                      @JsonProperty("desc") String desc,
                      @JsonProperty("count")  int count) {
        this.type = type;
        this.desc = desc;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BedDetails{" +
                "type='" + type + '\'' +
                ", desc='" + desc + '\'' +
                ", count=" + count +
                '}';
    }
}
