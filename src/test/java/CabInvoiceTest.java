import org.example.CabInvoiceGenerator;
import org.example.Rides;
import org.junit.Assert;
import org.junit.Test;

public class CabInvoiceTest {
    @Test
    public void given_Distance_And_Time_Should_Return_Total_Fare(){
       CabInvoiceGenerator cabInvoiceGenerator= new CabInvoiceGenerator();
       double totalFare=cabInvoiceGenerator.calculateTotalFare(5.0,4);
        Assert.assertEquals(54.0,totalFare,0.0);
    }

    @Test
    public void given_Distance_And_Time_Should_Return_Minimum_Fare(){
        CabInvoiceGenerator cabInvoiceGenerator= new CabInvoiceGenerator();
        double totalFare=cabInvoiceGenerator.calculateTotalFare(0.1,2);
        Assert.assertEquals(5.0,totalFare,0.0);
    }
    @Test
    public void given_Rides_Should_Return_Total_Fare(){
        CabInvoiceGenerator cabInvoiceGenerator= new CabInvoiceGenerator();
        Rides[] rides={
                new Rides(10.0,4),
                new Rides(0.1,2),
                new Rides(20.0,10),
                new Rides(15.0,30)
        };
        double totalFare= cabInvoiceGenerator.calculateFareForMultipleRides(rides);
        Assert.assertEquals(499.0,totalFare,0.0);
    }

}
