package m2h2.Backoffice.Koerier.TestScherm;

import m2h2.Backoffice.Components.*;

public class DummyData {

    public void setDummyData() {

        for (int i = 1; i <= 10; i++) {
            // Creating buses
            Bus bus = new Bus("Bus-" + i);

            // Creating routes
            Route route = new Route(bus, "Route " + i, "Bekijk mijn order(s)");

            // Creating orders
            for (int j = 1; j <= 3; j++) {
                Order order = new Order("Adres " + j, j * 2, "Postcode " + j, j % 2 == 0);

                // Creating order lines
                for (int k = 1; k <= 2; k++) {
                    OrderLine orderLine = new OrderLine("Product " + k, k, "Category " + k);
                    order.addOrderline(orderLine);
                }

                // Adding order to route
                route.addOrder(order);
            }
        }
    }
}
