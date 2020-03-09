package hotel.model.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Pricing {

    private Integer priceOrder;
    private BigDecimal price;
    private boolean breakFast;
    private boolean refundable;

    @JsonCreator
    public Pricing(@JsonProperty("priceOrder") Integer priceOrder,@JsonProperty("price") BigDecimal price,@JsonProperty("breakFast")
            boolean breakFast,@JsonProperty("refundable") boolean refundable) {
        this.priceOrder = priceOrder;
        this.price = price;
        this.breakFast = breakFast;
        this.refundable = refundable;
    }

    public Integer getPriceOrder() {
        return priceOrder;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isBreakFast() {
        return breakFast;
    }

    public boolean isRefundable() {
        return refundable;
    }

    @Override
    public String toString() {
        return "Pricing{" +
                "priceOrder=" + priceOrder +
                ", price=" + price +
                ", breakFast=" + breakFast +
                ", refundable=" + refundable +
                '}';
    }
}
