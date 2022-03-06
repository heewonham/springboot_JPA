package hello.itemservice.domain.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryCodesCreate {

    private static List<DeliveryCode> deliveryCodes = Arrays.asList(
        new DeliveryCode("FAST", "빠른 배송"),
        new DeliveryCode("NORMAL", "일반 배송"),
        new DeliveryCode("SLOW", "느린 배송")
    );

    private DeliveryCodesCreate() {
    }

    public static List<DeliveryCode> getInstance(){
        return deliveryCodes;
    }
}
