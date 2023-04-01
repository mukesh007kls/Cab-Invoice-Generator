import org.example.CabInvoiceGenerator;
import org.example.RideCategory;
import org.example.Rides;
import org.example.Summary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {
    CabInvoiceGenerator cabInvoiceGenerator;
    @Before
    public void setUp() throws Exception{
        cabInvoiceGenerator=new CabInvoiceGenerator();
    }
    @Test
    public void given_Distance_And_Time_Should_Return_Total_Fare(){
       double totalFare=cabInvoiceGenerator.calculateTotalFare(5.0,4);
        Assert.assertEquals(54.0,totalFare,0.0);
    }

    @Test
    public void given_Distance_And_Time_Should_Return_Minimum_Fare(){
        double totalFare=cabInvoiceGenerator.calculateTotalFare(0.1,2);
        Assert.assertEquals(5.0,totalFare,0.0);
    }
    @Test
    public void given_Rides_Should_Return_Total_Fare(){
        Rides[] rides={
                new Rides(10.0,4),
                new Rides(0.1,2),
                new Rides(20.0,10),
                new Rides(15.0,30)
        };
        double totalFare= cabInvoiceGenerator.calculateFareForMultipleRides(rides);
        Assert.assertEquals(499.0,totalFare,0.0);
    }

    @Test
    public void given_Rides_Should_Return_Invoice_Summary(){
        Rides[] rides={
                new Rides(10.0,4),
                new Rides(0.1,2),
                new Rides(20.0,10),
                new Rides(15.0,30)
        };
        Summary expected=new Summary(4,499.0);
        Summary summary = cabInvoiceGenerator.calculateFareForMultipleRidesSummary(rides);
        Assert.assertEquals(expected,summary);
    }

    @Test
    public void given_Riders_Should_Return_There_Summary(){
        String userID1="mukesh";
        String userId2="klsa";
        Rides[] rides1={
                new Rides(10.0,4),
                new Rides(0.1,2),
                new Rides(20.0,10),
                new Rides(15.0,30)
        };
        Rides[] rides2={
                new Rides(0.1,2),
                new Rides(0.1,1)
        };
        cabInvoiceGenerator.addRide(userID1,rides1);
        cabInvoiceGenerator.addRide(userId2,rides2);
        Summary summary1=cabInvoiceGenerator.calculateFareForMultipleRidersSummary(userID1);
        Summary summary1Expected=new Summary(4,499.0);
        Summary summary2=cabInvoiceGenerator.calculateFareForMultipleRidersSummary(userId2);
        Summary summary2Expected=new Summary(2,10);
        Assert.assertEquals(summary1Expected,summary1);
        Assert.assertEquals(summary2Expected,summary2);
    }
    @Test
    public void given_Riders_Should_Return_There_Summary_Premium(){
        String userID1="mukesh";
        String userId2="klsa";
        Rides[] rides1={
                new Rides(10.0,4, RideCategory.NORMAL_RIDE),
                new Rides(0.1,2,RideCategory.PREMIUM_RIDE),
                new Rides(20.0,10,RideCategory.PREMIUM_RIDE),
                new Rides(15.0,30,RideCategory.NORMAL_RIDE)
        };
        Rides[] rides2={
                new Rides(0.1,2,RideCategory.PREMIUM_RIDE),
                new Rides(0.1,1,RideCategory.NORMAL_RIDE)
        };
        cabInvoiceGenerator.addRide(userID1,rides1);
        cabInvoiceGenerator.addRide(userId2,rides2);
        Summary summary1=cabInvoiceGenerator.getSummaryForCategory(userID1);
        Summary summary1Expected=new Summary(4,624.0);
        Summary summary2=cabInvoiceGenerator.getSummaryForCategory(userId2);
        Summary summary2Expected=new Summary(2,25.0);
        Assert.assertEquals(summary1Expected,summary1);
        Assert.assertEquals(summary2Expected,summary2);
    }
}
