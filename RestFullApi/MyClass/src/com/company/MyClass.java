package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class MyClass{
    public static void main(String[] args) throws IOException, ParseException {

        Package[] arrObject = new Package[5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int invoiceNumber = Integer.parseInt(input.nextToken());

            input = new StringTokenizer(br.readLine());
            String fromCity = input.nextToken();

            input = new StringTokenizer(br.readLine());
            String toCity = input.nextToken();

            input = new StringTokenizer(br.readLine());
            String orderDate = input.nextToken();

            input = new StringTokenizer(br.readLine());
            String deliveryDate = input.nextToken();

            input = new StringTokenizer(br.readLine());
            double price = Double.parseDouble(input.nextToken());
            arrObject[i] = new Package(invoiceNumber, fromCity, toCity, orderDate, deliveryDate, price);

        }


        StringTokenizer input = new StringTokenizer(br.readLine());
        String frmCity = input.nextToken();

        input = new StringTokenizer(br.readLine());
        String toCity = input.nextToken();

        int countOrder = countOrdersDeliveredInAWeek(arrObject, frmCity);
        if(countOrder > 0)
            System.out.println(countOrder);
        else
            System.out.println("No Packages delivered within a week from the given city");

        Package ans = searchByPackageByCity(arrObject, toCity);
        if(ans == null)
            System.out.println("No Package was sent to the specified city");
        else
        {
            System.out.println(ans.getInvoiceNumber());
            System.out.println(ans.getPrice());
        }
    }



    public static int countOrdersDeliveredInAWeek(Package[] arrObject,String frmCity) throws ParseException {
        int countOrders = 0;
        for (int i = 0; i < arrObject.length; i++) {
            if(arrObject[i].getFromCity().compareTo(frmCity) == 0)
            {
                String ordDate = arrObject[i].getOrderDate();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date ordDate2 = null;
                ordDate2 = format.parse(ordDate);
                String delrDate = arrObject[i].getDeliveryDate();
                Date delrDate2 = format.parse(delrDate);
                long diffDate = Math.abs(delrDate2.getTime()-ordDate2.getTime());
                long differenceDates = diffDate / (24 * 60 * 60 * 1000);
                if(differenceDates <= 7)
                    countOrders++;
            }
        }
        return countOrders;
    }
    public static Package searchByPackageByCity(Package[] arrObject,String toCity){
        Arrays.sort(arrObject,(first,second)->{
            return (int) (second.getPrice()-first.getPrice());
        });
        Package ans = null;
        double maxPrice = 0;
        int count = 0;
        for (int i = 0; i < arrObject.length; i++) {
            if(arrObject[i].getToCity().compareTo(toCity) == 0)
            {
                if(maxPrice < arrObject[i].getPrice())
                {
                    maxPrice = arrObject[i].getPrice();
                    ans = arrObject[i];
                    count++;
                }

            }
            if(count == 2)
                break;
        }
        return ans;
    }
}

class Package{
    private int InvoiceNumber;
    private String fromCity;
    private String toCity;
    private String orderDate;
    private String deliveryDate;
    private double price;

    public Package(){}
    public Package(int invoiceNumber, String fromCity, String toCity, String orderDate, String deliveryDate
            , double price) {
        InvoiceNumber = invoiceNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        InvoiceNumber = invoiceNumber;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
